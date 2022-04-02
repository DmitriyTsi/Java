package hillel.arraylist;

import java.util.*;

public class ArrayList<T> implements List<T> {

    Object[] array = new Object[10];


    @Override
    public int size() {
        return array.length;
    }


    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }


    @Override
    public boolean contains(Object o) {
        for (T elem : this) {
            if (Objects.equals(elem, o)) return true;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Object next() {
                return (T) array[index++];
            }
        };
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }



    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(array, array.length, a.getClass());
    }



    @Override
    public boolean add(T t) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = t;
        return true;
    }



    @Override
    public boolean remove(Object o) {

        Object[] copy  = new Object[array.length];

        int count = 0;
        for (int i = 0; i < array.length; i++) {

            if(array[i] != o) {
                copy[count] = array[i];
                i++;
                count++;
            }
        }
        array = Arrays.copyOf(copy, copy.length);

        return true;

    }



    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {

        Object[] copy = new Object[array.length + c.size()];

       for(int i = 0, indexArray = 0; i < copy.length; i++) {


               if(i < c.size()) {
                   for (T obj : c) {
                       copy[i] = obj;
                       i++;
                   }
               }

               if(i >= c.size()) {
                   copy[i] = array[indexArray++];
               }
       }

         Object[] array = (Object[]) Arrays.copyOf(copy, copy.length);

        return true;
    }




    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        Object[] copy = new Object[array.length + c.size()];


        if(index > array.length || index < array.length) {

            System.out.println("Введите началный индекс от 0 до " + array.length);
            return false;
        }

        for(int i = 0, indexArray = 0; i < copy.length; i++) {
            System.out.println(i);


            if (i < index) {
                copy[i] = array[indexArray++];


            } else if (i == index) {

                for (T t : c) {
                    copy[i++] = t;
                }


            } else if (i >= (indexArray)) {
                copy[i] = array[indexArray++];

            }
        }
            Object[] array = (Object[]) Arrays.copyOf(copy, copy.length);

        return true;
    }




    @Override
    public boolean removeAll(Collection<?> c) {


        int numDeleteObject = 0;
        int count2 = 0;

        for(Object count : c) {
         for(int i = 0; i < array.length; i++) {
           if(array[i] == count) {
               array[i] = null;
               numDeleteObject++;
           }
             if (numDeleteObject == 0) return false;
       }
     }

        System.out.println("Количество одинаковых объектов: " + numDeleteObject);

        Object[] arrNew = new Object[(array.length - numDeleteObject)]; {

            for(int i = 0; i < array.length; i++) {
                if(array[i] != null) {
                    arrNew[count2] = array[i];
                    count2++;
                }
            }
        }
        Object [] array = (Object []) Arrays.copyOf(arrNew, arrNew.length);

        return true;
    }



    @Override
    public boolean retainAll(Collection<?> c) {

        int numDeleteObject = 0;


        for(Object count : c) {
            for(int i = 0; i < array.length; i++) {
                if(array[i] == count) {
                    array[i] = (Object) count;
                    numDeleteObject++;
                }
               if (numDeleteObject == 0) return false;
            }
        }

        System.out.println("Количество  одинаковых объектов: " + numDeleteObject);

        Object[] arrNew = new Object[(numDeleteObject)];


        for (Object obj : arrNew) {
            for(int i = 0; i < arrNew.length; i++) {
                arrNew[i] = array[i];
            }
        }
        Object [] array = (Object []) Arrays.copyOf(arrNew, arrNew.length);

        return true;
    }



    @Override
    public void clear() {
        array = new Object[0];
    }



    @Override
    public T get(int index) {
        return (T) array[index];
    }



    @Override
    public T set(int index, T element) {
        Object old = array[index];
        array[index] = element;
        return (T) old;
    }




    @Override
    public void add(int index, T element) {

        Object[] copy = new Object[array.length+1];

        for(int i = 0; i < copy.length; i++) {
            System.out.println(i);

            if(i == index) {
                copy[i] = (T) element;

            }else if(i < index) {
                copy[i] = array[i];


            }else if(i > index) {
                copy[i] = array[i-1];
            }
        }
        Object [] array = (Object []) Arrays.copyOf(copy, copy.length);

        }



    @Override
    public T remove(int index) {

        Object old = array[index];
        Object [] copy = new Object[array.length - 1];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                copy[j++] = array[i];
            }
        }
        return (T) old;
    }




    @Override
    public int indexOf(Object o) {
        int i;
        for (i = 0; i < size(); i++) {
            if (Objects.equals(get(i), o)) {

            }
        }
        return i;
    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }


    // лист итератор не трогаем
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    // лист итератор не трогаем
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }


    @Override
    public List<T> subList(int fromIndex, int toIndex) {

        List<T> result = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(get(i));
        }
        return result;

    }

}
