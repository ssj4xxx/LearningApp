package com.khoalt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Date> dates =
                new ArrayList<>();
        dates.add(new Date());
        Date date = dates.get(0);
    }
}
