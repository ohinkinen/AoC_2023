package day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoC_Day2 {
    static int cubeSetPower(String game) {
        int smallestRed = 0;
        int smallestBlue = 0;
        int smallestGreen = 0;
        String[] cubeSubsets = game.split(": ")[1].split("; ");

        Pattern redPattern = Pattern.compile("[0-9]+ red");
        Pattern bluePattern = Pattern.compile("[0-9]+ blue");
        Pattern greenPattern = Pattern.compile("[0-9]+ green");

        for (String subset: cubeSubsets
        ) {
            Matcher redMatcher = redPattern.matcher(subset);
            Matcher blueMatcher = bluePattern.matcher(subset);
            Matcher greenMatcher = greenPattern.matcher(subset);
            if (redMatcher.find()) {
                if (smallestRed < Integer.parseInt(redMatcher.group().replaceAll("[^0-9]", ""))) {
                    smallestRed = Integer.parseInt(redMatcher.group().replaceAll("[^0-9]", ""));
                }
            }
            if (blueMatcher.find()) {
                if (smallestBlue < Integer.parseInt(blueMatcher.group().replaceAll("[^0-9]", ""))) {
                    smallestBlue = Integer.parseInt(blueMatcher.group().replaceAll("[^0-9]", ""));
                }
            }
            if (greenMatcher.find()) {
                if (smallestGreen < Integer.parseInt(greenMatcher.group().replaceAll("[^0-9]", ""))) {
                    smallestGreen = Integer.parseInt(greenMatcher.group().replaceAll("[^0-9]", ""));
                }
            }
        }
        return (smallestRed * smallestBlue * smallestGreen);
    }
    static boolean isGamePossible(String game, int red, int blue, int green) {
        boolean isPossible = true;
        String[] cubeSubsets = game.split(": ")[1].split("; ");

        Pattern redPattern = Pattern.compile("[0-9]+ red");
        Pattern bluePattern = Pattern.compile("[0-9]+ blue");
        Pattern greenPattern = Pattern.compile("[0-9]+ green");

        for (String subset: cubeSubsets
             ) {
            Matcher redMatcher = redPattern.matcher(subset);
            Matcher blueMatcher = bluePattern.matcher(subset);
            Matcher greenMatcher = greenPattern.matcher(subset);
            if (redMatcher.find()) {
                if(red < Integer.parseInt(redMatcher.group().replaceAll("[^0-9]", ""))) {
                    isPossible = false;
                    break;
                }
            }
            if (blueMatcher.find()) {
                if(blue < Integer.parseInt(blueMatcher.group().replaceAll("[^0-9]", ""))) {
                    isPossible = false;
                    break;
                }
            }
            if (greenMatcher.find()) {
                if(green < Integer.parseInt(greenMatcher.group().replaceAll("[^0-9]", ""))) {
                    isPossible = false;
                    break;
                }
            }
        }
        return isPossible;
    }

    public static void main(String[] args) {
        int red = 12, blue = 14, green = 13;
        String line;
        int gameIndexSum = 0;
        int powerSum = 0;
        try {
            File gameDoc = new File("public/day2_input.txt");
            Scanner scanner = new Scanner(gameDoc);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if(isGamePossible(line,red,blue,green)) {
                    gameIndexSum += Integer.parseInt(line.split(" ")[1].split(":")[0]);
                }
                powerSum += cubeSetPower(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Answer to part 1: " + gameIndexSum);
        System.out.println("Answer to part 2: " + powerSum);
    }
}
