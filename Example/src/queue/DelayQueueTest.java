package queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

	public static void main(String[] args) throws Exception {
		System.out.println(TimeUnit.NANOSECONDS.convert(3000, TimeUnit.MILLISECONDS) + System.nanoTime());
		Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date2 = sdf.parse("2017-03-01 14:27:00"); 
        long time2 = date2.getTime();
        System.out.println(time-time2);
        

        Date date3 = sdf.parse("2017-03-01 14:28:00"); 
        long time3 = date3.getTime();
        

        Date date4 = sdf.parse("2017-03-01 14:29:00");
        long time4 = date4.getTime();
		DelayQueue<Message> queue = new DelayQueue<Message>();
		new Thread(new Consumer(queue)).start();
		Message m3 = new Message(time2, "hi", time2-time);
		Message m1 = new Message(time3, "world", time3-time);
		Message m2 = new Message(time4, "hello", time4-time);
		queue.offer(m2);
		queue.offer(m1);
		queue.offer(m3);
	}

}

