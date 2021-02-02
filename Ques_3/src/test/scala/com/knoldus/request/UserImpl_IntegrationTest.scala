package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImpl_IntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator(companyName,validateEmail)

  val userImpl = new UserImpl(userValidator)
//Integration Test
  "User" should "not be created as company does not exists in DB" in {
    val User_1: User = User("Deepak","Kumar","deepak@gmail.com","rtds")

    val result = userImpl.createUser(User_1)
    assert(result.isEmpty)
  }

  "User" should "be created as email id is valid and company exist in DB" in {
    val User_2: User = User("Shekhar","Yadav","shekhar.yadav@knoldus.com","Knoldus")

    val result = userImpl.createUser(User_2)
    assert(!result.isEmpty)
  }


}
