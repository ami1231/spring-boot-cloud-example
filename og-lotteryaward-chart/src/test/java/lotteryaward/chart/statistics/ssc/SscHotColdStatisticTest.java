package lotteryaward.chart.statistics.ssc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;

public class SscHotColdStatisticTest  extends  AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscHotColdStatistic")
	private StatisticsComponent statistics;
	
	//private String key = SscChartType.HotColdStatistic.getKey();

	//private String[] keys = new String[]{"first","second","third","fourth","fifth"};
	

	// 期望結果 熱溫冷
	Map<String, Object> fifthMap = new HashMap<>();
	
	
	 Integer[] expectFifthArray = new Integer[] { };

	// 舊資料
	List<String> twentyResult = Arrays.asList("6,9,10,11,1", "5,1,4,7,2", "5,1,7,11,3", "5,3,11,6,4", "5,3,9,7,4",
			"1,11,5,9,4", "5,7,8,11,4", "3,9,8,6,5", "1,10,9,4,6", "6,5,4,1,7", "9,10,5,4,7", "11,9,2,5,7", "4,5,9,6,7",
			"8,5,1,9,7", "6,2,4,5,9", "11,4,5,3,10", "2,4,6,3,10", "3,9,7,8,10", "9,8,3,1,11", "7,5,8,6,11");

	@Override
	public void readyVo() {
		//Map<String, Object> hotMap = new LinkedHashMap<>();
		//List<Map<String, Object>> hot = new ArrayList<>();
		
		vo.setTwentyResult(twentyResult);
		
	}

	@Override
	public void testStaistics() {
		
		Map<String, Object> map = statistics.chartRecord(vo);
		Integer[]  fifthArray = (Integer[])map.get("fifth");
		Assert.assertArrayEquals(fifthArray, expectFifthArray);
		
	}

}
