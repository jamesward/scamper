import sbt._
import Keys._
import cc.spray.revolver.RevolverPlugin._

object Build extends sbt.Build {
  import Dependencies._

  lazy val myProject = Project("scamper-spray-can", file("."))
    .settings(Revolver.settings: _*)
    .settings(
      organization  := "com.example",
      version       := "0.9.0",
      scalaVersion  := "2.9.1",
      scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
      resolvers     ++= Dependencies.resolutionRepos,
      libraryDependencies ++= Seq(
        Compile.akkaActor,
        Compile.sprayCan,
        Compile.sprayServer,
        Test.specs2,
        Container.akkaSlf4j,
        Container.slf4j,
        Container.logback
      )
    )
}

object Dependencies {
  val resolutionRepos = Seq(
    ScalaToolsSnapshots,
    "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/",
    "spray repo" at "http://repo.spray.cc/"
  )

  object V {
    val akka     = "1.3.1"
    val spray    = "0.9.0"
    val sprayCan = "0.9.3"
    val specs2   = "1.7.1"
    val slf4j    = "1.6.4"
    val logback  = "1.0.0"
  }

  object Compile {
    val akkaActor   = "se.scalablesolutions.akka" %  "akka-actor"      % V.akka     % "compile"
    val sprayCan    = "cc.spray"                  %  "spray-can"       % V.sprayCan % "compile"
    val sprayServer = "cc.spray"                  %  "spray-server"    % V.spray    % "compile"
  }

  object Test {
    val specs2      = "org.specs2"                %% "specs2"          % V.specs2  % "test"
  }

  object Container {
    val akkaSlf4j   = "se.scalablesolutions.akka" %  "akka-slf4j"      % V.akka
    val slf4j       = "org.slf4j"                 %  "slf4j-api"       % V.slf4j
    val logback     = "ch.qos.logback"            %  "logback-classic" % V.logback
  }
}
