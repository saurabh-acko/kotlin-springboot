package com.acko.engagement.repository

import com.acko.engagement.model.UserData
import org.springframework.stereotype.Repository

@Repository
interface UserDataRepository {

    fun getUserData():List<UserData>

    fun getUserDataById(id:String):UserData

    fun addUser(userData: UserData):UserData

}