package com.homanad.android.project.base.ui.vm

import com.homanad.android.project.domain.entities.MyEntity
import com.homanad.android.project.domain.repositories.MyRepository
import com.homanad.android.project.domain.usecases.GetSomethingUseCase
import com.homanad.android.project.domain.usecases.GetSomethingsUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class MainViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun shouldReturnSomething() = runTest {
        val useCase = GetSomethingUseCase(DummyRepoImpl())
        val result = useCase()

        assert(result.id == "abc")
    }

    @Test
    fun shouldReturnSomethings() = runTest {
        val useCase = GetSomethingsUseCase(DummyRepoImpl())
        val result = useCase(0)

        assert(result.size == 3)
    }
}

class DummyRepoImpl : MyRepository {

    override suspend fun getSomething(): MyEntity {
        return MyEntity("abc", "pro1", "pro2", "pro3")
    }

    override suspend fun getSomething(param: Int): List<MyEntity> {
        return listOf(
            MyEntity("abc1", "pro1", "pro2", "pro3"),
            MyEntity("abc2", "pro1", "pro2", "pro3"),
            MyEntity("abc3", "pro1", "pro2", "pro3")
        )
    }
}