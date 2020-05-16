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

    }
}
