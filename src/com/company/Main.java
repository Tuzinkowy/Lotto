package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String playerNumber;
        Integer[] playerNumbers = new Integer[6];
        for (int i = 0; i < 5; i++) {
            playerNumbers[i] = 0;
        }

        Integer[] array = new Integer[49];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));
        Collections.shuffle(Arrays.asList(array));
        System.out.println(Arrays.toString(array));

        Integer[] lottoNumbers = lottoArray(array);


        System.out.println("Grasz w losowanie Lotto!");
        System.out.println("Podaj szesc liczb, od 1 do 49.");

        for (int i = 0; i < 6; i++) {
            playerNumber = scanner.nextLine();

            if ((!isNumeric(playerNumber)) && (playerNumber.equals(null))) {
                System.out.println("To nie jest lizcba.");
                --i;
            } else if (isRepeat(playerNumbers, playerNumber)) {
                System.out.println("Liczbe już podano. Podaj inna liczbe");
                --i;
            } else if (!isInScope(playerNumber)) {
                System.out.println("Liczba jest z po za puli. Podaj inna liczbe");
                --i;
            } else {
                playerNumbers[i] = Integer.parseInt(playerNumber);
                System.out.println("podaj kolejna liczbe");
            }
        }

        System.out.println("W lotto wylosowano nastepujace liczby:");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.println(lottoNumbers[i]);
        }

        System.out.println("Podales nastepujace liczby:");
        for (int i = 0; i < playerNumbers.length; i++) {
            System.out.println(playerNumbers[i]);
        }

        System.out.println("Zgadles " + numberOfMatches(lottoNumbers, playerNumbers) + " liczb.");

    }

    private static boolean isNumeric(String playerGuess) {
        try {
            Integer.parseInt(playerGuess);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isRepeat(Integer playerNumbers[], String playerNumber) {
        Integer.parseInt(playerNumber);
        for (int i = 0; i < 5; i++) {
            if (playerNumbers[i] == Integer.parseInt(playerNumber)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInScope(String playerNumber) {
        Integer number = Integer.parseInt(playerNumber);

        if ((number > 0) && (number < 50)) {
            return true;
        } else {
            return false;
        }
    }

    private static Integer[] lottoArray(Integer[] array) {
        Integer[] lotto = new Integer[6];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = array[i];
        }
        return lotto;
    }

    private static int numberOfMatches(Integer[] firstArray, Integer[] secondArray) {
        int matches = 0;
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i].equals(secondArray[j])) {
                    ++matches;
                }
            }
        }
        return matches;
    }


}
