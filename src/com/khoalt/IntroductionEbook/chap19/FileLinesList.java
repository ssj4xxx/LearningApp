package com.khoalt.IntroductionEbook.chap19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
* input: 1 file
* output: 1 collection chứa các dòng trong file
* */
public class FileLinesList extends ArrayList<String> {

    public FileLinesList(int initialCapacity) {
        super(initialCapacity);
    }

    public FileLinesList() {
        super();
    }

    public FileLinesList(Collection<? extends String> c) {
        super(c);
    }

    public FileLinesList(File file) throws FileNotFoundException {
        //implement
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            super.add(input.nextLine());
        }
    }

    public List<String> find(String line){
        return null;
    }

    public void writeToFile(){
        //write toan bo collection vao file
    }

}
