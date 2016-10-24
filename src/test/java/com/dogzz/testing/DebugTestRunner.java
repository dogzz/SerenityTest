/*
* @Author: dogzz
* @Created: 6/9/2016
*/

package com.dogzz.testing;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.steps.ParameterControls;

public class DebugTestRunner extends SerenityStories {

    public DebugTestRunner() {
//        findStoriesCalled("stories/WebServicesInteractions/JiraApi/AddIssueWithDifferentFields.story");
        findStoriesCalled("stories/WebServicesInteractions/JiraApi/AddIssue.story;" +
                        "stories/WebServicesInteractions/JiraApi/AddIssueWithDifferentFields.story;" +
                "stories/WebServicesInteractions/JiraApi/EditIssue.story");
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useStoryTimeoutInSecs(800);
        configuration().useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
    }
}
