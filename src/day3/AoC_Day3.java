package day3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class AoC_Day3 {
    static int adjacentNumber(String line, int index) {
        int startingIndex = index;
        int endingIndex = index;
        while(Character.toString(line.charAt(startingIndex-1)).matches("[0-9]")) {
            if(startingIndex == 1) {
                startingIndex -= 1;
                break;
            }
            startingIndex -= 1;
        }
        while(Character.toString(line.charAt(endingIndex+1)).matches("[0-9]")) {
            if(endingIndex == line.length()-2) {
                endingIndex += 1;
                break;
            }
            endingIndex += 1;
        }
        endingIndex+=1;
        return Integer.parseInt(line.substring(startingIndex, endingIndex));
    }
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9.\s]");
        int j;
        int partSum = 0;
        int partNumber;
        ArrayList<Integer> partNumbers = new ArrayList<>();
        int gearRatio = 0;
        ArrayList<String> lines = new ArrayList<>();

        try {
            File gameDoc = new File("public/day3_input.txt");
            Scanner scanner = new Scanner(gameDoc);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 1; i < lines.size()-1; i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            while(matcher.find()) {
                partNumbers.clear();
                j = matcher.start();
                if (!(lines.get(i-1).charAt(j) == '.')) {
                    partNumber = adjacentNumber(lines.get(i-1), j);
                    partSum += partNumber;
                    if (lines.get(i).charAt(j) == '*') {
                        partNumbers.add(partNumber);
                    }
                } else {
                    if (!(lines.get(i-1).charAt(j-1) == '.')) {
                        partNumber = adjacentNumber(lines.get(i-1), j-1);
                        partSum += partNumber;
                        if (lines.get(i).charAt(j) == '*') {
                            partNumbers.add(partNumber);
                        }
                    }
                    if (!(lines.get(i-1).charAt(j+1) == '.')) {
                        partNumber = adjacentNumber(lines.get(i-1), j+1);
                        partSum += partNumber;
                        if (lines.get(i).charAt(j) == '*') {
                            partNumbers.add(partNumber);
                        }
                    }
                }
                if (!(lines.get(i).charAt(j-1) == '.')) {
                    partNumber = adjacentNumber(lines.get(i), j-1);
                    partSum += partNumber;
                    if (lines.get(i).charAt(j) == '*') {
                        partNumbers.add(partNumber);
                    }
                }
                if (!(lines.get(i).charAt(j+1) == '.')) {
                    partNumber = adjacentNumber(lines.get(i), j+1);
                    partSum += partNumber;
                    if (lines.get(i).charAt(j) == '*') {
                        partNumbers.add(partNumber);
                    }
                }
                if (!(lines.get(i+1).charAt(j) == '.')) {
                    partNumber = adjacentNumber(lines.get(i+1), j);
                    partSum += partNumber;
                    if (lines.get(i).charAt(j) == '*') {
                        partNumbers.add(partNumber);
                    }
                } else {
                    if (!(lines.get(i+1).charAt(j-1) == '.')) {
                        partNumber = adjacentNumber(lines.get(i+1), j-1);
                        partSum += partNumber;
                        if (lines.get(i).charAt(j) == '*') {
                            partNumbers.add(partNumber);
                        }
                    }
                    if (!(lines.get(i+1).charAt(j+1) == '.')) {
                        partNumber = adjacentNumber(lines.get(i+1), j+1);
                        partSum += partNumber;
                        if (lines.get(i).charAt(j) == '*') {
                            partNumbers.add(partNumber);
                        }
                    }
                }
                if (partNumbers.size() == 2) {
                    gearRatio += partNumbers.get(0) * partNumbers.get(1);
                }
            }
        }
        System.out.println("Answer to part 1: " + partSum);
        System.out.println("Answer to part 2: " + gearRatio);
    }
}
