package String;

public class LC0443_StringCompression {

    //Time: O(N), Space: O(1)
    public int compress(char[] chars) {
        int len = chars.length;
        int i = 0;
        int j = 0;
        int writeIdx = 0;

        if(len == 1) return 1;

        while(j < len){
            
            while(j < len && chars[i] == chars[j]){
                j++;
            }
            int sameCharLen = j - i;
            chars[writeIdx++] = chars[i++];
                   
            if(sameCharLen != 1){
                for(char ch : Integer.toString(sameCharLen).toCharArray()){
                    chars[writeIdx++] = ch;
                }
            }

            i = j;
        }
        
        return writeIdx;
    }
}
