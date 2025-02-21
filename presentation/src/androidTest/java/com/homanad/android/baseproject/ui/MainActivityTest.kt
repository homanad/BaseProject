//package com.homanad.android.project.base.ui
//
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.assertion.ViewAssertions.matches
//import androidx.test.espresso.matcher.LayoutMatchers.hasMultilineText
//import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
//import androidx.test.espresso.matcher.ViewMatchers.withId
//import androidx.test.ext.junit.rules.ActivityScenarioRule
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.homanad.android.project.base.R
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class MainActivityTest {
//
//    @get:Rule
//    val activityRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Test
//    fun buttonForSomethingShouldBeDisplayed() {
//        onView(withId(R.id.buttonForSomething)).check(matches(isDisplayed()))
//        onView(withId(R.id.buttonForSomething)).perform(click())
//    }
//
//    @Test
//    fun buttonForSomethingsShouldBeDisplayed() {
//        onView(withId(R.id.buttonForSomethings)).check(matches(isDisplayed()))
//        onView(withId(R.id.buttonForSomethings)).perform(click())
//        onView(withId(R.id.textForSomethings)).check(matches(hasMultilineText()))
//    }
//}