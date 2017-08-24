package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;

@Component
public class HotColdCompute implements ChartCompute<Integer,Integer>{
	//1:熱 0:溫 -1:冷
	@Override
	public Integer compute(Integer count) {
		if(count>=4){
			//熱
			return ChartThreeTypeKey.HotCold.getPvalue();
		}else if(count<4&&count>1){
			//溫
			return ChartThreeTypeKey.HotCold.getIvalue();
		}else{
			//冷
			return ChartThreeTypeKey.HotCold.getNvalue();
		}
	}
}