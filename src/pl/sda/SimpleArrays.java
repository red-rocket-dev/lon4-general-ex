package pl.sda;

import java.util.Arrays;

public class SimpleArrays {

    /**
     * 1. Stwórz metodę getDistinct, która przyjmuje w parametrze tablicę i zwraca inną tablicę (nie modyfikuje tamtej!) natomiast bez powtórzeń.
     * 2. Stwórz metodę getLarger(int tab1[], int tab2[]), która zsumuje osobno obie tablice i zwróci tą, która jest większa.
     */
    public static void main(String[] args) {
        System.out.println("1.");
        int[] ints = {1, 1, 2, 3, 4, 5, 5, 5, 6};
        int[] distinctNumbers = getDistinct(ints);
        System.out.println(Arrays.toString(distinctNumbers));
        System.out.println("2.");
        int[] arr1 = {10, 100, 1000};
        int[] arr2 = {5, 50, 500};
        System.out.println(Arrays.toString(getLarger(arr1, arr2)));
    }

    public static int[] getLarger(int[] tab1, int[] tab2) {
        int sumTab1 = 0;
        int sumTab2 = 0;
        for (int digit1 : tab1) {
            sumTab1 = sumTab1 + digit1;
        }
        for (int digit2 : tab2) {
            sumTab2 = sumTab2 + digit2;
        }
        //obojetnie czy 3 argumentowym czy normalnym ifem
        if (sumTab1 > sumTab2) {
            return tab1;
        } else {
            return tab2;
        }
        //return sumTab1 > sumTab2 ? tab1 : tab2;
    }

    public static int[] getDistinct(int[] array) {
        int[] arrayWithoutDuplicates = new int[array.length];
        int counter = 0;
        for (int element : array) {
            boolean newArrayContainsElement = doesArrayContain(arrayWithoutDuplicates, element);
            if (!newArrayContainsElement) {
                arrayWithoutDuplicates[counter] = element;
                counter++;
            }
        }
        if (counter != array.length) {
            int[] arrayOfProperSize = new int[counter];
            System.arraycopy(arrayWithoutDuplicates, 0, arrayOfProperSize, 0, counter);
            arrayWithoutDuplicates = arrayOfProperSize;
        }
        return arrayWithoutDuplicates;
    }

    private static boolean doesArrayContain(int[] array, int element) {
        boolean newArrayContainsElement = false;
        for (int elementFromArrayWithoutDuplicates : array) {
            if (element == elementFromArrayWithoutDuplicates) {
                newArrayContainsElement = true;
                break;
            }
        }
        return newArrayContainsElement;
    }

}
