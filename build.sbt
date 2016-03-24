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

libraryDependencies ++= Seq(
  "eu.timepit" %% "refined" % "0.3.7",
  "com.github.julien-truffaut" %% "monocle-refined" % "1.3.0-SNAPSHOT",
  "io.circe" %% "circe-refined" % "0.4.0-SNAPSHOT"
)

tutSettings

ghpages.settings
GhPagesKeys.privateMappings := Seq(
  tutTargetDirectory.value / "refined.html" -> "index.html"
)

git.remoteRepo := "git@github.com:fthomas/refined-talk.git"
