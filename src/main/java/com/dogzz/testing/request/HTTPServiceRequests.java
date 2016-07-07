/*
* @Author: dogzz
* @Created: 6/10/2016
*/

package com.dogzz.testing.request;

import com.dogzz.testing.TestProperties;
import com.dogzz.testing.dto.JsonData;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.rest.RestDefaultsChained;
import net.thucydides.core.ThucydidesSystemProperty;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.reset;


public class HTTPServiceRequests extends BaseRequests {

    public HTTPServiceRequests() {
        this("code/examples/servercalls/01_HTTPService/");
    }

    public HTTPServiceRequests(String defaultBasePath) {
        super();
        restConfig.setDefaultPort(80)
                .setDefaultBasePath(defaultBasePath);
        RestAssured.unregisterParser("text/html");
        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.baseURI = SerenitySystemProperties.getProperties().getValue(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
//        RestAssured.baseURI = TestProperties.angularServicesUrl;
    }

    public RequestSpecification getJSONRequest(String param1, String param2) {
        JsonData data = new JsonData(param1, param2);
        return given()
                .contentType(ContentType.JSON)
                .param("jsonObjParam", data);
    }

    public RequestSpecification getJSONRequestUsingMap(String param1, String param2) {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("param1", param1);
        jsonAsMap.put("param2", param2);
        return given()
                .contentType(ContentType.JSON)
                .param("jsonObjParam", jsonAsMap);
    }

    public RequestSpecification getRequest(String param1, String param2) {
        return given()
                .contentType(ContentType.TEXT)
                .queryParam("param1", param1)
                .queryParam("param2", param2);
    }

    public RequestSpecification getContactRequestById(String id) {
        return given()
                .contentType(ContentType.TEXT)
                .pathParam("id", id);
    }

    public RequestSpecification getAddContactRequest(String lastName, String firstName) {
        return getContactRequestById("0")
                .queryParam("firstName", firstName)
                .queryParam("lastName",lastName);
    }

    public RequestSpecification getAllContactsRequest() {
        return given()
                .contentType(ContentType.TEXT)
                .param("idsArray[]", 1, 2, 3);
    }

}
