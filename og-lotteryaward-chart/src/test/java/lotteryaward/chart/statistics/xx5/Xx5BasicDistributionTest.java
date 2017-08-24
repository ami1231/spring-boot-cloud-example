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
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public class Xx5BasicDistributionTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5BasicDistributionStatistics")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	private String distributionKey = Xx5ChartType.Distribution.getKey();

	// 期望結果
	List<Integer[]> expectDistribution = Arrays
			.asList(new Integer[][] { 
					{1,-1,-4,-6,-7,-8,-9,-10,-4,-5,-6},
					{-2,1,-4,-6,-7,-8,-9,-10,-4,-5,-6},
					{-2,-1,1,-6,-7,-8,-9,-10,-4,-5,-6},
					{-2,-1,-4,1,-7,-8,-9,-10,-4,-5,-6},
					{-2,-1,-4,-6,1,-8,-9,-10,-4,-5,-6}});

	@Before
	public void readyVo() {
		vo.setAwardResult("1,2,3,4,5");
		ChartResult lastResult = new ChartResult();
		List<Integer[]> distribution = Arrays
				.asList(new Integer[][] { 
						{-1,1,-3,-5,-6,-7,-8,-9,-3,-4,-5},
						{-1,1,-3,-5,-6,-7,-8,-9,-3,-4,-5},
						{-1,1,-3,-5,-6,-7,-8,-9,-3,-4,-5},
						{-1,1,-3,-5,-6,-7,-8,-9,-3,-4,-5},
						{-1,1,-3,-5,-6,-7,-8,-9,-3,-4,-5}});
		lastResult.put(distributionKey, distribution);
		vo.setLastResult(lastResult);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testStaistics() {
		Map<String, Object> nowResult = statistics.chartRecord(vo);
		List<Integer[]> distribution = (List<Integer[]>) nowResult.get(distributionKey);
		for(int i =0 ; i<distribution.size();i++){
			Assert.assertArrayEquals(expectDistribution.get(i), distribution.get(i));			
		}
	}
}
