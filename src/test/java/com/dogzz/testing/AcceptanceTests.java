/*
* @Author: dogzz
* @Created: 6/8/2016
*/

package com.dogzz.testing;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.steps.ParameterControls;

public class AcceptanceTests extends SerenityStories {

    public AcceptanceTests() {
        //used to allow to pass parameters from examples by their names in table
        // instead of using @Named annotation
        configuration().useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useStoryTimeouts(Long.toString(800));;
    }
}
