package de.nikora.tasks.task2;

import java.util.Scanner;

public class Task {


    public static Scanner scanner;
    public static double i1, i2;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        boolean insertMode = true;

        while(insertMode) {
            System.out.println("Gib die Untergrenze i1 für das Intervall ein:");
            i1 = scanner.nextDouble();
            System.out.println("Gib die Obergrenze i2 für das Intervall ein:");
            i2 = scanner.nextDouble();
            if(i1 == i2) {
                System.out.println("Die Werte i1 und i2 dürfen nicht identisch sein!");
            } else {
                if(!((functionValue(i1) < 0 && functionValue(i2) > 0) || (functionValue(i1) > 0 && functionValue(i2) < 0))) {
                    System.out.println("Fehler in der Eingabe. Bitte gib 2 neue Werte ein.");
                } else {
                    insertMode = false;
                }
            }
        }
        iterateZeroPoint();
    }

    public static double functionValue(double i) {
        return i * Math.sin(i);
    }

    public static void iterateZeroPoint() {
        boolean iterate = true;
        double iLower = i1;
        double iUpper = i2;

        while (iterate) {
            double median = (iLower + iUpper) / 2;
            if(hasElevationChange(iLower, median)) {
                iUpper = median;
            }
            if(hasElevationChange(median, iUpper)) {
                iLower = median;
            }
            if(functionValue(median) < 0.05 && functionValue(median) > -0.05) {
                System.out.println("Die Nullstelle für den Anfangs-Intervall [" + i1 + " ; " + i2 + "] befindet sich im folgenden Intervall:" );
                System.out.println("Nullstellen-Intervall: [" + iLower + " ; " + iUpper + "]");
                System.out.println("Am Mittelwert des Nullstellen-Intervalls resultiert der Funktionswert " + functionValue(median));
                iterate = false;
            }
        }
    }

    public static boolean hasElevationChange(double d1, double d2) {
        if((functionValue(d1) < 0 && functionValue(d2) > 0) || functionValue(d1) > 0 && functionValue(d2) < 0) {
            return true;
        }
        return false;
    }

}
