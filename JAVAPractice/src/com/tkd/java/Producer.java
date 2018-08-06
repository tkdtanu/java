package com.tkd.java;

import java.util.concurrent.BlockingQueue;


class Message {
    private String msg;
    
    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

}

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;
    
    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}