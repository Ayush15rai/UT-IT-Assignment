package com.example.module2.request

import com.example.module2.models.Company
import com.example.module2.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class CompanyImplTest extends AnyFunSuite{
  val companyValidator = mock[CompanyValidator]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  test("company should be created"){
    val companyImpl = new CompanyImpl(companyValidator)
    when(companyValidator.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isDefined)
  }

  test("company should not be created"){
    val companyImpl = new CompanyImpl(companyValidator)
    when(companyValidator.companyIsValid(knoldusCompany)) thenReturn(false)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}