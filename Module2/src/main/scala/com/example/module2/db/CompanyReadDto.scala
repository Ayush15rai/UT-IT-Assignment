package com.example.module2.db
import com.example.module2.models.Company
import scala.collection.immutable.HashMap

class CompanyReadDto {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val philipsCompany: Company = Company("Philips", "philips123@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Philips" -> philipsCompany)
  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}