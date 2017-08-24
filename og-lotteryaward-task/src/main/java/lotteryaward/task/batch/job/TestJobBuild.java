package lotteryaward.task.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lotteryaward.task.batch.job.base.BaseJob;
import lotteryaward.task.batch.job.base.RunJob;
	
@Configuration
public class TestJobBuild extends BaseJob implements RunJob{
	
	@Autowired
	protected ItemReader<String> reader;
	
	@Autowired
	protected ItemProcessor<String,String> processor;
	
	@Autowired
	protected ItemWriter<String> writer;
	
	@Bean
	public Job testJob(){
		return jobBuilderFactory.get("testJob")
				.start(testStep())
				.build();
	}
	
	@Bean
	public Step testStep(){
		return stepBuilderFactory.get("testStep")
				.<String, String>chunk(10)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Override
	public void run()  throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(testJob(), jobParameters);		
	}
	

}