package Recursion;
import java.util.*;

class PhoneNumberLetterCombination{
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;

        Map<Character, Character[]> dialMap = this.buildDialMap();

        ArrayList<Character> inputChars = new ArrayList<>();

        for(int i = 0; i < digits.length();i++){
            inputChars.add(digits.charAt(i));
        }

        backtrack(inputChars, dialMap, ans, new StringBuilder(), 0);
        return ans;
    }

    public void backtrack(ArrayList<Character> inputChars, Map<Character, Character[]> dialMap, List<String> ret, StringBuilder sb, int idx){
        if(sb.length() == inputChars.size()){
            ret.add(sb.toString());
            return;
        }

        Character[] chars = dialMap.get(inputChars.get(idx));
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
            backtrack(inputChars, dialMap, ret, sb, idx+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 

    private Map<Character, Character[]> buildDialMap(){
        Map<Character, Character[]> dialMap = new HashMap<>();
        dialMap.put('2', new Character[]{'a', 'b', 'c'});
        dialMap.put('3', new Character[]{'d','e','f'});
        dialMap.put('4', new Character[]{'g','h','i'});
        dialMap.put('5', new Character[]{'j','k','l'});
        dialMap.put('6', new Character[]{'m','n','o'});
        dialMap.put('7', new Character[]{'p','q','r','s'});
        dialMap.put('8', new Character[]{'t','u','v'});
        dialMap.put('9', new Character[]{'w','x','y','z'});

        return dialMap;
    }
}