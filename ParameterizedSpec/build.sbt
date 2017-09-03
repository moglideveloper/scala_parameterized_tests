name := "parametrized_scala_tests"

organization := "com.github.mogli"

scalaVersion := "2.11.7"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3"
libraryDependencies += "pl.pragmatists" % "JUnitParams" % "1.0.4"
libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

