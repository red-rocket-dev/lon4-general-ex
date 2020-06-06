package pl.sda;

public class DrawSomething {

    /**
     * 1. Narysuj prostokąt ze znaków *
     * 2. Zamiast rysować pełny prostokąt rysuj pusty w środku prostokąt (wypełniony spacjami)
     * 3. Daj użytkownikowi możliwość podania wymiarów prostokąta
     * 4. Przenieś kod do rysowania prostokąta do funkcji drawRectangle(int a, int b) - gdzie a i b to długości boków
     * 5. Stwórz dedykowaną metodę do rysowania kwadratu - powinna tylko wykorzystywać metodę drawRectangle
     * 6. Do sygnatury metody dodaj argument typu boolean isChessboardFill - sygnatura powinna wyglądać mniej więcej tak:
     * drawRectangle(int a, int b, boolean isChessboardFill)
     * jeśli isChessboardFill jest ustawione na true to wypełnij prostokąt szachownicą, jeśli nie samymi spacjami
     * 7. Narysuj trójkąt prostokątny wypełniony szachownicą i umieść kod do rysowania go w metodzie drawChessboardFillTriangle(int a, int h)
     * 8. Narysuj choinkę :)
     **/
    /**
     * Prostokąt 5 na 5:
     * *****
     * *****
     * *****
     * *****
     * *****
     * Pusty prostokąt 5 na 5:
     * *****
     * *   *
     * *   *
     * *   *
     * *****
     * Prostokąt wypełniony szachownicą (6 na 9):
     * *********
     * ** * * **
     * * * * * *
     * ** * * **
     * * * * * *
     * *********
     */
    public static void main(String[] args) {
        drawRectangleOwnImpl(20, 20, true);
        //drawSquare(5);
    }

    public static void drawSquare(int a) {
        drawRectangleOwnImpl(a, a, false);
    }

    public static void drawRectangle(int height, int width, boolean isChessBoardFill) {
        int filler = 0;
        for (int a = 0; a < width; a++) {
            System.out.print("*");
        }
        if (!isChessBoardFill) {
            System.out.println();
            for (int i = 0; i < height - 2; i++) {
                System.out.print("*");
                for (int x = 0; x < width - 2; x++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println();
            }
        } else {
            System.out.println();
            for (int i = 0; i < height - 2; i++) {
                System.out.print("*");
                for (int x = 0; x < width - 2; x++) {
                    if (filler % 2 == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                    filler++;
                }
                System.out.print("*");
                System.out.println();
            }
        }
        for (int a = 0; a < width; a++) {
            System.out.print("*");
        }
    }

    public static void drawRectangleOwnImpl(int a, int b, boolean isChessBoardFill) {
        for (int y = 0; y < a; y++) {
            for (int x = 0; x < b; x++) {
                boolean isOnBorder = x == 0 || x == b - 1 || y == 0 || y == a - 1;
                if (isOnBorder) {
                    System.out.print("*");
                } else {
                    if (isChessBoardFill) {
                        if ((x + y) % 2 == 0) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
