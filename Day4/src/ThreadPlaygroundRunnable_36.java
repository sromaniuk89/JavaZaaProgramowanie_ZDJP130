public class ThreadPlaygroundRunnable_36 implements Runnable {
    private String name;

    public ThreadPlaygroundRunnable_36(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+", "+name+", "+i);
            try{
                Thread.sleep(100); //usypiamy watek na 1 sekunde
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
