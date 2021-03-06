name := "functional-programming-scala"

version := "1.0"

scalaVersion := "2.11.7"

parallelExecution in Test := false


val commonTestSettings = Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  libraryDependencies += "junit" % "junit" % "4.10" % "test")

lazy val funProg = (project in file("."))
  .aggregate(week0)
  .aggregate(week1)
  .aggregate(week2)
  .aggregate(week3)
  .aggregate(week4)
  .aggregate(week6)
  .aggregate(week7)

lazy val week0 = (project in file("week0-examples")).settings(commonTestSettings)
lazy val week1 = (project in file("week1-recfun")).settings(commonTestSettings)
lazy val week2 = (project in file("week2-funsets")).settings(commonTestSettings)
lazy val week3 = (project in file("week3-objsets")).settings(commonTestSettings)
lazy val week4 = (project in file("week4-patmat")).settings(commonTestSettings)
lazy val week6 = (project in file("week6-forcomp")).settings(commonTestSettings)
lazy val week7 = (project in file("week7-streams")).settings(commonTestSettings)