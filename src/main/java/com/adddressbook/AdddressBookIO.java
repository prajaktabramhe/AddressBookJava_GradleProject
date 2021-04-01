package com.adddressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AdddressBookIO
{
    static AdddressBookIO addressbook = new AdddressBookIO();
    static Scanner scan = new Scanner(System.in);

    public  boolean addContact(ArrayList<Contact> contact)
    {
        try
        {
            if (addressbook.checkFile(contact))
            {
                System.out.println("\n contact is added in file");
            }
            return true;
        }
        catch (IOException e)
        {
            System.out.println("contact is not added in file");
        }
        return false;
    }
    public boolean checkFile(ArrayList<Contact> contact) throws IOException
    {
        String HOME = System.getProperty("user.dir");
        String fileName = "AddressBookIO.txt";
        Path homePath = Paths.get(HOME);
        if (Files.exists(homePath))
        {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try
            {
                if (Files.exists(filePath))
                {
                    if (WriteFileMain(new File(fileName), contact))
                    {
                        return true;
                    }
                }
                else
                    {
                    Files.createFile(filePath);
                    if (WriteFileMain(new File(fileName), contact))
                    {
                        return true;
                    }
                }
                return true;
            }
            catch (IOException e)
            {
                return false;
            }
        }
        return false;
    }

    public boolean WriteFileMain(File filename, ArrayList<Contact> contact)
    {
        try
        {
            FileWriter myWriter = new FileWriter(filename);
            for (Contact cont : contact)
            {
                myWriter.write(cont + "\n");
            }
            myWriter.close();
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Exception Occured");
            e.printStackTrace();
            return false;
        }
    }


}
