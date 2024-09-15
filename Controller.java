package com.example.Producer.Consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

@RestController
public class Controller {
     BlockingQueue<String> queue = new LinkedBlockingQueue<>();
     boolean isserviceStarted=false;
     ExecutorService ex;
   @GetMapping("/start")
    public String Start(){
        ex= Executors.newFixedThreadPool(2);
        for(int i=0;i<2;i++) {
            ex.execute(new producer(queue));
            ex.execute(new consumer(queue));
        }
        isserviceStarted=true;
       return "Services Started";
    }

   @GetMapping("/stop")
    public String stop(){
       if(!isserviceStarted==true){
           return "already closed";
       }
       if(ex!=null){
           ex.shutdown();
       }
       return "services stop";
   }
}
