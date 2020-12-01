package ru.vsu.cs;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Picture picture = new Picture(new Circle(-7, -4, 2), new Circle(5, 0, 3),
                new Parabola(-1, 4, 0.5), new Parabola(4, 6, 1),
                new Rectangle(1, 4, 8, 9));
        if (startTest(picture)) {
            startProgram(picture);
        } else {
            System.out.println("The program is not working correctly.");
        }
    }

    private static double readValue(char name) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter coordinates %s : ", name);
        return scan.nextDouble();
    }

    private static void checkValue(double x, double y) {
        while ((x > 10 || x < -10) || (y > 10 || y < -10)) {
            System.out.println("Error! The value of x and y must be in the range form -10 to 10. Please try again");
            x = readValue('x');
            y = readValue('y');
        }
    }

    private static void startProgram(Picture picture) {
        double x = readValue('x');
        double y = readValue('y');
        checkValue(x, y);
        Point point = new Point(x, y);
        SimpleColor colors = picture.getColor(x, y);
        printResult(point, colors);
        System.out.println("\n Continue? Enter YES to continue or NO to  finish the program.");
        restart(readAnswer(), picture);
    }

    private static String readAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static boolean checkAnswer(String answer) {
        while (true) {
            if (answer.equalsIgnoreCase("YES")) {
                return true;
            } else if (answer.equalsIgnoreCase("NO")) {
                return false;
            } else {
                System.out.println("Please write YES/NO to continue/finish the program");
                answer = readAnswer();
            }
        }
    }

    private static void restart(String answer, Picture picture) {
        if (checkAnswer(answer)) {
            startProgram(picture);
        } else {
            System.out.println("Thank you for using program!");
        }
    }

    private static boolean startTest(Picture picture) {

        Point[] pointsArr = {new Point(-7, -3), new Point(5, 1), new Point(-1, 7),
                new Point(4, 8), new Point(1, 1), new Point(2.45, 10)};

        SimpleColor[] expectedColorsArr = {SimpleColor.GRAY, SimpleColor.WHITE, SimpleColor.WHITE,
                SimpleColor.BLUE, SimpleColor.GRAY, SimpleColor.YELLOW};

        boolean result = true;
        SimpleColor colors;
        SimpleColor correctColors;
        for (int i = 0; i < pointsArr.length; i++) {
            colors = picture.getColor(pointsArr[i].getX(), pointsArr[i].getY());
            correctColors = expectedColorsArr[i];

            if (colors == correctColors) {
                printTestResult(pointsArr[i], colors, correctColors, "Correct");
            } else {
                printTestResult(pointsArr[i], colors, correctColors, "Wrong");
                result = false;
            }
        }
        return result;
    }

    private static void printTestResult(Point point, SimpleColor colors, SimpleColor correctColors, String result) {
        System.out.printf("(%.1f; %.1f) -> %s. Expected result -> %s. %s.\n", point.getX(), point.getY(), colors,
                correctColors, result);
    }

    private static void printResult(Point point, SimpleColor colors) {
        System.out.printf("(%.1f; %.1f) -> %s.", point.getX(), point.getY(), colors);
    }
}
