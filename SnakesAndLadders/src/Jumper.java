public abstract class Jumper {
    private final int from;
    private final int to;

    public Jumper(int from, int to){
        this.from = from;
        this.to = to;
    }

    public int getFrom(){
        return from;
    }

    public int getTo() {
        return to;
    }
}
