package lotteryaward.chart.statistics.compute;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;

@Component
public class DistributionCompute implements ChartCompute<String,int[]>,ChartComputeParam<Integer>{
	
	private ThreadLocal<Integer> arrayLength = new ThreadLocal<Integer>();
	
	@Override
	public int[] compute(String awardResult) {
		
		int[] distributionArray = new int [arrayLength.get()];
		Arrays.stream(awardResult.split(StatisticsComponent.COMMADN))
		.forEach(s->{
			Integer num = Integer.valueOf(s);
			distributionArray[num-1]=1;
		});
		
		for(int i=0;i<distributionArray.length;i++){
			if(distributionArray[i]==0){
				distributionArray[i]=-1;
			}
		}
		return distributionArray;
	}

	@Override
	public void setComputeParam(Integer param) {
		arrayLength.set(param);
	}
	
}