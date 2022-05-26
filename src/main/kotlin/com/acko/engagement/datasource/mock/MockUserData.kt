package com.acko.engagement.datasource.mock

import com.acko.engagement.model.UserData
import com.acko.engagement.repository.UserDataRepository
import org.springframework.stereotype.Repository

@Repository
class MockUserData : UserDataRepository {
    val data = mutableListOf(
        UserData("1", "Saurabh"),
        UserData("2", "Shivam"),
        UserData("3", "Shera"),
    )

    override fun getUserData(): List<UserData> = data

    override fun getUserDataById(id: String): UserData {
        return data.firstOrNull() { it.id == id } ?: throw NoSuchElementException("User not found for the provided id")
    }

    override fun addUser(userData: UserData):UserData{
        if(data.any(){it.id == userData.id})
            throw IllegalArgumentException("Id already exists")
         data.add(userData)
        return userData
    }
}