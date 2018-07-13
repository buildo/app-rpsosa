val circeVersion = "0.9.2"
val akkaActor = "2.5.13"
val akkaStream = "2.5.13"
val akkaHttp = "10.1.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "app-rpsosa",
    version := "1.0",
    scalaVersion := "2.12.6",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaActor,
      "com.typesafe.akka" %% "akka-http" % akkaHttp,
      "com.typesafe.akka" %% "akka-stream" % akkaStream,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.buildo" %% "enumero-circe-support" % "1.2.1",
      "io.buildo" %% "enumero" % "1.2.1",
      "de.heikoseeberger" %% "akka-http-circe" % "1.21.0"
    ),
    resolvers ++= Seq(Resolver.bintrayRepo("hseeberger", "maven"),
                      Resolver.bintrayRepo("buildo", "maven"))
      addCompilerPlugin ("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
  )
