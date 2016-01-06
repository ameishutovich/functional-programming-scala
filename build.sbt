name := "functional-programming-scala"

version := "1.0"

scalaVersion := "2.11.7"

parallelExecution in Test := false

lazy val funProg = (project in file("."))
  .aggregate(week1)

lazy val week1 = (project in file("week1-examples")).settings(Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  libraryDependencies += "junit" % "junit" % "4.10" % "test"))