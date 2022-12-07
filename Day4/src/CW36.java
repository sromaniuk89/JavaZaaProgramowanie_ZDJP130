public class CW36 {
    private static Thread thread1, thread2;

    public static void main(String[] args) {
        thread1 = new Thread(new ThreadPlaygroundRunnable_36("A"));
        thread2 = new Thread(new ThreadPlaygroundRunnable_36("B"));

        String message = new String();

        thread1.start();
        thread2.start();
    }
}
