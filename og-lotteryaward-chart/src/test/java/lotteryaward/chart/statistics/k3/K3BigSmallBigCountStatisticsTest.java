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

public class K3BigSmallBigCountStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3BigSmallBigCountStatistics")
	private StatisticsComponent k3BigSmallBigCountStatistics;

	private String key = K3ChartType.BigCount.getKey();
	
	Integer[]	expectValues = new Integer[]{-5, -1, -10, 1};
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("4,4,6");
		ChartResult lastResult = new ChartResult();
		Integer[] values = new Integer[]{-4, 1, -9, -12};
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
	}

	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> map = k3BigSmallBigCountStatistics.chartRecord(vo);
		Integer[] values = (Integer[]) map.get(key);
		Assert.assertArrayEquals(expectValues, values);
		
	}
	
	
}
