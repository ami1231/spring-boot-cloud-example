package lotteryaward.chart.statistics;

import lotteryaward.chart.BaseTest;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class AbstractStatisticsTest extends BaseTest{
	
	protected ChartStaisticsVo vo = new ChartStaisticsVo();
	
	public abstract void readyVo();
	
	public abstract void testStaistics();
	

	
}
