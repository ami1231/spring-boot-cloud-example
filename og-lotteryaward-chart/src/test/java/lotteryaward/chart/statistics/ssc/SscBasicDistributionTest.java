package lotteryaward.chart.statistics.ssc;

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

public class SscBasicDistributionTest extends AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscBasicDistributionStatistics")
	private StatisticsComponent statistics;
	
	String key = SscChartType.Distribution.getKey();

	//預期結果
	List<Integer[]> expectDistribution = Arrays.asList(new Integer[][]{
		{1,-1,-4,-6,-7,-8,-9,-10,-4,-5},{-2,-1,1,-6,-7,-8,-9,-10,-4,-5},{-2,-1,-4,1,-7,-8,-9,-10,-4,-5},
		{-2,-1,-4,-6,1,-8,-9,-10,-4,-5},{-2,-1,-4,-6,-7,-8,-9,-10,-4,1}});

	
	@Override
	@Before
	public void readyVo() {

		vo.setAwardResult("0,2,3,4,9");
		ChartResult lastResult = new ChartResult();
		//測試資料
		List<Integer[]> lastData = Arrays.asList(new Integer[][]{
			{-1,1,-3,-5,-6,-7,-8,-9,-3,-4},{-1,1,-3,-5,-6,-7,-8,-9,-3,-4},{-1,1,-3,-5,-6,-7,-8,-9,-3,-4},
			{-1,1,-3,-5,-6,-7,-8,-9,-3,-4},{-1,1,-3,-5,-6,-7,-8,-9,-3,-4}});
		lastResult.put(key, lastData);
		vo.setLastResult(lastResult);

		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void testStaistics() {

		Map<String, Object> map =  statistics.chartRecord(vo);
		
		List<Integer[]>  result = (List<Integer[]> )map.get(key);
		
		for(int i =0 ; i<result.size();i++){
			Assert.assertArrayEquals(result.get(i), expectDistribution.get(i));
		}	
	}

}
