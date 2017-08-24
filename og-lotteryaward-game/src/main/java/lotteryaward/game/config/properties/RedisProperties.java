package lotteryaward.game.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author Ami
 *
 */
@Configuration
@PropertySource("classpath:redis.properties")
public class RedisProperties {
	
}
