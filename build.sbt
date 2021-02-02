name := "UIT"

version := "0.1"

scalaVersion := "2.13.4"

lazy val Ques_1_2=project.in(file("Ques_1_2")).settings(
  libraryDependencies++=Seq("org.scalatest" %% "scalatest" % "3.2.2" % "test")
)
lazy val Ques_3=project.in(file("Ques_3")).settings(
  libraryDependencies++=Seq("org.scalatest" %% "scalatest" % "3.2.2" % "test",
                              "org.mockito" %% "mockito-scala" % "1.5.12" % "test")
)

lazy val root = project.in(file(".")).aggregate(Ques_1_2,Ques_3)