package Lesson_1.marathon.competitors;

public class Team {
    private Competitor[] competitors;

    public Team(Competitor... competitors) {
        this.competitors = new Competitor[competitors.length];
        for (int i = 0; i < competitors.length; i++) {
            this.competitors[i] = competitors[i];
        }
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showOnDistance() {
        for (Competitor c : competitors) {
            if (c.isOnDistance()) c.info();
        }
    }

    public void showResults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
