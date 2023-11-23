public class Ladder extends Jumper{

    public Ladder(int from, int to) throws IllegalArgumentException {
        super(from, to);
        if(from > to) throw new IllegalArgumentException("Ladder end cannot be less that its start");
    }
}
