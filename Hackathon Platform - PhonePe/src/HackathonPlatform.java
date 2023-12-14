import java.util.*;

class HackathonPlatform {
    private Map<Integer, Problem> problemLibrary;
    private Map<Integer, Contestant> contestants;

    private ScoringStrategy scoringStrategy;

    public HackathonPlatform(ScoringStrategy scoringStrategy) {
        this.problemLibrary = new HashMap<>();
        this.contestants = new HashMap<>();
        this.scoringStrategy = scoringStrategy;
    }

    public void setScoringStrategy(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    public void addProblem(String description, String tag, Difficulty difficulty, int score) {
        Problem problem = new Problem(description, tag, difficulty, score);
        problemLibrary.put(problem.getId(), problem);
    }

    public void addContestant(String name, String department) {
        Contestant contestant = new Contestant(name, department);
        contestants.put(contestant.getId(), contestant);
    }

    public List<Problem> fetchProblems(Map<String, Object> filterCriteria, String sortBy) {
        List<Problem> filteredProblems = new ArrayList<>(problemLibrary.values());

        ProblemFilter problemFilter = new ProblemFilter(filterCriteria);
        filteredProblems.removeIf(problem -> !problemFilter.matches(problem));

        if (sortBy.equals("score")) {
            filteredProblems.sort(new SortingComparator("score"));
        }

        return filteredProblems;
    }

    public void solve(int userId, int problemId) {
        Contestant contestant = contestants.get(userId);
        Problem problem = problemLibrary.get(problemId);
        problem.solve(contestant);
        contestant.getSolvedProblem().add(problem);
    }

    public Set<Problem> fetchSolvedProblems(int userId) {
        Contestant contestant = contestants.get(userId);
        return contestant.getSolvedProblem();
    }

    private int calculateScore(Contestant contestant) {
        return scoringStrategy.calculateScore(contestant);
    }

    public Contestant getLeader() {
        Contestant leader = null;
        int maxScore = 0;

        for (Contestant contestant : contestants.values()) {
            int score = calculateScore(contestant);
            if (score > maxScore) {
                maxScore = score;
                leader = contestant;
            }
        }

        return leader;
    }
}