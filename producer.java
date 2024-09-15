package com.example.Producer.Consumer;


import java.util.concurrent.BlockingQueue;



public class producer implements Runnable {
    BlockingQueue<String> l;

    public producer(BlockingQueue<String> l) {
        this.l = l;
    }

        public void run() {
            String data="data ->"+System.currentTimeMillis();
            try {
                System.out.println("producer producing data ......");
              //  Thread.sleep(3000);
                for(int i=0;i<10;i++) {
                    l.put(data);
                }

                System.out.println("data are pushed in to queue ......");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

}
