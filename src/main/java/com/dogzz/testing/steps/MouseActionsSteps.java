/*
* @Author: dogzz
* @Created: 6/22/2016
*/

package com.dogzz.testing.steps;

import com.dogzz.testing.page.MouseEventPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;


public class MouseActionsSteps {

    MouseEventPage mouseEventPage;

    @Step
    public void openMouseEventsPage() {
        mouseEventPage.open();
    }

    @Step
    public void performDoubleClickOnShape() {
        mouseEventPage.doubleClickOnShape();
    }

    @Step
    public void doubleClickResultShouldBe(String result) {
        String actualResult = mouseEventPage.getAllResults();
        assertThat(actualResult).containsIgnoringCase(result);
    }

    @Step
    public void moveMouseOverShapeWithCoordinates(int x, int y) {
        mouseEventPage.moveMouseOverShape(x, y);
    }

    @Step
    public void moveCoordinatesShouldDisplayForResult(int x, int y, String result) {
        String actualResult = mouseEventPage.getAllResults();
        String expectedResult = result + " RESULT: Mouse move at (" + x + ", " + y + ")";
        assertThat(actualResult).containsIgnoringCase(expectedResult);
    }
}
