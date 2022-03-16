package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruit;

    //Constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit=typeOfFruit;
        this.piecesOfFruit=startingPiecesOfFruit;
    }

    //Getters

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruit;
    }

    //pickFruit()

    public boolean pickFruit(int numberOfPiecesToRemove){
        if (piecesOfFruit>=numberOfPiecesToRemove){
            piecesOfFruit= piecesOfFruit-numberOfPiecesToRemove;
            return true;
        }
        else return false;
    }

}
