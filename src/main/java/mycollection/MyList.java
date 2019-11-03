package mycollection;


import java.util.Arrays;
import java.util.Iterator;

public class MyList {

    class MyListIterator implements Iterator {

        MyListEntry item;

        public MyListIterator(MyListEntry item) {
            this.item = item;
        }

        @Override
        public boolean hasNext() {
            return (item!=null);
        }

        @Override
        public Object next() {
            if(item==null) return null;
            Object result = item.getValue();
            item = item.getNext();
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    MyListEntry head;
    int         size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public boolean contains(Object o) {
        MyListEntry item = head;
        while(item!=null) {
            if(Common.equ(o, item.value)) return true;
            item = item.next;
        }
        return false;
    }

    public Iterator iterator() {
        return new MyListIterator(head);
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        Arrays.fill(result, null);

        MyListEntry item = head;
        for(int i=0; i<size && item!=null; i++, item=item.getNext()) {
            result[i] = item.getValue();
        }

        return result;
    }

    public boolean add(Object o) {
        if(head==null) {
            head = new MyListEntry(o);
            head.setPrev(head); // pointer to last item
        } else {
            MyListEntry last = head.getPrev();
            MyListEntry item = new MyListEntry(o, last, null);
            last.setNext(item);
            head.setPrev(item);
        }
        size++;
        return true;
    }

    private void removeEntry(MyListEntry item) {
        MyListEntry prev = item.getPrev();
        MyListEntry next = item.getNext();

        if(next!=null) next.setPrev(item.getPrev());
        if(prev!=null) prev.setNext(item.getNext());

        if(item==head) { // first item
            head = next;
            prev.setNext(null); // restore end pointer
        } else if(item==head.getPrev()) { //last item
            prev.setNext(null); // restore end pointer
        }
        size--;
    }

    public boolean remove(Object o) {
        MyListEntry item = head;
        while(item!=null) {
            if(Common.equ(o, item.value)) break;
            item = item.next;
        }

        if(item==null) return false;

        removeEntry(item);

        return true;
    }

    public void clear() {
        head=null;
        size=0;
    }

    private MyListEntry getEntryAt(int index) {
        if(index<0 || size<index+1) throw new IndexOutOfBoundsException();
        MyListEntry item = head;
        for(int i=0; i<index; i++) {
            item = item.getNext();
        }
        return item;
    }

    public Object get(int index) {
        MyListEntry item = getEntryAt(index);
        return item.getValue();
    }

    public Object set(int index, Object element) {
        MyListEntry item = getEntryAt(index);
        Object result = item.getValue();
        item.setValue(element);
        return result;
    }

    public void add(int index, Object element) {
        if(index<0 || index>size) throw new IndexOutOfBoundsException();
        if(index==size) add(element);

        MyListEntry next = getEntryAt(index);
        MyListEntry prev = next.getPrev();

        MyListEntry item = new MyListEntry(element, prev, next);
        if(prev.getNext()!=null ) prev.setNext(item);
        if(next!=null) next.setPrev(item);
    }

    public Object remove(int index) {
        MyListEntry item = getEntryAt(index);
        removeEntry(item);
        return item.getValue();
    }

    public int indexOf(Object o) {
        MyListEntry item = head;
        for(int i=0; i<size && item!=null; i++) {
            if(Common.equ(o, item.value)) return i;
            item = item.getNext();
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        MyListEntry item = head.getPrev(); // last item
        for(int i=size-1; i>00; i--) {
            if(Common.equ(o, item.value)) return i;
            item = item.getPrev();
        }
        return -1;
    }

}
