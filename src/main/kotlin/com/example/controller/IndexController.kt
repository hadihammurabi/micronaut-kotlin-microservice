package com.example.controller

import javax.annotation.security.PermitAll

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

data class IndexResult(
  val message: String
)

@Controller("/")
class IndexController {

  @Get(produces = [MediaType.APPLICATION_JSON]) 
  @PermitAll
  fun index(): IndexResult {
    return IndexResult("Welcome!! This is a Micronaut Kotlin with Microservice ready starter pack.")
  }

}
