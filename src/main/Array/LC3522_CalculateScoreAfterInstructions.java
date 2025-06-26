package Array;

import java.util.HashSet;

public class LC3522_CalculateScoreAfterInstructions {
    public long calculateScore(String[] instructions, int[] values) {
        HashSet<Integer> visitedSet = new HashSet<>();
        long score = 0;

        int i = 0;
        while(i >= 0 && i < values.length){
            if(visitedSet.contains(i)){
                break;
            }

            visitedSet.add(i);
            if(instructions[i].equals("add")){
                score += values[i];
                i++;
            }
            else{
                i += values[i];
            }
        }

        return score;
        
        /*int i;
        String op = instructions[i];
        int score = values[i];
        long res;
        if(op == "jump"){//check visited
            // jump to idx : values[i]
            //go to instructions[[values[i]]]
            String curOp = instructions[[values[i]]];
            if(curOp == "add"){
                res += values[i];
                i = i + 1;
            }
        }
        */
    }
}
