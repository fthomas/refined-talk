name := "refined-talk"

scalaVersion := "2.11.8"
scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xfuture",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard"
)

resolvers += Resolver.sonatypeRepo("snapshots")

val circeVersion = "0.4.0-RC2"

libraryDependencies ++= Seq(
  "eu.timepit" %% "refined" % "0.4.0",
  "com.github.julien-truffaut" %% "monocle-refined" % "1.3.0-SNAPSHOT",
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser"  % circeVersion,
  "io.circe" %% "circe-refined" % circeVersion
)

tutSettings

ghpages.settings
GhPagesKeys.privateMappings := Seq(
  tutTargetDirectory.value / "refined.html" -> "index.html"
)

git.remoteRepo := "git@github.com:fthomas/refined-talk.git"

lazy val stripPackages = taskKey[Unit]("")
stripPackages := {
  val file = tutTargetDirectory.value / "refined.html"
  val script = List("api", "boolean", "generic", "numeric", "string")
    .map(p => s"eu\\.timepit\\.refined\\.$p\\.")
    .map(p => s"""/^import/! s/$p//g""")
    .flatMap(s => List("-e", s))

  val cmd = List("sed", "-i") ++ script :+ file.toString
  state.value.log.info(cmd.mkString(" "))
  cmd.!!
}

lazy val makeSlides = taskKey[Unit]("")
makeSlides := Def.sequential(tut, stripPackages).value

lazy val updateSite = taskKey[Unit]("")
updateSite := Def.sequential(makeSlides, GhPagesKeys.pushSite).value
