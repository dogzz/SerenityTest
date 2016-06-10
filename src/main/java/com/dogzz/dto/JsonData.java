/*
* @Author: dogzz
* @Created: 6/10/2016
*/

package com.dogzz.dto;

public class JsonData {
    private String param1;
    private String param2;

    public JsonData(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
