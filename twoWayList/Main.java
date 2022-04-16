package hillel.twoWayList;


public class Main {

    public static void main(String[] args) {

        TwoWayList<String> list = new TwoWayList<>();
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      list.add("3");

        TwoWayList<String> list2 = new TwoWayList<>();
        list2.add("11");
        list2.add("22");
        list2.add("33");
        list2.add("44");

      TwoWayList<String> list3 = new TwoWayList<>();
      list3.add("1");
      list3.add("3");
      //list3.add("300");



      System.out.println("\n\n--contains(Object o)--");
      System.out.println(list.contains("2"));

      System.out.println("\n\n--- toArray==-");
      System.out.println(list.toArray());
      System.out.println("length: " + list.toArray().length);


      System.out.println("\n\n--add--");
      list.add("7");
        list.add(0,"100");
        list.add(2,"110");
        list.add(4,"105");
        list.add(5,"12");
      System.out.println("list.size: " + list.size());
      list.print();

      System.out.println("\n\n--remove--");
        System.out.println(list.remove("100"));
        System.out.println(list.remove("3"));
        System.out.println(list.remove("120"));
        System.out.println(list.remove("4"));
      System.out.println("list.size: " + list.size());
      list.print();


      System.out.println("\n\n--addAll(Collection c)--");
      System.out.println("list.size: " + list.size());
      System.out.println("list2.size: " + list2.size());
      System.out.println(list.addAll(list2));
      System.out.println("list.size: " + list.size());


      System.out.println("\n\n--addAll(int index, Collection c--");
      System.out.println("list.size: " + list.size());
      System.out.println("list2.size: " + list2.size());

      System.out.println(list.addAll(2, list2));

      System.out.println("list.size: " + list.size());
      System.out.println("list2.size: " + list2.size());
      System.out.println("--list.print--");
      list.print();


      System.out.println("\n\n--get(int index)--");
      System.out.println(list.get(1));
      System.out.println("--list.print--");
      list.print();


      System.out.println("\n\n--Object set(int index, Object element)--");
      System.out.println("list.size: " + list.size());
      System.out.println(list.set(0, "Hello"));
      System.out.println("list.size: " + list.size());
      System.out.println("--list.print--");
      list.print();



      System.out.println("\n\n--add(int index, Object element)--");
      System.out.println("list.size: " + list.size());
      list.add(2, "World");
      System.out.println("list.size: " + list.size());
      System.out.println("--list.print--");
      list.print();



      System.out.println("\n\n--indexOf(Object o)--");
      System.out.println("indexOf: " + list.indexOf("3"));
      System.out.println("--list.print--");
      list.print();



      System.out.println("\n\n-- lastIndexOf(Object o) --");
      System.out.println("lastIndexOf: " + list.lastIndexOf("3"));
      System.out.println("--list.print--");
      list.print();


      System.out.println("\n\n--subList(int fromIndex, int toIndex)--");
      System.out.println(list.subList(0,2));
      System.out.println("list.subList.size: " + list.subList(0,2).size());
      System.out.println("list.size: " + list.size());
      System.out.println("--list.print--");
      list.print();




      System.out.println("\n\n--retainAll(Collection c)--");
      System.out.println("--list.print--");
      list.print();
      System.out.println("list.size: " + list.size());
      System.out.println(list.retainAll(list3));
      System.out.println("list.size: " + list.size());
      System.out.println("--list.print--");
      list.print();




      System.out.println("\n\n--toArray(Object[] a--");
      System.out.println("--list.print--");
      list.print();

      System.out.println(list.toArray(new Object[list.size()]));
      System.out.println("length: " + list.toArray(new Object[list.size()]).length);



      System.out.println("\n\n--containsAll(Collection c)--");
      System.out.println("--list3.print--");
      list3.print();
      System.out.println("list.size: " + list3.size());
      System.out.println(list.containsAll(list3));
      System.out.println("list.size: " + list.size());
      System.out.println("--list.print--");
      list.print();

      System.out.println("\n\n--remove(int index)--");
      System.out.println("list.size: " + list.size());
      System.out.println(list.remove(0));
      System.out.println("list.size: " + list.size());
      System.out.println("--list.print--");
      list.print();

    }



}
