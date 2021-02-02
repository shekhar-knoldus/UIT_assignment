package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec


class CompanyValidatorTest extends AnyFlatSpec {

  val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)


  "Company" should "not be valid as email id format is not valid and company exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn(Option(company))
    when(mockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn(false)

    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  "Company" should "not be valid as it already exists in the DB" in {

    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn(Option(company))
    when(mockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn(true)

    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  "Company" should "not be valid as the email id format is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn(false)

    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }


  "Company" should "be valid as email id  format is correct company but not in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(company.name)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(company.emailId)) thenReturn(true)

    val result = companyValidator.companyIsValid(company)
    assert(result)
  }



}
