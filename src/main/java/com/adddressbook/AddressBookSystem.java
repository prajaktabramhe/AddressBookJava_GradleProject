package com.adddressbook;

import java.util.List;

public class AddressBookSystem
{
    public enum IOService{DB_IO}

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

    private Contact getEmployeePayrollData(String name) {
        return this.addressBookContactlist.stream().filter(employeePayrollDataItem -> employeePayrollDataItem.firstName.equals(name)).findFirst().orElse(null);
    }
}
