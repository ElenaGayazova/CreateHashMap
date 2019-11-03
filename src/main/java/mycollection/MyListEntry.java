package mycollection;

public class MyListEntry {
    Object value;
    MyListEntry prev, next;

    public MyListEntry() {
    }

    public MyListEntry(Object value) {
        this.value = value;
    }

    public MyListEntry(Object value, MyListEntry prev, MyListEntry next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public MyListEntry getPrev() {
        return prev;
    }

    public void setPrev(MyListEntry prev) {
        this.prev = prev;
    }

    public MyListEntry getNext() {
        return next;
    }

    public void setNext(MyListEntry next) {
        this.next = next;
    }

}
