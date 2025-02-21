package com.homanad.android.baseproject.baselineprofile.generators

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.uiautomator.UiDevice
import com.homanad.android.baseproject.baselineprofile.generators.common.BaseGenerator
import com.homanad.android.baseproject.baselineprofile.generators.common.findId
import com.homanad.android.baseproject.baselineprofile.generators.common.startApp
import com.homanad.android.baseproject.baselineprofile.generators.common.waitForObject

class GetSomethingGenerator : BaseGenerator() {

    override fun MacrobenchmarkScope.setupBlock() {
        startApp()
    }

    override fun UiDevice.profileBlock() {
        val editText = findId("edtId")
        waitForObject(editText) {
            it.text = "1"
        }
        waitForIdle()

        val somethingButton = findId("buttonForSomething")
        waitForObject(somethingButton) {
            it.click()
        }
    }
}