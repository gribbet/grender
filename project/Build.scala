import sbt._
import Keys._
import com.github.siasia.WebPlugin.webSettings

object GrenderBuild extends Build {
  lazy val standardSettings = Defaults.defaultSettings ++ Seq(
    organization := "org.gribbet",
    version := "0.1",
    scalaVersion := "2.9.2",
    scalacOptions ++= Seq("-deprecation"),
    resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/releases/")

  lazy val grender = Project(
    id = "grender",
    base = file("."),
    settings = standardSettings,
    aggregate = Seq(core, jersey))

  lazy val core = Project(
    id = "grender-core",
    base = file("core"),
    settings = standardSettings) dependsOn (css)

  lazy val css = Project(
    id = "grender-css",
    base = file("css"),
    settings = standardSettings)

  lazy val jersey = Project(
    id = "grender-jersey",
    base = file("jersey"),
    settings = standardSettings ++
      Seq(libraryDependencies +=
        "com.sun.jersey" % "jersey-core" % "1.8")
  ) dependsOn(core)

  lazy val exampleHello = Project(
    id = "grender-example",
    base = file("example"),
    settings = standardSettings
  ) dependsOn (core)

  lazy val exampleJersey = Project(
    id = "grender-example-jersey",
    base = file("example-jersey"),
    settings = standardSettings ++
      webSettings ++
      Seq(libraryDependencies ++= Seq(
        "org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
        "com.sun.jersey" % "jersey-server" % "1.8"))
  ) dependsOn (core, jersey)
}
