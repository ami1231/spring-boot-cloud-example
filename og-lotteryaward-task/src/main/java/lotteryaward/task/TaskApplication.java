package lotteryaward.task;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class TaskApplication
{
    public static void main( String[] args )
    {
    	SpringApplication.run(TaskApplication.class, args);
    }
}