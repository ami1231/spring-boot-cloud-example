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

public class K3NumberRoadBeadsStatisticsTest extends AbstractStatisticsTest{

	
	@Autowired
	@Qualifier("k3NumberRoadBeadsStatistics")
	private StatisticsComponent k3NumberRoadBeadsStatistics;
	
	private String key = K3ChartType.NumberRoadBeads.getKey();
	
	List<List<Integer>> expectValues = new ArrayList<>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	@Override
	public void readyVo() {
		GameChartTask task = new GameChartTask();
		task.setIsFirstIssue(false);
		vo.setGameChartTask(task);	
		vo.setAwardResult("2,1,1");
		ChartResult lastResult = new ChartResult();
		List<List<Integer>> values = new ArrayList<>();
		values.add(new ArrayList(Arrays.asList(new Integer[]{1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, 1})));
		values.add(new ArrayList(Arrays.asList(new Integer[]{-1, 1, -1, 1, 1, 1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, -1, -1})));
		values.add(new ArrayList(Arrays.asList(new Integer[]{-1, 1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1, -1, 1, 1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, -1})));
		values.add(new ArrayList(Arrays.asList(new Integer[]{-1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, -1, 1, -1, -1, 1, 1, -1, 1, 1, 1, -1, -1, -1, -1})));
		values.add(new ArrayList(Arrays.asList(new Integer[]{1, -1, 1, -1, 1, 1, -1, -1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, -1, -1})));
		values.add(new ArrayList(Arrays.asList(new Integer[]{1, -1, -1, 1, -1, -1, 1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, 1, -1})));	
		lastResult.put(key, values);
		vo.setLastResult(lastResult);
		
		//期望值
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, 1,1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{-1, 1, -1, 1, 1, 1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, -1, -1,1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{-1, 1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1, -1, 1, 1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, -1,-1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{-1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, -1, 1, -1, -1, 1, 1, -1, 1, 1, 1, -1, -1, -1, -1,-1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{1, -1, 1, -1, 1, 1, -1, -1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, -1, -1,-1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{1, -1, -1, 1, -1, -1, 1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, 1, -1,-1})));	
		
	}

	@SuppressWarnings("unchecked")
	@Test
	@Override
	public void testStaistics() {
		Map<String,Object> map = k3NumberRoadBeadsStatistics.chartRecord(vo);
		List<List<Integer>> values = (List<List<Integer>>) map.get(key);
		int index = 0;
		for(List<Integer> expectValue:expectValues){
			Assert.assertArrayEquals(expectValue.toArray(new Integer[0]), values.get(index).toArray(new Integer[0]));
			index++;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testStaisticsFirst() {
		vo.getGameChartTask().setIsFirstIssue(true);
		Map<String,Object> map = k3NumberRoadBeadsStatistics.chartRecord(vo);
		List<List<Integer>> values = (List<List<Integer>>) map.get(key);
		expectValues = values = new ArrayList<>();
		//期望值
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{1})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{0})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{0})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{0})));
		expectValues.add(new ArrayList(Arrays.asList(new Integer[]{0})));			

		int index = 0;
		for(List<Integer> expectValue:expectValues){
			Assert.assertArrayEquals(expectValue.toArray(new Integer[0]), values.get(index).toArray(new Integer[0]));
			index++;
		}
	}
	
}
