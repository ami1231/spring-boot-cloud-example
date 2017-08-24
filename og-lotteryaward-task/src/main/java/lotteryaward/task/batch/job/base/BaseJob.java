package lotteryaward.task.batch.job.base;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

@EnableBatchProcessing
public abstract class BaseJob{

	@Autowired
	protected JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	protected StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	protected JobLauncher jobLauncher;

	
}
