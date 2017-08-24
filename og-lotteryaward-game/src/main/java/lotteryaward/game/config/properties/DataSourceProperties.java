package lotteryaward.game.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceProperties {

}
