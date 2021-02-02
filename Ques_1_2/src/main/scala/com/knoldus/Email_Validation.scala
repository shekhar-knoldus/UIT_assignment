package com.knoldus

class Email_Validation {



 def isValid(email:String):Boolean = if("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.com|.net|.org)$".r.findFirstIn(email)==None) false else true

}
