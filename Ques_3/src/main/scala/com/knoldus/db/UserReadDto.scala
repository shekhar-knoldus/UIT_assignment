package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class UserReadDto {


  val User1:User=User("Shekhar","Yadav","shekhar.yadav@knoldus.com","Knoldus")
  val User2:User=User("Poonam","Tripathi","poonam.tripathi@knoldus.com","Knoldus")

  val Users: HashMap[String,User] = HashMap("Shekhar" -> User1, "Poonam" -> User2)

  def getUserByName(name: String): Option[User] = Users.get(name)

}
