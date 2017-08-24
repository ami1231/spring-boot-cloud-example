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

public class K3NumberSumStatisticsTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("k3NumberSumStatistics")
	private StatisticsComponent k3NumberSumStatistics;
	
	private String key = K3ChartType.NumberSum.getKey();
	
	Integer[] expectIalues = new Integer[]{-43, -43, -10, -30, -6, -37, -7, -12, -16, -1, -21, 1, -3, -43, -2, -43};
	@Override
	@Before
	public void readyVo() {
		vo.setAwardResult("4,5,5");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[]  {-42, -42, -9, -29, -5, -36, -6, -11, -15, 12, -20, -23, -2, -42, -1, -42};		
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
	}

	@Override
	@Test
	public void testStaistics() {
		Map<String,Object> map = k3NumberSumStatistics.chartRecord(vo);
		Integer[] values = (Integer[]) map.get(key);
		Assert.assertArrayEquals(expectIalues, values);
	}

}
