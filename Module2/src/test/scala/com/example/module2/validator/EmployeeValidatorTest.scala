package com.example.module2.validator

import com.example.module2.db.CompanyReadDto
import com.example.module2.models.{Company, Employee}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeValidatorTest extends AnyFunSuite{
  val employee: Employee = Employee("Ayush", "Rai", 21, 15000, "Intern", "knoldus", "ayush.rai@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val companyRead: CompanyReadDto = mock[CompanyReadDto]
  val emailValidator: EmailValidator = mock[EmailValidator]
  val employeeValidator = new EmployeeValidator(companyRead,emailValidator)

  test("Employee should valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(result)
  }
  test("employee is not valid because of his email is invalid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test("employee is not valid because his company not exist in DB"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test("employee is not valid because his company not exist in DB and email is not valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
}

