package Lesson_2;

public class DayOfWeekMain {
    public static int getWorkingHours(DayOfWeek day) {
        int res = 40;

        res = res - day.ordinal() * 8;
        if (res < 0) res = 0;
        if (res == 0) System.out.println("Сегодня выходной день");

        return res;
    }


    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }
}
