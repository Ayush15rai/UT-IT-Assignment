package com.example.module2.validator

import com.example.module2.db.CompanyReadDto
import com.example.module2.models.Employee

class EmployeeValidator(companyName: CompanyReadDto, validateEmail: EmailValidator) {

  def employeeIsValid(employee: Employee): Boolean = {

    if(companyName.getCompanyByName(employee.companyName).isDefined && validateEmail.emailIdIsValid(employee.emailId))
      true
    else
      false
  }
}
