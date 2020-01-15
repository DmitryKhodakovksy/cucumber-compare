package com.epam.cucumber.compare.qa.acceptance.tests.cucumber4.w3schools.stepsDef;

import com.epam.cucumber.compare.qa.common.gui.enums.MenuLinks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class CommonStepsDef extends AbstractStepsDef{

    @Given("^I open HTML home page$")
    public void iOpenHTMLHomePage(){
        homePage.open();
    }

    @When("I click {string} link")
    public void iClickHTMLTableLink(String linkName) {
        homePage.clickLink(linkName);
    }

    @When("I click HTML {link} link")
    public void iClickHTMLBasicLink(MenuLinks link) {
        driver.findElement(By.linkText("HTML " + link.getName())).click();
    }
}
