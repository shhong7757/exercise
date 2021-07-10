ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / version          := "0.0.1"

lazy val sample = (project in file("."))
  .settings(
    name := "스칼라로 배우는 함수형 프로그래밍 연습문제",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test,
  )