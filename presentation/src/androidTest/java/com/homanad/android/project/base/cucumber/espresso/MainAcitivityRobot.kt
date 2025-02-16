package com.homanad.android.project.base.cucumber.espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.homanad.android.project.base.R
import com.homanad.android.project.base.ui.MainActivity

class MainActivityRobot {
    fun launchMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    fun clickSomethingButton() {
        onView(withId(R.id.buttonForSomething)).perform(click())
    }

    fun expectSomethingData() {
        onView(withId(R.id.textForSomething)).perform(click())
    }
}