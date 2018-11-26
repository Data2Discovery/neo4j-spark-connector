/**
  *  build.sbt
  */

import deps.moduleDeps


lazy val userDir = scala.sys.props( "user.dir" ) // the root project/repo dir in local file-system.

//lazy val appName = userDir.split( sys.props( "line.separator" ) ).last
lazy val appName = "spark-java-connector"

lazy val appConf = "idea"
//lazy val appConf = "ian"
//lazy val appConf = "kingsley"
//lazy val appConf = "hoffmann"

//lazy val memory = "54g"
lazy val memory = appConf match {
    case "hoffmann" => "54g"
    case "ian" => "13g"
    case "kingsley" => "230g"
    case _ => "14g"
}

lazy val run_javaOptions = Seq(
    "-Djline.terminal=NONE",
    s"-Xms$memory",
    s"-Xmx$memory",
    "-XX:+UseCompressedOops",
    s"-Dlog4j.configuration=file:$userDir/conf/$appConf/log4j.properties",
    s"-Dconfig.file=conf/$appConf/application.conf",
    s"-Dspark.conf.dir=conf/$appConf",
    s"-Dspark.app.name=$appName",
    "-Dspark.neo4j.bolt.url=bolt://hoffmann.data2discovery.net:7689",
    "-Dspark.neo4j.bolt.user=randy",
    "-Dspark.neo4j.bolt.password=microbedeli",
    "-Dsun.io.serialization.extendedDebugInfo=true",
    "-Xmx2G", // sbt getting OOM when 'sbt assembly'. Doesn't look like this affects running SBT.
    "-XX:+CMSClassUnloadingEnabled",
    "-ea" )

// -Dlog4j.configuration=file:/Users/rk/gh/Data2Discovery/gdata/conf/idea/log4j.properties
// -Dspark.conf.dir=conf/idea
// -Dconfig.file=conf/idea/application.conf
// -Dderby.system.home=derby/local
// -ea

lazy val console_initialCommands: String = Seq(
    // https://stackoverflow.com/questions/50232040/error-running-spark-in-a-scala-repl-access-denied-org-apache-derby-security-sy
    "System.setSecurityManager( null )",
    "import d2d.gdata._",
    "import org.apache.spark.rdd.RDD",
    "import org.apache.spark.SparkContext",
    "import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}",
    "import org.apache.spark.sql.types._",
    "import org.apache.spark.sql.functions._",
    "import scala.collection.JavaConverters._",
    "SparkCon.setSession( spark )",
    "implicit val ss: SparkSession = SparkCon.ss",
    //    "val spark: SparkSession = SparkCon.ss",
    "import ss.implicits._",
    "val sc: SparkContext = ss.sparkContext",
    "val sqlContext: SQLContext = ss.sqlContext"
).mkString( "", "\n", "\n" )


lazy val console_cleanupCommands: String = Seq(
    "d2d.gdata.SparkCon.ss.close()",
    "spark.stop()"
).mkString( "", "\n", "\n" )

//lazy val baseSettings = Seq(
//    organization := "net.data2discovery",
//    organizationName := "Data2Discovery, Inc.",
//    organizationHomepage := Some( url( "http://d2discovery.com" ) ),
//    scalaVersion := "2.11.11",
//    version := "0.1.0-SNAPSHOT",
//    javacOptions ++= Seq( "-source", "1.8", "-target", "1.8" ), //, "-Xmx2G"),
//    scalacOptions ++= Seq( "-deprecation", "-unchecked" ),
//    //  javaOptions in(Test, run) ++= Seq( "-Xms12g", "-Xmx12g" ),
//    javaOptions in(Test, run) ++= run_javaOptions
//    ,
//    javaOptions in console ++= run_javaOptions
//    //    ,
//    //    initialCommands in console := console_initialCommands
//    //    ,
//    //    cleanupCommands in console := console_cleanupCommands
//    ,
//    run in Compile :=
//        Defaults
//            .runTask( fullClasspath in Compile, mainClass in(Compile, run), runner in(Compile, run) )
//            .evaluated
//    ,
//    runMain in Compile :=
//        Defaults.runMainTask( fullClasspath in Compile, runner in(Compile, run) ).evaluated
//    ,
//    resolvers ++= gdataResolvers.resolvers
//)

lazy val baseSettings = Seq(
    organization := "net.data2discovery",
    organizationName := "Data2Discovery, Inc.",
    organizationHomepage := Some( url( "http://d2discovery.com" ) ),
    scalaVersion := build_config.scala_version,
    version := "2.2.2-SNAPSHOT",
    javacOptions ++= Seq( "-source", "1.8", "-target", "1.8" ), //, "-Xmx2G"),
    scalacOptions ++= Seq( "-deprecation", "-unchecked" ),
    //  javaOptions in(Test, run) ++= Seq( "-Xms12g", "-Xmx12g" ),
    javaOptions in(Test, run) ++= run_javaOptions
    ,
    javaOptions in console ++= run_javaOptions
    //    ,
    //    initialCommands in console := console_initialCommands
    ,
    cleanupCommands in console := console_cleanupCommands

    //    , run in console
    ,
    run in Compile :=
        Defaults
            .runTask( fullClasspath in Compile, mainClass in(Compile, run), runner in(Compile, run) )
            .evaluated
    ,
    runMain in Compile :=
        Defaults.runMainTask( fullClasspath in Compile, runner in(Compile, run) ).evaluated
    ,
    assemblyMergeStrategy in assembly := {
        case x if x.endsWith( "io.netty.versions.properties" ) => MergeStrategy.first
        case PathList( "com", "amazonaws", xs@_* ) => MergeStrategy.last
        case PathList( "org", "aopalliance", xs@_* ) => MergeStrategy.last
        case PathList( "javax", "inject", xs@_* ) => MergeStrategy.last
        case PathList( "javax", "servlet", xs@_* ) => MergeStrategy.last
        case PathList( "javax", "activation", xs@_* ) => MergeStrategy.last
        case PathList( "org", "apache", xs@_* ) => MergeStrategy.last
        case PathList( "com", "google", xs@_* ) => MergeStrategy.last
        case PathList( "com", "esotericsoftware", xs@_* ) => MergeStrategy.last
        case PathList( "com", "codahale", xs@_* ) => MergeStrategy.last
        case PathList( "com", "yammer", xs@_* ) => MergeStrategy.last
        case PathList( "stax", "stax-api", xs@_* ) => MergeStrategy.discard
        case PathList( "xml-apis", "xml-apis", xs@_* ) => MergeStrategy.discard
        case PathList( "javax", "xml", xs@_* ) => MergeStrategy.first
        case PathList( "mozilla", "public-suffix-list.txt" ) => MergeStrategy.first
        case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
        case "META-INF/mailcap" => MergeStrategy.last
        case "META-INF/mimetypes.default" => MergeStrategy.last
        case "META-INF/LICENSES.txt" => MergeStrategy.rename
        //        case PathList("META-INF", xs @ _*) => MergeStrategy.discard
        case "plugin.properties" => MergeStrategy.last
        case "log4j.properties" => MergeStrategy.last
        case "about.html" => MergeStrategy.rename
        case "overview.html" => MergeStrategy.rename
        case "mime.types" => MergeStrategy.rename
        case "module-info.class" => MergeStrategy.rename
        case x =>
            val oldStrategy = (assemblyMergeStrategy in assembly).value
            oldStrategy( x )
    }
    ,
    assemblyOption in assembly := (assemblyOption in assembly).value.copy( includeScala = false )
    ,
    resolvers ++= gdataResolvers.resolvers
)

lazy val commonSparkSettings =
    baseSettings ++ Seq(
    )

//#######################################################################################
//  Modules
//#######################################################################################

/*
 * Seems like sqlite and gsheets should not need commonSparkDeps in settings since they both dependOn
 * sparkbase, but IntelliJ won't work for scala scripts without including commonSparkDeps.
 */

/**
  * The top-level 'gdata' Module.  In general, would not put any code here or expect to run from this
  * Module -- there would be too many dependency issues from conflicting dependencies.  But building
  * this Module would result in building all modules.
  */
lazy val `neo4j-spark-connector` = (project in file( "." )).
    settings( baseSettings: _* ).
    settings( libraryDependencies ++= moduleDeps.main )

//#######################################################################################
// package
//#######################################################################################

//mainClass in(Compile, packageBin) := Some( "d2d.gpath.GpathMain" )

//#######################################################################################
//  assembly
//#######################################################################################

//#######################################################################################
//  Publish
//#######################################################################################

//// disable publishing the main API jar
//publishArtifact in(Compile, packageDoc) := false
//
//// disable publishing the main sources jar
//publishArtifact in(Compile, packageSrc) := false

// Created on [2017.07.07] by copying items from 'gpath' project.
// Lines starting with '//sql ' are lines that were enabled in gpath but disabled here.

// enable publishing the assembly jar.
//sql publishArtifact in(Compile, assembly) := true
//sql publishArtifact in(Compile, assembleArtifact) := true

// Include the assembly jar in what is published.
// Adapted from https://github.com/sbt/sbt-assembly : "Publishing" section
//
//sql
//sql artifact in(Compile, assembly) := {
//sql     val art = (artifact in(Compile, assembly)).value
//sql     art.copy( `classifier` = Some( "assembly" ) )
//sql }
//sql addArtifact( artifact in(Compile, assembly), assembly )

// use sbt publishM2 to publish to local maven (not tried yet).

//#######################################################################################
//  Run
//#######################################################################################

// Add "provided" dependencies back to classpath when running.
//   http://stackoverflow.com/questions/18838944/how-to-add-provided-dependencies-back-to-run-test-tasks-classpath/21803413#21803413

//#######################################################################################
//  END of gdata/build.sbt
//#######################################################################################
