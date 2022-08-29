package com.khoalt.TestKhoa;

public class WriteData {
    public static void main(String[] args) throws java.io.IOException {
        java.io.File file = new java.io.File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        // Create a ﬁle
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        // Write formatted output to the ﬁle
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);
        // Close the ﬁle
        output.close();
    }
}
