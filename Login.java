package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; // I use scanner because it's command line.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Login {
    public static File File_UserName = new File( "accounts.txt");
    public static  File File_LogIn = new File( "LogIn.txt");
    public static String UserName;
    public static String Email;
    public static String pass;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public void run() throws FileNotFoundException {
        Scanner scan = new Scanner (new File("LogIn.txt"));
        Scanner keyboard = new Scanner (System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan

        System.out.println("Enter Your Email");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter Your password");
        String inpPass = keyboard.nextLine(); // gets input from user
        /*try {
            BufferedReader br = new BufferedReader(new FileReader(File_LogIn));
            String current;
            boolean checkname = false;
            while ((current = br.readLine()) != null) {
                if(current.equalsIgnoreCase(inpUser)||current.equalsIgnoreCase(inpPass)){
                    checkname = true;
                }
            }
            if (checkname) {
                System.out.print(ANSI_BLUE+"Log In Successfully....."+ANSI_BLUE);
            } else {
                if(!isValidEmail(inpUser)){
                    System.out.print(ANSI_RED+"Please Enter Correct Email "+ANSI_RED);
                }
                else
                    System.out.print(ANSI_RED+"Your Name Or Your Password is Wrong "+ANSI_RED);


            }
        }
        catch (Exception e) {
        }*/
        if (inpUser.equals(user) && inpPass.equals(pass)) {
            System.out.print(ANSI_BLUE+"Log In Successfully....."+ANSI_BLUE);
        } else {
            if(!isValidEmail(inpUser)){
                System.out.print(ANSI_RED+"Please Enter Correct Email "+ANSI_RED);
            }
            else
            System.out.print(ANSI_RED+"Your Name Or Your Password is Wrong "+ANSI_RED);
        }
    }
    public void SignUp(){       Scanner input = new Scanner(System.in);
        System.out.println("Registration Page");
        System.out.println("NOTE: your Username Is a Unique One So It Cannot Be Changed.");
        System.out.printf("Enter your First Name : ");
        String First_Name = input.next();
        System.out.printf("Enter your Last Name : ");
        String Last_Name = input.next();
        UserName = First_Name+" "+Last_Name;
        System.out.println("E-mail");
        Email = input.next();
        System.out.printf("Password: ");
        pass = input.next();
        System.out.printf("Confirm Password: ");
        String conf = input.next();
        int length = pass.length();
        int passInt = Integer.parseInt(pass);
        int confInt = Integer.parseInt(conf);




        if (length < 6 ) {
            System.out.println(ANSI_RED+"Too short password, password must be 6 characters or more"+ANSI_RED);
        }
        else if ( !isValidEmail(Email)){
            System.out.println(ANSI_RED+"Please Enter Valid E-mail"+ANSI_RED);}
        else {
            if (passInt == confInt) {

                try {
                    BufferedReader br = new BufferedReader(new FileReader(File_UserName));
                    String current;
                    boolean checkname = false;
                    while ((current = br.readLine()) != null) {
                        if(current.equalsIgnoreCase(UserName)){
                            checkname = true;
                        }
                    }
                    if (checkname) {
                        System.out.println(ANSI_RED+"Username is Already Exists and Used, Please Type Another One"+ANSI_RED);
                    } else {
                        WriteToFile(UserName);
                        WritEmaileToFile(Email,pass);
                        // Formatter x = null;
                   /* try {
                        //File_LogIn
                        FileWriter file_Name = new FileWriter(File_UserName.getAbsoluteFile());
                        BufferedWriter File_Username = new BufferedWriter(file_Name);
                        File_Username.write(UserName);
                        File_Username.close();
                        x = new Formatter(file_Name);
                        x.format("%s %s%n", UserName.toUpperCase(), pass);
                        System.out.println("You Registered Succesfully");
                        x.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
                    }
                }
                catch (Exception e) {
                }
            } else {
                System.out.println("Password and Confirm Password are not Matching");
            }
        }
    }
    private static boolean isValidEmail(String email)
    {
        boolean ret = true;

        if(email==null || email.trim().length()==0)
        {
            ret = false;
        }else
        {
            int index = email.indexOf("@");
            if(index == -1)
            {
                ret = false;
            }
        }

        return ret;
    }
    public static void WriteToFile(String username){
        Formatter x = null;
        try {


            if (!File_UserName.exists()) {
                File_UserName.createNewFile();
            }

            FileWriter fw = new FileWriter(File_UserName.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(username+ "\r\n");
            bw.close();
            x = new Formatter(fw);
            x.format("%s %s%n", UserName.toUpperCase(), pass);
            System.out.println(ANSI_YELLOW+"You Registered Succesfully"+ANSI_YELLOW);
            x.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WritEmaileToFile(String username , String password){

        try {


            if (!File_LogIn.exists()) {
                File_LogIn.createNewFile();
            }

            FileWriter fw = new FileWriter(File_LogIn.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(username+ "\r\n");
            bw.write(password+ "\r\n");
            bw.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}