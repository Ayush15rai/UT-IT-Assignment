package com.example.module2.request

import com.example.module2.db.CompanyReadDto
import com.example.module2.models.Company
import com.example.module2.validator.{CompanyValidator, EmailValidator}
import org.scalatest.funsuite.AnyFunSuite

class CompanyImplIntegrationTest extends AnyFunSuite{
  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val companyValidator = new CompanyValidator(companyName,validateEmail)

  test("Company should not be created as already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
  test("Company should not be created as email ID is not valid"){
    val ibmCompany: Company = Company("IBM", "IBM@ibmac", "Noida")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(ibmCompany)
    assert(result.isEmpty)
  }
  test("can not created as email not valid and already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus","knoldus@gmailcom","Noida")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
  test("company can be created"){
    val googleCompany: Company = Company("Google", "google@gmail.com", "Gurugram")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isDefined)
  }
}

