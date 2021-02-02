package com.knoldus.validator

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean =

    if("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.com|.net|.org)$".r.findFirstIn(emailId)==None)
      false
    else
      true

}
