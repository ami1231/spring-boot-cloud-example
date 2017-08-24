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

public class K3BigSmallRatioStatisticsTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("k3BigSmallRatioStatistics")
	private StatisticsComponent k3BigSmallRatioStatistics;

	private String key = K3ChartType.BigSmallRatio.getKey();

	Integer[] expectIalues = new Integer[] {1, -2, -1, -23};

	@Override
	@Before
	public void readyVo() {
		vo.setAwardResult("5,5,6");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[] { -3, -1, 1, -22 };
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
	}

	@Override
	@Test
	public void testStaistics() {
		Map<String, Object> map = k3BigSmallRatioStatistics.chartRecord(vo);
		Integer[] values = (Integer[]) map.get(key);
		Assert.assertArrayEquals(expectIalues, values);
	}
}
