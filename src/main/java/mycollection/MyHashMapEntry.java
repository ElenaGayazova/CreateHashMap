package mycollection;

import java.util.Map;

public class MyHashMapEntry implements Map.Entry {

    private Object key;
    private Object value;

    public MyHashMapEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        return this.value=value;
    }
}
