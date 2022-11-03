package com.example.acronym

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.acronym.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get : Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkForDisplayedData() {
        onView(withId(R.id.et_search)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_meanings)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_no_data)).check(matches(isDisplayed()))

    }

    @Test
    fun checkSearchButtonClick() {
        onView(withId(R.id.btn_search)).perform(click())
    }

    @Test
    fun checkNoDataText() {
        onView(withId(R.id.tv_no_data)).check(matches(withText(R.string.no_data_found)))
    }

}