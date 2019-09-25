package Lesson_3;

import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        System.out.println(checkPasswordSecure(password));
    }

    public static boolean checkPasswordSecure(String password) {
        boolean result = true;

        result = password.matches(".{8,}") && password.matches(".*\\d+.*") &&
                password.matches(".*[a-z]+.*") && password.matches(".*[A-Z]+.*") &&
                password.matches("^\\S*$");

//
//        // проверяем что пароль состоит из не менее 8ми символов:
//        result = password.matches(".{8,}");
//
//        // проверяем что пароль содержит не менее одной цифры:
//        if (result) {
//            result = password.matches(".*\\d+.*");
//        }
//
//        // проверяем что пароль содержит не менее одной строчной буквы:
//        if (result) {
//            result = password.matches(".*[a-z]+.*");
//        }
//
//        // проверяем что пароль содержит не менее одной заглавной буквы:
//        if (result) {
//            result = password.matches(".*[A-Z]+.*");
//        }
//
//        // проверяем что пароль не содержит пробелов:
//        if (result) {
//            result = password.matches("^\\S*$");
//        }

        return result;
    }
}
