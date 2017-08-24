package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;

/**
 * 
 * @author Ami
 *
 */
@Component
public class BigSmallCompute implements ChartCompute<Integer,Integer>,ChartComputeParam<Integer>{
	
	private ThreadLocal<Integer> bigSmallPoint = new ThreadLocal<>();
	
	@Override
	public Integer compute(Integer value) {
		if(value >= bigSmallPoint.get()){
			return ChartTypeKey.BigSmall.getPvalue();
		}else{
			return ChartTypeKey.BigSmall.getNvalue();
		}
	}
	
	@Override
	public void setComputeParam(Integer param){
		bigSmallPoint.set(param);
	}

}