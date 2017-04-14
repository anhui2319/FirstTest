package queueTest;

import java.util.concurrent.DelayQueue;

import queue.Consumer;
import queue.Message;

public class QueueMaker {
	public static DelayQueue<Message> queue;
	
	
	public static void init(){
		Consumer consumer=new Consumer(queue);
		new Thread(consumer).start();
	}
	public static DelayQueue<Message> getQueue() {
		return queue;
	}

	public static void setQueue(DelayQueue<Message> queue) {
		QueueMaker.queue = queue;
	}
	
	

}
