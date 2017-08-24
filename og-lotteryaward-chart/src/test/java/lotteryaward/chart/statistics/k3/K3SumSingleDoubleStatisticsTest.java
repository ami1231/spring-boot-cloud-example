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

public class K3SumSingleDoubleStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3SumSingleDoubleStatistics")
	private StatisticsComponent k3SumSingleDoubleStatistics;
	
	private String key = K3ChartType.SumSingleDouble.getKey();
	
	Integer[]	expectValues = new Integer[]{-1,1};
	
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
		Map<String,Object> result = k3SumSingleDoubleStatistics.chartRecord(vo);
		Integer[]	values = (Integer[]) result.get(key);
		Assert.assertArrayEquals(expectValues, values);		
	}

}
