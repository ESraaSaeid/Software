package com.company;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        boolean flag =true;
        Login Log = new Login();
        System.out.println("What Do You Want ?\n 1-LogIn \n 2-Sign Up \n 3-Exsit ");
        while (flag){

        int choic = in.nextInt();
        if (choic==1){
            Log.run();
        }
       else if (choic==2){
           Log.SignUp();
       }
       else {
           flag=false;
       }

        }




}



}
