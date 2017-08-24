package lotteryaward.chart.statistics.k3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class K3SumRoadBeasStatistics implements StatisticsComponent{

	String bigKey=K3ChartType.SumBigSmallRoadBeads.getKey();		

	String singleKey=K3ChartType.SumSingleDoubleRoadBeads.getKey();		
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String,Object> resultMap = new HashMap<>();
		
		List<Integer> bigValues = getMapValue(vo.getLastResult(), bigKey, List.class);
		List<Integer> singleValues = getMapValue(vo.getLastResult(), singleKey, List.class);
		
		if(vo.getGameChartTask().getIsFirstIssue() || bigValues==null || singleValues==null){
			bigValues = new ArrayList<>();
			singleValues = new ArrayList<>();		
		}
		Integer sumValue = ChartUtil.getSumResultNumber(vo.getAwardResult());
		
		if(sumValue%2==1){
			singleValues.add(ChartTypeKey.SingleDouble.getPvalue());
		}else{
			singleValues.add(ChartTypeKey.SingleDouble.getNvalue());			
		}
		
		if(sumValue>=4){
			bigValues.add(ChartTypeKey.BigSmall.getPvalue());
		}else{
			bigValues.add(ChartTypeKey.BigSmall.getNvalue());			
		}
		
		resultMap.put(bigKey, bigValues);
		resultMap.put(singleKey, singleValues);
		return resultMap;
	}

}
