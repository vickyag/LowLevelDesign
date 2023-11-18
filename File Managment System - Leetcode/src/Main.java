import FileSystem.FileSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String path = "/a/b";
        FileSystem fs = new FileSystem();
        fs.mkdir("/a/b/c");
        fs.mkdir("/a/c");
        System.out.println(Arrays.toString(fs.ls("/a/b")));
        fs.addContentToFile("a/b/d", "hello");
        System.out.println(fs.readContentFromFile("a/b/d"));
        fs.addContentToFile("a/b/d", "world");
        System.out.println(fs.readContentFromFile("a/b/d"));
    }
}