package lotteryaward.chart.statistics.k3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class K3NumberRoadBeadsStatistics implements StatisticsComponent{

	String key=K3ChartType.NumberRoadBeads.getKey();		
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String,Object> resultMap = new HashMap<>();
		List<List<Integer>> values = getMapValue(vo.getLastResult(), key, List.class);
		if(vo.getGameChartTask().getIsFirstIssue() || values==null){
			values = new ArrayList<>();
			values.add(new ArrayList<>());
			values.add(new ArrayList<>());
			values.add(new ArrayList<>());
			values.add(new ArrayList<>());
			values.add(new ArrayList<>());
			values.add(new ArrayList<>());			
		}
		//號碼重複過濾
		Set<Integer> numebrSet = ChartUtil.getSplitNumberStream(vo.getAwardResult()).map(s->Integer.valueOf(s)).collect(Collectors.toSet());;
		
		for(int i =0;i<values.size();i++){
			Boolean isContain = false;
			for(Integer number :numebrSet){
				if(number.equals(i+1)){
					isContain = true;
					break;
				}
			}
			if(isContain){
				values.get(i).add(1);				
			}else{
				values.get(i).add(-1);								
			}
		}
		
		resultMap.put(key, values);
		return resultMap;
	}

}
