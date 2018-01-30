package com.tongji.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xubing on 21:38 for manatee.
 * <p>
 * I love coding forever
 */

public abstract class DataWriter {

    Logger logger = LogManager.getLogger(DataWriter.class);

    /**
     *
     * hp_site, hp_type, hp_upload_time, hp_upload_hour
     *
     */
    private String dataDir;

    private String dbTag;

    private Integer flushSize;

    public DataWriter(String dataDir, String dbTag, Integer flushSize) {
        this.dataDir = dataDir;
        this.dbTag = dbTag;
        this.flushSize = flushSize;
    }

    abstract void flush(List<String> crawlData);

    public void searchFileAndFlush() {
        List<File> crawlDataDBs  = new LinkedList<File>();
        listCrawlDataDB(this.dataDir, crawlDataDBs);
        for (File crawlDataDB : crawlDataDBs) {
            logger.info(String.format("Begin send the db %s", crawlDataDB.getName()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                System.exit(-1);
            }
            readCrawlDataFileAndSend(crawlDataDB);
        }
    }

    public void delCrawlDataFile(File crawlDataFile) {
        crawlDataFile.delete();
    }

    private void listCrawlDataDB(String path, List<File> crawlDataFiles) {
        java.io.File file = new java.io.File(path);
        File[] files = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.endsWith(".db.closed")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        if (files != null && files.length > 0) {
            for (File crawlDataFile : files) {
                crawlDataFiles.add(crawlDataFile);
            }
        }
        for (File dir : file.listFiles()) {
            if (dir.isDirectory()) {
                listCrawlDataDB(dir.getAbsolutePath(), crawlDataFiles);
            }
        }
    }

    public void readCrawlDataFileAndSend(File crawlDataFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(crawlDataFile);
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            byte[] temp = new byte[0];
            List<String> pushData = new ArrayList<String>();
            Integer cnt = 0;
            while ((fileChannel.read(byteBuffer)) != -1) {
                byte[] bs = new byte[byteBuffer.position()];
                byteBuffer.flip();
                byteBuffer.get(bs);
                byteBuffer.clear();
                int startNum=0;
                boolean isNewLine = false;
                for(int i=0;i < bs.length;i++) {
                    if(bs[i] == 10) {
                        isNewLine = true;
                        startNum = i;
                    }
                }
                if(isNewLine) {
                    byte[] toTemp = new byte[temp.length + startNum];
                    System.arraycopy(temp,0,toTemp,0,temp.length);
                    System.arraycopy(bs,0,toTemp,temp.length,startNum);
                    if (cnt <= flushSize) {
                        pushData.add(new String(toTemp));
                    } else {
                        flush(pushData);
                        pushData.clear();
                        cnt = 0;
                    }
                    temp = new byte[bs.length-startNum-1];
                    System.arraycopy(bs,startNum+1,temp,0,bs.length-startNum-1);
                } else {
                    byte[] toTemp = new byte[temp.length + bs.length];
                    System.arraycopy(temp, 0, toTemp, 0, temp.length);
                    System.arraycopy(bs, 0, toTemp, temp.length, bs.length);
                    temp = toTemp;
                }
            }
            if (pushData.size() != 0) {
                flush(pushData);
                pushData.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
