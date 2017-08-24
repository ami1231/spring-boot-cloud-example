package lotteryaward.chart.statistics.compute;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;

/**
 * 合質判斷
 * 合0,4,6,8,9
 * 質1,2,3,5,7
 * @author aronlin
 *
 */
@Component
public class HeZhiCompute  implements ChartCompute<Integer,Integer>{
	
	@Override
	public Integer compute(Integer value) {
		
		
		Integer [] he = {0,4,6,8,9};
		
		if(Arrays.asList(he).contains(value)){
			return ChartTypeKey.HeZhi.getPvalue();
		}else {
			return ChartTypeKey.HeZhi.getNvalue();
		}
		
		
		
	}
	

}
