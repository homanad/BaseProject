package com.homanad.android.baseproject.cucumber.espresso

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.LayoutMatchers.hasMultilineText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.homanad.android.baseproject.R
import com.homanad.android.baseproject.ui.MainActivity

class MainActivityRobot {
    fun launchMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    fun clickSomethingsButton() {
        onView(withId(R.id.buttonForSomethings)).perform(click())
    }

    fun expectSomethingsData() {
        onView(withId(R.id.textForSomethings)).check(matches(hasMultilineText()))
    }

    fun clickEditText() {
        onView(withId(R.id.edtId)).perform(click())
    }

    fun typeIdOnEditText(id: Int) {
        onView(withId(R.id.edtId)).perform(typeText("$id"))
    }

    fun closeKeyboard() {
        closeSoftKeyboard()
        Thread.sleep(100)
    }

    fun clickSomethingButton() {
        onView(withId(R.id.buttonForSomething)).perform(click())
    }

    fun expectSomethingData(id: Int) {
        onView(withId(R.id.textForSomethings)).check { view, noViewFoundException ->
            (view as TextView).text.contains("$id")
        }
        onView(withId(R.id.textForSomethings)).check(matches(isDisplayed()))
    }
}