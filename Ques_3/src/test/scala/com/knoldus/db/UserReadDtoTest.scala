package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

class UserReadDtoTest extends AnyFlatSpec {

  val user = new UserReadDto()

  "Shekhar User " should "exist in database" in
  {
    val result = user.getUserByName("Shekhar")
    assert(!result.isEmpty)
  }

  "Poonam User " should "exist in database" in
    {
      val result = user.getUserByName("Poonam")
      assert(!result.isEmpty)
    }

  "Shashi User " should "not exist in database" in{
    val result=user.getUserByName("Shashi")
    assert(result.isEmpty)
  }




}
