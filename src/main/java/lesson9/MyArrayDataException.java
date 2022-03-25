package lesson9;

public class MyArrayDataException extends Exception{

    public MyArrayDataException() {
        super(String.format("Ошибка преобразования в число!"));
    }
    public MyArrayDataException(int row, int column) {
        super(String.format("Ошибка преобразования элемента [%d, %d] в число!", row, column));
    }
}
