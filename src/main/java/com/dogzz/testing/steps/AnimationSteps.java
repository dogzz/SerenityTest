/*
* @Author: dogzz
* @Created: 6/7/2016
*/

package com.dogzz.testing.steps;

import com.dogzz.testing.page.AnimatedDirectivesPage;
import com.dogzz.testing.page.JavaScriptAnimationPage;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimationSteps {

    AnimatedDirectivesPage animatedDirectivesPage;
    JavaScriptAnimationPage javaScriptAnimationPage;

    @Step
    public void openAnimationPage() {
        animatedDirectivesPage.open();
    }

    @Step
    public void openJSAnimationPage() {
        javaScriptAnimationPage.open();
    }

    @Step
    public void checkElement(String element) {
        switch (element) {
            case "EnterLeave":
                animatedDirectivesPage.checkShowSquare();
                break;
            case "AddRemoveClass":
                animatedDirectivesPage.checkShowClassSquare();
                break;
            case "CSSFrame":
                animatedDirectivesPage.checkShowCSSSquare();
                break;
            case "JSEnterLeave":
                javaScriptAnimationPage.checkShowSquare();
                break;
        }
    }

    @Step
    public void uncheckElement(String element) {
        switch (element) {
            case "EnterLeave":
                animatedDirectivesPage.uncheckShowSquare();
                break;
            case "AddRemoveClass":
                animatedDirectivesPage.uncheckShowClassSquare();
                break;
            case "CSSFrame":
                animatedDirectivesPage.uncheckShowCSSSquare();
                break;
            case "JSEnterLeave":
                javaScriptAnimationPage.uncheckShowSquare();
                break;
        }
    }

    @Step
    public void shouldSeeSquare(String element) {
        switch (element) {
            case "JSEnterLeave":
                assertThat(javaScriptAnimationPage.isSquarePresent()).isTrue();
                break;
            default:
                assertThat(animatedDirectivesPage.isSquarePresent(element)).isTrue();
                break;
        }
    }

    @Step
    public void shouldNotSeeSquare(String element) {
        switch (element) {
            case "JSEnterLeave":
                assertThat(javaScriptAnimationPage.isSquarePresent()).isFalse();
                break;
            default:
                assertThat(animatedDirectivesPage.isSquarePresent(element)).isFalse();
                break;
        }
    }

    @Step
    public void reverseArray() {
        animatedDirectivesPage.reverseArray();
    }

    @Step
    public void shouldSeeReversedArray() {
        List<String> currentArray = animatedDirectivesPage.getCurrentArray();
        assertThat(currentArray).isEqualTo(Arrays.asList("Fourth", "Third", "Second", "First"));
    }

    @Step
    public void shouldSeeOrderedArray() {
        List<String> currentArray = animatedDirectivesPage.getCurrentArray();
        assertThat(currentArray).isEqualTo(Arrays.asList("First", "Second", "Third", "Fourth"));
    }
}
