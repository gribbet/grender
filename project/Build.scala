import sbt._
import Keys._

object GrenderBuild extends Build {
  lazy val standardSettings = Defaults.defaultSettings ++ Seq(
    organization := "org.gribbet",
    version := "0.1",
    scalaVersion := "2.9.2",
    scalacOptions ++= Seq("-deprecation"),
    resolvers ++= Seq(
      "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"))

  lazy val grender = Project(
    id = "grender",
    base = file("."),
    settings = standardSettings,
    aggregate = Seq(core, example)) dependsOn (core, example)

  lazy val core = Project(
    id = "core",
    base = file("core"),
    settings = standardSettings) dependsOn ("css")

  lazy val css = Project(
    id = "css",
    base = file("css"),
    settings = standardSettings)
    
  lazy val example = Project(
    id = "example",
    base = file("example"),
    settings = standardSettings) dependsOn ("core")
}
