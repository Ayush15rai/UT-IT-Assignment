package com.example.module2.request
import com.example.module2.db.CompanyReadDto
import com.example.module2.models.Employee
import com.example.module2.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplIntegrationTest extends AnyFunSuite{
  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val employeeValidator = new EmployeeValidator(companyName,validateEmail)

  val employeeImpl = new EmployeeImpl(employeeValidator)

  test("user can not created bcz company doesn't exist"){
    val shubham:Employee = new Employee("Ayush","Rai",21,15000,"Intern","Google","ayush.rai@knoldus.com")
    val result = employeeImpl.createEmployee(shubham)
    assert(result.isEmpty)
  }

  test("user can not created bcz email is invalid"){
    val shubham:Employee = new Employee("Ayush","Rai",21,15000,"Intern","Knoldus","ayush.rai@knolduscom")
    val result = employeeImpl.createEmployee(shubham)
    assert(result.isEmpty)
  }
  test("user can not created bcz email invalid and company doesnt exist in DB"){
    val shubham:Employee = new Employee("Ayush","Rai",21,15000,"Intern","Google","ayush.rai@knolducom")
    val result = employeeImpl.createEmployee(shubham)
    assert(result.isEmpty)
  }
  test("user can be created"){
    val shubham:Employee = new Employee("Ayush","Rai",21,15000,"Intern","Knoldus","ayush.rai@knoldus.com")
    val result = employeeImpl.createEmployee(shubham)
    assert(result.isDefined)
  }
}