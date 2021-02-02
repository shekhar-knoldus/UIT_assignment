package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class Impl_Div_FibTest extends AnyFlatSpec {


  val obj_Fib = new Impl_Div_Fib()
  val obj_Div = new Impl_Div_Fib()

  //Test cases for testing of Fibonacci Function

  //Test cases: for correct Fibonacci Nth Number

  "The Fibonacci number" should "be correct" in {

    assert(obj_Fib.fibonacci(10)==34)
    assert(obj_Fib.fibonacci(1) == 0)
    assert(obj_Fib.fibonacci(3) == 1)
  }

  //Test cases: for incorrect Fibonacci Nth Number

  "The Fibonacci number" should "not be correct" in {

    assert(obj_Fib.fibonacci(10)!=33)
    /////10th Fibonacci number is 34

  }



  //Test cases for testing of Divide Function

  //Case 1:

  "10 when divided by 4" should "give 2" in {

    assert(obj_Div.divide(10, 4) == 2)

  }
  //Case 2:

  "10 divided by 0" should "throw ArithmeticException" in {

    assertThrows[ArithmeticException] {   //throws exception
      obj_Div.divide(10, 0)
    }

  }

}