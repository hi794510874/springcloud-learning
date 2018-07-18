package com.owen.model;

/**
 * Created by huang_b on 2018/6/21.
 */
public class CheckChangeMsg {

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getExcutingTask() {
        return excutingTask;
    }

    public void setExcutingTask(int excutingTask) {
        this.excutingTask = excutingTask;
    }


    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public int getCoreThreadNum() {
        return coreThreadNum;
    }

    public void setCoreThreadNum(int coreThreadNum) {
        this.coreThreadNum = coreThreadNum;
    }

    private String threadName;
    private int poolSize;
    private int queueSize;
    private int coreThreadNum;
    private String content;

    private int id;

    private int excutingTask;
}
