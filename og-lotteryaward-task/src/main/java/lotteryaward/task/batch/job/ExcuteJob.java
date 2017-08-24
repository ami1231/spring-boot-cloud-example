package lotteryaward.task.batch.job;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import lotteryaward.task.batch.job.base.RunJob;

//@Configuration
public class ExcuteJob implements CommandLineRunner{

	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	RunJob  taskJobBuild;
	
	@Override
	public void run(String... args) throws Exception {
		taskJobBuild.run();
	}

}