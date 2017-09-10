name := "SampleParamsTest"

scalaVersion := "2.12.1"

libraryDependencies += "com.github.mogli" % "parametrized_scala_tests_2.12" % "0.1-SNAPSHOT" % "test"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.11.0.0"
libraryDependencies += "net.manub" %% "scalatest-embedded-kafka" % "0.15.0"
