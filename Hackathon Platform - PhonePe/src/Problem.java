import java.util.HashSet;
import java.util.Set;

class Problem {

    private int id;
    private String description;
    private String tag;
    private Difficulty difficulty;
    private int score;
    private Set<Contestant> solvedBy;

    private static int count = 0;

    public Problem(String description, String tag, Difficulty difficulty, int score) {
        count++;
        this.id = count;
        this.description = description;
        this.tag = tag;
        this.difficulty = difficulty;
        this.score = score;
        this.solvedBy = new HashSet<>();
    }


    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public Set<Contestant> getSolvedBy() {
        return solvedBy;
    }

    public void solve(Contestant contestant) {
        solvedBy.add(contestant);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
