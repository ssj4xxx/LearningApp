package com.khoalt.IntroductionEbook.chap17.Ex1706;

class StudentExamScore implements java.io.Serializable {
    private int id;
    private String name;
    private double score;

    public StudentExamScore() {
    }

    public StudentExamScore(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
