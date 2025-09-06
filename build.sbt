import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val option = (project in file("."))
  .settings(name := "option")
  .aggregate(
    optionCore.jvm,
    optionCore.js,
  )

lazy val optionCore = (crossProject(JVMPlatform, JSPlatform) in file("option-core"))
  .settings(name := "option-core")
  .settings(crossDependencies(
    peknight.query,
    typelevel.spire,
  ))
  .settings(crossTestDependencies(scalaTest))
