package com.acko.engagement.service

import com.acko.engagement.datasource.mock.MockUserData
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class UserDataServiceTest {
    private val mockUserData: MockUserData = mockk(relaxed = true)
    private val userDataService = UserDataService(mockUserData)

    @Test
    fun `should get user data from data source`() {
        // when
        userDataService.getUserData()
        // then
        verify(exactly = 1) { mockUserData.getUserData() }
    }

}