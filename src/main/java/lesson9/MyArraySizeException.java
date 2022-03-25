package lesson9;

public class MyArraySizeException extends Exception{
    public MyArraySizeException() {
        super("Ошибка выхода индекса массива за пределы!");
    }
}
