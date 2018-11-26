logLevel := Level.Warn

addSbtPlugin( "com.eed3si9n" % "sbt-assembly" % "0.14.9" )


// sbt-dependecy-graph isn't really part of a project. Makes most sense that it be installed by
// individual users as a general dev tool rather than specific to one project.  Thus best place
// to install it is in each user's '~/.sbt/' configuration.
// SEE:  https://github.com/jrudolph/sbt-dependency-graph/blob/master/README.md

// addSbtPlugin( "net.virtual-void" % "sbt-dependency-graph" % "0.9.2" )
