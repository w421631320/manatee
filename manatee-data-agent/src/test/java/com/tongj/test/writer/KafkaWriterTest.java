package com.tongj.test.writer;

import com.tongji.writer.KafkaDataWriter;
import org.junit.Test;

/**
 * Created by xubing on 21:45 for manatee.
 * <p>
 * I love coding forever
 */

public class KafkaWriterTest {

    @Test
    public void test(){
        KafkaDataWriter kafkaDataWriter = KafkaDataWriter.getInstance("/Users/xubing/xb_project/manatee/crawl_data",
                ".db.closed", 3);
        while (true) {
            kafkaDataWriter.searchFileAndFlush();
        }
    }
}
