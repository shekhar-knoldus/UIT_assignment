package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class UserValidatorTest extends AnyFlatSpec {

  val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val user: User = User("Shekhar","Yadav","shekhar.yadav@knoldus.com","knoldus")
  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

 val userValidator=new UserValidator(mockedCompanyReadDto,mockedEmailValidator)

  "User" should "be valid as email format correct and company exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn(Option(company))
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(user)
    assert(result)
  }
  "User" should "not be valid as his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn(Option(company))
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(user)
    assert(!result)
  }

  "User" should "not be valid as his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(user)
    assert(!result)
  }

  "User" should "not be valid as his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(user)
    assert(!result)
  }





}
