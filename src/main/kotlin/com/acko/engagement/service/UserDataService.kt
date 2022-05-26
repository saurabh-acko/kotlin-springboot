package com.acko.engagement.service

import com.acko.engagement.datasource.mock.MockUserData
import com.acko.engagement.model.UserData
import org.springframework.stereotype.Service

@Service
class UserDataService(private val userData: MockUserData) {

    fun getUserData(): List<UserData> = userData.getUserData()
}