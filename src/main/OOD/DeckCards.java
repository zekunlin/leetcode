package OOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckCards {
    ArrayList<Card> cards;
    static Random random = new Random();
    
    public DeckCards(){
        this.cards = new ArrayList<>();

        for(int i = 1; i <= 52; i++){
            for(Suit suit : Suit.values()){
                Card card = new Card(i, suit);
                this.cards.add(card);
            }
        }
    }

    public void shuffle(){
        for(int i = cards.size() - 1; i >= 0; i--){
            int j = random.nextInt(i); 
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public Card deal(){
        return cards.remove(cards.size() - 1);
    }

    public List<Card> deal(int num){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < num; i++){
            cards.add(deal());
        }
        return cards;
    }

}

