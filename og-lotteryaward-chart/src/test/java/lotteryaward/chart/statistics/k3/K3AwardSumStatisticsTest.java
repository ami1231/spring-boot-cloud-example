package lotteryaward.chart.statistics.k3;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;

public class K3AwardSumStatisticsTest extends AbstractStatisticsTest{

	
	@Autowired
	@Qualifier("k3AwardSumStatistics")
	private StatisticsComponent k3AwardSumStatistics;
	
	String key = K3ChartType.AwardSum.getKey();

	Integer expectBigSmall = -1;
	
	Integer expectSingleDouble = 1;
	
	Integer expectSum = 9;
	
	@Before
	@Override
	public void readyVo() {
		vo.setAwardResult("1,3,5");
	}

	@Test
	@SuppressWarnings("unchecked")
	@Override
	public void testStaistics() {
		Map<String,Object> map = k3AwardSumStatistics.chartRecord(vo);
		Map<String,Object> resultMap = (Map<String, Object>) map.get(key);
		Assert.assertEquals("BigSmall Check", resultMap.get(ChartTypeKey.BigSmall.getKey()), expectBigSmall);
		Assert.assertEquals("SingleDouble Check", resultMap.get(ChartTypeKey.SingleDouble.getKey()), expectSingleDouble);
		Assert.assertEquals("sumValue Check", resultMap.get("sumValue"), expectSum);
	}

}
