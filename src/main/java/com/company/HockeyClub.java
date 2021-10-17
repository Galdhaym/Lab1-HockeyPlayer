package com.company;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HockeyClub {
    private ArrayList<HockeyPlayer> hockeyPlayers = new ArrayList<>();

    public HockeyClub(){

    }

    public void add(HockeyPlayer hockeyPlayer) {
        hockeyPlayers.add(hockeyPlayer);
    }

    public int size() {
        return hockeyPlayers.size();
    }

    public static void printHockeyPlayerData(HockeyClub club) {
        double averageAge = getHockeyPlayersAverageAge(club.hockeyPlayers);
        System.out.println("Средний возраст всех хокеистов = " + averageAge);

        int i = 0;
        for(HockeyPlayer hockeyPlayer: club.hockeyPlayers){
            int age = hockeyPlayer.getAge();
            if(age > 25) {
                System.out.println("Хокеист №" + (i + 1) + ":\n" + hockeyPlayer);
                i++;
            }
        }
    }

    public static double getHockeyPlayersAverageAge(ArrayList<HockeyPlayer> hockeyPlayers){
        int sum = 0;
        for(HockeyPlayer hockeyPlayer: hockeyPlayers){
            sum = sum + hockeyPlayer.getAge();
        }
        return (double) sum / hockeyPlayers.size();
    }
}
