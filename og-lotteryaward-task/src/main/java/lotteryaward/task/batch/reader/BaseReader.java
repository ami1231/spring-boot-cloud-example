package lotteryaward.task.batch.reader;

import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ItemReader;

public abstract class BaseReader<T> implements ItemReader<T>{

	protected int index = 0;

	@AfterStep
	public void afterJob(){
		index = 0;
	}
	
}
