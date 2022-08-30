package com.khoalt.IntroductionEbook.Chap12;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise1211 {
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
                PrintWriter output = new PrintWriter(textFile);
        ) {
            int count = 0;
            while (input.hasNext()) {
                String s1 = input.nextLine();
                if (s1.equals(args[0])) {
                    count = count + 1;
                }
            }
            System.out.println(count);
        }
    }
}
