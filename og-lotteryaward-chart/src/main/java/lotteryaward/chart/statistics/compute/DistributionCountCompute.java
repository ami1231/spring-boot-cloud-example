package lotteryaward.chart.statistics.compute;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;

/**
 * 
 * @author Ami
 *
 */
@Component
public class DistributionCountCompute implements ChartCompute<String,int[]>,ChartComputeParam<Integer>{
	
	private ThreadLocal<Integer> arrayLength = new ThreadLocal<>();
	
	@Override
	public int[] compute(String awardResult) {
		int[] distributionArray = new int [arrayLength.get()];
		Arrays.stream(awardResult.split(StatisticsComponent.COMMADN))
		.forEach(s->{
			Integer num = Integer.valueOf(s);
			distributionArray[num-1] = distributionArray[num-1]+1;
		});
		return distributionArray;
	}

	@Override
	public void setComputeParam(Integer param) {
		arrayLength.set(param);
	}

}
