package lotteryaward.chart.statistics.k3;

import java.util.ArrayList;
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
import lotteryaward.common.domain.GameChartTask;

public class K3SumRoadBeasStatisticsTest extends AbstractStatisticsTest{

	String bigKey=K3ChartType.SumBigSmallRoadBeads.getKey();		

	String singleKey=K3ChartType.SumSingleDoubleRoadBeads.getKey();		
	
	@Autowired
	@Qualifier("k3SumRoadBeasStatistics")
	private StatisticsComponent k3SumRoadBeasStatistics;
	
	List<Integer> expectBigValue = new ArrayList<>(Arrays.asList(new Integer[]{1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1, 1, -1, -1, -1, 1, -1,1}));
	List<Integer> expectSingleValue = new ArrayList<>(Arrays.asList(new Integer[]{-1, 1, -1, -1, 1, 1, -1, 1, 1, 1, -1, 1, -1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, 2, -1, -1, 1, -1,1}));
	
	@Before
	@Override
	public void readyVo() {
		GameChartTask task = new GameChartTask();
		task.setIsFirstIssue(false);
		vo.setGameChartTask(task);
		vo.setAwardResult("5,6,6");
		ChartResult lastResult = new ChartResult();
		List<Integer> bigValue = 	new ArrayList<>(Arrays.asList(new Integer[]{1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1, 1, -1, -1, -1, 1, -1}));
		List<Integer> singleValue = new ArrayList<>(Arrays.asList(new Integer[]{-1, 1, -1, -1, 1, 1, -1, 1, 1, 1, -1, 1, -1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, 2, -1, -1, 1, -1}));
		lastResult.put(bigKey, bigValue);
		lastResult.put(singleKey, singleValue);		
		vo.setLastResult(lastResult);		
	}

	@SuppressWarnings("unchecked")
	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> map = k3SumRoadBeasStatistics.chartRecord(vo);
		List<Integer> bigValue= (List<Integer>) map.get(bigKey);
		List<Integer>  singleValue = (List<Integer>) map.get(singleKey);
		
		Assert.assertArrayEquals(expectBigValue.toArray(new Integer[0]), bigValue.toArray(new Integer[0]));
		Assert.assertArrayEquals(expectSingleValue.toArray(new Integer[0]), singleValue.toArray(new Integer[0]));		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testStaistics2() {
		vo.getGameChartTask().setIsFirstIssue(true);
		Map<String,Object> map = k3SumRoadBeasStatistics.chartRecord(vo);
		List<Integer> expectBigValue = new ArrayList<>(Arrays.asList(new Integer[]{1}));
		List<Integer> expectSingleValue = new ArrayList<>(Arrays.asList(new Integer[]{1}));		
		List<Integer> bigValue= (List<Integer>) map.get(bigKey);
		List<Integer>  singleValue = (List<Integer>) map.get(singleKey);
		
		Assert.assertArrayEquals(expectBigValue.toArray(new Integer[0]), bigValue.toArray(new Integer[0]));
		Assert.assertArrayEquals(expectSingleValue.toArray(new Integer[0]), singleValue.toArray(new Integer[0]));		
		
	}

}
