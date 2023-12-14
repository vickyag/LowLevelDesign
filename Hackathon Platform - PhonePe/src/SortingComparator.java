import java.util.Comparator;

class SortingComparator implements Comparator<Problem> {
    private String sortByAttribute;

    public SortingComparator(String sortByAttribute) {
        this.sortByAttribute = sortByAttribute;
    }

    @Override
    public int compare(Problem p1, Problem p2) {
        switch (sortByAttribute.toLowerCase()) {
            case "score":
                return Integer.compare(p1.getScore(), p2.getScore());
            default:
                return 0;
        }
    }
}