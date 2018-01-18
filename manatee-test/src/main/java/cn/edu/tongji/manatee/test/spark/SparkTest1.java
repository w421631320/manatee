package cn.edu.tongji.manatee.test.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.Arrays;

public class SparkTest1 {

    public static void main(String[] args) {
        SparkConf conf =new
                SparkConf().setMaster("local").setAppName("WordCount");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        JavaRDD<String> inputData =
                javaSparkContext.textFile("path_of_input_file");
        JavaRDD<Integer> integerJavaRDD = javaSparkContext.parallelize(Arrays.asList(1,2,3,4));
        integerJavaRDD.filter(new Function<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) throws Exception {
                return null;
            }
        });

        StructType schema = new StructType(
                new StructField[] {
                        DataTypes.createStructField("id", DataTypes.StringType, true),
                        DataTypes.createStructField("name", DataTypes.StringType, true),
                        DataTypes.createStructField("address", DataTypes.StringType, true),
                        DataTypes.createStructField("telephone", DataTypes.StringType, true),
                        DataTypes.createStructField("latitude", DataTypes.DoubleType, true),
                        DataTypes.createStructField("longitude", DataTypes.DoubleType, true)

                }
        );
    }
}
