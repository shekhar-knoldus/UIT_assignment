package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class Email_ValidationTest extends AnyFlatSpec {

  val obj_email=new Email_Validation()

  "The email" should "be correct "in{
    var res:Boolean=obj_email.isValid(email="Shekhar.yadav@knoldus.com")
    assert(res==true)

  }
  "email" should "invalid with missing @" in {
    var result: Boolean =obj_email.isValid("shekhar.yadavgmail.com")
    assert(result == false)
  }
  "email" should "invalid with missing top level domain" in {
    var result: Boolean =obj_email.isValid ("shekhar@yadav")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {
    var result: Boolean =obj_email.isValid("shekhar@gmail.uk")
    assert(result == false)
  }


}
