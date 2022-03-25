package lesson9;

public class Main {

    public static final int COLUMN = 4;
    public static final int ROW = 4;

    public static void main(String[] args) {

        String[][] stringArray1 = {{"6", "5", "5", "5"},
                {"7", "x", "5", "1"},
                {"3", "-4", "-2", "0"},
                {"1", "4", "1", "1"}};
        String[][] stringArray2 = {{"-1", "9", "25", "55"},
                {"15", "4", "25", "55"}};

        try {
            System.out.println("Сумма = " + sumOfElements(stringArray1));
        } catch (MyArraySizeException e){
            e.printStackTrace();
            System.out.println("Сумму не удалось вычислить, т.к. размер массива не 4X4!");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Сумму не удалось вычислить, т.к. не все элементы массива содержат числовые данные!");
        }

        try {
            System.out.println("Сумма = " + sumOfElements(stringArray2));
        } catch (MyArraySizeException e){
            e.printStackTrace();
            System.out.println("Сумму не удалось вычислить, т.к. размер массива не 4X4!");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Сумму не удалось вычислить, т.к. не все элементы массива содержат числовые данные!");
        }

    }

    public static int sumOfElements(String[][] strArray) throws MyArraySizeException, MyArrayDataException {

        if (strArray.length != ROW || strArray[0].length != COLUMN) {
            throw new MyArraySizeException();
        }

        int s = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                int number;
                    if (!isNumeric(strArray[i][j])) {
                        throw new MyArrayDataException(i, j);
                    }
                    number = Integer.parseInt(String.valueOf(strArray[i][j]));
                s += number;
            }
        }
        return s;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
