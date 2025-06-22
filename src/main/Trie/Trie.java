package Trie;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        char[] wordChars = word.toCharArray();
        TrieNode cur = root;
        
        for(char ch : wordChars){
            if(cur.children[ch] == null){             //if(!cur.children.containsKey(ch)){
                cur.children[ch] = new TrieNode(ch);  //     cur.children.put(ch, new TrieNode());
            }                                         //}
            cur = cur.children[ch];                   //     cur = cur.children.get(ch);
        }
        cur.isWord = true;                            //cur.children.put(endSymbol, null);
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        char[] wordChars = word.toCharArray();
        for(char ch : wordChars){
            if(cur.children[ch] == null){
                return false;
            }
            cur = cur.children[ch];
        }

        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] prefixArray = prefix.toCharArray();

        for(char ch: prefixArray){
            if(cur.children[ch] == null){
                return false;
            }
            cur = cur.children[ch];
        }

        return true;
    }
}

class TrieNode{
    public int val;
    public TrieNode[] children;
    public boolean isWord;
    //HashMap<Character, TrieNode[]> children;
    public TrieNode(int val){
        this.val = val;
        children = new TrieNode[256];
        isWord = false;
    }
}
