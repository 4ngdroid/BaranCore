package com.arghamnegargroup.core.features.auth.domain.usecase

import com.arghamnegargroup.core.features.auth.data.repository.FakeAuthRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

//import com.google.common.truth.Truth.assertThat


@ExperimentalCoroutinesApi
class LoginTest {

    private lateinit var login: Login
    private lateinit var fakeRepository: FakeAuthRepository

    @Before
    fun setup() {
        fakeRepository = FakeAuthRepository()
        login = Login(fakeRepository)
    }


    @Test
    fun `Login successfully`() = runTest {
        val username = "admin"
        val password = ""
        val response = login(username, password)
        assertThat(response).isEqualTo(Result.success(Unit))
    }


    @Test
    fun `Login with empty username`() = runTest {
        val username = ""
        val password = ""
        val response = login(username, password)
        assertThat(response.exceptionOrNull()).isInstanceOf(NullPointerException::class.java)
    }
}