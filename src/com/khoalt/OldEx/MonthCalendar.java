package com.khoalt.OldEx;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class MonthCalendar {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap nam: ");
        int year = input.nextInt();
        System.out.print("Nhap thang (1-12): ");
        int month = input.nextInt();
        printMonth(year, month);
        input.nextLine();
    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        String monthName = new DateFormatSymbols().getMonths()[month -1];
        System.out.printf("%15s %-15d", monthName, year);
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
    }

    public static void printMonthBody(int year, int month) {
            int count = getStartDay(year, month);
            for (int i = 1; i <= getNumberOfDayInMonth(year, month); i++) {
                if (i == 1) {
                    int j = 0;
                    while (j < count % 7 - 1) {
                        System.out.print("    ");
                        j++;
                    }
                    System.out.printf("%4d", i);
                } else {
                    System.out.printf("%4d", i);
                }
                if (count % 7 == 0) {
                    System.out.println();
                }
                count++;
            }
    }

    public static int getStartDay(int year, int month) {
        int yearIndexOfCentury = year % 100;
        int indexOfCentury = year / 100;
        return (1 + 26 * (month + 1) / 10 + yearIndexOfCentury + yearIndexOfCentury / 4 + indexOfCentury / 4 + 5 * indexOfCentury) % 7;
    }

    public static int getNumberOfDayInMonth(int year, int month) {
        int temp = 0;
        switch (month) {
            case 1: temp = 31;
            break;
            case 2: if (!isLeapYear(year)) {
                    temp = 28;
                } else {
                    temp = 29;
                }
                break;
            case 3: temp = 31;
                break;
            case 4: temp = 30;
                break;
            case 5: temp = 31;
                break;
            case 6: temp = 30;
                break;
            case 7: temp = 31;
                break;
            case 8: temp = 31;
                break;
            case 9: temp = 30;
                break;
            case 10: temp = 31;
                break;
            case 11: temp = 30;
                break;
            case 12: temp = 31;
                break;
        }
        return temp;
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
