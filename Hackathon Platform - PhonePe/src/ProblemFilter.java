import java.util.Map;

class ProblemFilter {
    private Map<String, Object> filterCriteria;

    public ProblemFilter(Map<String, Object> filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public boolean matches(Problem problem) {
        for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
            String field = entry.getKey();
            Object expectedValue = entry.getValue();

            switch (field.toLowerCase()) {
                case "difficulty":
                    if (expectedValue instanceof Difficulty) {
                        if (!problem.getDifficulty().equals(expectedValue)) {
                            return false;
                        }
                    }
                    break;
                case "tag":
                    if (expectedValue instanceof String) {
                        if (!problem.getTag().equals(expectedValue)) {
                            return false;
                        }
                    }
                    break;
                default:
                    return false;
            }
        }

        return true;
    }
}
