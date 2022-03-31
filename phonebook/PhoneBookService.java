package hillel.phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static hillel.phonebook.ContactType.EMAIL;
import static hillel.phonebook.ContactType.PHONE;

public class PhoneBookService implements iphoneBook {

    ArrayList<Contact> listContact;
    private String SearhQuery;
    private boolean contactNotFound;
    private int NumberDeleteContact;


    public boolean getContactNotFound() {
        return contactNotFound;
    }


    PhoneBookService(ArrayList<Contact> listContact) {
        this.listContact = listContact;
    }


    @Override
    public void AllEmail() {
        System.out.println("---Email---");
        int i = 0;
        for (Object key : listContact) {
            if ((listContact.get(i).getType().equals(EMAIL))) {
                System.out.println(listContact.get(i).getphoneEmail());
            }
            i++;
        }
    }


    @Override
    public void AllPhone() {
        System.out.println("---Телефоны---");
        int i = 0;
        for (Object key : listContact) {
            if ((listContact.get(i).getType().equals(PHONE))) {
                System.out.println(listContact.get(i).getphoneEmail());
            }
            i++;
        }
    }


    @Override
    public void searchName(String SearhQuery) {
        this.SearhQuery = SearhQuery;

        ArrayList<Contact> listResult = new ArrayList();
        int count = 0;
        int i = 0;

        System.out.println("\n---Поиск контакта по имени:---");
        for (Object key : listContact) {

            for (int j = 0; j < SearhQuery.length(); j++) {
                char a = SearhQuery.charAt(j);
                char b = listContact.get(i).getName().charAt(j);
                if (a == b) count++;
                if (a != b) break;

                if (a == b && count == SearhQuery.length()) {
                    count++;
                    listResult.add((Contact) key);
                    count = 0;

                    System.out.println("Результат поиска:");
                    if (listResult != null) {
                        System.out.print("№ " + i + " ");
                        System.out.print(listContact.get(i).getName());
                        System.out.print(" " + listContact.get(i).getSurname());
                        System.out.println(" " + listContact.get(i).getPhoneEmail());
                    }
                }
            }
            i++;
        }
        if (listResult.size() == 0) {
            contactNotFound = true;
            System.out.println("Контакт не найден");
        }
    }



    @Override
    public void searhPhoneEmail(String SearhQuery) {
        this.SearhQuery = SearhQuery;

        ArrayList<Contact> listResult = new ArrayList();
        int count = 0;
        int i = 0;


        System.out.print("Результат поиска:\n");
        for (Object key : listContact) {

            for (int j = 0; j < SearhQuery.length(); j++) {
                char a = SearhQuery.charAt(j);
                char b = listContact.get(i).getPhoneEmail().charAt(j);

                if (a == b) count++;
                if (a != b) break;

                if (a == b && count == SearhQuery.length()) {
                    count++;
                    listResult.add((Contact) key);
                    count = 0;


                    if (listResult != null) {

                        System.out.print("№ " + i + "  ");
                        System.out.print(listContact.get(i).getName());
                        System.out.print(" " + listContact.get(i).getSurname());
                        System.out.println(" " + listContact.get(i).getPhoneEmail());
                    }
                }
            }i++;
        }
        if (listResult.size() == 0) {
            System.out.println("Контакт не найден");
        }
    }



    @Override
    public void sortSurname() {
        System.out.println("---Cортировкa по фамилии---");
        Comparator<Contact> sortPhamilyComparator = Comparator.comparing(Contact::getSurname);
        Collections.sort(listContact, sortPhamilyComparator);

        int q = 0;
        for (Object obj : listContact) {
            System.out.print("\n" + listContact.get(q).getSurname());
            System.out.print(" " + listContact.get(q).getName());
            System.out.print(" " + listContact.get(q).getPhoneEmail());
            q++;
        }
    }



    @Override
    public void deleteContact(int NumberDeleteContact) {

            this.NumberDeleteContact = NumberDeleteContact;
            listContact.remove(listContact.get(NumberDeleteContact));
            System.out.println("Контакт удален");
            System.out.println("Количество контактов: " + listContact.size());

        }

    }