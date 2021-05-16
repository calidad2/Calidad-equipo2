package com.aplicacionps.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
        plugin = "pretty",
        features = {
                "src/test/java/com/aplicacionps/cucumber/Youtube/Youtube.feature",
                "src/test/java/com/aplicacionps/cucumber/idioma/idioma.feature"

        },
        glue = "com.aplicacionps.cucumber"
)
@RunWith(Cucumber.class)
public class Runner {

}