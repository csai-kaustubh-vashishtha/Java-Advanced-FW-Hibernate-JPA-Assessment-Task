package com.capgemini.java_advance.framework_hibernate_jpa.main;





import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.capgemini.java_advance.framework_hibernate_jpa.dao.UserDAO;
import com.capgemini.java_advance.framework_hibernate_jpa.entity.Profile;
import com.capgemini.java_advance.framework_hibernate_jpa.entity.User;

public class MainApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        while(true) {

            System.out.println("\n===== User Profile Management =====");
            System.out.println("1 Add User");
            System.out.println("2 Search User");
            System.out.println("3 Update Email");
            System.out.println("4 Update Profile");
            System.out.println("5 Delete User");
            System.out.println("6 Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch(ch) {

            case 1:

                System.out.println("\n--- Add User ---");

                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();

                System.out.print("Enter DOB (yyyy-MM-dd): ");
                String dob = sc.nextLine();

                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);

                Profile p = new Profile(phone, gender, date);
                User u = new User(username, email, p);

                dao.addUser(u);

                break;

            case 2:

                System.out.println("\n--- Search User ---");

                System.out.print("Enter User ID: ");
                int id = sc.nextInt();

                dao.searchUser(id);

                break;

            case 3:

                System.out.println("\n--- Update Email ---");

                System.out.print("Enter User ID: ");
                int id1 = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Email: ");
                String newEmail = sc.nextLine();

                dao.updateEmail(id1,newEmail);

                break;

            case 4:

                System.out.println("\n--- Update Profile ---");

                System.out.print("Enter User ID: ");
                int uid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Phone: ");
                String ph = sc.nextLine();

                System.out.print("Enter Gender: ");
                String gen = sc.nextLine();

                System.out.print("Enter DOB (yyyy-MM-dd): ");
                String dob2 = sc.nextLine();

                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dob2);

                dao.updateProfile(uid,ph,gen,d);

                break;

            case 5:

                System.out.println("\n--- Delete User ---");

                System.out.print("Enter User ID: ");
                int did = sc.nextInt();

                dao.deleteUser(did);

                break;

            case 6:

                System.out.println("Exiting...");
                System.exit(0);
            }
        }
    }
}
