package lotteryaward.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Aron
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ZuulApplication.class, args);
    }
    
  
}
