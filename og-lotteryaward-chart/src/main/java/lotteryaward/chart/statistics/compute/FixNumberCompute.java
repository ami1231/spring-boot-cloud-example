package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;

/**
 * 
 * @author Ami
 *
 */
@Component
public class FixNumberCompute implements ChartCompute<Integer,Integer[]>,ChartComputeParam<Integer> {

	private ThreadLocal<Integer> length = new ThreadLocal<>();
	
	@Override
	public Integer[] compute(Integer value) {
		 
		Integer[] sumValuearray =new Integer[length.get()];
		
		for(int i=0;i<length.get();i++){
			if(value==i+1){
				sumValuearray[i]=ChartTypeKey.FixNumberValue.getPvalue();
			}else{
				sumValuearray[i]=ChartTypeKey.FixNumberValue.getNvalue();				
			}
		}
		return sumValuearray;
	}

	@Override
	public void setComputeParam(Integer param) {
		length.set(param);
	}


}
