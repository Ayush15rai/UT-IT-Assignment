package com.example.module2.db

import org.scalatest.funsuite.AnyFunSuite

class CompanReadtoDTest extends AnyFunSuite{
  val companyReadDto = new CompanyReadDto()

  test("Check if company exists in DB"){
    val companeName = "Knoldus"
    val result = companyReadDto.getCompanyByName(companeName)
    assert(result.isDefined)
    //    val expectedResult = true
    //    assert(result.isDefined == expectedResult)
  }

  test("Company should not exist in DB "){
    val companeName = "Google"
    val result = companyReadDto.getCompanyByName(companeName)
    assert(result.isEmpty)
  }
}
