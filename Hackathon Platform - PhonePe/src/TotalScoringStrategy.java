class TotalScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(Contestant contestant) {
        int totalScore = 0;
        for (Problem problem : contestant.getSolvedProblem()) {
                totalScore += problem.getScore();
        }
        return totalScore;
    }
}