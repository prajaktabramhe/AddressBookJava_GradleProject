package com.adddressbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBSystem
{


    private static AddressBookDBSystem addressBookDBSystem;


    public static AddressBookDBSystem getInstance()
    {
        if(addressBookDBSystem == null)
            addressBookDBSystem = new AddressBookDBSystem();
        return addressBookDBSystem;
    }

    private Connection getConnection() throws SQLException
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "Admin@123";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }

    public List<Contact> readData()
    {
        String sql = "SELECT * FROM  address_book_service;";
        return this.getPersonDatafromDatabase(sql);
    }

    private List<Contact> getPersonDatafromDatabase(String query)
    {
        List<Contact> personList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            personList = this.getAddressbookContactData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private List<Contact> getAddressbookContactData(ResultSet resultSet)
    {
        List<Contact> addressBookContactArrayList = new ArrayList<>();
        try{
            while (resultSet.next()) {
                String firstName = resultSet.getString("Name");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                long mobileNo = resultSet.getLong("PhoneNumber");
                String email = resultSet.getString("email");
                addressBookContactArrayList.add(new Contact(firstName, lastName, address, city, state, email, mobileNo, zip));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return addressBookContactArrayList;
    }
}
