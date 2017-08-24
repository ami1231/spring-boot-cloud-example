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

public class K3SingleDoubleRatioStatisticsTest extends AbstractStatisticsTest{


	@Autowired
	@Qualifier("k3SingleDoubleRatioStatistics")
	private StatisticsComponent k3SingleDoubleRatioStatistics;

	private String key = K3ChartType.SingleDoubleRatio.getKey();

	Integer[] expectIalues = new Integer[] {-5, 1, -13, -4};

	@Override
	@Before
	public void readyVo() {
		vo.setAwardResult("2,5,5");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[] { -4, 1, -12, -3 };
		lastResult.put(key, values);       
		vo.setLastResult(lastResult);   
	}

	@Override
	@Test
	public void testStaistics() {
		Map<String, Object> map = k3SingleDoubleRatioStatistics.chartRecord(vo);
		Integer[] values = (Integer[]) map.get(key);
		Assert.assertArrayEquals(expectIalues, values);
	}
}
