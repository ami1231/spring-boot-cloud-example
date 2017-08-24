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
import lotteryaward.chart.statistics.k3.K3ChartType;
import lotteryaward.chart.statistics.vo.ChartResult;

public class K3NumberSiteSingleDoubleStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3NumberSiteSingleDoubleStatistics")
	private StatisticsComponent k3NumberSiteSingleDoubleStatistics;

	private String key = K3ChartType.NumberSiteSingleDouble.getKey();
	
	List<Integer[]>	expectValues = Arrays.asList(new Integer[][]{
		new Integer[]{1,-1},
		new Integer[]{-2,1},
		new Integer[]{-2,1}				
	});
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("5,6,6");
		ChartResult lastResult = new ChartResult();
		List<Integer[]> values = Arrays.asList(new Integer[][]{
				new Integer[]{-1,1,},
				new Integer[]{-1,1,},
				new Integer[]{-1,1}				
		});
		lastResult.put(key, values);
		vo.setLastResult(lastResult);		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void testStaistics() {
		Map<String,Object> map= k3NumberSiteSingleDoubleStatistics.chartRecord(vo);
		List<Integer[]>	values = (List<Integer[]>) map.get(key);
		Assert.assertArrayEquals(expectValues.get(0), values.get(0));
		Assert.assertArrayEquals(expectValues.get(1), values.get(1));
		Assert.assertArrayEquals(expectValues.get(2), values.get(2));
	}
	
}
