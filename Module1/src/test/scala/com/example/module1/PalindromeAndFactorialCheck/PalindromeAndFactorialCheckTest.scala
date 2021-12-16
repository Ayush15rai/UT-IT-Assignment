package com.example.module1.PalindromeAndFactorialCheck

import org.scalatest.funsuite.AnyFunSuite

class PalindromeAndFactorialCheckTest extends AnyFunSuite {
  var check = new PalindromeAndFactorialCheck()

  //Test cases to check isPalindrome method
  test("This test case checks if number is palindrome or not"){
    val number= 757
    val expectedResult: Boolean = true
    assert(check.palindromeChecker(number) == expectedResult)
  }

  test("This test case if negative number is palindrome or not"){
    val number = -155
    val expectedResult = false
    assert(check.palindromeChecker(number) == expectedResult)
  }

  test("Number is pallindrome if it is zero 0"){
    val number = 0
    val expectedResult = true
    assert(check.palindromeChecker(number) == expectedResult)
  }

  test("Number should not be palindrome"){
    val number = 5814
    val expectedResult = false
    assert(check.palindromeChecker(number) == expectedResult)
  }


  //Test cases to check factorial method
  test("This test will check if factorial of number is right or not"){
    val number = 5
    val expectedResult = 120
    assert(check.factorialChecker(number) == expectedResult)
  }
  test("This test will check if factorial of 0 is 1"){
    val number = 0
    val expectedResult = 1
    assert(check.factorialChecker(number) == expectedResult)
  }
  test("This test will check is factorial of number is right or not"){
    val number = 10
    val expectedResult = 3628800
    assert(check.factorialChecker(number) == expectedResult)
  }
}
