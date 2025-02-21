package com.homanad.android.baseproject.cucumber.steps

import com.homanad.android.baseproject.cucumber.espresso.MainActivityRobot
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class GetSomethingsSteps {

    private val robot = MainActivityRobot()

    @Given("^I start the application$")
    fun startApplication() {
        robot.launchMainActivity()
    }

    @When("^I click somethings button$")
    fun clickSomethingButton() {
        robot.clickSomethingsButton()
    }

    @Then("^I expect to see somethings data$")
    fun expectSomethingsData() {
        robot.expectSomethingsData()
    }
}