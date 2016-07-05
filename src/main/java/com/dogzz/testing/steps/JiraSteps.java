/*
* @Author: dogzz
* @Created: 6/29/2016
*/

package com.dogzz.testing.steps;

import com.dogzz.testing.request.JiraRequests;
import com.dogzz.testing.response.JiraResponses;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JiraSteps {

    private JiraRequests jiraRequests = new JiraRequests();
    private JiraResponses jiraResponses = new JiraResponses();
    private RequestSpecification requestSpec;

    @Step
    public void logInUsingBasicAuth() {
        requestSpec = jiraRequests.getBasicAuthenticationSpec();
    }

    @Step
    public void logInUsingCookiesAuth() {
        requestSpec = jiraRequests.getCookiesAuthenticationSpec();
    }

    @Step
    public void logInUsingOAuthAuth() {
        requestSpec = jiraRequests.getOAuthAuthenticationSpec();
    }

    @Step
    public void addIssueWithTypeTask(String project, String summary, String description) {
        addIssue(project, summary, description, "Task");
    }

    @Step
    public void addIssue(String project, String summary, String description, String type) {
        given()
                .specification(requestSpec)
                .body(jiraRequests.addIssue().
                        withProject(project).
                        withSummary(summary).
                        withDescription(description).
                        withType(type).
                        getMap())
//                .log().all()
                .when()
                .post("/issue");
    }

    @Step
    public void updateSummaryAndDescriptionForIssue(String addedIssueKey, String summary, String description) {
        given()
                .specification(requestSpec)
                .body(jiraRequests.updateIssue().
                        withSummary(summary).
                        withDescription(description).
                        getMap())
//                .log().all()
                .when()
                .put("/issue/{0}", addedIssueKey);
    }

    @Step
    public void updateTypeForIssue(String addedIssueKey, String issueType) {
        given()
                .specification(requestSpec)
                .body(jiraRequests.updateIssue().
                        withType(issueType).
                        getMap())
//                .log().all()
                .when()
                .put("/issue/{0}", addedIssueKey);
    }

    @Step
    public void issueShouldBeAdded() {
        then()
                .statusCode(isOneOf(200, 201))
                .body("id", is(notNullValue()));
    }

    @Step
    public void issueShouldBeUpdated() {
        then()
                .statusCode(204);
    }

    @Step
    public String noteRecentlyAddedIssueId() {
        return then().extract().path("id");
    }

    @Step
    public String noteRecentlyAddedIssueKey() {
        return then().extract().path("key");
    }

    @Step
    public void getAllIssuesForProject(String project) {
        rest()
                .specification(requestSpec)
                .specification(jiraRequests.getIssuesForProjectRequest(project))
                .get("/search");
    }

    @Step
    public void issueShouldBePresent(String id, String summary, String description) {
        then()
                .body("issues.id", hasItem(id))
                .body("issues.find {it.id == \"" + id + "\"}.fields.summary", equalToIgnoringCase(summary))
                .body("issues.find {it.id == \"" + id + "\"}.fields.description", equalToIgnoringCase(description));
    }

    @Step
    public void issueShouldBePresentAlternative(String id, String summary, String description) {
        JsonPath response = then().extract().body().jsonPath();
        String actualSummary = jiraResponses.withResponse(response).forIssuedId(id).getSummary();
        String actualDescription = jiraResponses.withResponse(response).forIssuedId(id).getDescription();
        assertThat(actualSummary, equalToIgnoringCase(summary));
        assertThat(actualDescription, equalToIgnoringCase(description));
    }

    @Step
    public void issueShouldHaveType(String id, String issueType) {
        JsonPath response = then().extract().body().jsonPath();
        String actualType = jiraResponses.withResponse(response).forIssuedId(id).getType();
        assertThat(actualType, equalToIgnoringCase(issueType));
    }

    @Step
    public void issueShouldNotBeAdded() {
        then()
                .statusCode(not(isOneOf(200, 201)))
                .body("id", is(nullValue()));
    }

    @Step
    public void errorShouldBeReturned(String error) {
        JsonPath response = then().extract().body().jsonPath();
        String actualError = jiraResponses.withResponse(response).getError();
        assertThat(actualError, containsString(error));
    }
}
