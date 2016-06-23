/*
* @Author: dogzz
* @Created: 6/13/2016
*/

package com.dogzz.testing.steps;

import com.dogzz.testing.page.QServicePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class ServicesUISteps {

    QServicePage qServicePage;

    @Step
    public void executeSuccessActionForServiceType(String serviceType) {
        executeAction(true, serviceType);
    }

    @Step
    public void executeFailureActionForServiceType(String serviceType) {
        executeAction(false, serviceType);
    }

    private void executeAction(boolean isSuccess, String serviceType) {
        switch (serviceType) {
            case "http":
                if (isSuccess) {
                    qServicePage.executeSuccessForHttpService();
                } else {
                    qServicePage.executeFailureForHttpService();
                }
                Serenity.setSessionVariable("serviceType").to("http");
                break;
            case "fake":
                if (isSuccess) {
                    qServicePage.executeSuccessForFakeService();
                } else {
                    qServicePage.executeFailureForFakeService();
                }
                Serenity.setSessionVariable("serviceType").to("fake");
                break;
        }
    }

    @Step
    public void shouldDisplayForSavedServiceTypeCorrectRersult(String result) {
        String serviceType = Serenity.sessionVariableCalled("serviceType").toString();
        String actualResult = "";
//        switch (serviceType) {
//            case "http":
//                actualResult = qServicePage.getHttpServiceActionResult();
//                break;
//            case "fake":
//                actualResult = qServicePage.getFakeServiceActionResult();
//                break;
//        }
        actualResult = qServicePage.getAllResults();
        assertThat(actualResult).containsIgnoringCase(result);
    }

    @Step
    public void openQServicePage() {
        qServicePage.open();
    }

}
