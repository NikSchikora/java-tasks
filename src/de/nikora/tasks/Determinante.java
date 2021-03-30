package de.nikora.tasks;

import java.util.Scanner;

public class Determinante {

    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        //Basic-Matrix (a, b)
        double [][] tmpMatrix = getMatrixData();
        System.out.println("Deine Eingabe ergibt folgende Matrix: \n");
        printMatrix(tmpMatrix);

        //Erweiterte Matrix (c)
        double[][] extendedMatrix = extendedMatrix(tmpMatrix);
        System.out.println("Die erweiterte Matrix für die Berechnung der Determinante: \n");
        printMatrix(extendedMatrix);

        //Letztendliche Berechnung der Determ. (d)
        calculateDeterminant(extendedMatrix(tmpMatrix));
    }


    //Abfragemethode für die Grundmatrix (a & b)
    public static double[][] getMatrixData() {
        double[][] matrix = new double [3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j< 3; j++) {
                char row = (char) (65+i);
                System.out.println("Eingabe für " + row + "" + (j+1));
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    //Methode um aus einer Matrix eine erweiterte Matrix für die Berechnung der Determinante zu erstellen.
    public static double[][] extendedMatrix(double [][] matrix) {
        double[][] newMatrix = new double[3][5];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                if(j < 3) {
                    newMatrix[i][j] = matrix[i][j];
                } else {
                    newMatrix[i][j] = matrix[i][j-3];
                }
            }
        }
        return newMatrix;
    }

    //Methode für die Berechnung der Determinante
    public static void calculateDeterminant(double[][] matrix) {
        /*
        * Temporärer Speicher für die Werte p1 p2 p3 und n1 n2 n3 ...
        * Das mit den Arrays / Variablen kann man bestimmt auch noch eleganter lösen ...
        */
        double[] pValues = new double[3];
        double[] nValues = new double[3];
        double pVal = 0;
        double nVal = 0;
        //Hier werden dann die Werte für Haupt- und Nebendiagonale berechnet
        for(int i = 0; i < 3; i++) {
            pValues[i] = matrix[0][i] * matrix[1][i+1] * matrix[2][i+2];
            nValues[i] = matrix[0][4-i] * matrix[1][4-(i+1)] * matrix[2][4-(i+2)];
        }
        for(int i = 0; i < 3; i++) {
            pVal += pValues[i];
            nVal += nValues[i];
        }

        double determinante = pVal - nVal;
        System.out.println("Berechnung der Determinante:");
        System.out.println(pVal + " - " + nVal + " = " + determinante);

    }

    //Debug-Methode um sich die Matritzen anzeigen zu lassen - damit man sich das besser vorstellen kann
    public static void printMatrix(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
