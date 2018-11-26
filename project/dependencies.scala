import sbt._

object build_config {

    val use_scala_2_12 = false
    //    val spark_version = "2.3.2"
    val spark_version = "2.4.0"
    //    val spark_version = "2.4.1-SNAPSHOT"
    val scala_version = "2.11.12"
    val use_emr: Boolean = false // Build for AWS EMR?
}

trait HadoopVersions {

    def hadoop: String

    def slf4j: String

    def log4j: String

    def avro: String

    def javax_servlet: String

    def netty: String

    def jetty: String

    def jersey: String

    def guava: String

    def joda: String

    def codehaus_jackson: String

    def fasterxml_jackson: String

    def fasterxml_jackson_databind: String

    def aws_sdk: String

    def kafka: String
}

trait SparkVersions {

    def spark_hadoop: HadoopVersions

    def spark: String

    def scala: String

    def graphframes: String

    def hadoop: String = spark_hadoop.hadoop

    def slf4j: String

    def log4j: String

    def parquet: String

    def avro: String

    def arrow: String

    def derby: String

    def jetty: String

    def jersey: String

    def snappy: String

    def guava: String

    def joda: String

    def json4s: String

    def codehaus_jackson: String

    def fasterxml_jackson: String

    def fasterxml_jackson_databind: String

    def breeze: String

    def netlib: String

    def hive: String

    def hive_short: String

    def hive_parquet: String

    def aws_sdk: String = spark_hadoop.aws_sdk

    def kinesis_client: String // used by spark-streaming-kinesis-asl -> amazon-kinesis-client

    def scalatest: String
}

object hadoopVersion_2_9_1 extends HadoopVersions {

    // hadoop-cloud-storage first appears in 2.9.1
    lazy val hadoop = "2.9.1"
    lazy val jetty = "6.1.26" // mortbay
    lazy val kafka = "0.8.2.1" // ??
    lazy val avro = "1.7.7"
    lazy val jersey = "1.9"
    lazy val codehaus_jackson = "1.9.13"
    lazy val fasterxml_jackson = "2.7.8"
    lazy val fasterxml_jackson_databind = fasterxml_jackson
    lazy val slf4j = "1.7.25"
    lazy val log4j = "1.2.17"
    lazy val guava = "11.0.2"
    lazy val joda = "2.9.9" // ??
    lazy val aws_sdk = "1.11.199"
    lazy val javax_servlet = "2.5"
    lazy val netty = "3.6.2.Final"
    // httpcomponents:httpclient 4.5.2
}

object hadoopVersion_3_1_0 extends HadoopVersions {

    lazy val hadoop = "3.1.0"
    lazy val jetty = "9.3.19.v20170502"
    lazy val kafka = "0.8.2.1"
    lazy val avro = "1.7.7"
    lazy val jersey = "1.19"
    lazy val codehaus_jackson = "1.9.13"
    lazy val fasterxml_jackson = "2.7.8"
    lazy val fasterxml_jackson_databind = fasterxml_jackson
    lazy val slf4j = "1.7.25"
    lazy val log4j = "1.2.17"
    lazy val guava = "11.0.2"
    lazy val joda = "2.9.9"
    lazy val aws_sdk = "1.11.271"
    lazy val javax_servlet = "3.1.0"
    lazy val netty = "3.10.5.Final"
}

object sparkVersion_2_3_2 extends SparkVersions {

    def spark_hadoop: HadoopVersions = hadoopVersion_2_9_1

    lazy val spark = "2.3.2"
    lazy val scala = "2.11.8"
    lazy val graphframes = "0.6.0-spark2.3-s_2.11"
    //    lazy val hadoop = spark_hadoop.hadoop
    lazy val slf4j = "1.7.6"
    lazy val log4j = "1.2.17"
    lazy val parquet = "1.8.3" // 1.8.2 in 2.3.0
    lazy val avro = "1.7.7"
    lazy val arrow = "0.8.0"
    lazy val derby = "10.12.1.1"
    lazy val jetty = "9.3.20.v20170531"
    lazy val jersey = "2.22.2"
    lazy val snappy = "1.1.2.6"
    lazy val guava = "14.0.1"
    lazy val joda = spark_hadoop.joda // ??
    lazy val json4s = "3.2.11"
    lazy val codehaus_jackson = spark_hadoop.codehaus_jackson
    lazy val fasterxml_jackson = "2.6.7"
    lazy val fasterxml_jackson_databind = "2.6.7.1"
    lazy val breeze = "0.13.2"
    lazy val netlib = "1.1.2"
    lazy val hive_short = "1.2.1"
    lazy val hive = s"${hive_short}.spark2"
    lazy val hive_parquet = "1.6.0"
    lazy val kinesis_client = "1.7.3" // uses aws sdk v??
    //    lazy val aws_sdk = "1.11.76"
    lazy val scalatest = "3.0.3"
}

object sparkVersion_2_4_x extends SparkVersions {

    def spark_hadoop: HadoopVersions = hadoopVersion_2_9_1

    //    def spark_hadoop: HadoopVersions = hadoopVersion_3_1_0

    lazy val spark = build_config.spark_version
    lazy val scala = build_config.scala_version
    lazy val graphframes = "0.6.0-spark2.3-s_2.11"
    //    lazy val hadoop = spark_hadoop.hadoop
    lazy val slf4j = "1.7.16"
    lazy val log4j = "1.2.17"
    lazy val parquet = "1.10.0"
    lazy val avro = "1.8.2"
    lazy val arrow = "0.10.0"
    lazy val derby = "10.12.1.1"
    lazy val jetty = "9.3.24.v20180605"
    lazy val jersey = "2.22.2"
    lazy val snappy = "1.1.7.1"
    lazy val guava = "14.0.1"
    lazy val joda = "2.9.3"
    lazy val json4s = "3.5.3"
    lazy val codehaus_jackson = spark_hadoop.codehaus_jackson
    lazy val fasterxml_jackson = "2.6.7"
    lazy val fasterxml_jackson_databind = "2.6.7.1"
    lazy val breeze = "0.13.2"
    lazy val netlib = "1.1.2"
    lazy val hive_short = "1.2.1"
    lazy val hive = s"${hive_short}.spark2"
    lazy val hive_parquet = "1.6.0"
    lazy val kinesis_client = "1.8.10" // uses aws sdk 1.11.271
    //    lazy val aws_sdk = "1.11.271"
    lazy val scalatest = "3.0.3"
}

object versions {

    //    val sparkVersions: SparkVersions = sparkVersion_2_3_2
    //    val sparkVersions: SparkVersions = sparkVersion_2_4_x

    lazy val sparkVersions: SparkVersions = build_config.spark_version match {
        case "2.3.1" => sparkVersion_2_3_2
        case "2.3.2" => sparkVersion_2_3_2
        case "2.4.0" => sparkVersion_2_4_x
        case "2.4.1-SNAPSHOT" => sparkVersion_2_4_x
        case _ => sparkVersion_2_3_2
    }

    /* Updated for Spark 2.3.1 */
    //    val scala211_latest = "2.11.12" // There are notes in mailing list about 2.11.12+ have small issue.
    //    val scala212_latest = "2.12.6"
    //    private val spark_scala211_default = "2.11.8"
    //    private val spark_scala212_default = "2.12.4"
    //    private val spark_scala = spark_scala211_default
    val scala = build_config.scala_version
    val scala_major = scala.split( "." ).dropRight( 1 ).mkString( "." )
    //    val scala = "2.11.11"

    //    val typesafe_config = "1.3.1" // Latest = 1.3.1 [2017.07.08]
    val typesafe_config = "1.3.3" // Latest = 1.3.1 [2017.07.08]
    //val typesafe_config_version = "1.2.1" // What Spark and/or Scalatra uses.
    //    val guava = "14.0.1" // Spark version
    val guava = sparkVersions.guava
    //    val streamsets = "3.1.0.0"

    val snappy = sparkVersions.snappy

    /* EMR */

    private val emr = "5.16.0"
    private val emr_spark = "2.3.1"
    private val emr_hadoop = "2.8.4"
    private val emr_hadoop_amzn = "2.8.4-amzn-0"
    private val emr_hive = "2.3.3"
    private val emr_hive_amzn = "2.3.3-amzn-1"
    private val emr_aws_sdk = "1.11.336"

    /* Spark, Hadoop */

    val spark = sparkVersions.spark
    val spark_con = Provided
    //    val hadoop = "2.6.5" // spark 2.2 default in pom.xml
    //    val hadoop_in_spark = "2.7.3" // [2017.07.09] Spark = 2.6.5(default) or 2.7.3, latest = 2.8.0, 3.0.0
    //    val hadoop_in_emr = emr_hadoop
    //val hadoop_w_spark = if (build_config.use_emr) hadoop_in_emr else hadoop_in_spark
    val hadoop_w_spark = sparkVersions.hadoop
    //    val parquet = "1.8.3" // Spark 2.3.1
    val parquet = sparkVersions.parquet // "1.10.0" // Spark 2.4
    //    val servlet = "3.1.0" // Spark 2.2. Jetty? hadoop?

    val hadoop_wo_spark = sparkVersions.hadoop // "3.1.1"
    val hive = "3.0.0"

    //    val breeze = "0.13.1" // (low-level number crunching?) Spark 2.2
    val breeze = sparkVersions.breeze // (low-level number crunching?) Spark 2.4
    val netlib = sparkVersions.netlib // Spark 2.2

    //    val graphframes = "0.5.0-spark2.1-s_2.11"
    val graphframes = sparkVersions.graphframes

    /* DBMS */

    val mysqlConnector = "5.1.45" // "6.0.6" (experimental) // "5.1.20"
    val sqlite = "3.19.3" // from June 2017
    val postgres = "42.1.4"
    //    val sqoop = "1.4.7"
    val spark_excel = "0.9.17" // "0.8.4" (ended 2018.08.02)
    val spark_gsheets = "0.5.0"
    val google_api_client = "1.22.0"
    //    val gsheets_by_spark_gsheets = "v4-rev18-1.22.0"
    private val gsheets_latest = "v4-rev478-" + google_api_client
    val gsheets = gsheets_latest

    val jena = "3.6.0" //  "3.5.0" // "3.4.0"

    /* JSON, jackson */

    // Spark usage:
    //   - jackson-databind
    //   - jackson-module-scala_2.11
    // latest = 2.9.5 [2018.05.05]
    // Spark 2.3.0 uses 2.6.7.1
    // Spark 2.2.1 uses 2.6.5
    //    val json4s = "3.2.11" // Spark 2.2
    //    val codehaus_jackson = "1.9.13" // Spark 2.2
    //  val jackson_spark = "2.6.5" // Spark 2.2.1

    val fasterxml_jackson = sparkVersions.fasterxml_jackson
    val fasterxml_jackson_databind = sparkVersions.fasterxml_jackson_databind

    // spark 2.1.0. pull it in using jackson-module-scala.
    // up to 2.8.8
    // Jena ARQ 3.3.0 -> jsonld-java 0.9.0 -> jackson core,databind 2.7.4

    val netty = sparkVersions.spark_hadoop.netty

    //    val jetty = "6.1.26"  // Spark 2.2
    //    val cxf = "2.4.3"
    //    val jersey = "1.10"
    //    val commons_cli = "1.2"
    //    val hamcrest = "1.3"

    /* AWS */

    //        val aws_recent = "1.11.360"
    private val aws_recent = "1.11.416"
    //    val aws_recent = "1.11.177" // first version of aws-java-sdk-glue
    //    val aws_recent = "1.11.176" // last version of pre aws-java-sdk-glue
    //    val aws_recent = "1.11.0"
    //    val aws_recent = "1.10.20"
    //    val aws_recent = "1.9.40"
    //    val aws_recent = "1.8.12"
    //    val aws_in_sagemaker = "1.11.238" // what AWS sagemaker-spark 2.2.0-1.1.4 uses.
    /* Version to use when wanting most recent to use without Spark and Hadoop */
    /* If wanting to access Parquet in S3 from Spark, likely need to use what hadoop uses. */
    //    val aws_from_hadoop = "1.7.4"
    //    val aws_withSpark = "1.7.4" // hadoop 1.7.3  // This was 1.7.4 until 2018.07.06
    /* What Spark 2.3.1 uses. What hadoop uses is more important. */
    //    val aws_in_Spark_23 = "1.11.76" // spark 2.2, 2.3 uses 1.11.76
    //    val aws_in_Spark_24 = "1.11.271" // spark 2.2, 2.3 uses 1.11.76
    /* Which aws-sdk version to use with Spark modules. */
    //    val aws = aws_recent
    //    val aws = sparkVersions.aws_sdk

    val aws_wo_spark = aws_recent

    val aws_withSpark = if (build_config.use_emr) emr_aws_sdk else sparkVersions.aws_sdk
    //    val aws_withSpark = aws_in_Spark_23
    //    val aws = "1.10.6"  // hadoop 2.8.x
    // sagemaker-spark % spark_2.2.0-1.1.4 uses hadoop-aws

    //    val awsScala = "8.0.3"

    /* Logging */

    val slf4j = sparkVersions.slf4j // Spark 2.2
    //    val log4j = "1.2.16"
    //val logback_version = "1.1.2" // requires slf4j 1.7.10
    //val log4j_version = "1.2.17" // What Spark uses, last of the 1.x series. v2.3 exists.
    //val log_con = spark_con
    //val log_con = Compile

    /* Testing */

    //val junit_version = "4.12"
    //    val scalaTestSpark21 = "2.2.6"
    //    val scalaTest = scalaTestSpark21
    val scalaTest = sparkVersions.scalatest

    val mongodb = "3.6.3"
    val neo4jdriver = "1.6.3" // "1.6.1"
    val neo4j = "3.4.7" // "3.3.7"
    //    val spark_cypher = "1.0.0-beta7" // requires spark-2.2.x (May 2018)
    val spark_cypher = "0.2.1" // requires spark-2.2.1 (Oct 2018)
    val neo4j_spark_connector = "2.2.1-M5" // dep on spark 2.2.1, neo 3.2.3, graphframes 0.5.0-spark2.1

    val graphaware = "3.4.8.52" // Oct 2018

    //    val scalaTest = "3.0.1"
}

object deps {

    //========================================================================
    // Scala
    //========================================================================

    def scalaDep (artifact: String) = {
        "org.scala-lang" % artifact % versions.scala
    }

    lazy val scala = Seq(
        scalaDep( "scala-compiler" ), // "provided" in sparkbase
        scalaDep( "scala-reflect" ), // "provided" in sparkbase
        scalaDep( "scalap" ), // "provided" in sparkbase
        scalaDep( "scala-library" ) // "compile" in sparkbase
    )

    //========================================================================
    // Typesafe Config - the reference.conf & application.conf config/properties files.
    //========================================================================

    //    "com.typesafe" % "config" % typesafe_config_version % spark_con,
    lazy val typesafe_config = Seq( "com.typesafe" % "config" % versions.typesafe_config )
    //    "net.ceedubs" %% "ficus" % ficus_version,    // a Scala layer on typesafe config

    lazy val guava = Seq( "com.google.guava" % "guava" % versions.guava )


    //========================================================================
    // JSON
    //========================================================================

    lazy val jackson_core = Seq(
        "com.fasterxml.jackson.core" % "jackson-core" % versions.fasterxml_jackson
    )

    lazy val jackson_in_spark = Seq(
        "com.fasterxml.jackson.core" % "jackson-databind" % versions.fasterxml_jackson_databind,
        "com.fasterxml.jackson.module" %% "jackson-module-scala" %
            versions.fasterxml_jackson_databind exclude("com.google.guava", "guava")
    )

    //========================================================================
    // netlib & breeze
    //========================================================================

    /* Used by Spark and/or Hadoop */

    lazy val breeze = Seq(
        "org.scalanlp" %% "breeze" % versions.breeze % versions.spark_con
    )

    lazy val netlib = Seq(
        "com.github.fommil.netlib" % "all" % versions.netlib % versions.spark_con pomOnly()
    )

    //========================================================================
    // Spark
    //========================================================================

    /*
     * Dependency strategy explanation:
     *
     * Need to use Jetty. But Jetty contains problematic dependency on Servlet stuff.
     * As does hadoop.
     *
     * Exclude hadoop-client & hadoop-hdfs from Spark dependencies.
     * Exclude servlet from hadoop-client & hadoop-hdfs dependencies.
     */

    private def sparkDep (artifact: String): ModuleID = {
        ("org.apache.spark" %% artifact % versions.spark % versions.spark_con) exclude(
            "org.apache.hadoop", "hadoop-client") exclude(
            "org.apache.hadoop", "hadoop-hdfs") exclude(
            "org.amazonaws", "aws-java-sdk") exclude(
            "xml-apis", "xml-apis")
    }

    lazy val spark = Seq( sparkDep( "spark-graphx" ),
                          sparkDep( "spark-sql" ),
                          sparkDep( "spark-core" )
    )
    //   sparkDep("spark-streaming-kinesis-asl")
    //                          ,
    // ** Add this in attempt to keep it out of assembly jar. spark-core has Test dep on it.
    //                          "xml-apis" % "xml-apis" % "1.4.01"
    //                          ("org.apache.spark" %% "spark-core" % versions.spark % Test) exclude(
    //                              "xml-apis", "xml-apis")

    //   "org.pentaho", "pentaho-aggdesigner-algorithm")
    //   "org.xerial.snappy" % "snappy-java" % "1.1.2.6" % Runtime
    //   "spark-repl" % spark_version % spark_con
    //   "spark-mllib" % spark_version % spark_con
    //   "spark-ml" % spark_version % spark_con
    //    "edu.berkeley.sc.amplab" %% "keystoneml" % keystone_version,

    //========================================================================
    // GraphFrames
    //========================================================================

    /**
      * Uses spark-graphx, spark-sql, spark-mlib
      * 0.6.0-spark2.3-s_2.11 uses scala-library:2.11.8, scala-logging %% 2.1.2
      */
    lazy val graphframes = Seq(
        "graphframes" % "graphframes" % versions.graphframes
    )

    //========================================================================
    // Hive in Spark
    //========================================================================

    lazy val sparkHive = Seq(
        sparkDep( "spark-hive" )
    )

    //    private def sparkHiveDep (artifact: String,
    //                              scope: Configuration
    //                             ): ModuleID = {
    //        ("org.spark-project.hive" % artifact % "1.2.1.spark2" % scope withSources()) exclude(
    //            "org.apache.spark", "spark-core_2.10") exclude(
    //            "org.apache.spark", "spark-network-common_2.10") exclude(
    //            "stax", "stax-api") exclude(
    //            "org.spark-project.hive", "hive-ant") exclude(
    //            "org.spark-project.hive", "hive-client") exclude(
    //            "org.spark-project.hive", "hive-shims") exclude(
    //            "org.spark-project.hive", "hive-metastore") exclude(
    //            "org.pentaho", "pentaho-aggdesigner-algorithm") excludeAll (
    //            ExclusionRule( "org.apache.calcite" )) excludeAll (
    //            ExclusionRule( "org.apache.spark" )) excludeAll (
    //            ExclusionRule( "org.json4s" )) excludeAll (
    //            ExclusionRule( "com.twitter" )) excludeAll (
    //            ExclusionRule( "com.fasterxml.jackson.module" ))
    //                                  exclude("stax", "stax-api")
    //                              sparkDep( "spark-hive-thriftserver" )
    //                              sparkHiveDep( "hive-exec", Provided )
    //                              sparkHiveDep( "hive-metastore", Provided )
    //                              sparkHiveDep( "hive-exec", Runtime )
    //                              sparkHiveDep( "hive-metastore", Runtime )
    //   "spark-hive-thriftserver" % spark_version % spark_con,
    //   "org.spark-project.hive" % "hive-exec" % "1.2.1.spark2" % Provided

    //========================================================================
    // Hadoop
    //========================================================================

    /**
      * ToDo: if 'aws' libs are not dependencies then maybe "aws-java-sdk" should not be excluded.
      */
    private def hadoopDep (artifact: String, scope: Configuration): ModuleID = {
        "org.apache.hadoop" % artifact % versions.hadoop_w_spark % scope exclude(
            "javax.servlet", "servlet-api") exclude(
            "org.mortbay.jetty", "jetty") exclude(
            "org.mortbay.jetty", "jetty-util") excludeAll (
            //            ExclusionRule( "com.amazonaws", "aws-java-sdk" )) excludeAll (
            //            ExclusionRule( "com.amazonaws", "aws-java-sdk-s3" )) excludeAll (
            ExclusionRule( "commons-beanutils" )) exclude(
            "com.fasterxml.jackson.core", "jackson-databind") exclude(
            "com.fasterxml.jackson.core", "jackson-core")
    }

    lazy val hadoop = {
        val hadoop_scope: Configuration = Provided // Compile
        Seq(
            //            hadoopDep( "hadoop-aws", hadoop_scope ),
            hadoopDep( "hadoop-client", hadoop_scope ),
            hadoopDep( "hadoop-common", hadoop_scope ),

            // Include hdfs so can exclude mortbay and other servlet stuff that collides w/ Jetty..
            //
            hadoopDep( "hadoop-hdfs", hadoop_scope )

            //        hadoopDep( "hadoop-cloud-storage" )
        )
    }

    //========================================================================
    // Streamsets
    //========================================================================

    //    lazy val streamsets = Seq(
    //        "com.streamsets" % "streamsets-datacollector-spark-api" % versions.streamsets
    //    )

    //========================================================================
    // Jetty
    //========================================================================

    // spark-core published in public mavens does not have compile dependency on jetty,
    // (only 'provided' dependency) thus adding explicit dependency here.
    //
    //sql            "org.eclipse.jetty" % "jetty-server" % jetty_version % Compile,

    // Add these if need to exclude to fix dependency problems.
    //    "org.apache.hadoop" % "hadoop-common" % hadoop_version % spark_con excludeAll
    // ExclusionRule(organization = "javax.servlet"),
    // "hadoop-client, hadoop-hdfs excludeAll ExclusionRule(organization = "org.mortbay.jetty"),

    //========================================================================
    // hadoop-cloud / hadoop-aws
    //========================================================================

    /**
      * This is mirroring the dependency of 'hadoop-aws' defined in Spark's Maven profile called
      * 'hadoop-cloud'.
      *
      * hadoop-aws 2.7.3 uses aws-java-sdk v1.7.4 (March, 2014)
      * hadoop-aws 2.9.1 uses aws-java-sdk-bundle v1.11.199 (Sep, 2017)
      * hadoop-aws 3.1.x uses aws-java-sdk-bundle v1.11.271 (Jan, 2018)
      * latest aws-java-sdk-bundle v1.11.428 (Oct, 2018)
      */
    lazy val hadoopAws = {
        val hadoop_scope: Configuration = Provided // Compile // Runtime
        Seq(
            "org.apache.hadoop" % "hadoop-aws" % versions.hadoop_w_spark % hadoop_scope exclude(

                "org.apache.hadoop", "hadoop-commons") exclude(
                "commons-logging", "commons-logging") exclude(
                "org.codehaus.jackson", "jackson-mapper-asl") exclude(
                "org.codehaus.jackson", "jackson-core-asl") exclude(
                "com.fasterxml.jackson.core", "jackson-core") exclude(
                "com.fasterxml.jackson.core", "jackson-databind") exclude(
                "com.fasterxml.jackson.core", "jackson-annotations") exclude(
                "org.xerial.snappy", "snappy-java") excludeAll (
                ExclusionRule( "com.fasterxml.jackson.core" )
                )
            //            ,
            //            "org.xerial.snappy" % "snappy-java" % "1.1.2.6" % Provided // Runtime
            //            "org.xerial.snappy" % "snappy-java" % versions.snappy % Provided // Runtime
        )
    }

    //========================================================================
    // AWS w/o Spark
    //========================================================================

    /**
      * Version to use if NOT using Spark
      */
    private def awsDepWithoutSpark (artifact: String): ModuleID = {
        "com.amazonaws" % artifact % versions.aws_wo_spark
    }

    lazy val awsSdkWithoutSpark = Seq(
        awsDepWithoutSpark( "aws-java-sdk" ) // includes all
    )

    //========================================================================
    // AWS SDK in Spark
    //========================================================================

    // AWS Java SDK 1.11.271 uses jackson 2.6.7+2.6.7.1, joda 2.8.1, httpclient 4.5.2

    private def awsSdkWithSparkDep (artifact: String): ModuleID = {
        "com.amazonaws" % artifact % versions.aws_withSpark exclude(
            "commons-codec", "commons-codec") exclude( // 1.7.4 uses 1.3, hadoop 2.7 uses 1.4
            "javax.servlet", "servlet-api") exclude(
            "org.mortbay.jetty", "jetty") exclude(
            "org.mortbay.jetty", "jetty-util") excludeAll (
            ExclusionRule( "com.fasterxml.jackson.core" )
            )
    }

    lazy val awsSdkWithSpark = Seq(

        //        awsDep( "hadoop-aws" ),
        //        awsDep( "aws-java-sdk-s3" ),
        //        awsScalaDep( "aws-scala" ),
        //        awScala,
        //        awsDep( "aws-java-sdk-glue" )
        awsSdkWithSparkDep( "aws-java-sdk" ) // includes all
    )

    //========================================================================
    // an AWS scala lib
    //========================================================================

    /**
      * [2017.07.29] Probably can't really use this now, 3 years ahead of aws-java-sdk used by
      * Spark+Hadoop.
      */
    //    private def awsScalaDep (artifact: String): ModuleID = {
    //        "io.atlassian.aws-scala" %% artifact % versions.awsScala
    //    }

    //    lazy val awScala = "com.github.seratch" %% "awscala" % "0.6.2"

    //========================================================================
    // Sesame & RDF4J
    //========================================================================
    // Sesame project discontinued. Rebranded as RDF4J v-2.0

    //  (disabled until need RDF support again)
    //    "org.openrdf.sesame" % "sesame-rio-turtle" % sesame_version,
    //    "org.openrdf.sesame" % "sesame-rio-ntriples" % sesame_version,
    //    "org.openrdf.sesame" % "sesame-rio-n3" % sesame_version,
    //    "org.eclipse.rdf4j" % "rdf4j-rio-turtle" % rdf4j_version,
    //val rdf4j_version = "2.0"
    //val rdf4j_version = "2.2" // used 2017.04.22
    //val rdf4j_version = "2.2.1" // mvn released 2017.05.04

    //    def sesameDep (name: String): ModuleID = {
    //        "org.openrdf.sesame" % name % versions.sesame withSources()
    //    }
    //
    //    lazy val sesame_rio = sesameDep( "sesame-rio-api" )
    //    lazy val sesame_sparql = sesameDep( "sesame-queryparser-sparql" )
    //
    //    lazy val sesame = Seq( sesame_rio, sesame_sparql )

    //========================================================================
    // Jena
    //========================================================================

    // for RDF, Virtuoso support, used by banana-rdf
    // apache-jena-libs pulls in all standard Jena libs.
    //val jena_version = "2.10.1" // hp version
    //val jena_version = "2.6.4" // hp version
    //val jena_version = "3.1.1" // org.apache version
    //val jena_version = "3.2.0" // used 2017.04.22

    //    "org.apache.jena" % "apache-jena-libs" % jena_version,

    private def jenaDep (name: String): ModuleID

    = {
        "org.apache.jena" % name % versions.jena withSources() withJavadoc() exclude(
            "com.fasterxml.jackson.core", "jackson-databind") exclude(
            "com.fasterxml.jackson.core", "jackson-core")
    }

    lazy val jena = Seq( jenaDep( "jena-arq" ),
                         jenaDep( "jena-cmds" ),
                         jenaDep( "jena-iri" ),
                         jenaDep( "jena-text" ),
                         //                         jenaDep( "jena-extras" ) pomOnly(),
                         jenaDep( "jena-querybuilder" ) )

    //========================================================================
    // sansa
    //========================================================================

    //    private def sansaDep (name: String): ModuleID = {
    //        "net.sansa-stack" %% name % versions.sansa
    //    }
    //
    //    lazy val sansa = Seq(
    //        sansaDep( "sansa-rdf-spark-bundle" ),
    //        sansaDep( "sansa-owl-spark" ),
    //        sansaDep( "sansa-query-spark-bundle" ),
    //        sansaDep( "sansa-inference-spark" ),
    //        sansaDep( "sansa-ml-spark" ),
    //        sansaDep( "sansa-rdf-common" )
    //    )

    //========================================================================
    // RDBMS, SQL, JDBC
    //========================================================================

    lazy val mysql = Seq( "mysql" % "mysql-connector-java" % versions.mysqlConnector )

    lazy val sqlite = Seq( "org.xerial" % "sqlite-jdbc" % versions.sqlite )

    lazy val postgres = Seq( "org.postgresql" % "postgresql" % versions.postgres )

    //========================================================================
    // Google GSheets
    //========================================================================

    //    lazy val sparkGSheets = Seq( "com.github.potix2" %% "spark-google-sheets" % versions.spark_gsheets )

    lazy val gSheets = Seq( "com.google.apis" % "google-api-services-sheets" % versions.gsheets )

    /**
      * uses guava-jdk5, google-http-client-jackson2, google-oauth-client.
      */
    lazy val googleClient = Seq(
        ("com.google.api-client" % "google-api-client" % versions.google_api_client).
            exclude( "com.google.guava", "guava-jdk5" ) )

    // com.google.oauth-client:google-oauth-client-jetty:1.22.0
    lazy val googleOauthClientJetty = Seq(
        "com.google.oauth-client" % "google-oauth-client-jetty" % versions.google_api_client )

    //========================================================================
    // Excel
    //========================================================================

    // "com.crealytics" % "spark-excel_2.11" % "0.8.4"
    lazy val sparkExcel = Seq(
        "com.crealytics" %% "spark-excel" % versions.spark_excel
    )

    //========================================================================
    // Neo4J
    //========================================================================

    lazy val neo4j_driver = Seq(
        "org.neo4j.driver" % "neo4j-java-driver" % versions.neo4jdriver
            withSources()
    )

    lazy val neo4j_community = Seq(
        "org.neo4j" % "neo4j" % versions.neo4j,
        "org.neo4j" % "neo4j-bolt" % versions.neo4j
        //        "org.neo4j.app" % "neo4j-server" % versions.neo4j
        //        "com.graphaware.neo4j" % "server" % "3.4.7.52" % "provided"
    )

    lazy val neo4j_enterprise = Seq(
        "org.neo4j" % "neo4j-enterprise" % versions.neo4j
        //        ,
        //        "org.neo4j" % "neo4j" % versions.neo4j,
        //        "org.neo4j.app" % "neo4j-server-enterprise" % versions.neo4j
    )

    //========================================================================
    // Neo4J Spark Connector
    //========================================================================

    lazy val neo4j_spark_connector = Seq(
        "neo4j-contrib" % "neo4j-spark-connector" % versions.neo4j_spark_connector
            withSources()
            excludeAll ExclusionRule( "org.apache.spark" )
            excludeAll ExclusionRule( "graphframes" )
            excludeAll ExclusionRule( "org.slf4j" )
            excludeAll ExclusionRule( "org.neo4j.driver" )
            excludeAll ExclusionRule( "junit" )
            excludeAll ExclusionRule( "io.netty" )
    )

    //========================================================================
    // Spark-Cypher
    //========================================================================

    lazy val spark_cypher = Seq(
        "org.opencypher" % "spark-cypher" % versions.spark_cypher
            withSources()
            excludeAll ExclusionRule( "org.apache.spark" )
    )

    //========================================================================
    // MongoDB
    //========================================================================

    lazy val mongoDB = Seq( "org.mongodb" % "mongodb-driver" % versions.mongodb )

    //========================================================================
    // Avro
    //========================================================================

    lazy val parquetAvro = Seq( "org.apache.parquet" % "parquet-avro" % versions.parquet )

    //            "junit" % "junit" % junit_version % Test,


    //========================================================================
    // logging, testing
    //========================================================================

    /* slf4j is the api, log4j is the implementation of slf4j.
     * Thus slf4j-log4j12 is the log4j 'binding' for slf4j.
     * logback is an alternative implementation.
     * Not the same as log4j-over-slf4j, which delegates log4j to slf4j.
     * slf4j-log4j12 requires slf4j-api and slf4j-api.
     */
    lazy val slf4j = Seq( "org.slf4j" % "slf4j-api" % versions.slf4j % Provided )

    lazy val scalaTest = Seq(
        "org.scalatest" %% "scalatest" % versions.scalaTest % Test
    )


    //========================================================================
    // Dependency Bundles for build.sbt
    //========================================================================

    object moduleDeps {

        lazy val baseDeps: Seq[ModuleID] =
            typesafe_config ++
                guava ++
                //    aws ++ // would like to, but only feasible in 'aws' Module.
                //                slf4j ++
                scalaTest

        lazy val commonSparkDeps: Seq[ModuleID] =
            baseDeps ++
                spark ++
                graphframes ++
                sparkHive ++
                hadoop ++
                hadoopAws ++
                jackson_in_spark ++
                breeze ++
                netlib

        //    graphframes ++
        //        awsWithSpark ++
        //    streamsets ++
        //            jackson_spark
        //    sqoop ++
        //        queryexpander ++ ims ++ validator ++ bridgedb ++
        //            slf4j ++
        //            scalaTest

        lazy val base = baseDeps ++ scala ++ slf4j

        lazy val sparkbase = commonSparkDeps

        lazy val sqlite = commonSparkDeps ++ deps.sqlite

        lazy val pg = commonSparkDeps ++ deps.postgres

        lazy val mysql = commonSparkDeps ++ deps.mysql

        lazy val gsheets = commonSparkDeps ++ deps.gSheets ++
            googleClient ++ googleOauthClientJetty ++ jackson_core

        lazy val excel = commonSparkDeps ++ deps.sparkExcel

        lazy val jenav = commonSparkDeps ++ deps.jena

        lazy val kgp = commonSparkDeps

        lazy val neo = {
            commonSparkDeps ++
                //                spark_cypher ++
                //                neo4j_spark_connector ++
                //                neo4j_community ++
                //                neo4j_enterprise ++
                neo4j_driver
        }

        lazy val poco = commonSparkDeps

        lazy val emr = commonSparkDeps

        lazy val aws = base ++ awsSdkWithoutSpark

        lazy val testing = Seq(
            "org.neo4j.test" % "neo4j-harness" % versions.neo4j % Test,
            "junit" % "junit" % "4.12" % Test,
            "io.netty" % "netty-all" % versions.netty % Test, // "4.1.8.Final"
            "org.bouncycastle" % "bcprov-jdk15on" % "1.53" % Test,
            "org.bouncycastle" % "bcpkix-jdk15on" % "1.53" % Test
        )

        lazy val main = {
            spark ++
                Seq( hadoopDep( "hadoop-common", Provided ) ) ++
                graphframes ++
                neo4j_driver ++
                testing
        }

    }

}
