/*
* @Author: dogzz
* @Created: 6/9/2016
*/

package com.dogzz.stepdefinitions;

import com.dogzz.steps.ServicesSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ServicesStepDefinitions {

    @Steps
    ServicesSteps servicesSteps;

    @When(value = "I send $parameter1 and $parameter2 to JsonService", priority = 1)
    public void sendRequestToJsonService(@Named("parameter1") String parameter1,
                                         @Named("parameter2") String parameter2) {
        servicesSteps.sendRequestToJsonService(parameter1, parameter2);
    }

    @Then("response contains $parameter1 and $parameter2")
    public void verifyResponseContains(@Named("parameter1") String parameter1,
                                       @Named("parameter2") String parameter2) {
        servicesSteps.shouldGetResponseWithParameters(parameter1, parameter2);
    }

    @When(value = "I send to HTTPService request with $parameter1 and $parameter2 and $data", priority = 1)
    public void prepareRequestToHTTPService(@Named("parameter1") String parameter1,
                                            @Named("parameter2") String parameter2,
                                            @Named("data") String data) {
        servicesSteps.prepareRequestToHTTPService(parameter1, parameter2, data);
        servicesSteps.sendPreparedPOSTRequestToHTTPService();
    }

    @When(value = "I send to HTTPService PUT request with $parameter1 and $parameter2 and $data", priority = 3)
    public void preparePutRequestToHTTPService(@Named("parameter1") String parameter1,
                                            @Named("parameter2") String parameter2,
                                            @Named("data") String data) {
        servicesSteps.preparePutRequestToHTTPService(parameter1, parameter2, data);
    }

    @Then(value = "response contains $parameter1, $parameter2 and $data", priority = 1)
    public void verifyResponseForPOSTContains(@Named("parameter1") String parameter1,
                                              @Named("parameter2") String parameter2,
                                              @Named("data") String data) {
        servicesSteps.shouldGetResponseWithParameters(parameter1, parameter2, data);
    }

    @When(value = "I send to HTTPService $requestType request with $parameter1Value and $parameter2Value", priority = 2)
    public void prepareDeleteOrHeadRequestToHTTPService(String requestType,
                                                        @Named("parameter1Value") String parameter1,
                                                        @Named("parameter2Value") String parameter2) {
        switch (requestType) {
            case "DELETE":
                servicesSteps.sendDeleteRequestToHTTPService(parameter1, parameter2);
                break;
            case "HEAD":
                servicesSteps.sendHeadRequestToHTTPService(parameter1, parameter2);
                break;
        }

    }

    @Then(value = "response contains $parameterName with value $parameterValue", priority = 1)
    public void verifyResponseForOtherContains(String parameterName,
                                              String parameterValue) {
        servicesSteps.shouldGetResponseWithNamedParameter(parameterName, parameterValue);
    }

    @Then(value = "response is successful", priority = 1)
    public void verifyResponseIsSuccessful() {
        servicesSteps.shouldGetSuccessfulResponse();
    }
}
