package com.knoldus.request

import com.knoldus.request.CompanyImpl
import org.mockito.MockitoSugar.{mock, when}
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplTest extends AnyFlatSpec {

  val mockedCompanyValidator = mock[CompanyValidator]
  val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val newCompany:Company=Company("HCL","hcl@gmail.com","New Delhi")
  val companyImpl = new CompanyImpl(mockedCompanyValidator)

  //Unit Testing


  "Company" should " not be created" in {

    when(mockedCompanyValidator.companyIsValid(company)) thenReturn (false)
    val result = companyImpl.createCompany(company)
    assert(result.isEmpty)
  }
  "NewCompany" should "  be created" in {

    when(mockedCompanyValidator.companyIsValid(newCompany)) thenReturn (true)
    val result = companyImpl.createCompany(newCompany)
    assert(!result.isEmpty)
  }


}
