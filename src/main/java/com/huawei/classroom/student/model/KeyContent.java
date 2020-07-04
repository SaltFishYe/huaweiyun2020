package com.huawei.classroom.student.model;

import com.huawei.classroom.student.race.vo.Data;

import java.util.*;

public enum KeyContent {

    INSTANCE {
        Map<String, RBTree<Delta>> keyMap = new HashMap();

        @Override
        public Data getDate(long key, long min, long max) throws Exception {
            Data data = null;
            RBTree<Delta> tree = keyMap.get(key);
            Data.DataBuilder builder = Data.builder();
            if (tree == null) {
                throw new Exception(String.format("不存在key：%s", key));
            } else {
                LinkedList<Delta> deltaList = tree.inOrder(new Delta(min, 0), new Delta(max, 0));
                long version = deltaList.getLast().version;
                if (version > max) {
                    throw new Exception(String.format("不存在低于版本：%s的key：%s", max, key));
                }
                builder.key(key).version(version);
                Iterator<Delta> itr = deltaList.iterator();
                long deltaValue = 0L;
                for (Delta delta = itr.next(); itr.hasNext(); delta = itr.next()) {
                    deltaValue += delta.getDelta();
                    builder.addField(deltaValue);
                }
                data = builder.build();
            }
            return data;
        }

        @Override
        public Data getDateByMax(long key, long max) throws Exception {
            return getDate(key, Long.MIN_VALUE, max);
        }

        @Override
        public Data getDateByMin(long key, long min) throws Exception {
            return getDate(key, Long.MIN_VALUE, min);
        }

        @Override
        public void putData(long key, long version, long field) {
            RBTree<Delta> tree = keyMap.get(key);
            if (tree == null) {
                tree = new RBTree<>();
            }
            tree.insert(new Delta(version, field));
        }
    };


    public abstract Data getDate(long key, long min, long max) throws Exception;

    public abstract Data getDateByMax(long key, long max) throws Exception;

    public abstract Data getDateByMin(long key, long min) throws Exception;

    public abstract void putData(long key, long version, long field);
}
