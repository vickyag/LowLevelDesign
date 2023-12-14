package entity;

public abstract class User {
    private long id;
    private String name;

    private static long count = 0;

    public User(String name) {
        this.id = ++count;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
