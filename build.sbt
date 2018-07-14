val circeVersion = "0.9.2"
val akkaActorVersion = "2.5.13"
val akkaStreamVersion = "2.5.13"
val akkaHttpVersion = "10.1.3"
val wiroVersion = "0.6.12"

lazy val root = project
  .in(file("."))
  .settings(
    name := "app-rpsosa",
    version := "1.0",
    scalaVersion := "2.12.6",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaActorVersion,
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaStreamVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.buildo" %% "enumero-circe-support" % "1.2.1",
      "io.buildo" %% "enumero" % "1.2.1",
      "de.heikoseeberger" %% "akka-http-circe" % "1.21.0",
      "io.buildo" %% "wiro-http-server" % wiroVersion,
      "org.slf4j" % "slf4j-nop" % "1.6.4" //Wiro uses scala-logging, so we need to include a SLF4J backend
    ),
    resolvers ++= Seq(Resolver.bintrayRepo("buildo", "maven")),
    addCompilerPlugin(
      "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full) //Wiro uses scala macro annotations
  )
