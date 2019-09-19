package Lesson_2;

public class MyArrayMain {
    public static int myArraySum(String[][] strArr) throws MyArraySizeException, MyArrayDataException {
        int result = 0;
        int element = 0;

        checkArraySize(strArr);
        checkArrayData(strArr);

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                element = Integer.parseInt(strArr[i][j]);
                result += element;
            }
        }
        return result;
    }

    public static void checkArraySize(String[][] strArr) throws MyArraySizeException {
        if (strArr.length != 4 || strArr[0].length != 4)
            throw new MyArraySizeException("Размер массива должен быть равен 4", strArr.length, strArr[0].length);
    }

    public static void checkArrayData(String[][] strArr) throws MyArrayDataException {
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                try {
                    Integer.parseInt(strArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Массив должен содержать целые числа", i, j);
                }


            }
        }
    }

    public static void main(String[] args) {
        int sum = 0;
        String[][] stringArray = {{"11", "12", "13", "14"}, {"21", "22", "23", "24"}, {"31", "32", "33","34"},
                {"41", "42", "43", "44"}};
        try {
            sum = myArraySum(stringArray);
        } catch (MyArraySizeException e) {
            System.out.println("Размерности: X = " + e.getSizeX() + ", Y = " + e.getSizeY());
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в ячейке с X = " + e.getIndexX() + ", Y = " + e.getIndexY());
            e.printStackTrace();
        }
        System.out.println("Сумма элементов массива: " + sum);

    }
}
