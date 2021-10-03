package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;

        // options for selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //set access  for video into selenoid
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        // set options
        Configuration.browserCapabilities = capabilities;
        // url of selenoid
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

}
