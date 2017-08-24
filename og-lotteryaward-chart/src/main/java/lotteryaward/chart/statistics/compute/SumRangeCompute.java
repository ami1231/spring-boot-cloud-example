package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.util.ChartUtil;

/**
 * 和值走势
 * @author Ami
 *
 */
@Component
public class SumRangeCompute implements ChartCompute<String,Integer[]>,ChartComputeParam<Integer[]>{

	private ThreadLocal<Integer> begin = new ThreadLocal<>();
	
	private ThreadLocal<Integer> end = new ThreadLocal<>();
	
	@Override
	public Integer[] compute(String awardResult) {
		Integer beginInedx = begin.get();		
		Integer endInedx = end.get();
		Integer length = endInedx-beginInedx+1;
		
		Integer[] sumValuearray =new Integer[length];
		Integer sumValue = ChartUtil.getSumResultNumber(awardResult);
		
		for(int i=0;i<length;i++){
			if(sumValue==beginInedx++){
				sumValuearray[i]=ChartTypeKey.NumberSumValue.getPvalue();
			}else{
				sumValuearray[i]=ChartTypeKey.NumberSumValue.getNvalue();				
			}
		}
		return sumValuearray;
	}

	@Override
	public void setComputeParam(Integer[] param) {
		begin.set(param[0]);
		end.set(param[1]);		
	}

}
