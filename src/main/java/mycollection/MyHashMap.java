package mycollection;

import java.util.*;

public class MyHashMap {

    private int size;
    private int base;
    private MyList[] data;

    public MyHashMap() {
        size=0;
        base=100;
        data = new MyList[base];
        Arrays.fill(data, null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size==0);
    }

    private int getIndex(Object key) {
        if(key==null) return 0;
        int hash = key.hashCode();
        if(hash<0) hash=-hash;
        return hash % base;
    }

    private MyHashMapEntry getEntryByKey(Object key) {
        int idx = getIndex(key);
        if(data[idx]==null) return null;
        Iterator it = data[idx].iterator();
        while(it.hasNext()) {
            MyHashMapEntry entry = (MyHashMapEntry)it.next();
            if(Common.equ(entry.getKey(), key)) return entry;
        }
        return null;
    }

    private MyHashMapEntry getEntryByValue(Object value) {
        for(int idx=0; idx<data.length; idx++) {
            if (data[idx] == null) continue;
            Iterator it = data[idx].iterator();
            while (it.hasNext()) {
                MyHashMapEntry entry = (MyHashMapEntry) it.next();
                if (Common.equ(entry.getValue(), value)) return entry;
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        MyHashMapEntry entry = getEntryByKey(key);
        return (entry!=null);
    }

    public boolean containsValue(Object value) {
        MyHashMapEntry entry = getEntryByValue(value);
        return (entry!=null);
    }

    public Object get(Object key) {
        MyHashMapEntry entry = getEntryByKey(key);
        return (entry!=null) ? entry.getValue() : null;
    }

    public Object put(Object key, Object value) {
        MyHashMapEntry entry = getEntryByKey(key);
        Object result = null;
        if(entry!=null) {
            result = entry.getValue();
            entry.setValue(value);
        } else {
            int idx = getIndex(key);
            entry = new MyHashMapEntry(key, value);
            if(data[idx]==null) data[idx] = new MyList();
            data[idx].add(entry);
            size++;
        }
        return result;
    }

    public Object remove(Object key) {
        MyHashMapEntry entry = getEntryByKey(key);
        Object result = null;
        if(entry!=null)  {
            result = entry.getValue();
            int idx = getIndex(key);
            data[idx].remove(entry);
            size--;
        }
        return result;
    }

    public void clear() {
        for(int i=0; i<data.length; i++) {
            if(data[i]!=null) data[i].clear();
        }
        Arrays.fill(data, null);
        size=0;
    }

}
