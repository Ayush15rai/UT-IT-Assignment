package com.example.module2.request

import com.example.module2.models.Employee
import com.example.module2.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Ayush:Employee = new Employee("Ayush","Rai",21,15000,"Intern","Knoldus","ayush.rai@knoldus.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be created"){
    when(employeeValidator.employeeIsValid(Ayush)) thenReturn(true)
    val result = userImpl.createEmployee(Ayush)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Ayush)) thenReturn(false)
    val result = userImpl.createEmployee(Ayush)
    assert(result.isEmpty)
  }
}