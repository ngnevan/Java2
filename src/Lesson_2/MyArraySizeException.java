package Lesson_2;

public class MyArraySizeException extends Exception {
    private int sizeX, sizeY;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public MyArraySizeException(String message, int sizeX, int sizeY) {
        super(message);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
}
