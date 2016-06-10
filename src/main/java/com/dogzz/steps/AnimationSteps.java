/*
* @Author: dogzz
* @Created: 6/7/2016
*/

package com.dogzz.steps;

import com.dogzz.page.AnimatedDirectivesPage;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimationSteps {

    AnimatedDirectivesPage animatedDirectivesPage;

    @Step
    public void openAnimationPage() {
        animatedDirectivesPage.open();
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
        }
    }

    @Step
    public void shouldSeeSquare(String element) {
        assertThat(animatedDirectivesPage.isSquarePresent(element)).isTrue();
    }

    @Step
    public void shouldNotSeeSquare(String element) {
        assertThat(animatedDirectivesPage.isSquarePresent(element)).isFalse();
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
