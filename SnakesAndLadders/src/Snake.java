public class Snake extends Jumper{
    public Snake(int from, int to) throws IllegalArgumentException {
        super(from, to);
        if(from < to) throw new IllegalArgumentException("Snake head cannot be less than its tail");
    }
}
