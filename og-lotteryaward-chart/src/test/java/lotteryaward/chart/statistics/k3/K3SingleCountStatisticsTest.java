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

public class K3SingleCountStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3SingleCountStatistics")
	private StatisticsComponent k3SingleCountStatistics;
	
	private String key = K3ChartType.SingleCount.getKey();
	
	Integer[] expectIalues = new Integer[]{-6, -1, -2, 1};
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("3,5,5");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[]{-5, 1, -1, -6};
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
		
	}

	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> map = k3SingleCountStatistics.chartRecord(vo);
		Integer[] values = (Integer[]) map.get(key);
		Assert.assertArrayEquals(expectIalues, values);
	}

}
