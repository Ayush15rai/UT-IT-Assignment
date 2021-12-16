package com.example.module2.request
import com.example.module2.models.Company
import com.example.module2.validator.CompanyValidator

class CompanyImpl(companyValidator: CompanyValidator) {

  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) {
      println("=>Company ='"+company.name+"' is created successfully!")
      Option(company.name)
    }
    else{
      println("=>Company ='"+company.name+"' can not be not created")
      None
    }
  }
}