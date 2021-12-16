package com.example.module1.PasswordValidator
import java.util.regex.Pattern


class PasswordValidator(){

  def isValidPassword(password:String):Boolean={
    if(password.contains(" ")){
      return false
    }

    //Check length of password is between 8 & 15 inclusive
    if (!(password.length >= 8 && password.length <= 15))
      return false


    //Check if password contains digit and at-least one Uppercase and lowercase
    val upperletter = Pattern.compile("[A-Z]")
    val lowerletter = Pattern.compile("[a-z]")
    val digit = Pattern.compile("[0-9]")
    val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")

    val hasUpperLetter = upperletter.matcher(password)
    val hasLowerLetter = lowerletter.matcher(password)
    val hasDigit = digit.matcher(password)
    val hasSpecial = special.matcher(password)

    if( !(hasLowerLetter.find() && hasUpperLetter.find() && hasDigit.find() && hasSpecial.find()) ){
      return false
    }

    true
  }

}

