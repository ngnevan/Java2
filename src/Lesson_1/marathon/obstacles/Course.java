package Lesson_1.marathon.obstacles;

import Lesson_1.marathon.competitors.Competitor;
import Lesson_1.marathon.competitors.Team;

public class Course {
    Obstacle[] obstacles;
    public Course(Obstacle... obstacles) {
        this.obstacles = new Obstacle[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            this.obstacles[i] = obstacles[i];
        }
    }

    public void doIt(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o: this.obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }

}
