package OneWayList;


public class Main {

    public static void main(String[] args) {

        oneWayList<Person> list = new oneWayList<Person>();

    Person person1  = new Person("Ivan");
    Person person2  = new Person("Andrey");
    Person person3  = new Person("Egor");
    Person person4  = new Person("Nastya");
    Person person5  = new Person("Godya");
    Person person6  = new Person("Pavel");
    Person person7  = new Person("Nikita");
    Person person8  = new Person("Taras");
    Person person9  = new Person("Liza");


        System.out.println(list.add(person1));
        System.out.println(list.add(person2));
        System.out.println(list.add(person3));
        System.out.println(list.add(person4));
        System.out.println(list.add(person5));

      oneWayList<Person> list2 = new oneWayList<Person>();
      System.out.println(list2.add(person7));
      System.out.println(list2.add(person2));
      System.out.println(list2.add(person1));
      System.out.println(list2.add(person9));
      System.out.println(list2.add(person8));


      System.out.println("\n--removeAll-----");
      System.out.println("length list: " +list.toArray().length);
      System.out.println("lengthlist2: " +list2.toArray().length);
      System.out.println(list.removeAll(list2));
        System.out.println(list.count);
      System.out.println("length list: " +list.toArray().length);
      System.out.println("length list2: " +list2.toArray().length);



        System.out.println("\n-- Object[] toArray-----");
        System.out.println(list.toArray());
        System.out.println("length: " +list.toArray().length);

        System.out.println("\n-- T1[] toArray-----");
        Object[] myArr2 = new Object[list.size()];
        System.out.println(list.toArray(myArr2));
        System.out.println("length: " + list.toArray().length);

        System.out.println("\n--add-----");
        System.out.println(list.add(person6));
        System.out.println(list.size());

        System.out.println("\n--remove-----");
        System.out.println(list.remove(person2));
        System.out.println(list.size());

        System.out.println("\n--containsAll-----");
        System.out.println(list.containsAll(list2));
        System.out.println("list size: " + list.size());
        System.out.println("list2 size: " + list2.size());
        System.out.println("count (matched objects): " + list.getcount());


        System.out.println("\n--addAll-----");
        System.out.println(list.addAll(list2));

        System.out.println("list size: " + list.size());
        System.out.println("list2 size: " + list2.size());

        System.out.println("\n--addAll(index....)-----");
        System.out.println(list.addAll(3, list2));
        System.out.println("list size: " + list.size());
        System.out.println("list2 size: " + list2.size());



        System.out.println("\n--add(int index, T element-----");
        list.add(1, person8);
        System.out.println("Size: " +list.size());


      System.out.println("\n--remove(int index)----");
      list.remove(0);
      System.out.println("Size: " +list.size());
      list.remove(1);
      System.out.println("Size: " +list.size());
      list.remove(8);
      System.out.println("Size: " +list.size());

      System.out.println("\n--indexOf----");
      System.out.println(list. indexOf(person8));

      System.out.println("\n--subList----");
      System.out.println(list. subList(0,1));
      System.out.println(list. subList(0,1).size());


      System.out.println("\n--indexOf----");
      System.out.println(list.indexOf(person1));
      for (Person person : list) {
        System.out.println(person.getName());
      }

      System.out.println("\n--lastIndexOf----");
      System.out.println(list.lastIndexOf(person1));
    }
}
