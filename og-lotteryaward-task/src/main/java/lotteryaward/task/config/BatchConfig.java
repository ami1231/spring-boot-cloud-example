package lotteryaward.task.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class BatchConfig extends DefaultBatchConfigurer{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	protected JobRepository createJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTransactionManager(transactionManager);
		factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
		factory.afterPropertiesSet();
		return  factory.getObject();
	}
}
