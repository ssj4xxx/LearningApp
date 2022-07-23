package com.khoalt.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static PhoneBook pb = new PhoneBook();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Them lien lac");
            System.out.println("2. Sua lien lac");
            System.out.println("3. Xoa lien lac");
            System.out.println("4. Tim kiem lien lac");
            System.out.println("5. Hien thi tat ca lien lac");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    Main.addContactScr();
                    break;
                }
                case 2: {
                    Main.modifyContactScr();
                    break;
                }
                case 3: {
                    Main.deleteContactScr();
                    break;
                }
                case 4: {
                    Main.findEntryScr();
                    break;
                }
                case 5: {
                    Main.showAllEntryScr();
                }
            }
        } while (choice != 0);
    }

    public static void addContactScr() {
        System.out.println("Nhap ten: ");
        String contactName = input.nextLine();
        System.out.println("Nhap so dien thoai: ");
        String phoneNumber = input.nextLine();
        PhoneEntry newEntry = new PhoneEntry(contactName, phoneNumber);
        if (pb.addEntry(newEntry)) {
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Them khong thanh cong");
        }
    }


    public static void modifyContactScr() {
        int choice;
        do {
            System.out.println("1. Sua theo ten");
            System.out.println("2. Sua theo so dien thoai");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    Main.modifyByNameScr();
                    break;
                }
                case 2: {
                    Main.modifyByNumberScr();
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void modifyByNameScr() {
        System.out.println("Nhap ten can sua: ");
        String oldName = input.nextLine();
        System.out.println("Nhap ten moi: ");
        String newName = input.nextLine();
        String result = pb.modifyEntryName(oldName, newName) ? "Sua thanh cong" : "Trung hoac khong ton tai";
        System.out.println(result);
    }

    public static void modifyByNumberScr() {
        System.out.println("Nhap so can sua: ");
        String oldNumber = input.nextLine();
        System.out.println("Nhap so moi: ");
        String newNumber = input.nextLine();
        String result = pb.modifyEntryNumber(oldNumber, newNumber) ? "Sua thanh cong" : "Trung hoac khong ton tai";
        System.out.println(result);
    }

    public static void deleteContactScr() {
        int choice;
        do {
            System.out.println("1. Xoa theo ten");
            System.out.println("2. Xoa theo so dien thoai");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    Main.deleteByNameScr();
                    break;
                }
                case 2: {
                    Main.deleteByNumberScr();
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void deleteByNameScr() {
        System.out.println("Nhap ten cua lien he muon xoa: ");
        String contacName = input.nextLine();
        String result = pb.deleteEntryByName(contacName) ? "Xoa thanh cong" : "Khong ton tai lien he";
        System.out.println(result);
    }

    public static void deleteByNumberScr() {
        System.out.println("Nhap so dien thoai muon xoa: ");
        String phoneNumber = input.nextLine();
        String result = pb.deleteEntryByNumber(phoneNumber) ? "Xoa thanh cong" : "Khong ton tai lien he";
        System.out.println(result);
    }

    public static void findEntryScr() {
        int choice;
        do {
            System.out.println("1. Tim theo ten");
            System.out.println("2. Tim theo so dien thoai");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    Main.findByNameScr();
                    break;
                }
                case 2: {
                    Main.findByNumberScr();
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void findByNameScr() {
        System.out.println("Nhap ten: ");
        String contactName = input.nextLine();
        PhoneEntry entry = pb.findEntryByName(contactName);
        if (entry != null) {
            System.out.println(entry);
        } else {
            System.out.println("Khong ton tai");
        }
    }

    public static void findByNumberScr() {
        System.out.println("Nhap so dien thoai: ");
        String phoneNumber = input.nextLine();
        PhoneEntry entry = pb.findEntryByNumber(phoneNumber);
        if (entry != null) {
            System.out.println(entry);
        } else {
            System.out.println("Khong ton tai");
        }
    }

    public static void showAllEntryScr() {
        System.out.println(pb);
    }
}
