package com.khoalt.bai1;

import java.util.Scanner;

public class IMEICheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap IMEI: ");
        String imei = input.nextLine();
        if (imei.length() == 18 && imei.charAt(2) == imei.charAt(9) && imei.charAt(9) == imei.charAt(16) && imei.charAt(9) == '-') {
            String imeiPart1, imeiPart2, imeiPart3, imeiPart4;
            imeiPart1 = imei.substring(0, 2);
            imeiPart2 = imei.substring(3, 9);
            imeiPart3 = imei.substring(10, 16);
            imeiPart4 = imei.substring(17, 18);
            if (isNumeric(imeiPart1) && isNumeric(imeiPart2) && isNumeric(imeiPart3) && isNumeric(imeiPart4)) {
                System.out.println(imei + " is a valid IMEI");
            } else {
                System.out.println(imei + " is not a valid IMEI");
            }
        } else {
            System.out.println(imei + " is not a valid IMEI");
        }
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
