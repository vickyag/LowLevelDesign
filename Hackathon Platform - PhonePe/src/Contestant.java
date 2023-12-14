import java.util.HashSet;
import java.util.Set;

class Contestant {
    private int id;
    private String name;
    private String department;

    Set<Problem> solvedProblem;

    private static int count = 0;

    public Contestant(String name, String department) {
        count++;
        this.id = count;
        this.name = name;
        this.department = department;
        this.solvedProblem = new HashSet<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Set<Problem> getSolvedProblem() {
        return solvedProblem;
    }

    public void setSolvedProblem(Set<Problem> solvedProblem) {
        this.solvedProblem = solvedProblem;
    }
}