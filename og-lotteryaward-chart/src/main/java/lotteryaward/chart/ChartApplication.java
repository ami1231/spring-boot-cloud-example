package lotteryaward.chart;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 
 * @author Ami
 *
 */
@SpringCloudApplication
@EnableRedisHttpSession
@EnableFeignClients
public class ChartApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ChartApplication.class, args);
	}
}