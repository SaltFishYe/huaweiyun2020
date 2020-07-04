package com.huawei.classroom.student.model;

public class Delta implements Comparable<Delta> {
    long version;
    long delta;

    private Delta(){};

    public Delta(long version, long field) {
        this.version = version;
        this.delta = delta;
    }

    public long getVersion() {
        return version;
    }

    public long getDelta() {
        return delta;
    }

    @Override
    public int compareTo(Delta o) {
        long oVersion = o.version;
        return Long.compare(version, oVersion);
    }
}
