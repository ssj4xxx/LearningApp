package com.khoalt.IntroductionEbook.chap20;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Ex2001 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1){
            System.out.println("Wrong syntax");
            System.exit(1);
        }

        File textFile = new File(args[0]);
        if (!textFile.exists()) {
            System.out.println("File does not exist");
            System.exit(2);
        }

        Scanner input = new Scanner(textFile);
        List<String> textList = new ArrayList<String>();
        while (input.hasNext()) {
            textList.add(input.next());
        }
        Collections.reverse(textList);

        try (PrintWriter output = new PrintWriter(textFile)) {
            for (int i = 0; i < textList.size(); i++) {
                output.print(textList.get(i));
                output.print(" ");
            }
        }
    }
}
