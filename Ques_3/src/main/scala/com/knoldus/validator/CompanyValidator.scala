package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto

class CompanyValidator(companyName:CompanyReadDto,email:EmailValidator) {





  def companyIsValid(company: Company): Boolean =

    if(companyName.getCompanyByName(company.name).isEmpty &&
    email.emailIdIsValid(company.emailId))
      true
    else
      false


  }






