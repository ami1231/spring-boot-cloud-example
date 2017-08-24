package lotteryaward.task.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import lotteryaward.task.annotation.IProcessor;

@IProcessor
public class TestProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		return item;
	}

}
