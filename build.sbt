ThisBuild / scalaVersion := "3.3.8"
ThisBuild / version := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala-estudos",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )
