/*
* @Author: dogzz
* @Created: 6/9/2016
*/

package com.dogzz;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.steps.ParameterControls;

public class DebugTestRunner extends SerenityStories {

    public DebugTestRunner() {
//        findStoriesCalled("stories/AngularInteractions/animation/AnimationDirectives.story");
        findStoriesCalled("stories/WebServicesInteractions/HTTPService/PostRequests.story;" +
                "stories/WebServicesInteractions/HTTPService/OtherRequests.story");
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useStoryTimeoutInSecs(800);
        configuration().useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
    }
}
