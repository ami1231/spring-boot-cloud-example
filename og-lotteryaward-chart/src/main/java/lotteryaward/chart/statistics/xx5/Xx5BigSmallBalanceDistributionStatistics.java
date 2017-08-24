package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5TwoFaceDistributionTemplateStatistics;

@Component
public class Xx5BigSmallBalanceDistributionStatistics extends Xx5TwoFaceDistributionTemplateStatistics{
		
		/**
		 * Xx5 大小和走勢
		 * 
		 */
	
		@Autowired
		@Qualifier("bigSmallBalanceCompute")
		private ChartCompute<Integer,Integer> bigSmallBalanceCompute;

		@Override
		protected ChartCompute<Integer, Integer> getChartCompute() {
			//塞入中間值、平衡值
			Integer[] balance = new Integer[]{6,11};
			bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, balance);
			return bigSmallBalanceCompute;
		}

		@Override
		protected ChartTypeKey getChartTypeKey() {
			return ChartTypeKey.BigSmall;
		}

		@Override
		protected String getKey() {
			return Xx5ChartType.BigSmallDistribution.getKey();
		}

}
