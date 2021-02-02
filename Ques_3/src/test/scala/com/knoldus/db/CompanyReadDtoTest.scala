package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

class CompanyReadDtoTest extends AnyFlatSpec {


  val company = new CompanyReadDto()

  "Knoldus Company" should "exist" in {
    val result = company.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  "Nokia Company" should " not exist" in {
    val result = company.getCompanyByName("Nokia")
    assert(result.isEmpty)
  }




}
