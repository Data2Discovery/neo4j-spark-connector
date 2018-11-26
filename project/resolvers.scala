import sbt.Resolver
import sbt._

object gdataResolvers {

    val resolvers = Seq(
        Resolver.sonatypeRepo( "public" )
        // ,
        //        "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"
        //        ,
        //        Opts.resolver.mavenLocalFile // ~/.m2/repository
        //        ,
        // Resolver.mavenLocal
        ,
        "neo4j-snapshots" at "https://m2.neo4j.org/content/repositories/snapshots"
        ,
        "neo-snapshots" at "https://neo.jfrog.io/neo/opencypher-public"
        //        ,
        //        DefaultMavenRepository // http(s)://repo1.maven.org/maven2/
        //        ,
        //        Resolver.defaultLocal // ~/.ivy2/local
        ,
        "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"
        //        ,
        //        "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
    )
}

//    ,
//    Resolver.defaultLocal
//    ,
//    Resolvers.local
//    ,
//    "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
//        ,
//        "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
// Resolver.mavenLocal has issues - hence the duplication
// "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
// "Apache Staging" at "https://repository.apache.org/content/repositories/staging/",
// Classpaths.typesafeReleases,
// "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
// Classpaths.sbtPluginReleases,
// "Eclipse repositories" at "https://repo.eclipse.org/service/local/repositories/egit-releases/content/",
// "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
