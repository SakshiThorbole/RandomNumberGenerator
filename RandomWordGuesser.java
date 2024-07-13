package com.aurionpro.homework;

import java.util.Random;
import java.util.Scanner;

public class RandomWordGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the random word: ");
        int wordLength = scanner.nextInt();

        String randomWord = generateRandomWord(wordLength);
        char[] guessedWord = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            guessedWord[i] = '_';
        }

        int lives = 5; 
        boolean isWordGuessed = false;

        while (lives > 0 && !isWordGuessed) {
            System.out.print("Current word: ");
            System.out.println(guessedWord);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean isCorrectGuess = false;
            for (int i = 0; i < wordLength; i++) {
                if (randomWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    isCorrectGuess = true;
                }
            }

            if (!isCorrectGuess) {
                lives--;
                System.out.println("Incorrect guess. Lives remaining: " + lives);
                if (lives == 0) {
                    System.out.println("You've run out of lives. Game over!");
                    System.out.println("The correct word was: " + randomWord);
                } else {
                    System.out.print("Have you run out of lives? (yes/no): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        System.out.println("Game over!");
                        System.out.println("The correct word was: " + randomWord);
                        break;
                    }
                }
            } else {
                isWordGuessed = true;
                for (int i = 0; i < wordLength; i++) {
                    if (guessedWord[i] == '_') {
                        isWordGuessed = false;
                        break;
                    }
                }

                if (isWordGuessed) {
                    System.out.println("Congratulations! You've guessed the word: " + String.valueOf(guessedWord));
                } else {
                    System.out.print("Have you filled all the blanks? (yes/no): ");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        System.out.println("Congratulations! You've guessed the word: " + String.valueOf(guessedWord));
                        break;
                    }
                }
            }
        }

        scanner.close();
    }

    public static String generateRandomWord(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            word.append(characters.charAt(index));
        }

        return word.toString();
    }
}
