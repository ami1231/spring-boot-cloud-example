package lotteryaward.chart.statistics;

import java.util.Map;

import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 
 * @author Ami
 *
 */
public interface StatisticsComponent {

	String COMMADN = ",";
	
	Map<String,Object> chartRecord(ChartStaisticsVo vo);
	
	default <T> T  getMapValue(Map<String,Object> map,String key,Class<T> type){
		if(map.get(key)!=null){
			return type.cast(map.get(key));
		}else{
			return null;
		}
	}
	
}