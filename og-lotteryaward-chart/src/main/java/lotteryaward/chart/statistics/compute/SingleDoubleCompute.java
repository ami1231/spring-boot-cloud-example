package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;

/**
 * 
 * @author Ami
 *
 */
@Component
public class SingleDoubleCompute implements ChartCompute<Integer,Integer>{
	
	@Override
	public Integer compute(Integer value) {
		if(value%2==0){
			return ChartTypeKey.SingleDouble.getNvalue();
		}else{
			return ChartTypeKey.SingleDouble.getPvalue();
		}
	}
	
}
