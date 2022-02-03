
package blackJack;

public class Card{

    public static void main(String[] args) {
        for (int i = 0; i < 52; i++){
            System.out.println(new Card(i));
        }
    }

 	private String name = "";
    private String suit = "";

    public Card(){
    }

    public Card(String name, String suit){
        this.name = name;
        this.suit = suit;
    }

    public Card(int num){
        if (num % 4 == 0){
            suit = "Diamonds";
        } else if (num % 4 == 1){
            suit = "Clubs";
        } else if (num % 4 == 2){
            suit = "Hearts";
        } else {
            suit = "Spades";
        }

        if (num % 13 == 0){
            name = "2";
        } else if (num % 13 == 1){
            name = "3";
        } else if (num % 13 == 2){
            name = "4";
        } else if (num % 13 == 3){
            name = "5";
        } else if (num % 13 == 4){
            name = "6";
        } else if (num % 13 == 5){
            name = "7";
        } else if (num % 13 == 6){
            name = "8";
        }  else if (num % 13 == 7){
            name = "9";
        } else if (num % 13 == 8){
            name = "10";
        } else if (num % 13 == 9){
            name = "Jack";
        } else if (num % 13 == 10){
            name = "Queen";
        } else if (num % 13 == 11) {
            name = "King";
        } else {
            name = "Ace";
        }
 
    }

    public String getName(){
        return name;
    }

    public String getSuit(){
        return suit;
    }

    public int getValue(){
        if (name.equals("2")){
            return 2;
        } else if (name.equals("3")){
            return 3;
        } else if (name.equals("4")){
            return 4;
        } else if (name.equals("5")){
            return 5;
        } else if (name.equals("6")){
            return 6;
        } else if (name.equals("7")){
            return 7;
        } else if (name.equals("8")){
            return 8;
        }  else if (name.equals("9")){
            return 9;
        } else if (name.equals("10")){
            return 10;
        } else if (name.equals("Jack")){
            return 10;
        } else if (name.equals("Queen")){
            return 10;
        } else if (name.equals("King")) {
            return 10;
        } else if (name.equals("Ace")){
            return 11;
        } else {
            return -1;
        }
    }

    public void setName(String n){
        name = n;
    }

    public void setSuit(String s){
        suit = s;
    }

    public String toString(){
        return getName() + " of " + getSuit();
    }
}
