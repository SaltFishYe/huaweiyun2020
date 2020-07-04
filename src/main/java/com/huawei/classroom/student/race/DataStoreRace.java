package com.huawei.classroom.student.race;

import com.huawei.classroom.student.race.vo.Data;
import com.huawei.classroom.student.race.vo.DeltaPacket;

public interface DataStoreRace {

    boolean init(String dir);

    void deInit();

    void writeDeltaPacket(DeltaPacket deltaPacket);

    Data readDataByVersion(long key, long version);

}
