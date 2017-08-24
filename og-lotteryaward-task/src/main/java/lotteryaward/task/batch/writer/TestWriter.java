package lotteryaward.task.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import lotteryaward.task.annotation.IWriter;

@IWriter
public class TestWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println(items.size());
		items.forEach(s->{
			System.out.println(s);
		});
	}

}
