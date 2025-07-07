package OOD;

import java.sql.Timestamp;

public class File extends Node{
    private String content;
    private long size;
    public File(Node parent, String permission, String name, Timestamp createTimestamp) {
        super(parent, permission, name, createTimestamp);

    }
    

    @Override
    public long getSize(){
        return this.size;
    }

    public boolean setContent(String content){
        if(content == "" || content.length() == 0) return false;
        
        this.size = content.length();
        this.content = content;
        return true;
    }
}
