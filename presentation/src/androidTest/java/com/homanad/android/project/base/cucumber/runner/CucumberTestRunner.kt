package com.homanad.android.project.base.cucumber.runner

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.homanad.android.project.base.BuildConfig
import cucumber.api.android.CucumberInstrumentationCore

class CucumberTestRunner : AndroidJUnitRunner() {

    private val CUCUMBER_TAGS_KEY: String = "tags"
    private val CUCUMBER_SCENARIO_KEY: String = "name"
    private val instrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle) {
        val tags = BuildConfig.TEST_TAGS
        if (tags.isNotEmpty()) {
            arguments.putString(CUCUMBER_TAGS_KEY, tags.replace("\\s".toRegex(), ""))
        }
        var scenario = BuildConfig.TEST_SCENARIO
        if (scenario.isNotEmpty()) {
            scenario = scenario.replace(" ".toRegex(), "\\\\s")
            arguments.putString(CUCUMBER_SCENARIO_KEY, scenario)
        }
        instrumentationCore.create(arguments)
        super.onCreate(arguments)
    }

    override fun onStart() {
        waitForIdleSync()
        instrumentationCore.start()
    }

//    private val instrumentationCore = CucumberInstrumentationCore(this)
//    override fun onCreate(arguments: Bundle?) {
//        super.onCreate(arguments)
//
//        instrumentationCore.create(arguments)
//        start()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        waitForIdleSync()
//        instrumentationCore.start()
//    }
}