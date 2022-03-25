package lesson4;

import java.util.Random;
import java.util.Scanner;


public class TicTacToe {

    /* инициализация */
    public static int SIZE = 5;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';

    private static char[][] MAP;
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static final String SPACE_MAP = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    private static int turnsCount;

    private static Integer rowCurrent = 0;
    private static Integer colCurrent = 0;

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    /* печать */
    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    /* запуск игры */
    public static void turnGame() {
        getNumberOfElements();
        do {
            System.out.println("\n\nИГРА НАЧИНАЕТСЯ");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static void init() {
        turnsCount = 0;
        MAP = new char[SIZE][SIZE];

        initMap();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void getNumberOfElements() {
        while (true) {
            System.out.print("Введите размерность n игрового поля n*n: (3-10)");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (n > 2 && n < 11) {
                    SIZE = n;
                    break;
                } else {
                    System.out.println("\nВведите число в диапазоне от 3 до 10!");
                    in.next();
                }
            }
        }
    }

    private static void humanTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА");

        while (true) {
            rowCurrent = getValidNumberFromUser() - 1;
            colCurrent = getValidNumberFromUser() - 1;

            if (isCellFree()) {
                break;
            }
        }


        MAP[rowCurrent][colCurrent] = DOT_HUMAN;
        turnsCount++;
    }

    private static int getValidNumberFromUser() {
        while (true) {
            System.out.print("Введите координату(1-" + SIZE + "): ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                }
                System.out.println("\nПроверьте значение координаты. Должно быть от 1 до " + SIZE);
            } else {
                in.next();
                System.out.println("\nВвод допускает лишь целые числа");
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isCellFree() {
        return MAP[rowCurrent][colCurrent] == DOT_EMPTY;
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("\nУРАААААААААААААААА!! Вы победили!");
            } else {
                System.out.println("\nВосстание близко... ИИ победил...");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        /*for (char[] chars : MAP) {
            for (char symbol : chars) {
               if (symbol == DOT_EMPTY) {
                   return false;
               }
            }
        }
        return true;*/

        return turnsCount >= SIZE * SIZE;

    }

    private static boolean checkWin(char symbol) {

        // проверка строки
        if (checkWinByRow(symbol)) {
            return true;
        }

        // проверка столбца
        if (checkWinByColumn(symbol)) {
            return true;
        }

        // проверка диаг-лей паралл-х главной диагонали
        if (checkWinByDiagonalParallelMain(symbol)) {
            return true;
        }

        // проверка диаг-лей паралл-х побочной диагонали
        if (checkWinByDiagonalParallelSide(symbol)) {
            return true;
        }

        return false;
    }

    private static boolean checkWinByRow(char symbol) {
        boolean isSameSymbols = true;
        // проверка строки
        for (int i = 0; i < SIZE; i++) {
            if (MAP[rowCurrent][i] != symbol) {
                isSameSymbols = false;
                break;
            }
        }
        return isSameSymbols;
    }

    private static boolean checkWinByColumn(char symbol) {
        boolean isSameSymbols = true;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][colCurrent] != symbol) {
                isSameSymbols = false;
                break;
            }
        }
        return isSameSymbols;
    }

    private static boolean checkWinByDiagonalParallelMain(char symbol) {

        int col = colCurrent;
        int row = rowCurrent;
        int countOfFilledElements = 0;
        boolean isAboveMainDiagonal = true;
        isAboveMainDiagonal = (col - row > 0) ? true : false;

        //поиск коорд. верхнего эл-та диаг.
        if (isAboveMainDiagonal) {
            col -= row;
            row = 0;
        } else {
            row -= col;
            col = 0;
        }
        //если заполнены угловые элементы
        if (SIZE - Math.abs(col - row) == 1) {
            return false;
        }
        // проверка диаг-лей паралл-х главной диагонали
        boolean isSameSymbols = true;
        for (int i = 0; i < SIZE - Math.abs(col - row); i++) {
            countOfFilledElements++;
            if (MAP[i + row][i + col] != symbol) {
                isSameSymbols = false;
                break;
            }
        }
        return isSameSymbols && (countOfFilledElements > 1);
    }

    private static boolean checkWinByDiagonalParallelSide(char symbol) {
        //поиск коорд. верхнего эл-та диаг.
        boolean isSameSymbols = true;
        int col = colCurrent;
        int row = rowCurrent;
        int countOfFilledElements = 0;
        boolean isAboveSideDiagonal = (col + row < SIZE - 1) ? true : false;
        if (isAboveSideDiagonal) {
            while (row != 0) {
                col++;
                row--;
            }
        } else {
            while (col != SIZE - 1) {
                col++;
                row--;
            }
        }

        if (isAboveSideDiagonal) {
            for (int i = 0; i < col + 1; i++) {
                countOfFilledElements++;
                if (MAP[i][col - i] != symbol) {
                    isSameSymbols = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < col - row + 1; i++) {
                countOfFilledElements++;
                if (MAP[i + row][col - i] != symbol) {
                    isSameSymbols = false;
                    break;
                }
            }
        }
        return isSameSymbols && (countOfFilledElements > 1);
    }

    private static void aiTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА");
        do {
            rowCurrent = random.nextInt(SIZE); //0 - S -1;
            colCurrent = random.nextInt(SIZE);

        } while (!isCellFree());


        MAP[rowCurrent][colCurrent] = DOT_AI;
        turnsCount++;
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "+", "да", "конечно" -> true;
            default -> false;
        };
    }

    private static void endGame() {
        in.close();
        System.out.println("Ты заходи, если что");
    }
}
