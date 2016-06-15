/*
* @Author: dogzz
* @Created: 6/9/2016
*/

package com.dogzz.stepdefinitions;

import com.dogzz.steps.ServicesSteps;
import com.dogzz.steps.ServicesUISteps;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matcher;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static net.thucydides.core.matchers.BeanMatchers.each;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.core.IsNot.not;

import java.util.List;
import java.util.Map;

public class ServicesStepDefinitions {

    @Steps
    ServicesSteps servicesSteps;
    @Steps
    ServicesUISteps servicesUISteps;

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

    @Given("QService mapped page is open")
    public void QServicePageIsOpen() {
        servicesUISteps.openQServicePage();
    }

    @When("I execute $action related to $type service")
    public void executeActionOnQServivePage(String action, String serviceType) {
        switch (action) {
            case "Success":
                servicesUISteps.executeSuccessActionForServiceType(serviceType);
                break;
            case "Failure":
                servicesUISteps.executeFailureActionForServiceType(serviceType);
                break;
        }
    }

    @Then("the output $result is displayed")
    public void verifyResultOnQServicePage(String result) {
        servicesUISteps.shouldDisplayForSavedServiceTypeCorrectRersult(result);
    }

    @Given("a system with some contacts")
    public void systemHasContacts() {
        servicesSteps.initializeContactsService();
    }

    @When("I request contact with id is $id")
    public void sendRequestToGetContactById(String id) {
        servicesSteps.requestContactById(id);
    }

    @Then("contact with id is $id is returned")
    public void verifyThatReturnedContactHasId(String id) {
        servicesSteps.returnedContactShouldHaveId(id);
    }

    @Then("contact has name $lastName $firstName")
    public void verifyThatReturnedContactHasName(String lastName, String firstName) {
        servicesSteps.returnedContactShouldHaveName(lastName, firstName);
    }

    @When("I request all contacts")
    public void sendRequestToGetAllContacts() {
        servicesSteps.requestAllContacts();
    }

    @Then("the contacts returned are: $contactsTable")
    public void verifyAllReturnedContacts(ExamplesTable contactsTable) {
        servicesSteps.returnedContactsCountShouldBe(contactsTable.getRows().size());
        for (Map<String, String> row : contactsTable.getRows()) {
            servicesSteps.contactShouldBeReturned(row);
        }
    }

    @When("I add new contact")
    public void sendRequestToAddNewContact() {
        servicesSteps.addNewContact("Cartman", "Eric");
    }

    @Then("response with user parameters is returned")
    public void verifyResponseContainsAddedContactParams() {
        servicesSteps.returnedContactShouldHaveName("Cartman", "Eric");
        servicesSteps.returnedContactShouldHaveAnyId();
    }

    @When("I delete existing contact")
    public void sendRequestToDeleteContact() {
        servicesSteps.deleteContactWithId("12");
    }

    @Then("response about successful removal is returned")
    public void verifyResponseAboutRemovalSuccess() {
        servicesSteps.shouldGetSuccessfulResponseForRemovalContactWithId("12");
    }

    @Then("contact is not present in the system")
    public void verifyRemovedContactIsNotPresent() {
        servicesSteps.requestAllContacts();
        servicesSteps.contactListShouldNotContain(the("id", is(("12"))));
    }

    @When("I update data for existing contact")
    public void sendRequestToUpdateContact() {
        servicesSteps.updateContactWithId("2");
    }

    @Then("response about successful update is returned")
    public void verifyResponseAboutUpdateSuccess() {
        servicesSteps.shouldGetSuccessfulResponseForUpdatingContactWithId("2");
    }
}
