package com.tongji.writer;


import java.util.List;

/**
 * Created by xubing on 21:37 for manatee.
 * <p>
 * I love coding forever
 */

public class KafkaDataWriter extends DataWriter{

    private static KafkaDataWriter kafkaDataWriter = null;

    /**
     *
     * @param dataDir the directory crawl-data persisted
     * @param dbTag the crawl-data db endwith tag
     * @param flushSize batch
     */
    private KafkaDataWriter(String dataDir, String dbTag, Integer flushSize) {
        super(dataDir, dbTag, flushSize);

    }

    @Override
    void flush(List<String> crawlDatas) {
        for (String crawlData : crawlDatas) {
        }

    }

    public static KafkaDataWriter getInstance(String dataDir, String dbTag, Integer flushSize) {
        if (kafkaDataWriter == null) {
            synchronized (KafkaDataWriter.class) {
                if (kafkaDataWriter == null) {
                    kafkaDataWriter = new KafkaDataWriter(dataDir, dbTag, flushSize);
                }
            }
        }
        return kafkaDataWriter;
    }

}
