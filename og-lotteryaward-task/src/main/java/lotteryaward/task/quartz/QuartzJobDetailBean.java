package lotteryaward.task.quartz;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lotteryaward.task.config.QuartzConfig;

public class QuartzJobDetailBean extends QuartzJobBean{
	
	private String targetObject;

	private String targetMethod;
	
	private final ApplicationContext applicationContext;
	
	public QuartzJobDetailBean(){
		this.applicationContext = QuartzConfig.applicationContext;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			Object otargetObject = applicationContext.getBean(targetObject);
			Method m = null;
			try {
				m = otargetObject.getClass().getMethod(targetMethod, new Class[] {});
				m.invoke(otargetObject, new Object[] {});
			} catch (SecurityException e) {

			} catch (NoSuchMethodException e) {

			}
		} catch (Exception e) {
			throw new JobExecutionException(e);
		}		
	}

	public String getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

}
