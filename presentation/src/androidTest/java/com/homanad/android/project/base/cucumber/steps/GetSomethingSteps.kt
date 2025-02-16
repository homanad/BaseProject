package com.homanad.android.project.base.cucumber.steps

import com.homanad.android.project.base.cucumber.espresso.MainActivityRobot
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class GetSomethingSteps {

    private val robot = MainActivityRobot()

    @When("^I click id field$")
    fun clickEditText() {
        robot.clickEditText()
    }

    @And("^I type (\\S+)$")
    fun typeId(id: Int) {
        robot.typeIdOnEditText(id)
    }

    @And("^I close keyboard$")
    fun closeKeyboard() {
        robot.closeKeyboard()
    }

    @And("^I click something button$")
    fun clickSomethingButton() {
        robot.clickSomethingButton()
    }

    @Then("^I expect to see something data$")
    fun expectSomethingsData() {
        robot.expectSomethingData()
    }
}