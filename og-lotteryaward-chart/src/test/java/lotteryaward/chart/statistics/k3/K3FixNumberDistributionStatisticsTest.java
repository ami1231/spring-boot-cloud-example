package lotteryaward.chart.statistics.k3;

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

public class K3FixNumberDistributionStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3FixNumberDistributionStatistics")
	private StatisticsComponent k3FixNumberDistributionStatistics;
	
	private String key = K3ChartType.FixDistribution.getKey();
	
	List<Integer[]>	expectValues = Arrays.asList(new Integer[][]{
		new Integer[]{-2 , -1 , -7 , -3,  1, -46},
		new Integer[]{-2 , -1 , -7 , -4, -3, 1},
		new Integer[]{-46, -46, -13, -9, -2, 1}				
	});
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("5,6,6");
		ChartResult lastResult = new ChartResult();
		List<Integer[]> values = Arrays.asList(new Integer[][]{
				new Integer[]{-1, 2,-6,-2,-4,-45},
				new Integer[]{-1,2,-6,-3,-2,-4},
				new Integer[]{-45,-45,-12,-8,-1,6}				
		});
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
	}

	@SuppressWarnings("unchecked")
	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> result = k3FixNumberDistributionStatistics.chartRecord(vo);
		List<Integer[]>	values = (List<Integer[]>) result.get(key);
		Assert.assertArrayEquals(expectValues.get(0), values.get(0));
		Assert.assertArrayEquals(expectValues.get(1), values.get(1));
		Assert.assertArrayEquals(expectValues.get(2), values.get(2));		
	}

}
