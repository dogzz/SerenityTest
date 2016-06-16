/*
* @Author: dogzz
* @Created: 6/10/2016
*/

package com.dogzz.request;

import com.dogzz.dto.JsonData;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.RestDefaultsChained;
import org.openqa.selenium.os.CommandLine;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.reset;

public class HTTPServiceRequests {

    public HTTPServiceRequests() {
        this("code/examples/servercalls/01_HTTPService/");
    }

    public HTTPServiceRequests(String defaultBasePath) {
        reset();
        new RestDefaultsChained().setDefaultPort(80)
                .setDefaultBasePath(defaultBasePath)
                .setDefaultProxy("localhost", 8888);
        RestAssured.baseURI = "http://www.angularjshub.com";
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
