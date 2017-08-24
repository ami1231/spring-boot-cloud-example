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
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public class K3DistributionStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3DistributionStatistics")
	private StatisticsComponent k3DistributionStatistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = K3ChartType.Distribution.getKey();
	String distributionCountKey = K3ChartType.DistributionCount.getKey();

	int[] expectDistribution = new int[]{-8,1,1,-2,-2,-1};
	int[] expectDistributionCount = new int[]{0,1,2,0,0,0};
	
	@Before
	public void readyVo(){
		vo.setAwardResult("2,3,3");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, new int[]{-7, 2, -2, -1, -1, 6});
		lastResult.put(distributionCountKey, new int[]{0, 1,0, 0, 0, 2});
		vo.setLastResult(lastResult);
	}
	
	@Test
	public void testStaistics() {
		Map<String,Object> nowResult = k3DistributionStatistics.chartRecord(vo);
		int[] distribution = (int[]) nowResult.get(distributionKey);
		int[] distributionCount = (int[]) nowResult.get(distributionCountKey);
		Assert.assertArrayEquals(expectDistribution, distribution);
		Assert.assertArrayEquals(expectDistributionCount, distributionCount);
	};
	
	
	
	
}
