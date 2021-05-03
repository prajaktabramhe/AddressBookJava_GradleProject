package com.adddressbook;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookSystem
{
    public enum IOService {DB_IO,REST_IO,FILE_IO}


    private List<Contact> addressBookContactlist;
    private AddressBookDBSystem addressBookDBSystem;

    public AddressBookSystem()
    {
        addressBookDBSystem = addressBookDBSystem.getInstance();

    }

    public AddressBookSystem(List<Contact> addressBookContactList)
    {
        this();
        this.addressBookContactlist=addressBookContactList;
    }

    public List<Contact> readAddressBookData(IOService ioService){
        if(ioService.equals( IOService.DB_IO ))
            this.addressBookContactlist =  addressBookDBSystem.readData();
        return this.addressBookContactlist;
    }


    public void updateMobileNumber(String firstName, String mobileNo)
    {
        int result = addressBookDBSystem.updateMobileNumber(firstName,mobileNo);
        if (result == 0) return;
        Contact person = this.getAddressBookData(firstName);
        if (person != null) person.mobileNo = mobileNo;
    }

    private Contact getAddressBookData(String firstName)
    {
        return this.addressBookContactlist.stream()
                .filter(addressBookDataItem -> addressBookDataItem.firstName.equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public boolean checkAddressBookInSyncWithDB(String name) {
        List<Contact> addressBookDataList = addressBookDBSystem.getAddressbookContactData(name);
        return addressBookDataList.get(0).equals(getEmployeePayrollData(name));
    }

    private Contact getEmployeePayrollData(String name)
    {
        return this.addressBookContactlist.stream().filter(employeePayrollDataItem -> employeePayrollDataItem.firstName.equals(name)).findFirst().orElse(null);
    }
    public List<Contact> countPeopleFromGivenCity(IOService ioService, String city)
    {
        return addressBookDBSystem.countPeopleFromGivenCity(city);
    }

    public List<Contact> countPeopleFromGivenState(IOService ioService, String state)
    {
        return addressBookDBSystem.countPeopleFromGivenState(state);
    }

    public List<Contact> readAddressBookForDateRange(IOService ioService, LocalDate startDate, LocalDate endDate)
    {
        if(ioService.equals(IOService.DB_IO))
            return addressBookDBSystem.getAddressBookForDateRange(startDate, endDate);
        return null;
    }


    public void addEmployeeToAddressBook( int id, String firstName, String lastName, String address, String city, String state, int zip, String mobileNumber,  String email, LocalDate entryDate)
    {
        addressBookContactlist.add(addressBookDBSystem.addEntryToPayroll(id, firstName, lastName, address, city, state,zip, mobileNumber, email, entryDate));

    }
    public boolean checkNameInDatabase(int id)
    {
        boolean status = false;

        for (Contact person : addressBookContactlist)
        {
            System.out.println(person.getId());
            if (person.getId() == id)
            {
                status = true;
            }
        }
        return status;
    }
    public void addMultipleRecordsToAddressBook(List<Contact> List)
    {
        List.forEach(person -> {
            System.out.println("Person Being Added: " + person.getFirstName());
            this.addEmployeeToAddressBook(person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAddress(),
                    person.getCity(),
                    person.getState(),
                    person.getZip(),
                    person.getMobileNo(),
                    person.getEmail(),
                    person.getEntryDate());
            System.out.println("Person Added: " + person.getFirstName());
            //System.out.println(personList);
        });
    }


    public void addMultipleRecordsUsingThreadToAddressBook(List<Contact> List)
    {
        Map<Integer, Boolean> personAdditionStatus = new HashMap<>();
        List.forEach(person -> {
            Runnable task = () -> {
                personAdditionStatus.put(person.hashCode(), false);
                System.out.println("Person Being Added: " + Thread.currentThread().getName());
                this.addEmployeeToAddressBook(person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getAddress(),
                        person.getCity(),
                        person.getState(),
                        person.getZip(),
                        person.getMobileNo(),
                        person.getEmail(),
                        person.getEntryDate());
                personAdditionStatus.put(person.hashCode(), true);
                System.out.println("Person Added: " + Thread.currentThread().getName());
            };
            Thread thread = new Thread(task, person.firstName);
            thread.start();
        });
        while (personAdditionStatus.containsValue(false))
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {

            }
        }
    }
    public long countEntries(IOService ioService)
    {
        //if (ioService.equals(IOService.FILE_IO))
        //    return new AddressBookFileIOService().countEntries();
        return addressBookContactlist.size();
    }
}
