import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._
// If you have JDK 6 and not JDK 7 then replace all three instances of the number 7 to the number 6

organization := "com.micronautics"

name := "rightfabric"

version := "0.6.14-SNAPSHOT"

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-deprecation", "-encoding", "UTF-8", "-feature", "-target:jvm-1.7", "-unchecked",
    "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlint")

scalacOptions in (Compile, doc) <++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-sourcepath", bd.getAbsolutePath,
     "-doc-source-url", "https://github.com/mslinn/changeMe/tree/master€{FILE_PATH}.scala"
  )
}

javacOptions ++= Seq("-Xlint:deprecation", "-Xlint:unchecked", "-source", "1.7", "-target", "1.7", "-g:vars")

resolvers ++= Seq(
  "Typesafe Releases"   at "http://repo.typesafe.com/typesafe/releases"
)

libraryDependencies ++= Seq(
//  "org.scalatest"           %% "scalatest"     % "2.2.0" % "test" withSources(),
//  "com.github.nscala-time"  %% "nscala-time"   % "1.2.0" withSources()
  "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
)

logLevel := Level.Warn

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
                     |""".stripMargin

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn

cancelable := true

sublimeTransitive := true

packageArchetype.java_application
