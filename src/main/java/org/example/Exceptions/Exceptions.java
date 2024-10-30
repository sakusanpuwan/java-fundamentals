package org.example.Exceptions;

public class Exceptions {
    public static void specificException() {
        try {
            int[] numbers = {1, 2, 3};

            int result = numbers[4]; // Trying to access an out-of-bounds index

            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void customException() {
        try {
          inputChecker("");
        } catch (CustomException e){
            System.out.println("Custom exception thrown: " + e.getMessage());
        }
    }

    private static void inputChecker(String input) throws CustomException {
        if (input == null || input.isEmpty()) {
            throw new CustomException("Input is null or empty");
        }
    }
}
