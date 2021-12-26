package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
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
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.remote = "137.184.53.141:8080";
    }

    // add attachments into Allure report
    @AfterEach
    public void tearDown(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
