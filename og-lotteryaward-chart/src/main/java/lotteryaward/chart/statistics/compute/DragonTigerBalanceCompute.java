package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
@Component
public class DragonTigerBalanceCompute implements ChartCompute<Integer,Integer> {

	@Override
	public Integer compute(Integer value) {
		if(value>0){
			return ChartThreeTypeKey.DragonTiger.getPvalue();
		}else if(value<0){
			return ChartThreeTypeKey.DragonTiger.getNvalue();
		}else{
			return ChartThreeTypeKey.DragonTiger.getIvalue();
		}
	}
}
