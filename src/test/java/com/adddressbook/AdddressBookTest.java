package com.adddressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class AdddressBookTest
{
    ArrayList<Contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetails_IsAdded_ShouldReturn_True()
    {
        Contact contact1 = new Contact
                (
                   "Prajakta",
                   "Bramhe" ,
                   "Ashtyavinayak colony",
                   "Nagpur" ,
                   "Maharashtra",
                   "prajakta@gmail.com",
                   8149240833L,
                   440034

               );

        Contact contact2 = new Contact
                (
                    "Payal",
                    "Raut" ,
                    "om colony",
                    "Pune" ,
                    "Maharashtra",
                    "payal@gmail.com",
                    8149240833L,
                    440034
               );

        Contact contact3 = new Contact
                (
                    "Ekta",
                    "Sharma" ,
                    "ram colony",
                    "bhopal" ,
                    "UP",
                    "ekta@gmail.com",
                    8149420833L,
                    448800
                );

        Contact contact4 = new Contact
                (
                    "Puja",
                    "Thakre" ,
                    "Gopal colony",
                    "Amravati" ,
                    "MP",
                    "Puja@gmail.com",
                    9149240833L,
                    778899
               );

        Contact contact5 = new Contact
                (
                    "Sneha",
                    "Shende" ,
                    "Ashtyavinayak colony",
                    "Akola" ,
                    "Telangana",
                    "sneha@gmail.com",
                    8149240844L,
                    885522
               );

        AdddressBookIO addressBook = new AdddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        contact.add(contact3);
        contact.add(contact4);
        contact.add(contact5);
        boolean isAdded = addressBook.addContact(contact);
        Assertions.assertTrue(isAdded);
    }


    @Test
    public void whenPersonContactsAddedToFile_ISRead_ShouldReturn_True() {
        Contact contact1 = new Contact
                (
                        "Prajakta",
                        "Bramhe",
                        "Ashtyavinayak colony",
                        "Nagpur",
                        "Maharashtra",
                        "prajakta@gmail.com",
                        8149240833L,
                        452365
                );

        Contact contact2 = new Contact
                (
                        "Payal",
                        "Raut",
                        "om colony",
                        "Pune",
                        "Maharashtra",
                        "payal@gmail.com",
                        8149240833L,
                        748563
                );

        Contact contact3 = new Contact
                (
                        "Ekta",
                        "Sharma",
                        "ram colony",
                        "bhopal",
                        "UP",
                        "ekta@gmail.com",
                        8149420833L,
                        635241

                );

        Contact contact4 = new Contact
                (
                        "Puja",
                        "Thakre",
                        "Gopal colony",
                        "Amravati",
                        "MP",
                        "Puja@gmail.com",
                        9149240833L,
                        887752
                );

        Contact contact5 = new Contact
                (
                        "Sneha",
                        "Shende",
                        "Ashtyavinayak colony",
                        "Akola",
                        "Telangana",
                        "sneha@gmail.com",
                        8149240844L,
                        663322

                );

        AdddressBookIO addressBook = new AdddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        contact.add(contact3);
        contact.add(contact4);
        contact.add(contact5);
        boolean isRead = addressBook.addContact(contact);
            Assertions.assertTrue(isRead);

    }
}
