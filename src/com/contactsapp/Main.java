/**
 * This is the main entry point for the program
 * It check whether the user is registered and does user authentication
 * Then user updates profile information, changes password or manages preferences
 *
 * @author vyapti gupta
 * @version 3.0
 */

package com.contactsapp;

import com.contactsapp.controller.UserController;
import com.contactsapp.model.User;
import com.contactsapp.model.UserType;
import com.contactsapp.service.Authenticator;
import com.contactsapp.service.BasicAuthenticator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userCtrl = UserController.getInstance();
        Authenticator auth = new BasicAuthenticator();
        Scanner sc = new Scanner(System.in);

        User sessionUser = null; 

        while (true) {
            if (sessionUser == null) {
                System.out.println("\n--- CONTACTS APP ---");
                System.out.println("1. Register\n2. Login\n3. Exit");
                System.out.print("Choice: ");
                String choice = sc.nextLine();

                if (choice.equals("1")) {
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Email: "); String e = sc.nextLine();
                    System.out.print("Pass: "); String p = sc.nextLine();
                    System.out.print("Phone: "); String ph = sc.nextLine();
                    System.out.println(userCtrl.register(n, e, p, ph, UserType.FREE));

                } else if (choice.equals("2")) {
                    // Login Logic (UC-02)
                    System.out.print("Email: "); String e = sc.nextLine();
                    System.out.print("Password: "); String p = sc.nextLine();
                    sessionUser = auth.authenticate(e, p); // Now updates the top-level variable
                    
                    if (sessionUser == null) System.out.println("Login Failed.");

                } else if (choice.equals("3")) break;

            } else {
                System.out.println("\n--- WELCOME " + sessionUser.getName() + " ---");
                System.out.println("1. Update Profile");
                System.out.println("2. Logout");
                System.out.print("Choice: ");
                String choice = sc.nextLine();

                if (choice.equals("1")) {
                    // UC-03 Logic
                    System.out.print("New Name: "); String nName = sc.nextLine();
                    System.out.print("New Phone: "); String nPhone = sc.nextLine();
                    System.out.println(userCtrl.updateProfile(sessionUser, nName, nPhone));
                } else if (choice.equals("2")) {
                    sessionUser = null; // Logout
                    System.out.println("Logged out.");
                }
            }
        }
        sc.close();
    }
}