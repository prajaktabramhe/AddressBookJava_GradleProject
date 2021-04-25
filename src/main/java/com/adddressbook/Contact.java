package com.adddressbook;

import java.time.LocalDate;
import java.util.Objects;

public class Contact
{
    int id;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String email;
    String mobileNo;
    int zip;
    LocalDate entryDate;


    public Contact( String firstName, String lastName, String address, String city, String state, String email, String mobileNo, int zip)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address= address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.mobileNo = mobileNo;
        this.zip = zip;

    }
    public Contact(String firstName, String lastName, String address, String city, String state, String email, String mobileNo, int zip, LocalDate entryDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address= address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.mobileNo = mobileNo;
        this.zip = zip;
        this.entryDate = entryDate;

    }
    public Contact(int id, String firstName, String lastName, String address, String city, String state, int zip, String mobileNo, String email, LocalDate entryDate)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address= address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.mobileNo = mobileNo;
        this.email = email;
        this.entryDate = entryDate;

    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getMobileNo()
    {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo)
    {
        this.mobileNo = mobileNo;
    }
    public int getZip()
    {
        return zip;
    }
    public void setZip(int zip)
    {
        this.zip = zip;
    }
    public LocalDate getEntryDate()
    {
        return entryDate;
    }
    public void setEntryDate(LocalDate entryDate)
    {
        this.entryDate = entryDate;
    }
    public String toString()

    {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Address="+address+", city=" + city
                + ", state=" + state + ", pincode=" + zip + ", MobileNo=" + mobileNo +  "]" + "\n";
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact person = (Contact) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(city, person.city) && Objects.equals(state, person.state) && Objects.equals(zip, person.zip) && Objects.equals(mobileNo, person.mobileNo) && Objects.equals(email, person.email) && Objects.equals(entryDate, person.entryDate);
    }
}
