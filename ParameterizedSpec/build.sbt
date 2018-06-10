name := "parametrized_scala_tests"

organization := "com.github.mogli"

scalaVersion := "2.12.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3"
libraryDependencies += "pl.pragmatists" % "JUnitParams" % "1.0.4"
libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0"
libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.7"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
unmanagedSourceDirectories in Test +=  (baseDirectory in Test).value / "src/sampletests/scala"
unmanagedResourceDirectories in Test += (baseDirectory in Test).value / "src/sampletests/resources"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// License of your choice
//TODO double check below parameters
licenses := Seq("The MIT License" -> url("https://opensource.org/licenses/MIT"))
homepage := Some(url("https://github.com/moglideveloper/scala_parameterized_tests)"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/moglideveloper/scala_parameterized_tests"),
    "git@github.com:moglideveloper/scala_parameterized_tests.git"
  )
)
developers := List(
  Developer(id="moglideveloper", name="mogli", email="moglideveloper@gmail.com", url=url("https://github.com/moglideveloper/scala_parameterized_tests"))
)

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

useGpg := true

//code from http://www.scala-sbt.org/release/docs/Using-Sonatype.html

pomIncludeRepository := { _ => false }

publishArtifact in Test := false