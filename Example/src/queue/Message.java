package queue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时消息实体
 * @author slimina
 *
 */
public class Message implements Delayed{
	public DelayQueue<Message> queue;
	private long id;  
    private String body;  //消息内容
    private long excuteTime;//执行时间    
    
    public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getExcuteTime() {
		return excuteTime;
	}

	public void setExcuteTime(long excuteTime) {
		this.excuteTime = excuteTime;
	}

	public Message(long id, String body,long delayTime) {  
        this.id = id;  
        this.body = body;  
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();  
        System.out.println(this.excuteTime);
    } 

	@Override
	public int compareTo(Delayed delayed) {
		Message msg = (Message)delayed;  
        return this.id>msg.id?1:( this.id<msg.id?-1:0);  
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return  unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);   
	}
}

