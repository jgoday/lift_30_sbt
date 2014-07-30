name := "Lift 3.0 template"

version := "0.1"

organization := "net.liftweb"

scalaVersion := "2.10.0"

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases"
)

seq(webSettings :_*)

libraryDependencies ++= {
  val liftVersion = "3.0-SNAPSHOT"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"        % liftVersion        % "compile",
    "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container",
    "org.eclipse.jetty" % "jetty-plus"   % "9.1.0.v20131115" % "container",
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.specs2"        % "specs2_2.10.0-M7"    % "1.12.1"           % "test",
    "com.h2database"    % "h2"                  % "1.3.167"
  )
}
