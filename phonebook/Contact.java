package hillel.phonebook;

import java.util.UUID;

public class Contact {

    private String surname;
    private String name;
    private String phoneEmail;
    private UUID id;
    private ContactType type;
    private String SearhQuery;
    private boolean contactNotFound;
    private int NumberDeleteContact;




    Contact(String name, String phamily, String phoneEmail, UUID id, ContactType type) {
        this.surname = phamily;
        this.name = name;
        this.phoneEmail = phoneEmail;
        this.id = id;
        this.type = type;

    }


    public String getPhoneEmail() {
        return phoneEmail;
    }

    public void setPhoneEmail(String phoneEmail) {
        this.phoneEmail = phoneEmail;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphoneEmail() {
        return phoneEmail;
    }

    public void setphoneEmail(String phone) {
        this.phoneEmail = phoneEmail;
    }



}



