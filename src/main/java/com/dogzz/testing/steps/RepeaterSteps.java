/*
* @Author: dogzz
* @Created: 6/6/2016
*/

package com.dogzz.testing.steps;

import com.dogzz.testing.page.RepeaterPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class RepeaterSteps {

    RepeaterPage repeaterPage;

    @Step
    public void openRepeaterPage() {
        repeaterPage.open();
    }

    @Step
    public void addNewItem() {
        repeaterPage.addItem();
    }

    @Step
    public void removeItem(int index) {
        repeaterPage.removeItem(index);
    }

    @Step
    public void itemShouldExists(int index) {
        assertThat(repeaterPage.isItemExists(index)).isTrue();
    }

    @Step
    public void itemShouldNotExists(int index) {
        assertThat(repeaterPage.isItemExists(index)).isFalse();
    }

    @Step
    public void tableShouldNotExists() {
        assertThat(repeaterPage.isTableExists()).isFalse();
    }

    @Step
    public void twoItemsHaveIncrementedNames(int firstItem, int secondItem) {
        String first = repeaterPage.getTextForItemWithIndex(firstItem);
        String second = repeaterPage.getTextForItemWithIndex(secondItem);
        int firstNumber = Integer.valueOf(first.substring(first.indexOf(' ') + 1));
        int secondNumber = Integer.valueOf(second.substring(first.indexOf(' ') + 1));
        assertThat(firstNumber + 1).isEqualTo(secondNumber);
    }
}
