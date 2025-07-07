package OOD;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Directory extends Node {
    public List<Node> content;
    public long size;
    public Directory(Node parent, String permission, String name, Timestamp createTimestamp) {
        super(parent, permission, name, createTimestamp);
        content = new ArrayList<>();
    }
    
    @Override
    public long getSize(){
        long curSize = 0;
        for(Node n : content){
            curSize += n.getSize();
        }
        return curSize;
    }

    public void addNode(Node node){
        content.add(node);
        node.parent = this;
        this.size++;
    }

    public void deleteNode(Node node){
        content.remove(node);
        node.parent = null;
        this.size--;
    }

    public int countFiles(){
        int count = 0;
        for(Node n : content){
            if(n instanceof Directory){
                count += ((Directory)n).countFiles();
            }
            else{
                count ++;
            }
        }

        return count;
    }

    public List<Node> getContent(){
        return this.content;
    }
}
