package hillel.phonebook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;
import static hillel.phonebook.ContactType.*;


public class Main  {

    public static void main(String[] args) throws InterruptedException {

        int menuChoice = 1;

        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> listContact = new ArrayList();
        PhoneBookService service = new PhoneBookService(listContact);


        // list contact generate//
        UUID id0 = UUID.randomUUID();
        listContact.add(new Contact("Nastya", "Varenikova", "0954567812", id0, PHONE));
        UUID id1 = UUID.randomUUID();
        listContact.add(new Contact("Denis", "Amelshenko", "0957331245", id1, PHONE));
        UUID id2 = UUID.randomUUID();
        listContact.add(new Contact("Anjela", "Zurka", "+380957776756", id2, PHONE));
        UUID id3 = UUID.randomUUID();
        listContact.add(new Contact("Taras", "Pushnoy", "tarass23@gmail.com", id3, EMAIL));
        UUID id4 = UUID.randomUUID();
        listContact.add(new Contact("Bogdan", "Rakimov", "bogdan89@gmail.com", id4, EMAIL));



        // Menu //
        Menu menu = new Menu();

        while (menuChoice > 0) {
            menuChoice = scanner.nextInt();

            if (menuChoice == 1) {
                System.out.println("Введите имя: ");
                String name = scanner.next();
                System.out.println("Введите фамилию: ");
                String surname = scanner.next();
                System.out.println("Введите номер телефона или email: ");
                String emailPhone = scanner.next();

                String regexEmail = ".*@.*";
                String regexPhone = ".*([0-9])";
                boolean MailFound = Pattern.matches(regexEmail, emailPhone);
                boolean regexPhoneFound = Pattern.matches(regexPhone, emailPhone);


                if (MailFound) {
                    UUID id = UUID.randomUUID();
                    listContact.add(new Contact(name, surname, emailPhone, id, EMAIL));
                    System.out.println("Контакт типа " + "\"EMAIL\"" + " добавлен" + "\n");

                } else if (regexPhoneFound) {
                    UUID id = UUID.randomUUID();
                    listContact.add(new Contact(name, surname, emailPhone, id, PHONE));
                    System.out.println("Контакт типа " + "\"PHONE\"" + " добавлен" + "\n");
                }


            } else if (menuChoice == 2) {
                service.sortSurname();
                menuChoice = scanner.nextInt();

            } else if (menuChoice == 3) {
                service.AllPhone();

            } else if (menuChoice == 4) {
                service.AllEmail();

            } else if (menuChoice == 5) {

                System.out.println("Введите имя (или его часть):");
                String searchName = scanner.next();
                service.searchName(searchName);


            } else if (menuChoice == 6) {
                System.out.println("Введите начальное значение: ");
                String searhPhoneEmail = scanner.next();
                service.searhPhoneEmail(searhPhoneEmail);

            } else if (menuChoice == 7) {

                System.out.println("Введите начальное значение: ");
                String searhPhoneEmailDel = scanner.next();
                service.searhPhoneEmail (searhPhoneEmailDel);

                if(searhPhoneEmailDel != null) {
                    System.out.println("Введите № контакта для удаления: ");
                    int NumberDeleteContact = scanner.nextInt();

                    if(NumberDeleteContact <= listContact.size() && service.getContactNotFound() == false) {
                        service.deleteContact(NumberDeleteContact);
                    } else System.out.println("Неправильный ввод");

                }
            }
        }scanner.close();
    }
}