package com.huawei.classroom.student.race.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeltaPacket implements Serializable {
    private long version;
    private long deltaCount;
    private List<DeltaItem> deltaItem;

    public DeltaPacket() {
    }

    DeltaPacket(long version, long deltaCount, List<DeltaItem> deltaItem) {
        this.version = version;
        this.deltaCount = deltaCount;
        this.deltaItem = deltaItem;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getDeltaCount() {
        return deltaCount;
    }

    public void setDeltaCount(long deltaCount) {
        this.deltaCount = deltaCount;
    }

    public List<DeltaItem> getDeltaItem() {
        return deltaItem;
    }

    public void setDeltaItem(List<DeltaItem> deltaItem) {
        this.deltaItem = deltaItem;
    }

    public static class DeltaItem implements Serializable {
        private long key;
        private List<Long> delta;

        public DeltaItem() {
        }

        public DeltaItem(long key, List<Long> delta) {
            this.key = key;
            this.delta = delta;
        }

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }

        public List<Long> getDelta() {
            return delta;
        }

        public void setDelta(List<Long> delta) {
            this.delta = delta;
        }

        public static DeltaItemBuilder builder(){
            return new DeltaItemBuilder();
        }
        public static class DeltaItemBuilder {

            private long key;
            private List<Long> delta = new ArrayList<Long>();

            DeltaItemBuilder() {
            }

            public DeltaItemBuilder key(long key){
                this.key = key;
                return DeltaItemBuilder.this;
            }

            public DeltaItemBuilder delta(List<Long> delta){
                this.delta = delta;
                return DeltaItemBuilder.this;
            }

            public DeltaItemBuilder addDelta(Long delta){
                this.delta.add(delta);
                return DeltaItemBuilder.this;
            }

            public DeltaItem build() {
                return new DeltaItem(this.key, this.delta);
            }
            @Override
            public String toString() {
                return "DeltaItem.DeltaItemBuilder(key=" + this.key + ", delta=" + this.delta + ")";
            }
        }

        @Override
        public String toString() {
            return "DeltaItem(key=" + this.key + ", delta=" + this.delta + ")";
        }
    }


    public static DeltaPacketBuilder builder(){
        return new DeltaPacketBuilder();
    }
    public static class DeltaPacketBuilder {

        private long version;
        private long deltaCount;
        private List<DeltaItem> deltaItem = new ArrayList<DeltaItem>();

        DeltaPacketBuilder() {
        }

        public DeltaPacketBuilder version(long version){
            this.version = version;
            return DeltaPacketBuilder.this;
        }

        public DeltaPacketBuilder deltaCount(long deltaCount){
            this.deltaCount = deltaCount;
            return DeltaPacketBuilder.this;
        }

        public DeltaPacketBuilder deltaItem(List<DeltaItem> deltaItem){
            this.deltaItem = deltaItem;
            return DeltaPacketBuilder.this;
        }

        public DeltaPacketBuilder addDeltaItem(DeltaItem deltaItem){
            this.deltaItem.add(deltaItem);
            return DeltaPacketBuilder.this;
        }

        public DeltaPacket build() {
            return new DeltaPacket(this.version, this.deltaCount, this.deltaItem);
        }
        @Override
        public String toString() {
            return "DeltaPacket.DeltaPacketBuilder(version=" + this.version + ", deltaCount=" + this.deltaCount + ", deltaItem=" + this.deltaItem + ")";
        }
    }

    @Override
    public String toString() {
        return "DeltaPacket(version=" + this.version + ", deltaCount=" + this.deltaCount + ", deltaItem=" + this.deltaItem + ")";
    }
}
