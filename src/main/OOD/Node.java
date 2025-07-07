package OOD;

import java.sql.Timestamp;
import java.util.Date;

abstract class Node {
    protected Node parent;
    protected String permission;
    protected String Name;
    protected final Date createTimestamp;
    protected Date lastModifiedAt;

    public Node(Node parent, String permission, String name, Timestamp createTimestamp){
        this.parent = parent;
        this.permission = permission;
        this.Name = name;
        this.createTimestamp = new Date();
    }

    public abstract <T> long getSize();

    public Date getCreated(){
        return createTimestamp;
    }

    public Date getModified(){
        return lastModifiedAt;
    }

    public Date setModified(){
        lastModifiedAt = new Date();
        return lastModifiedAt;
    }

    public String getPath(){
        if(parent == null) return "root";

        return parent.getPath() + "/" + this.Name;
    }
}
