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

public class K3DoubleCountStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3DoubleCountStatistics")
	private StatisticsComponent k3DoubleCountStatistics;
	
	private String key = K3ChartType.DoubleCount.getKey();
	
	Integer[] expectIalues = new Integer[]{1, -3, -2, -7};
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("3,5,5");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[]{1, -2, -1, -6};
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
		
	}

	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> map = k3DoubleCountStatistics.chartRecord(vo);
		Integer[] values = (Integer[]) map.get(key);
		Assert.assertArrayEquals(expectIalues, values);
	}
	
}
