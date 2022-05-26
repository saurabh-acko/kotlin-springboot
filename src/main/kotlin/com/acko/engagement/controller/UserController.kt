package com.acko.engagement.controller

import com.acko.engagement.datasource.mock.MockUserData
import com.acko.engagement.model.UserData
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/health-data")
class UserController(val mockUserData: MockUserData) {
    @GetMapping
    fun getUserData(): List<UserData> {
        return mockUserData.getUserData()
    }


    @GetMapping("/{userId}")
    fun getUseUserById(@PathVariable userId: String): UserData {
        return mockUserData.getUserDataById(userId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody userData: UserData):UserData = mockUserData.addUser(userData)
}