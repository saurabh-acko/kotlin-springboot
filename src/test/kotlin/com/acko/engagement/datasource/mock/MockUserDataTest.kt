package com.acko.engagement.datasource.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MockUserDataTest {
    private val mockData = MockUserData()

    @Test
    fun `should provide user data list`() {
        val data = mockData.getUserData()
        Assertions.assertThat(data).isNotEmpty
        Assertions.assertThat(data.size).isGreaterThanOrEqualTo(3)

    }

    @Test
    fun `user data is valid`() {
        val data = mockData.getUserData()
        Assertions.assertThat(data).allMatch { it.name.isNotBlank() }
        Assertions.assertThat(data).allMatch { it.id.toInt()>0 }
    }
}