package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {

  val obj_email=new EmailValidator()

  "The email" should "be correct "in{
    var res:Boolean=obj_email.emailIdIsValid("shekhar.yadav@knoldus.com")
    assert(res==true)

  }
  "email" should "invalid with missing @" in {
    var result: Boolean =obj_email.emailIdIsValid("shekhar.yadavgmail.com")
    assert(result == false)
  }
  "email" should "invalid with missing top level domain" in {
    var result: Boolean =obj_email.emailIdIsValid("poonam@tripathi")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {
    var result: Boolean =obj_email.emailIdIsValid("shekharyadav@gmail.uk")
    assert(result == false)
  }


}
