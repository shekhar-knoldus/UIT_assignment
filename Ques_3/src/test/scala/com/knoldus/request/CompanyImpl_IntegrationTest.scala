package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

//Integration Test
class CompanyImpl_IntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val companyValidator = new CompanyValidator(companyName,validateEmail)

  "Company" should "not be created as it already exists in DB" in {
    val aCompany: Company = Company("Knoldus","knoldus@gmail.com", "Noida")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(aCompany)
    assert(result.isEmpty)
  }

  "Company" should "be created" in {
    val bCompany: Company = Company("Dell", "dell@gmail.com", "Hyderabad")

    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(bCompany)
    assert(!result.isEmpty)
  }

}
