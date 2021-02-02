package com.knoldus.request
import com.knoldus.models.{Company, User}
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}


class UserImplTest extends AnyFlatSpec {

  val mockedUserValidate = mock[UserValidator]

  val user1: User = User("Shekhar","Yadav","shekhar.yadav@knoldus.com","Knoldus")
  val newuser2: User = User("Deepak","Singh","deepaksingh@rtds.com","rtds")
  val userImpl = new UserImpl(mockedUserValidate)

  //Unit Testing

  "User" should "be created" in {

    when(mockedUserValidate.userIsValid(newuser2)) thenReturn(true)
    val result = userImpl.createUser(newuser2)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {

    when(mockedUserValidate.userIsValid(user1)) thenReturn(false)
    val result = userImpl.createUser(user1)
    assert(result.isEmpty)
  }




}
