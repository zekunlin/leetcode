 //


// I spent $100.00 on Amazon this week." -> "I spent $85.00 on Amazon this week"
// "This candy costs $1.00" -> "This candy costs $0.85"
// "The weather is really great" -> "The weather is really great"

//I spent $100.00 on Amazon this week."
//        p1         *

///decrition descrease money value by given discount
// input / output/
import java.util.*;

public class MoneyNumber {

    public String decreaseMoneyValue(String input, double discount, List<Character> currency){
        if(input == null || input.length() <= 0) return input;
        if(discount < 0 || discount > 1) return input; // invalid argument exception
        Set<Character> currencySet = new HashSet();
        for(char character : currency){
            currencySet.add(character);
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = input.length();
        while(i < len){
            char c = input.charAt(i);
            if(currencySet.contains(c)){
                int j = i;
                while(j < len && (Character.isDigit(input.charAt(j)) || input.charAt(j) == '.')){
                    i++;
                }
                
                String money = input.substring(j, i);
                double prevPrice = Double.parseDouble(money);
                double curPrice = prevPrice * (1 - discount);
                
                String formatted = String.format("%.2f", curPrice);
                sb.append(formatted);
            }
            else{
                sb.append(c);
                i++;
            }
            
        }
        
        return sb.toString();
    }
    
}
