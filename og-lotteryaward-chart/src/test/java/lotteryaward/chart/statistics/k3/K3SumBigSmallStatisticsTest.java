package lotteryaward.chart.statistics.k3;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartResult;

public class K3SumBigSmallStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3SumBigSmallStatistics")
	private StatisticsComponent k3SumBigSmallStatistics;
	
	private String key = K3ChartType.SumBigSmall.getKey();
	
	Integer[]	expectValues = new Integer[]{1,-3};
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("5,5,6");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[]{1, -2};
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
	}

	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> result = k3SumBigSmallStatistics.chartRecord(vo);
		Integer[]	values = (Integer[]) result.get(key);
		Assert.assertArrayEquals(expectValues, values);		
	}

	
}
