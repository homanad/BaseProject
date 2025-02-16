package com.homanad.android.project.base.cucumber.steps

import com.homanad.android.project.base.cucumber.espresso.MainActivityRobot
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class GetSomethingSteps {

    private val robot = MainActivityRobot()

    @Given("^I start the application$")
    fun startApplication() {
        robot.launchMainActivity()
    }

    @When("^I click something button$")
    fun clickSomethingButton() {
        robot.clickSomethingButton()
    }

    @Then("^I expect to see something data$")
    fun expectSomethingData() {
        robot.expectSomethingData()
    }
}