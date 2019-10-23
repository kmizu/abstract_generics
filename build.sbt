organization := "com.github.kmizu"

name := "abstract_generics"

scalaVersion := "2.12.10"

crossScalaVersions := Seq("2.11.11", scalaVersion.value)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

initialCommands in console += {
  Iterator().map("import "+).mkString("\n")
}
