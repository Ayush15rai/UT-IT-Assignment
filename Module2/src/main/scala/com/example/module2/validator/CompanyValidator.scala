package com.example.module2.validator

import com.example.module2.db.CompanyReadDto
import com.example.module2.models.Company

class CompanyValidator(companyName:CompanyReadDto, validateEmail: EmailValidator) {

  def companyIsValid(company: Company): Boolean = {
    if(companyName.getCompanyByName(company.name).isEmpty  && validateEmail.emailIdIsValid(company.emailId)){
      true
    }
    else
      false
  }
}