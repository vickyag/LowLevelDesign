import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HackathonPlatform platform = new HackathonPlatform(new TotalScoringStrategy());

        platform.addProblem("Problem 1", "TagA", Difficulty.EASY, 10);
        platform.addProblem("Problem 4", "TagA", Difficulty.EASY, 20);
        platform.addProblem("Problem 2", "TagB", Difficulty.MEDIUM, 20);
        platform.addProblem("Problem 3", "TagA", Difficulty.HARD, 40);

        platform.addContestant( "Alice", "DepartmentA");
        platform.addContestant("Bob", "DepartmentB");

        Map<String, Object> filterCriteria1 = new HashMap<>();
        filterCriteria1.put("difficulty", Difficulty.EASY);
        filterCriteria1.put("tag", "TagA");

        List<Problem> user1filteredProblems = platform.fetchProblems(filterCriteria1, "score");

        platform.solve(1, user1filteredProblems.get(0).getId());
        platform.solve(1, user1filteredProblems.get(1).getId());


        Map<String, Object> filterCriteria2 = new HashMap<>();
        filterCriteria2.put("difficulty", Difficulty.HARD);
        filterCriteria2.put("tag", "TagA");

        List<Problem> user2filteredProblems = platform.fetchProblems(filterCriteria2, "score");

        platform.solve(2, user2filteredProblems.get(0).getId());

        Set<Problem> solvedProblems = platform.fetchSolvedProblems(1);

        for (Problem solvedProblem : solvedProblems)
            System.out.println("Solved Problems for user1: " + solvedProblem.getDescription());

        System.out.println("Leader is: " + platform.getLeader().getName());

    }

}



