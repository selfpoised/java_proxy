package thread;

import java.util.concurrent.CompletableFuture;

public class Sync {
    public static void main(String[] args) throws Exception{
        System.out.println(Thread.currentThread().getName() + ": in main");;

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + completableFuture.get());
                }catch (Exception e){
                    System.out.println(e.toString());
                }
            }
        };
        t.start();
        completableFuture.complete("Future's Result");

        Thread.sleep(1000);
    }
}