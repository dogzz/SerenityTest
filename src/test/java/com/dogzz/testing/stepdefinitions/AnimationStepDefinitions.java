/*
* @Author: dogzz
* @Created: 6/7/2016
*/

package com.dogzz.testing.stepdefinitions;

import com.dogzz.testing.steps.AnimationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class AnimationStepDefinitions {

    @Steps
    AnimationSteps animationSteps;

    @Given("an animation page is open")
    public void openAnimationPage() {
        animationSteps.openAnimationPage();
    }

    @Given("a JavaScript animation page is open")
    public void openJSAnimationPage() {
        animationSteps.openJSAnimationPage();
    }

    @When("I $action $element element")
    @Given("$element element is $action")
    public void checkShowElement(String action, @Named("element") String element) {
        switch (action) {
            case "checked":
            case "check":
                animationSteps.checkElement(element);
                break;
            case "uncheck":
                animationSteps.uncheckElement(element);
                break;
        }
    }

    @Then("square for $element should be displayed")
    public void squareShouldBeDisplayed(@Named("element") String element) {
        animationSteps.shouldSeeSquare(element);
    }

    @Then("square for $element should not be displayed")
    public void squareShouldNotBeDisplayed(@Named("element") String element) {
        animationSteps.shouldNotSeeSquare(element);
    }

    @When("I reversing array")
    @Given("array is reversed")
    public void reverseArray() {
        animationSteps.reverseArray();
    }

    @Then("array should be reversed")
    public void arrayShouldBeReversed() {
        animationSteps.shouldSeeReversedArray();
    }

    @Then("array should be reversed back")
    public void arrayShouldBeReversedBack() {
        animationSteps.shouldSeeOrderedArray();
    }
}
