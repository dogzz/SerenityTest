/*
* @Author: dogzz
* @Created: 6/29/2016
*/

package com.dogzz.testing.stepdefinitions;

import com.dogzz.testing.steps.JiraSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class JiraStepDefinitions {

    private String addedIssueId = "";
    private String addedIssueKey = "";

    @Steps
    JiraSteps jiraSteps;
    private String summary;
    private String description;

    @Given("a jira user logged in using basic authentication")
    public void logInUsingBasicAuthentication() {
        jiraSteps.logInUsingBasicAuth();
        summary = "New Issue with basic auth";
        description = "The issue demonstrates the ability to perform basic authentication";
    }

    @Given("a jira user logged in using cookies authentication")
    public void logInUsingCookiesAuthentication() {
        jiraSteps.logInUsingCookiesAuth();
        summary = "New Issue with cookies auth";
        description = "The issue demonstrates the ability to perform cookies authentication";
    }

    @Given("a jira user logged in using OAuth authentication")
    public void logInUsingOAuthAuthentication() {
        jiraSteps.logInUsingOAuthAuth();
        summary = "New Issue with OAuth auth";
        description = "The issue demonstrates the ability to perform OAuth authentication";
    }

    @When("the user add issue")
    public void addJiraIssue() {
        jiraSteps.addIssueWithTypeTask("TAP", summary, description);
    }

    @Then("the issue added succesfully")
    public void issueShouldBeAdded() {
        jiraSteps.issueShouldBeAdded();
        addedIssueId = jiraSteps.noteRecentlyAddedIssueId();
    }

    @Then("the issue can be viewed in list of issues")
    public void issueShouldPresentInList() {
        jiraSteps.getAllIssuesForProject("TAP");
        jiraSteps.issueShouldBePresent(addedIssueId, summary, description);
        jiraSteps.issueShouldBePresentAlternative(addedIssueId, summary, description);
    }

    @Given("a system with issue")
    public void logInAndAddIssue() {
        jiraSteps.logInUsingBasicAuth();
        summary = "New Issue to be updated";
        description = "The issue demonstrates the ability to perform update";
        jiraSteps.addIssueWithTypeTask("TAP", summary, description);
        addedIssueKey= jiraSteps.noteRecentlyAddedIssueKey();
        addedIssueId= jiraSteps.noteRecentlyAddedIssueId();
    }

    @When("user edits Summary and Description of the issue")
    public void editSummaryAndDescriptionOfTheIssue() {
        summary = "Updated issue summary";
        description = "The issue description has been updated successfully";
        jiraSteps.updateSummaryAndDescriptionForIssue(addedIssueKey, summary, description);
    }

    @When("user edits Type of the issue")
    public void editTypeOfTheIssue() {
        summary = "Updated issue summary";
        description = "The issue description has been updated successfully";
        jiraSteps.updateTypeForIssue(addedIssueKey, "Bug");
    }

    @Then("edit operation completes succesfully")
    public void issueShouldBeUpdated() {
        jiraSteps.issueShouldBeUpdated();
    }

    @Then("changed Summary and Description can be viewed")
    public void issueShouldPresentInListWithChangedFields() {
        jiraSteps.getAllIssuesForProject("TAP");
        jiraSteps.issueShouldBePresent(addedIssueId, summary, description);
        jiraSteps.issueShouldBePresentAlternative(addedIssueId, summary, description);
    }

    @Then("changed Type can be viewed")
    public void issueShouldPresentInListWithChangedType() {
        jiraSteps.getAllIssuesForProject("TAP");
        jiraSteps.issueShouldHaveType(addedIssueId, "Bug");
    }
}
