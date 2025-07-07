package OOD;

import java.sql.Timestamp;

public class FileSystem {
    public Node root;

    public FileSystem(){
        root = new Directory(null, "All", "root", new Timestamp(System.currentTimeMillis()));

    }

    public long getSize(){
        return ((Directory)root).getSize();
    }

    public int countFiles(){
        return ((Directory)root).countFiles();
    }

    // public void mkdir(String path){
    //     String[] pathName = path.split("/");
    //     Directory cur = (Directory) root;
    //     for(String name : pathName){
    //         for(Node n : cur.getContent()){
    //             if(n.)
    //         }
    //     }
    // }
}
