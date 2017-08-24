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

public class K3NumberSiteBgiSmallStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3NumberSiteBgiSmallStatistics")
	private StatisticsComponent k3NumberSiteBgiSmallStatistics;
	
	private String key = K3ChartType.NumberSiteBigSmall.getKey();
	
	List<Integer[]>	expectValues = Arrays.asList(new Integer[][]{
		new Integer[]{1,-1},
		new Integer[]{1,-1},
		new Integer[]{1,-13}				
	});
	
	@Override
	@Before
	public void readyVo() {
		vo.setAwardResult("5,6,6");
		ChartResult lastResult = new ChartResult();
		List<Integer[]> values = Arrays.asList(new Integer[][]{
				new Integer[]{-2,   2,},
				new Integer[]{-2,   2,},
				new Integer[]{1,-12}				
		});
		lastResult.put(key, values);
		vo.setLastResult(lastResult);		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void testStaistics() {
		Map<String,Object> map= k3NumberSiteBgiSmallStatistics.chartRecord(vo);
		List<Integer[]>	values = (List<Integer[]>) map.get(key);
		Assert.assertArrayEquals(expectValues.get(0), values.get(0));
		Assert.assertArrayEquals(expectValues.get(1), values.get(1));
		Assert.assertArrayEquals(expectValues.get(2), values.get(2));		
	}

}
