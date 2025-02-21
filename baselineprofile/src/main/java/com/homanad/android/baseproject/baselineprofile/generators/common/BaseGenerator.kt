package com.homanad.android.baseproject.baselineprofile.generators.common

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Before
    open fun setUp() {
    }

    open val includeInStartupProfile = false

    abstract fun MacrobenchmarkScope.setupBlock()

    abstract fun UiDevice.profileBlock()

    @Test
    fun generate() {
        rule.collect(
            packageName = getAppId(),
            maxIterations = 1,
            includeInStartupProfile = includeInStartupProfile
        ) {
            setupBlock()
            device.profileBlock()
        }
    }
}