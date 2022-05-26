package com.acko.engagement.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMapAdapter

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(
            "{\"message\":\"${e.message}\"}",
            MultiValueMapAdapter<String, String>(mapOf("content-type" to listOf(MediaType.APPLICATION_JSON_VALUE))),
            HttpStatus.NOT_FOUND
        )

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(
            "{\"message\":\"${e.message}\"}",
            MultiValueMapAdapter<String, String>(mapOf("content-type" to listOf(MediaType.APPLICATION_JSON_VALUE))),
            HttpStatus.BAD_REQUEST
        )

}