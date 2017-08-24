package lotteryaward.chart.statistics.xx5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartResult;

public class Xx5RoadBeadsSumBigSmallTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5RoadBeadsSumBigSmallStatistics")
	private StatisticsComponent statistics;

	private String key = Xx5ChartType.RoadBeadsSumBigSmall.getKey();

	List<Integer> expectValue = Arrays.asList(new Integer[] { -1, 1, 1,-1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, 1, 1 });

	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("4,5,6,7,11");
		ChartResult lastResult = new ChartResult();
		List<Integer> values = Arrays.asList(new Integer[] { -1, 1, 1, -1,-1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, 1 });
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
		// 期望值
	}

	@SuppressWarnings("unchecked")
	@Test
	@Override
	public void testStaistics() {
		Map<String, Object> map = statistics.chartRecord(vo);
		List<Integer> values = (List<Integer>) map.get(key);
		Assert.assertEquals(expectValue, values);
	}
}
