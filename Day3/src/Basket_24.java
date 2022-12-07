public class Basket_24 {
    private int i; //ta wartosc mowi ile mam elementow w koszyku

    public Basket_24() {
        i=0;
    }

    public void addToBasket(){
        if(i<10){
            i++;
        } else {
            throw new BasketFullException_24("Basket is full, i: "+i);
        }
    }

    public void removeFromBasket(){
        if(i>0){
            i--;
        } else {
            throw new BasketEmptyException_24("Basket is empty, i:"+i);
        }
    }

}
