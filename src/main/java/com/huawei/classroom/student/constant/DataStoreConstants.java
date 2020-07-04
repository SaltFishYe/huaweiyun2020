package com.huawei.classroom.student.constant;

public interface DataStoreConstants {

    int DATA_FIELD_NUM = 64;

    long DELTA_PACKET_HEADER_SIZE = Long.BYTES * 2;

    long DELTA_ITEM_SIZE = Long.BYTES + DATA_FIELD_NUM * Long.BYTES;

    long PACKAGE_LENGTH_RECORD_SIZE = Long.BYTES;

}
