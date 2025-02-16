package com.homanad.android.project.base.baselineprofile.generators.common

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

private const val SMALL_TIMEOUT = 1000L
private const val DEFAULT_TIMEOUT = 5000L
private const val LONG_TIMEOUT = 10000L

fun getAppId() = InstrumentationRegistry.getArguments().getString("targetAppId")
    ?: throw Exception("targetAppId not passed as instrumentation runner arg")

fun MacrobenchmarkScope.startApp() {
    pressHome()
    startActivityAndWait()
}

fun findId(id: String): BySelector = By.res(getAppId(), id)

fun UiDevice.waitForObject(
    selector: BySelector,
    timeout: Long = DEFAULT_TIMEOUT,
    action: (UiObject2) -> Unit = {}
) {
    if (wait(Until.hasObject(selector), timeout)) {
        action.invoke(findObject(selector))
    } else {
        println("Can't find object: $selector after $timeout milliseconds")
    }
}
