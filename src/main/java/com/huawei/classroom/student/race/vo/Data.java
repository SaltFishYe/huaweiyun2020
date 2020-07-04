package com.huawei.classroom.student.race.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {
    private long key;
    private long version;
    private List<Long> field;

    public Data() {
    }

    public Data(long key, long version, List<Long> field) {
        this.key = key;
        this.version = version;
        this.field = field;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<Long> getField() {
        return field;
    }

    public void setField(List<Long> field) {
        this.field = field;
    }

    public static DataBuilder builder() {
        return new DataBuilder();
    }

    public static class DataBuilder {

        private long key;
        private long version;
        private List<Long> field = new ArrayList<Long>();

        DataBuilder() {
        }

        public DataBuilder key(long key) {
            this.key = key;
            return DataBuilder.this;
        }

        public DataBuilder version(long version) {
            this.version = version;
            return DataBuilder.this;
        }

        public DataBuilder field(List<Long> field) {
            this.field = field;
            return DataBuilder.this;
        }

        public DataBuilder addField(Long field) {
            this.field.add(field);
            return DataBuilder.this;
        }

        public Data build() {
            return new Data(this.key, this.version, this.field);
        }

        @Override
        public String toString() {
            return "Data.DataBuilder(key=" + this.key + ", version=" + this.version + ", field=" + this.field + ")";
        }
    }

    @Override
    public String toString() {
        return "Data(key=" + this.key + ", version=" + this.version + ", field=" + this.field + ")";
    }
}
