package com.homanad.android.baseproject.baselineprofile.generators

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.UiDevice
import com.homanad.android.baseproject.baselineprofile.generators.common.BaseGenerator
import com.homanad.android.baseproject.baselineprofile.generators.common.startApp

class StartupGenerator : BaseGenerator() {

    override val includeInStartupProfile = true

    override fun MacrobenchmarkScope.setupBlock() {
        startApp()
    }

    override fun UiDevice.profileBlock() {}
}