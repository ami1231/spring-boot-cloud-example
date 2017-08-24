package lotteryaward.task.config;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import org.quartz.Trigger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig implements ApplicationContextAware{

	public static ApplicationContext applicationContext;
	
	@Autowired
	private List<Trigger> triggers;
	
	@Bean
	@Lazy
	public SchedulerFactoryBean schedulerFactory(DataSource dataSource) throws IOException {
		//讀取Quartz
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
		
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
		schedulerFactory.setDataSource(dataSource);
		schedulerFactory.setQuartzProperties(propertiesFactoryBean.getObject());
		schedulerFactory.setTriggers(triggers.toArray(new Trigger[0]));
		
		return schedulerFactory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		QuartzConfig.applicationContext = applicationContext;
	}
	
	
}