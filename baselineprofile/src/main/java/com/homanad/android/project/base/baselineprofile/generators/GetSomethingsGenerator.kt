package com.homanad.android.project.base.baselineprofile.generators

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.UiDevice
import com.homanad.android.project.base.baselineprofile.generators.common.BaseGenerator
import com.homanad.android.project.base.baselineprofile.generators.common.findId
import com.homanad.android.project.base.baselineprofile.generators.common.startApp
import com.homanad.android.project.base.baselineprofile.generators.common.waitForObject

class GetSomethingsGenerator : BaseGenerator() {

    override fun MacrobenchmarkScope.setupBlock() {
        startApp()
    }

    override fun UiDevice.profileBlock() {
        val somethingsButton = findId("buttonForSomethings")
        waitForObject(somethingsButton) {
            it.click()
        }
    }
}