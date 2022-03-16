package com.techelevator;

public class HomeworkAssignment {


    private String submitterName;

    private int possibleMarks;
    private int earnedMarks;

    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks=possibleMarks;
        this.submitterName=submitterName;
    }

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks=earnedMarks;
    }

    public String getLetterGrade() {
        double grade = ((double)getEarnedMarks()/(double)getPossibleMarks());
        if(grade>=.9){ return "A";}
        if(grade>=.8&&grade<.89){ return "B";}
        if(grade>=.7&&grade<.79){ return "C";}
        if(grade>=.6&&grade<.69){ return "D";}
        else{ return "F";}
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }
}
