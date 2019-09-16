package Lesson_1.marathon;

import Lesson_1.marathon.competitors.*;
import Lesson_1.marathon.obstacles.*;
//import Lesson_1.marathon.competitors.Cat;
//import Lesson_1.marathon.competitors.Dog;
//import Lesson_1.marathon.competitors.Human;
//import Lesson_1.marathon.competitors.Team;
//import Lesson_1.marathon.obstacles.Cross;
//import Lesson_1.marathon.obstacles.Wall;
//import Lesson_1.marathon.obstacles.Water;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120)); // Создаем полосу препятствий
        Team team = new Team(new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults();

    }
}
