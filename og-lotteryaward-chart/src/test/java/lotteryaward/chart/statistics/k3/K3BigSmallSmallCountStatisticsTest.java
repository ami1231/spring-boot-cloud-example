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

public class K3BigSmallSmallCountStatisticsTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("k3BigSmallSmallCountStatistics")
	private StatisticsComponent k3BigSmallSmallCountStatistics;
	
	private String key = K3ChartType.SmallCount.getKey();
	
	Integer[]	expectValues = new Integer[]{1,-10,-1, -5};
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("5,6,6");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[]{-12, -9, 1, -4};
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
	}

	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> result = k3BigSmallSmallCountStatistics.chartRecord(vo);
		Integer[]	values =  (Integer[]) result.get(key);
		Assert.assertArrayEquals(expectValues, values);
	}

}
