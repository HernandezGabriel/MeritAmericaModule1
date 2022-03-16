package com.techelevator;

public class Television {

    boolean isOn;
    int currentChannel=3;
    int currentVolume=2;

    public void turnOff(){ isOn=false; }

    public void turnOn(){
        currentChannel=3;
        currentVolume=2;
        isOn=true;
    }

    public void changeChannel(int newChannel){
        if(isOn&&newChannel<=18&&newChannel>=3){
            currentChannel=newChannel;
        }
    }

    public void channelUp(){
        if(isOn){
            currentChannel++;
            if (currentChannel>18){
                currentChannel=3;
            }
        }
    }
    public void channelDown(){
        if(isOn){
            currentChannel--;
            if(currentChannel<3){
                currentChannel=18;
            }
        }
    }

    public void raiseVolume(){
        if(isOn){
            if((currentVolume+1)<=10){
                currentVolume++;
            }
        }
    }
    public void lowerVolume(){
        if(isOn){
            if(currentVolume-1>=0){
                currentVolume--;
            }
        }
    }






    //Getters

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}
