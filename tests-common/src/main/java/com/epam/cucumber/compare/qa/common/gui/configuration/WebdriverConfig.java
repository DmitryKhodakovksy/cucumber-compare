package com.epam.cucumber.compare.qa.common.gui.configuration;
/*
 * Copyright 2002 - 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.epam.cucumber.compare.qa.common.gui.services.webdriver.WrappedWebdriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

/**
 * Created by Anton_Shapin on 5/23/17.
 */
@Configuration
public class WebdriverConfig {

    @Value("${webdriver.browser:Firefox}")
    private String browserName;


    @Bean(destroyMethod = "quit")
    public WrappedWebdriver webDriver() throws IOException {
        return Match(browserName).of(
                Case($(CHROME::equalsIgnoreCase), this::initChrome),
                Case($(FIREFOX::equalsIgnoreCase), this::initFirefox)
        );
    }

    private WrappedWebdriver initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return new WrappedWebdriver(driver);
    }

    private WrappedWebdriver initChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return new WrappedWebdriver(driver);
    }
}
