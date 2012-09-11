name := "scamper-servlet"

organization := "com.versal"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies ++= Seq(
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "container,test"
  , "javax.servlet" % "servlet-api" % "2.5" % "provided,test"
)

port in container.Configuration := 9002
