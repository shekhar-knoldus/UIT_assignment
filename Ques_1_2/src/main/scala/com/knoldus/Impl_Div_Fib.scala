package com.knoldus

class Impl_Div_Fib {


  ////Division Function to divide two numbers
  def divide(x: Int, y: Int): Int = x/y



  ////Fibonacci Function to print nth value of fibonacci series
  def fibonacci(x: Int): Int ={

    if(x==1)
      0
    else if(x==2)
      1
    else
      fibonacci(x-1)+fibonacci(x-2)

  }


}
