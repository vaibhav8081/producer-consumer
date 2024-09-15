package com.example.Producer.Consumer;


import java.util.concurrent.BlockingQueue;

public class consumer implements Runnable{
    BlockingQueue<String> l;

    public consumer(BlockingQueue<String> l) {
        this.l = l;
    }

        public void run() {
            String s= null;
            try {
                System.out.println("Consumer are tring to get data ......");
              //  Thread.sleep(3000);
                while(!l.isEmpty()){
                    s = l.take();
                    System.out.println(s);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s);
        }

}
