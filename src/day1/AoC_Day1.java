package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class AoC_Day1 {
    static String writtenNumsToDigits(String string) {
        ArrayList<String> numberList = getNumStrings(string);

        for (String numStr:numberList) {
            switch (numStr) {
                case "one":
                    string = string.replaceFirst("one", "1e");
                    break;

                case "two":
                    string = string.replaceFirst("two", "2o");
                    break;

                case "three":
                    string = string.replaceFirst("three", "3e");
                    break;

                case "four":
                    string = string.replaceFirst("four", "4");
                    break;

                case "five":
                    string = string.replaceFirst("five", "5e");
                    break;

                case "six":
                    string = string.replaceFirst("six", "6");
                    break;

                case "seven":
                    string = string.replaceFirst("seven", "7n");
                    break;

                case "eight":
                    string = string.replaceFirst("eight", "8t");
                    break;

                case "nine":
                    string = string.replaceFirst("nine", "9e");
                    break;
            }
        }
        return string;
    }

    private static ArrayList<String> getNumStrings(String string) {
        int start = 0;
        String substring;
        ArrayList<String> numberList = new ArrayList<>();
        for(int i = 3; i <= string.length(); i++) {
            substring = string.substring(start, i);
            if (substring.contains("one")) {
                numberList.add("one");
                start = i-1;
                i += 2;
            } else if (substring.contains("two")) {
                numberList.add("two");
                start = i-1;
                i += 2;
            } else if (substring.contains("three")) {
                numberList.add("three");
                start = i-1;
                i += 2;
            } else if (substring.contains("four")) {
                numberList.add("four");
                start = i-1;
                i += 2;
            } else if (substring.contains("five")) {
                numberList.add("five");
                start = i-1;
                i += 2;
            } else if (substring.contains("six")) {
                numberList.add("six");
                start = i-1;
                i += 2;
            } else if (substring.contains("seven")) {
                numberList.add("seven");
                start = i-1;
                i += 2;
            } else if (substring.contains("eight")) {
                numberList.add("eight");
                start = i-1;
                i += 2;
            } else if (substring.contains("nine")) {
                numberList.add("nine");
                start = i-1;
                i += 2;
            }
        }
        return numberList;
    }

    static int parseCalVal(String string) {
        String numbersOnly = string.replaceAll("[^0-9]", "");
        String calVal = String.valueOf(numbersOnly.charAt(0));
        calVal += numbersOnly.charAt(numbersOnly.length()-1);
        return Integer.parseInt(calVal);
    }

    public static void main(String[] args) {
        String line;
        int part1_calValSum = 0;
        int part2_calValSum = 0;

        try {
            File calDoc = new File("public/day1_input.txt");
            Scanner scanner = new Scanner(calDoc);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                part1_calValSum += parseCalVal(line);
                part2_calValSum += parseCalVal(writtenNumsToDigits(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Answer to part 1: " + part1_calValSum);
        System.out.println("Answer to part 2: " + part2_calValSum);
    }
}
