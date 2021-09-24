package com.company;

public class HockeyPlayer {
    public static final int MAXAGE = 120;
    private String lastName;
    private int age;
    private int gamesNumber;
    private int numberOfMissedPucks;

    public int getGamesNumber() {
        return gamesNumber;
    }

    public void setGamesNumber(int gamesNumber) {
        if(gamesNumber >= 0) {
            this.gamesNumber = gamesNumber;
        }
        else{
            throw new Error("gamesNumber must be more than 0 or equals 0.");
        }
    }

    public int getNumberOfMissedPucks() {
        return numberOfMissedPucks;
    }

    public void setNumberOfMissedPucks(int numberOfMissedPucks) {
        if(numberOfMissedPucks >= 0) {
            this.numberOfMissedPucks = numberOfMissedPucks;
        }
        else{
            throw new Error("numberOfMissedPucks must be more than 0 or equals 0.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        if(lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        }
        else{
            throw new Error("lastName must not be empty.");
        }
    }

    @Override
    public String toString() {
        return "Хокеист:\n" +
                "Фамилия: " + lastName + "\n" +
                "Возраст: " + age + "\n" +
                "Количество игр: " + gamesNumber + "\n" +
                "Количество пропущенных шайб: " + numberOfMissedPucks;
    }

    public void setAge(int age) {
        if(age > 0 && age < MAXAGE) {
            this.age = age;
        }
        else{
            throw new Error("age must be more than 0 and less than 120.");
        }
    }
}
