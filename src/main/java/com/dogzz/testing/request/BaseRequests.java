/*
* @Author: dogzz
* @Created: 7/7/2016
*/

package com.dogzz.testing.request;

import com.dogzz.testing.TestProperties;
import net.serenitybdd.rest.RestDefaultsChained;

import static com.jayway.restassured.RestAssured.reset;

public class BaseRequests {
    RestDefaultsChained restConfig = new RestDefaultsChained();

    public BaseRequests () {
        reset();
        if (TestProperties.withProxy) {
            restConfig.setDefaultProxy("localhost", 8888);
        }
    }
}
