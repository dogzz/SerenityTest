/*
* @Author: dogzz
* @Created: 6/30/2016
*/

package com.dogzz.testing.response;

import com.jayway.restassured.path.json.JsonPath;

public class JiraResponses {

    private JsonPath response;
    private final String FIND_ISSUE_BY_ID = "issues.find {it.id == \"%s\"}";
    private String id;

    public JiraResponses withResponse(JsonPath response) {
        this.response = response;
        return this;
    }

    public JiraResponses forIssuedId(String id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return response.getString(String.format(FIND_ISSUE_BY_ID, id) + ".fields.summary");
    }

    public String getDescription() {
        return response.getString(String.format(FIND_ISSUE_BY_ID, id) + ".fields.description");
    }

    public String getType() {
        return response.getString(String.format(FIND_ISSUE_BY_ID, id) + ".fields.issuetype.name");
    }
}
