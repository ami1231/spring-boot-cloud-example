package lotteryaward.task.batch.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import lotteryaward.task.annotation.IReader;

@IReader
public class TestReader extends BaseReader<String> {

	int index  = 0;
	
	List<String> list = new ArrayList<String>();
	
	@BeforeStep
	public void beforeJob()
	{
		System.out.println(456);		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
	}
	
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		try{
			return list.get(index++);			
		}catch (IndexOutOfBoundsException e) {
			return null;			
		}
	}

}
