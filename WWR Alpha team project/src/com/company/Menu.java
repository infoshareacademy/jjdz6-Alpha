package com.company;

public class Menu {

    public static int menu() {
        System.out.println();
        System.out.println("                            MENU                     ");
        System.out.println("     *        Prosze wybrac odpowiedni numer:        *");
        System.out.println("     ************************************************");
        System.out.println("     1. Wybor placowki realizujacej WWR w ramach NFZ ");
        System.out.println("     2. Wybor placowki prywatnej realizujacej WWR    ");
        System.out.println("     3. Wybor specjalisty                            ");
        System.out.println("     4. Wybor miejscowoci                            ");
        System.out.println("     5. Rodzaj terapii                               ");
        System.out.println("     6. Powrót do głownego menu                      ");

        Scanner scanner1 = new Scanner(System.in);
        int x = scanner1.nextInt();  // x represents a chosen number from menu
        return x;
    }

    public static void main(String[] args) {
        int choiceOfNumberFromMenu = menu();

        switch (choiceOfNumberFromMenu) {
            case 1:
                choseNFZFacility();
                break;
            case 2:
                convertDecimalNumberToBinaryNumber();
                break;
            case 3:
                convertDecimalNumberToBinaryNumber();
                break;
            case 4:
                convertDecimalNumberToBinaryNumber();
                break;
            case 5:
                convertDecimalNumberToBinaryNumber();
                break;
            case 6:
                goBackFunction();
                break;
        }
    }
}
