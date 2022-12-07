import java.util.Locale;
import java.util.Random;

public class CW38 {
    private static Double water = 1.0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Random random = new Random();
        //wyrazenie lambda to jest tak naprawde instancja klasy, ktora implementuje konkretny interfejs
        //oczywiscie implementujac dana metode abstrakcyjna z tego interfejsu
        //w tym przypadku tym interfejsem jest Runnable
        Thread waterRefiller = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(random.nextInt(7000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    while(water>2.0){
                        System.out.println("There is too much water in the tank!");
                        try{
                            lock.wait();
                        } catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }

                    water += 1.0;
                    System.out.println("Water added: " + String.format(Locale.ENGLISH, "%.1f", water));
                    //informuje watek ktory zostal dodany do kolejki oczekujacych na powiadomienie,
                    lock.notify(); //notify wzbudzi JEDEN watek oczekujacy na obiekcie
                    //water.notifyAll(); //notifyAll() wzbudzi WSZYSTKIE watki oczekujace na danym obiekcie
                }
            }
        });

        Thread coffeeMaker1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock) {
                    while (water < 0.2) {//stosujemy zamiast if'a while'a, bo moga wystepowac falszywe/sztuczne wybudzenia
                        System.out.println("[Service 1] Water tank is empty!");
                        try{
                            lock.wait(); //wstrzymujemy watek na poczet obiektu water
                        } catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }

                    water -= 0.2;
                    if(water<=2.0)
                        lock.notify(); //???
                    System.out.println("[Service 1] Black coffee " + (i + 1) + " is ready! " + String.format(Locale.ENGLISH, "%.1f", water));
                }
            }
        });

        Thread coffeeMaker2 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock) {
                    while (water < 0.2) {
                        System.out.println("[Service 2] Water tank is empty!");
                        try{
                            lock.wait(); //wstrzymujemy watek na poczet obiektu water
                        } catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }

                    water -= 0.2;
                    if(water<=2.0)
                        lock.notify(); //???

                    System.out.println("[Service 2] Black coffee " + (i + 1) + " is ready! " + String.format(Locale.ENGLISH, "%.1f", water));
                }
            }
        });

        waterRefiller.start();
        coffeeMaker1.start();
        coffeeMaker2.start();

    }
}
