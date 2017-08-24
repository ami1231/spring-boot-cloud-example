package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;

@Component
public class BigSmallBalanceCompute implements ChartCompute<Integer,Integer>,ChartComputeParam<Integer[]>{
	
	private ThreadLocal<Integer> bigSmallPoint = new ThreadLocal<>(); 	//6
	private ThreadLocal<Integer> balancePoint = new ThreadLocal<>();	//11
	@Override
	public Integer compute(Integer value) {
		if (value == balancePoint.get()){
			return ChartThreeTypeKey.BigSmall.getIvalue();
		}else if(value >= bigSmallPoint.get()){
			return ChartThreeTypeKey.BigSmall.getPvalue();
		}else{
			return ChartThreeTypeKey.BigSmall.getNvalue();
		}
	}
	
	@Override
	public void setComputeParam(Integer[] param){
		bigSmallPoint.set(param[0]);
		balancePoint.set(param[1]);
	}

}