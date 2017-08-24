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

/**
 * 豹子 顺子 对子 半顺 杂六
 * @author aronlin
 *
 */
public class SscNumCombineDistributionTest extends AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscNumCombineDistributionStatistics")
	private StatisticsComponent statistics;
	
	String key = SscChartType.FrontMiddleBehindThree.getKey();
	
	//預期結果 豹子 顺子 对子 半顺 杂六
//	List<Integer[]> expectDistribution = Arrays.asList(new Integer[][]{
//		{-2,-1,-4,-6,1},{-2,-1,-4,1,-7},{-2,-1,1,-6,-7}});
	List<Integer[]> expectDistribution = Arrays.asList(new Integer[][]{
		{1,-1,-4,-6,-7},{-2,-1,1,-6,-7},{-2,1,-4,-6,-7}});


	@Override
	@Before
	public void readyVo() {
		//vo.setAwardResult("4,8,2,3,2");//雜六  半順 對子
		vo.setAwardResult("4,4,4,5,6");//豹子 對子 順子
		ChartResult lastResult = new ChartResult();
		//測試資料
		List<Integer[]> lastData = Arrays.asList(new Integer[][]{
			{-1,1,-3,-5,-6},{-1,1,-3,-5,-6},{-1,1,-3,-5,-6}});
		lastResult.put(key, lastData);
		vo.setLastResult(lastResult);
		
	}

	@Override
	@Test
	public void testStaistics() {
		Map<String, Object> map =  statistics.chartRecord(vo);
		
		@SuppressWarnings("unchecked")
		List<Integer[]>  result = (List<Integer[]> )map.get(key);
		
		for(int i =0 ; i<result.size();i++){
			Assert.assertArrayEquals(result.get(i), expectDistribution.get(i));
		}	
		
	}

}
