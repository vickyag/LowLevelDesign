package FileSystem;

import java.util.*;

public class FileSystem {
    private FSNode root;

    public FileSystem() {
        root = new FSNode("root", NodeType.Directory);
    }

    private FSNode createNode(String path, NodeType type){
        String[] names = path.split("/");
        FSNode currNode = root;
        String pName;
        if(names.length == 0) return currNode;
        for(int i = 1; i < names.length - 1; i++){
            pName = names[i];
            if(!currNode.getChildren().containsKey(pName)){
                currNode.getChildren().put(pName, new FSNode(pName, NodeType.Directory));
            }
            currNode = currNode.getChildren().get(pName);
        }
        pName = names[names.length - 1];
        currNode.getChildren().put(pName, new FSNode(pName, type));
        return currNode.getChildren().get(pName);
    }

    private FSNode searchNode(String path){
        String[] names = path.split("/");
        FSNode currNode = root;
        String pName;
        if(names.length == 0) return currNode;
        for(int i = 1; i < names.length - 1; i++){
            pName = names[i];
            if(!currNode.getChildren().containsKey(pName)){
                return null;
            }
            currNode = currNode.getChildren().get(pName);
        }
        pName = names[names.length - 1];
        return currNode.getChildren().getOrDefault(pName, null);
    }
    public void mkdir(String path){
        createNode(path, NodeType.Directory);
    }

    public void addContentToFile(String path, String content){
        FSNode node = createNode(path, NodeType.File);
        node.setContent(content);
    }

    public String readContentFromFile(String path){
        FSNode node = searchNode(path);
        if(node == null || node.getType() == NodeType.Directory){
            return "File doesn't exist";
        }
        return node.getContent();
    }

    public String[] ls(String path){
        FSNode node = searchNode(path);
        if(node == null){
            return new String[]{};
        }
        Set<String> set = node.getChildren().keySet();
        String[] names = new String[set.size()];
        Iterator<String> itr = set.iterator();
        int i = 0;
        while(itr.hasNext()){
            names[i++] = itr.next();
        }
        return names;
    }
}
