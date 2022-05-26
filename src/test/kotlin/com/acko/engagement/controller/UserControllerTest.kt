package com.acko.engagement.controller

import com.acko.engagement.model.UserData
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class UserControllerTest @Autowired constructor(val mockMvc: MockMvc, val objectMapper: ObjectMapper) {
    val path = "/api/v1"

    @Test
    fun `should return all users`() {
        //given
        mockMvc.get("$path/health-data").andDo {
            print()
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$[0].id") { value(1) }
        }

        // when


        // then
    }

    @Test
    fun `should return a specific user`() {
        //given
        val userId = 1
        mockMvc.get("$path/health-data/$userId").andDo {
            print()
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.id") { value("1") }
        }
    }


    @Test
    fun `should return not found in case user does not exist`() {
        //given
        val userId = 4
        mockMvc.get("$path/health-data/$userId").andDo {
            print()
        }.andExpect {
            status { isNotFound() }
        }
    }

    @Test
    fun `POST user api`() {
        //given
        val userId = 4
        mockMvc.post("$path/health-data/") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(UserData("4", "Saksham"))
        }.andDo {
            print()
        }.andExpect {
            status { isCreated() }
        }
    }

    @Test
    fun `check already existing user id`() {
        //given
        val userId = 2
        mockMvc.post("$path/health-data/") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(UserData("2", "Saksham"))
        }.andDo {
            print()
        }.andExpect {
            status { isBadRequest() }
        }
    }
}