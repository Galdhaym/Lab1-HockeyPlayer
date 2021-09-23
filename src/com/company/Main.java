package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HockeyClub hockeyClub = new HockeyClub();
        HockeyPlayer hockeyPlayer;
        System.out.println("Введите количество хокеистов:");
        int length = scanner.nextInt();
        if(length > 0) {
            for (int i = 0; i < length; i++) {
                System.out.println("Хокеист №" + (i + 1) + ":");
                hockeyPlayer = new HockeyPlayer();
                System.out.print("Фамилия: ");
                hockeyPlayer.setLastName(scanner.next());
                System.out.print("Возраст: ");
                hockeyPlayer.setAge(scanner.nextInt());
                System.out.print("Число игр: ");
                hockeyPlayer.setGamesNumber(scanner.nextInt());
                System.out.print("Число пропущенных шайб: ");
                hockeyPlayer.setNumberOfMissedPucks(scanner.nextInt());
                hockeyClub.add(hockeyPlayer);
            }

            HockeyClub.printHockeyPlayerData(hockeyClub);
        }
        else{
            System.out.print("Кол-во хокеистов должно быть > 0");
        }


    }
}
