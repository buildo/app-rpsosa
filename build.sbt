lazy val root = project
  .in(file("."))
  .settings(
    name := "app-rpsosa",
    version := "1.0",
    scalaVersion := "2.12.6",
    resolvers += Resolver.bintrayRepo("buildo", "maven"),
    libraryDependencies += "io.buildo" %% "enumero" % "1.2.1",
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
  )
