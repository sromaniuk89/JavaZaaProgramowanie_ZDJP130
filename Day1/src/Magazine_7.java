public class Magazine_7 {
    private String[] tab; //magazynek realizujemy za pomoca tablicy
    private int i; //indeks elementu ktory zostanie wypisany

    public Magazine_7(int size) {
        this.tab = new String[size];
        this.i = -1;
    }

    public void loadBullet(String bullet){
        if(i<tab.length-1) { //sprawdzamy czy magazynek nie jest pelny
            tab[++i] = bullet;
        } else {
            System.out.println("Magazine is full");
        }
    }

    public boolean isLoaded(){
        if(i>=0){
            return true;
        } else {
            return false;
        }
    }

    public void shoot(){
        if(isLoaded()){
            System.out.println(tab[i--]); //wypisujemy wartosc oraz przygotowujemy nastepnego Stringa (i--)
        } else {
            System.out.println("Magazine is currently empty");
        }
    }
}
