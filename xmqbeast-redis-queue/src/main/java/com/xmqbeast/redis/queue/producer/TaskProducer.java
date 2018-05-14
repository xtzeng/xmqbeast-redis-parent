package com.xmqbeast.redis.queue.producer;

  
import java.util.Random;  
import java.util.UUID;  
  
import redis.clients.jedis.Jedis;  
  
/** 
 * 模拟一个生产者 
 * <p>Title: TaskProducer</p> 
*/  
public class TaskProducer implements Runnable{  
	
    Jedis jedis = new Jedis("127.0.0.1",6379);  
      
    public void run() {  
        Random random = new Random();  
        while(true){  
            try{  
                Thread.sleep(random.nextInt(600) + 600);  
                // 模拟生成一个任务  
                UUID taskid = UUID.randomUUID();  
                //将任务插入任务队列：task-queue  
                /**
                 * 将值taskid.toString()插入到列表task-queue的表头。 
                 */
                
                for (int i = 0; i < 10; i++) {
                    jedis.lpush("task-queue", i+"");  
				}
                
               
//                jedis.lpush("task-queue", taskid.toString());  
                System.out.println("插入了一个新的任务： " + taskid); 
                
                break;
  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
        }  
          
    }  
  
}  
