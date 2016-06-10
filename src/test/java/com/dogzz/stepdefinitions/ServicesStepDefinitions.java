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

    @Then(value = "response contains $parameter1, $parameter2 and $data", priority = 1)
    public void verifyResponseForPOSTContains(@Named("parameter1") String parameter1,
                                              @Named("parameter2") String parameter2,
                                              @Named("data") String data) {
        servicesSteps.shouldGetResponseWithParameters(parameter1, parameter2, data);
    }
}
