package edu.madisoncollege.entjava;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3. <= another unit test
 * ))((((( also results in floor 3. <= another unit test
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application: you will use only unit tests to run your code.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {
    private final Logger logger = Logger.getLogger(this.getClass());

    public Integer determineFloorNumber(String instructions) {
        Integer floorNumber = 0;

        Integer index = 0;
        while (index < instructions.length()) {
            String currentCharacter = Character.toString(instructions.charAt(index));

            if (currentCharacter.equals("(")) {
                floorNumber++;
            } else if (currentCharacter.equals(")")) {
                floorNumber--;
            }

            index++;
        }

        logger.info("Floor number is: " + floorNumber);
        return floorNumber;
    }

    public String getInstructions() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("SantaUpDown.txt").getFile());

        String instructions = "";
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)){

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                instructions += line;
                logger.info("Read in line: " + line);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("File not found: " + fileNotFoundException);
        } catch (IOException ioException) {
            logger.error("There was a problem reading the file." + ioException);
        } catch (Exception exception) {
            logger.error("There was a major issue. " + exception);
        }

        return instructions;
    }
}





