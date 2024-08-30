package com.bbdog.study.springboot.summary.demo.web.v2024.v08.算法;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class MyHashMap<K, V> {

    private LinkedList<Entry<K, V>>[] table = new LinkedList[16];

    public V put(K k, V v) {
        // 计算k的数组下标位置
        if (CollectionUtils.isEmpty(table[k.hashCode() & 0xf])) {
            LinkedList<Entry<K, V>> list = new LinkedList<>();
            list.add(getKvEntry(k, v));
            table[k.hashCode() & 0xf] = list;
        } else {
            LinkedList<Entry<K, V>> list = table[k.hashCode() & 0xf];
            list.add(getKvEntry(k, v));
        }
        return v;
    }

    private Entry<K, V> getKvEntry(K k, V v) {
        Entry<K, V> entry = new Entry<>();
        entry.setK(k);
        entry.setV(v);
        return entry;
    }

    public V get(K k) {
        for (int i = 0; i < table[k.hashCode() & 0xf].size(); i++) {
            if (table[k.hashCode() & 0xf].get(i).getK().equals(k)) {
                return table[k.hashCode() & 0xf].get(i).getV();
            }
        }
        return null;
    }


    class Entry<K, V> {
        private K k;
        private V v;

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

    }


}
