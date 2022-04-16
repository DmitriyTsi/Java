package hillel.twoWayList;



import java.util.*;

public class TwoWayList<T> implements List {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;


    //+
    @Override
    public int size() {
        return size;
    }

    //+
    @Override
    public boolean isEmpty() {
        return head == null;
    }

//++
    @Override
    public boolean contains(Object o) {

            for (Object obj : this) {
                if (Objects.equals(obj, o)) return true;
            }
        return false;
    }


    @Override
    public Iterator iterator() {

        return new Iterator() {

            Node<T> node = head;


            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Object next() {
                T value = node.value;
                node = node.next;
                return value;
            }

            public boolean hasPrev() {
                return node != null;
            }

            public Object prev() {
                T value = node.value;
                node = node.prev;
                return value;
            }
        };
    }



    @Override
    public Object[] toArray() {

        Object[] myArr = new Object[size+1];

        int i = 0;
        for (Object o : this) {
            myArr[i] = o;
            i++;
        }
        return myArr;
    }



    public void addLast(Object o) {

        Node<T> node = new Node(o);
        if (isEmpty()) head = node;
        else tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }



    @Override
    public boolean add(Object o) {
        Node<T> node = new Node(o);

            if (head == null) {
                head = tail = node;
                size++;
                return true;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
                size++;
                return true;
        }
    }



    @Override
    public boolean remove(Object o) {

        int count = 0;
        Node<T> node;
        for (node = head; node != null; node = node.next) {

            if (Objects.equals(node.value, o)) {

                if (count == 0) {
                    head.next.prev = null;
                    head = head.next;
                    size--;
                    return true;
                }
                if (count > 0 && count < size) {
                    node.prev.next = node.next;
                    node.prev.prev = node.prev;
                    size--;
                    return true;
                }
                if (count == size) {
                    tail.prev.next = null;
                    tail = tail.prev;
                    size--;
                    return true;
                }
            }
            count++;
        }return false;
    }



    @Override
    public boolean addAll(Collection c) {

        int count = 0;
        Node<T> node;
     for (node = head; node != null; node = node.next) {

         if(count == size-1) {
             for (Object o : c) {
             add(o);

             } return true;
         }
         count++;
     }
        return false;
    }


    //++
    @Override
    public boolean addAll(int index, Collection c) {

        int count = 0;
        Node<T> node;
        for (node = head; node != null; node = node.next) {
                for (Object o : c) {
                   add(index, o);
                }return true;
            }
            count++;
        return false;
    }



    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }


    @Override
    public Object get(int index) {

        int count = 0;
        for (Object o : this) {
         if(index == count) return o;
         count++;
        }return null;
    }


    @Override
    public Object set(int index, Object element) {

        if(index > size) throw new IndexOutOfBoundsException();
        int count = 0;
        for (Object o : this) {
            if(index == count) {
                add(index, element);
                return true;
            }
            count++;
        }return false;
    }


    @Override
    public void add(int index, Object element) {
        Node<T> node = head;
        int count = 0;

        while (node != null && count != index) {
            node = node.next;
            count++;
        }
        if(index == 0) {
            Node<T> tmp = new Node<T>((T) element);
            head.prev = tmp;
            tmp.next = head;
            head = tmp;
            head.prev = null;
            size++;

        } else if(index == count && node.next != null) {
          Node<T> tmp = new Node<T>((T) element);
          node.prev.next = tmp;
          tmp.prev = node.prev;
          node.prev = tmp;
          tmp.next = node;
            size++;
        } else addLast(element);
    }



    void print(){

        Node<T> node = head;
       int i = 0;
        while(node != null) {
            System.out.println("index: " + i + " node.value: " + node.value);
            node = node.next;
            i++;
        }
    }




    @Override
    public Object remove(int index) {

        if(index > size && index < 0) throw new IndexOutOfBoundsException();
        int count = 0;
        for (Object o : this) {
            if(index == count) {
                remove(o);
                return true;
            }
            count++;
        }return false;
    }



    @Override
    public int indexOf(Object o) {


        int count = 0;
        for (Object obj : this) {
            if(Objects.equals(obj, o)) {
                return count;
            }
            count++;
        }return -1;
    }


    @Override
    public int lastIndexOf(Object o) {

        Node<T> node;
        int count = size;
        for (node = tail; node != null; node = node.prev) {
            if (Objects.equals(node.value, o)) {
                return count-1;
            }
            count--;
        }return -1;
    }


    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }



    @Override
    public List subList(int fromIndex, int toIndex) {

        LinkedList<T> Mylist = new LinkedList<>();
        int count = 0;
        for (Object o : this) {
            if (count >= fromIndex && count <= toIndex) {
                Mylist.add((T) o);
           }
            count++;
        }
            return Mylist;
    }


    @Override
    public boolean retainAll(Collection c) {

        Node<T> node;
        int countEquals = 0;
        int countRemove = 0;

        for (node = head; node != null; node = node.next) {
            countEquals = 0;
            for (Object o : c) {

                if(node.value.equals(o)) countEquals++;

            }if(countEquals == 0) {
            remove(indexOf(node.value));
                countRemove++;
            }
       }if(countRemove > 0)  return true;
        return false;
    }




    @Override
    public boolean removeAll(Collection c) {
        Node<T> node;
        int count = 0;
        for (node = head; node != null; node = node.next) {

            for (Object o : c) {
                if(node.value == o) {
                    remove(indexOf(node.value));
                    count++;
                }
            }
        }  if(count == 0) {
            return false;
        } return true;
    }




    @Override
    public boolean containsAll(Collection c) {

        Node<T> node;
        int count = 0;

        for (Object o : c) {
        for (node = head; node != null; node = node.next) {
                if(!contains(o)) count++;
              }
            }
        if (count > 0) return false;
        else return true;
        }


    @Override
    public Object[] toArray(Object[] a) {


        Node<T> node;
        int count = 0;
        for (node = head; node != null; node = node.next) {
            a[count] = node.value;
            count++;
        }
        return a = new Object[a.length];
    }
}
