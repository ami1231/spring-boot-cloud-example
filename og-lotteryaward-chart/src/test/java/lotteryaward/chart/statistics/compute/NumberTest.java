package lotteryaward.chart.statistics.compute;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.BaseTest;
import lotteryaward.chart.statistics.compute.ChartCompute;

public class NumberTest extends BaseTest {

	@Autowired
	@Qualifier("numberCombinationCompute")
	private ChartCompute<Integer[],Integer> numberCombinationCompute;
	
	@Test
	public void test(){
		
		Integer [] array= {1,8,11};
		
		Integer a= numberCombinationCompute.compute(array);
		System.out.println(a);
		
	}

}
