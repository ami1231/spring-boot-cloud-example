package lotteryaward.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lotteryaward.zuul.filter.AccessFilter;

@Configuration
public class AccessFilterConfig {
	
	
	  /**
     * 過濾器
     */
    @Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

}
