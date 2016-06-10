/*
* @Author: dogzz
* @Created: 6/9/2016
*/

package com.dogzz.steps;

import com.dogzz.request.HTTPServiceRequests;
import com.jayway.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Step;


import static net.serenitybdd.rest.SerenityRest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

public class ServicesSteps {

    HTTPServiceRequests requests = new HTTPServiceRequests();

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


}
