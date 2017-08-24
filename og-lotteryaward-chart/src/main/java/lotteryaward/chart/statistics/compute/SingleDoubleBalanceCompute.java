package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;

@Component
public class SingleDoubleBalanceCompute implements ChartCompute<Integer,Integer>,ChartComputeParam<Integer>{
	
	private ThreadLocal<Integer> balancePoint = new ThreadLocal<>();	
	@Override
	public Integer compute(Integer value) {
		if (value == balancePoint.get()){
			return ChartThreeTypeKey.SingleDouble.getIvalue();
		}else if(value%2 != 0){
			return ChartThreeTypeKey.SingleDouble.getPvalue();
		}else{
			return ChartThreeTypeKey.SingleDouble.getNvalue();
		}
	}
	
	@Override
	public void setComputeParam(Integer param){
		balancePoint.set(param);
	}

}