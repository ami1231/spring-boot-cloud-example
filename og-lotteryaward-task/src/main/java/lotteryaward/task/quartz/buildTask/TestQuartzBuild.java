package lotteryaward.task.quartz.buildTask;

import java.text.ParseException;

import org.quartz.JobDataMap;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import lotteryaward.task.quartz.QuartzJobDetailBean;

@Configuration
public class TestQuartzBuild {
	
	@Bean
	public JobDetailFactoryBean testJobDetailBean() throws ClassNotFoundException, NoSuchMethodException {
		JobDetailFactoryBean bean = new JobDetailFactoryBean();
		bean.setBeanName("testJobDetailBean");
		bean.setJobClass(QuartzJobDetailBean.class);
		bean.setDurability(true);
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("targetObject", "testJobBuild");
		jobDataMap.put("targetMethod", "run");		
		bean.setJobDataAsMap(jobDataMap);
		bean.afterPropertiesSet();
		return bean;
	}

	@Bean
	public Trigger testCronTriggerBean(JobDetailFactoryBean taskJobDetailBean) throws ParseException {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setBeanName("testCronTriggerBean");		
		trigger.setJobDetail(taskJobDetailBean.getObject());
		trigger.setCronExpression ("0/30 * * * * ?");	
		trigger.afterPropertiesSet();
		return trigger.getObject();
	}
	

}
