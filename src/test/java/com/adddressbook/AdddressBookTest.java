package com.adddressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                   "8149240833",
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
                    "8149240833",
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
                    "8149420833",
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
                    "9149240833",
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
                    "8149240844",
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
                        "8149240833",
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
                        "8149240833",
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
                        "8149420833",
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
                        "9149240833",
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
                        "8149240844",
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

    @Test
    public void givenCSVFile_WhenRead_ShouldReturn_True() throws IOException
    {
        OpenCSVFile openCSVReader = new OpenCSVFile();
        Boolean result = openCSVReader.readCSV();
        Assertions.assertTrue(result);
    }


    @Test
    public void givenCSVFile_WhenWritten_ShouldReturn_True() throws IOException
    {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        List<String[]> contacts = new ArrayList<>();
        String[] contact1 =
                {
                "Prajakta",
                "Bramhe",
                "Ashtyavinayak colony",
                "Nagpur",
                "Maharashtra",
                "prajakta@gmail.com",
                "8149240733",
                "698574"
    };

        String[] contact2 = {
                "Arun",
                "Gawande",
                "Shakti nagar",
                "Bengluru",
                "Karnatak",
                "arun@gmail.com",
                "8149240873",
                "001144"
        };
        String[] contact3 = {
                "Ritesh",
                "Nirmalkar",
                "Shakti nagar",
                "Umred",
                "Maharashtra",
                "ritesh@gmail.com",
                "8149240873",
                "001144"
        };
        String[] contact4 = {
                "Rashmi",
                "kale",
                "Abhyankar nagar",
                "baitul",
                "MP",
                "ritesh@gmail.com",
                "8149240873",
                "001144"
        };

        String[] contact5 = {
                "Amol",
                "Zade",
                "Krishna nagar",
                "chennai",
                "TamilNadu",
                "amol@gmail.com",
                "8928397674",
                "050403"
        };

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        OpenCSVFile  openCSVReader = new OpenCSVFile();
        Boolean result = openCSVReader.writeCSV(contacts);
        Assertions.assertTrue(result);
    }


    @Test
    public void givenObject_WhenStoredInTheJson_ShouldReturn_TRUE()
    {
       Contact contactinfo = new Contact
               (
                     "Prajakta",
                    "Bramhe",
                    "Ashtyavinayak colony",
                    "Nagpur",
                    "Maharashtra",
                    "prajakta14bramhe@gmail.com",
                   "8149240833",
                    440034
               );

        JsonFile jsonfile = new JsonFile();
        boolean isAdded = jsonfile.jsonWriteData(contactinfo);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void givenJsonFile_WhenReadData_ShouldReturn_TRUE()
    {
        JsonFile jsonfile = new JsonFile();
        boolean isRead = jsonfile.jsonReadData();
        Assertions.assertTrue(isRead);
    }

    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount()
    {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Contact> addressBookContactList = addressBookSystem.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        Assertions.assertEquals(8,addressBookContactList.size());
    }

    @Test
    public void givenNewMobileNumberForEmployee_WhenUpdated_ShouldSyncWithDB()
    {
        AddressBookSystem addressBookService = new AddressBookSystem();
        List<Contact> personList = addressBookService.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        addressBookService.updateMobileNumber("Prajakta","7083261675");
        boolean result = addressBookService.checkAddressBookInSyncWithDB("Prajakta");
        Assertions.assertTrue(result);
    }
}
