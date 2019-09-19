package Lesson_2;

public class MyArrayDataException extends Exception {
    private int indexX, indexY;

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public MyArrayDataException(String message, int indexX, int indexY) {
        super(message);
        this.indexX = indexX;
        this.indexY = indexY;
    }
}
