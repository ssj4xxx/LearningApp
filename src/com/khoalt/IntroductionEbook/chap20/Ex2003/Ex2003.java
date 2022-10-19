package com.khoalt.IntroductionEbook.chap20.Ex2003;

import java.util.*;

public class Ex2003 {
    static CapitalCity[] cityArray = new CapitalCity[50];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        getData();
        List<CapitalCity> cityArrayList = new ArrayList<CapitalCity>(Arrays.asList(cityArray));
        Collections.shuffle(cityArrayList);
//        System.out.println(cityArrayList.toString());
        System.out.println("Game starts: Answer 5 questions");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println("What is the capital city of " + cityArrayList.get(i).getState() + ": ");
            if (!cityArrayList.get(i).getCity().equalsIgnoreCase(input.nextLine())) {
                System.out.println("The correct capital city of " + cityArrayList.get(i).getState() + " is "
                + cityArrayList.get(i).getCity());
            }
            System.out.println();
        }

    }

    public static void getData() {

        CapitalCity cityStatePair = new CapitalCity();

        String[][] d = {
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
                {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
                {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
                {"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"},
                {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
                {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
                {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
                {"Nevada	", "Carson City"}, {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
                {"New York", "Albany"}, {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"}, {"Texas", "Austin"},
                {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"}, {"Washington", "Olympia"},
                {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}};

        for (int i = 0; i < d.length; i++) {
            cityArray[i] = new CapitalCity(d[i][0], d[i][1]);
        }
    }
}
