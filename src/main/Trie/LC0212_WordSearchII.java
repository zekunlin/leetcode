package Trie;
import java.util.*;

class WordSearchII {
    private final 
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0,1}, {0, -1}};
    int nrow;
    int ncol;
    public List<String> findWords(char[][] board, String[] words) {
        nrow = board.length;
        ncol = board[0].length;
        boolean[][] visited = new boolean[nrow][ncol];
        
        List<String> ret = new ArrayList<>();
        Trie trie = new Trie();
        TrieNode root = trie.root;

        for(String word : words){
            trie.insert(word);
        }

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(root.children[board[i][j]] != null){

                    dfs(i, j, board, ret, visited, root);
                }
            }
        }

        return ret;
    }

    public void dfs(int i, int j, char[][]board, List<String> res, boolean[][] visited, TrieNode root){
        if(i < 0 || i >= nrow || j < 0 || j >= ncol || visited[i][j] || root.children[board[i][j]] == null) return;
        visited[i][j] = true;
        char curChar = board[i][j];
        root = root.children[curChar];

        if(root.isWord){
            res.add(root.word);
            root.isWord = false;
        }

        for(int[] dir : dirs){
            int a = i + dir[0];
            int b = j + dir[1];
            dfs(a, b, board, res, visited, root);
        }
        visited[i][j] = false;
    }

    class TrieNode{
        int val;
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode(int val){
            this.val = val;
            this.children = new TrieNode[256];
            this.isWord = false;
            this.word = null;
        }
    }

    class Trie{
        TrieNode root;

        public Trie(){
            this.root = new TrieNode(-1);
        }

        public void insert(String word){
            TrieNode cur = root;
            char[] wordChars = word.toCharArray();
            
            for(char ch : wordChars){
                if(cur.children[ch] == null){
                    cur.children[ch] = new TrieNode(ch);
                }
                cur = cur.children[ch];
            }
            cur.isWord = true;
            cur.word = word;
        }

        public boolean contain(String word){
            TrieNode cur = root;
            char[] wordChars = word.toCharArray();

            for(char ch : wordChars){
                if(cur.children[ch] != null){
                    cur = cur.children[ch];
                }
                else{
                    return false;
                }
            }
            return cur.isWord;
        }
    }
    
}
