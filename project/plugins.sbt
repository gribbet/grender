addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0")

libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % "0.12.0-0.2.11.1")
