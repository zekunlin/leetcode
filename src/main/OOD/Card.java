package OOD;

public class Card {
    int value;
    Suit suit;
    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }
}
    
enum Suit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES
}
