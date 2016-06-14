/*
* @Author: dogzz
* @Created: 6/9/2016
*/

package com.dogzz.steps;

import com.dogzz.request.HTTPServiceRequests;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.assertion.AssertParameter;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.path.json.JsonPath;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;


import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ServicesSteps {

    HTTPServiceRequests requests = new HTTPServiceRequests();
    private JsonPath response;
    private List<Map<String, String>> contacts;

    @Step
    public void sendRequestToJsonService(String parameter1, String parameter2) {
        rest()
                .specification(requests.getJSONRequestUsingMap(parameter1, parameter2))
                .log().all()
                .get("server.php");
    }

    @Step
    public void shouldGetResponseWithParameters(String parameter1, String parameter2) {
        JsonPath response = then().extract().body().jsonPath();
        assertThat(response.getString("receivedJSONParam1")).isEqualTo(parameter1);
        assertThat(response.getString("receivedJSONParam2")).isEqualTo(parameter2);
//        then()
//                .body("receivedJSONParam1", equalTo(parameter1))
//                .and()
//                .body("receivedJSONParam2", equalTo(parameter2));
    }

    @Step
    public void prepareRequestToHTTPService(String parameter1, String parameter2, String data) {
        given()
                .specification(requests.getRequest(parameter1, parameter2))
                .body(data)
                .log().all()
                .post("server.php");
    }

    @Step
    public void preparePutRequestToHTTPService(String parameter1, String parameter2, String data) {
        given()
                .specification(requests.getRequest(parameter1, parameter2))
                .body(data)
                .log().all()
                .put("server.php");
    }

    @Step
    public void sendPreparedPOSTRequestToHTTPService() {
//        when()
//                .post("server.php");
    }

    @Step
    public void shouldGetResponseWithParameters(String parameter1, String parameter2, String data) {
        then()
                .body(containsString(parameter2))
                .and()
                .body(containsString(parameter2))
                .and()
                .body(containsString(data));
    }

    @Step
    public void sendDeleteRequestToHTTPService(String parameter1, String parameter2) {
        given()
                .specification(requests.getRequest(parameter1, parameter2))
                .log().all()
                .delete("server.php");
    }
    @Step
    public void sendHeadRequestToHTTPService(String parameter1, String parameter2) {
        given()
                .specification(requests.getRequest(parameter1, parameter2))
                .log().all()
                .head("server.php");
    }

    @Step
    public void shouldGetResponseWithNamedParameter(String parameterName, String parameterValue) {
        then()
                .body(containsString(parameterName.concat(" = ").concat(parameterValue)));
    }

    @Step
    public void shouldGetSuccessfulResponse() {
        then()
                .statusCode(200);
    }

    @Step
    public void requestContactById(String id) {
        rest()
                .specification(requests.getContactRequestById(id))
                .log().all()
                .get("retrieve/{id}");
        response = then().extract().body().jsonPath();
    }

    @Step
    public void returnedContactShouldHaveId(String id) {
        assertThat(response.getString("id")).isEqualTo(id);
//        then()
//                .using().log().all()
//                .defaultParser(Parser.JSON)
//                .body("id", equalTo(id));
    }

    @Step
    public void returnedContactShouldHaveName(String lastName, String firstName) {
        assertThat(response.getString("firstName")).isEqualTo(firstName);
        assertThat(response.getString("lastName")).isEqualTo(lastName);
    }

    @Step
    public void initializeContactsService() {
        requests = new HTTPServiceRequests("code/examples/servercalls/03_ResourceService/people/");
    }

    @Step
    public void requestAllContacts() {
        rest()
                .specification(requests.getAllContactsRequest())
                .log().all()
                .get("retrievearray/0");
        response = then().extract().body().jsonPath();
        contacts = response.getList("$");
    }

    @Step
    public void contactShouldBeReturned(Map<String, String> row) {
        assertThat(contacts).contains(row);
    }

    @Step
    public void returnedContactsCountShouldBe(int count) {
        assertThat(contacts.size()).isEqualTo(count);
    }
}
