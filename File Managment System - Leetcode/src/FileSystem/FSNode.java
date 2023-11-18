package FileSystem;

import java.util.HashMap;
import java.util.Map;

public class FSNode {
    private String name;
    private NodeType type;
    private String content;
    private Map<String, FSNode> children;

    public FSNode(String pName, NodeType pType) {
        this.name = pName;
        this.type = pType;
        if(type == NodeType.Directory)
            children = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, FSNode> getChildren() {
        return children;
    }

    public void setChildren(Map<String, FSNode> children) {
        this.children = children;
    }
}
