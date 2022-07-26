package com.khoalt.IntroductionEbook.chap12;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 2) {
            System.out.println(
                    "Syntax Error");
            System.exit(1);
        }

        // Check if file exists
        File textFile = new File(args[1]);
        if (!textFile.exists()) {
            System.out.println("Text file " + args[1] + " does not exist");
            System.exit(2);
        }

        try (
                // Create input and output files
                Scanner input = new Scanner(textFile);
        ) {
//            int count = 0;
//            while (input.hasNext()) {
//                String s1 = input.next();
//                if (s1.equals(args[0])) {
//                    count = count + 1;
//                }
//            }
//            System.out.println(count);
            String s3 = "";
            while (input.hasNext()) {
                String s1 = input.nextLine();
                System.out.println(s1);
                String s2 = s1.replaceAll(args[0], "");
                System.out.println(s2);
                s3 = s3 + s2;
            }
            //Check s3 truoc khi print
            System.out.println(s3);
            PrintWriter output = new PrintWriter(textFile);
            output.print(s3);
            output.flush();
            System.out.println(s3);
        }
    }
}
