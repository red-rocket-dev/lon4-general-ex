package pl.sda;

import java.util.Arrays;

public class SimpleArrays {

    /**
     * 1. Stwórz metodę getDistinct, która przyjmuje w parametrze tablicę i zwraca inną tablicę (nie modyfikuje tamtej!) natomiast bez powtórzeń.
     * 2. Stwórz metodę getLarger(int tab1[], int tab2[]), która zsumuje osobno obie tablice i zwróci tą, która jest większa.
     */
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 4, 5, 5, 5, 6};
        int[] distinctNumbers = getDistinct(ints);
        System.out.println(Arrays.toString(distinctNumbers));
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
        if(counter != array.length) {
            int[] arrayOfProperSize = new int[counter];
            System.arraycopy(arrayWithoutDuplicates, 0, arrayOfProperSize, 0, counter);
            arrayWithoutDuplicates = arrayOfProperSize;
        }
        return arrayWithoutDuplicates;
    }

    private static boolean doesArrayContain(int[] array, int element) {
        boolean newArrayContainsElement = false;
        for(int elementFromArrayWithoutDuplicates : array) {
            if(element == elementFromArrayWithoutDuplicates) {
                newArrayContainsElement = true;
                break;
            }
        }
        return newArrayContainsElement;
    }

}
