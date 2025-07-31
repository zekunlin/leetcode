package String;

public class LC0408_StringAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        //c.c
        int wordLen = word.length();
        int abbrLen = abbr.length();
        
        int idx1 = 0;
        int idx2 = 0;
        int num = 0;
        
        while(idx1 < wordLen && idx2 < abbrLen){
            char abbrChar = abbr.charAt(idx2);
            
            if(Character.isDigit(abbrChar)){
                if(abbrChar == '0' && num == 0){
                    return false;
                }
                else{
                    num = num * 10 + (abbr.charAt(idx2) - '0');
                }
            }
            else{
                idx1 += num;
                num = 0;
                if(idx1 >= wordLen || word.charAt(idx1) != abbrChar){
                    return false;
                }
                idx1++; 
            }
            idx2++;
        }

        return (idx1 + num) == wordLen && idx2 == abbrLen;
    }
}
