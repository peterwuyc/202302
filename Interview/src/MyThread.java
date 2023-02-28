public class MyThread implements Runnable{

    @Override
    public void run() {
        Thread.currentThread().setName("my thread");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
    }
}
