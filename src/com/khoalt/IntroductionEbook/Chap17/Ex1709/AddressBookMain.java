package com.khoalt.IntroductionEbook.Chap17.Ex1709;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add address");
            System.out.println("2. First address");
            System.out.println("3. Next address");
            System.out.println("4. Previous address");
            System.out.println("5. Last address");
            System.out.println("6. Update address");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = input.nextInt();
            input.nextLine();
//            switch (choice) {
//                case 1: {
//                    PhonebookMain.addAddress();
//                    break;
//                }
//                case 2: {
//                    PhonebookMain.getFirstAddress();
//                    break;
//                }
//                case 3: {
//                    PhonebookMain.getNextAddress();
//                    break;
//                }
//                case 4: {
//                    PhonebookMain.getPreviousAddress();
//                    break;
//                }
//                case 5: {
//                    PhonebookMain.getLastAddress();
//                }
//                case 6: {
//                    PhonebookMain.updateAddress();
//                }
//            }
        } while (choice != 0);
    }

    public static void addAddress() {
        try (RandomAccessFile inout = new RandomAccessFile("AddressBook.txt", "rw"))
        {
            Scanner input = new Scanner(System.in);
            String newName = input.nextLine();
            byte[] b = newName.getBytes();
            inout.write(b, (int) inout.length(), 32);

            String newStreet = input.nextLine();
            b = newStreet.getBytes();
            inout.write(b, (int) inout.length(), 32);

            String newCity = input.nextLine();
            b = newCity.getBytes();
            inout.write(b, (int) inout.length(), 20);

            String newState = input.nextLine();
            b = newState.getBytes();
            inout.write(b, (int) inout.length(), 2);

            int newZip = input.nextInt();
//            b = newZip.getBytes();
//            inout.write(newZip, (int) inout.length(), 5);
        } catch (IOException Ex) {
            System.out.println("Cannot add address");
        }
    }
}
