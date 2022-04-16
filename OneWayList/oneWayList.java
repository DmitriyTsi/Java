package OneWayList;

import java.util.*;

public class oneWayList<T>  implements List<T> {


    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
        this.value = value;
        }
    }


    private int size = 0;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        for (T t : this) {
            if (Objects.equals(t, o)) return true;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node<T> node = head;

            // есть ли следующий элемент списка?
            @Override
            public boolean hasNext() {
                return node != null;
            }

            //получение следующего значения
            @Override
            public T next() {
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    // реализовано работает
    @Override
    public Object[] toArray() {

        Object[] myArr = new Object[size];
        int i = 0;
        for (T t : this) {
            myArr[i] = t;
            i++;
        }
        return Arrays.copyOf(myArr, myArr.length);
    }


    @Override
    public <T1> T1[] toArray(T1[] a) {

        int i = 0;
        for (T t : this) {
            a[i] = (T1) t;
            i++;
        }
        return (T1[]) a;
    }


    @Override
    public boolean add(T t) {

        if (head == null) {
            head = tail = new Node<>(t);
        } else {
            tail.next = new Node<>(t);
            tail = tail.next;
        }
        size++;
        return true;
    }



    @Override
    public boolean remove(Object o) {

        if (head == null) return false;

        // если нода это голова списка
        if (Objects.equals(head.value, o)) {
            head = head.next;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }

        // ищем предыдущий перед удалением
        Node<T> node = head;
        while (node != null && node.next != null && Objects.equals(node.next.value, o)) {
            node = node.next;
        }
        //дошагали до нашей ноды ищем следующую
        if (node == null) return false;

        if (node.next == tail) {
            tail = node;
            tail.next = null;

        } else {
            node.next = node.next.next;
        }

        size--;
        return true;
    }

    public int count = 0;
    public int getcount() {
        return count;
    }


    @Override
    public boolean containsAll(Collection<?> c) {

        Node<T> node = null;
        count = 0;

        for (node = head; node.next != null; node = node.next) {
            T k = node.value;
            for (Object o : c) {
                if (Objects.equals(k, o)) count++;
            }
            if (count == c.size()) return true;
        }
        return false;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {

        if (c == null || c.size() == 0) return false;
        for (T t : c) {
            T o = (T) t;
            add(o);
        }
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {


        int count = 0;

        if (c == null || c.size() == 0) return false;

        for (T t : c) {
            count++;
            T o = (T) t;
            if (count >= index) add(o);
        }
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> c) {


        Node<T> node = null;
        count = 0;
        for (Object o : c) {
            for (node = head; node.next != null; node = node.next) {
                if (head.value == o) {
                    remove(node);
                    count++;

                }
            }
        }
        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {

        if (isEmpty()) return false;
        if (c == null || c.size() == 0) return false;

        Node<T> node;
        for (node = head; node != null; node = node.next) {

            T m = node.value;
            boolean have = false;

            for (Object obj : c) {
                T o = (T) obj;
                if (m.equals(o)) have = true;
            }
            if (!have) this.remove(m);
        }
        return true;
    }


    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }


    @Override
    public T get(int index) {

        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        for (int i = 0; node != null && i < index; i++) node = node.next;
        return node.value;
    }


    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        for (int i = 0; node != null && i < index; i++) node = node.next;
        T old = node.value;
        node.value = element;
        return old;
    }


    @Override
    public void add(int index, T element) {

        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int i = 0;
        Node<T> node = new Node<>(element);

        if (index == 0) {
            node.next = head;
            head = node;
            size++;

        } else if (index >= 1) {

            tail.next = new Node<>(element);
            tail = tail.next;
            size++;

            // добавление в хвост
        } else if (index == size) {
            tail.next = new Node<>(element);
            tail = tail.next;
            size++;
        }
    }


    public T remove(int index) {
        int count = 0;

        Node<T> node = head;
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        for (node = head; node != null; node = node.next) {
            node = node.next;
            count++;
            if (index == count) {
                remove(node);
            } else if (index == 0) {
                remove(node);
            }else if (index == size-1) {
                remove(node);
            }
            return node.value;
        }
        return null;
    }



    @Override
    public int indexOf(Object o) {

        int count = 0;

        Node<T> node = head;

        for (node = head; node != null; node = node.next) {
            count++;
            if (Objects.equals(node.value, o)) {
                return count;
            }
        }
        return -1;
    }



    @Override
    public int lastIndexOf(Object o) {
        int count = 0;
        int count2 = 0;

        Node<T> node = head;

        for (node = head; node != null; node = node.next) {
            count++;
            if (Objects.equals(node.value, o)) {
                count2++;
            }
        }
        if(count2 != 0)return count - count2;
        return -1;
    }



    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }


    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        
      int count = 0;
      LinkedList<T> sublist = new LinkedList<T>();

        if (fromIndex < 0 || toIndex > size) throw new IndexOutOfBoundsException();
        for (T t : this) {
            if(count >= fromIndex  && count <= toIndex)  {
                sublist.add(t);
            }
            count++;
        }
        return sublist;
    }

}
