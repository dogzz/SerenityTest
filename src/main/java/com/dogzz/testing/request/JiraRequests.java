/*
* @Author: dogzz
* @Created: 6/29/2016
*/

package com.dogzz.testing.request;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.filter.Filter;
import com.jayway.restassured.filter.FilterContext;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.FilterableRequestSpecification;
import com.jayway.restassured.specification.FilterableResponseSpecification;
import com.jayway.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.RestDefaultsChained;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.reset;

public class JiraRequests {

    public static final String JSESSIONID = "JSESSIONID";
    RestDefaultsChained restConfig = new RestDefaultsChained();
    private String testuser = "testuser";
    private String testpassword = "testpassword";
    private String accessToken = "u6845KAm9SJWn0GUsSAMgMeEtkzVi2l8";
    private Map<String, Object> rootMap;
    private Map<String, Object> fieldsMap;

    public JiraRequests() {
        reset();
        restConfig.setDefaultPort(8080)
                .setDefaultBasePath("/rest/api/2/")
                .setDefaultProxy("localhost", 8888);
        RestAssured.baseURI = "http://172.28.118.61";
    }

    public RequestSpecification getBasicAuthenticationSpec() {
        return given()
                .auth().preemptive()
                .basic(testuser, testpassword)
                .contentType(JSON);
    }

    public RequestSpecification getCookiesAuthenticationSpec() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("username", testuser);
        jsonAsMap.put("password", testpassword);
        Cookies sessionCookies =
        given().
                with().basePath("/rest/auth/1/").
                contentType(JSON).
                body(jsonAsMap).
        when().
                post("/session").
        then().
                extract().detailedCookies();
        return given().cookies(sessionCookies).contentType(JSON);
    }

    //Will work for OAuth2 only but JIRA supports only OAuth1
    public RequestSpecification getOAuthAuthenticationSpec() {
        return given().filter(sign(accessToken)).contentType(JSON);
    }

    public RequestSpecification getIssuesForProjectRequest(String project) {
        return given()
                .queryParam("jql", "project=" + project);
    }

    protected static Filter sign(final String accessToken) {
        return new Filter() {
            @Override
            public Response filter(FilterableRequestSpecification requestSpec,
                                   FilterableResponseSpecification responseSpec,
                                   FilterContext ctx) {
                requestSpec.header("Authorization", String.format("Bearer %s",
                        accessToken));
                return ctx.next(requestSpec, responseSpec);
            }
        };
    }

    public JiraRequests addIssue() {
        initMaps();
        return this;
    }

    public JiraRequests updateIssue() {
        initMaps();
        return this;
    }

    private void initMaps() {
        rootMap = new HashMap<>();
        fieldsMap = new HashMap<>();
    }

    public JiraRequests withProject(String project) {
        if (project != null && !project.isEmpty()) {
            fieldsMap.put("project", new HashMap<String, Object>() {{
                put("key", project);
            }});
        }
        return this;
    }

    public JiraRequests withSummary(String summary) {
        if (summary != null && !summary.isEmpty()) {
            fieldsMap.put("summary", summary);
        }
        return this;
    }

    public JiraRequests withDescription(String description) {
        if (description != null && !description.isEmpty()) {
            fieldsMap.put("description", description);
        }
        return this;
    }

    public JiraRequests withType(String type) {
        if (type !=null && !type.isEmpty()) {
            fieldsMap.put("issuetype", new HashMap<String, Object>() {{
                put("name", type);
            }});
        }
        return this;
    }

    public Map<String, Object> getMap() {
        rootMap.put("fields", fieldsMap);
        return rootMap;
    }
}
