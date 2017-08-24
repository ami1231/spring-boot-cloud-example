package lotteryaward.chart.statistics.k3;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.vo.ChartResult;

public class K3BasicNumberFormStatisticsTest extends AbstractStatisticsTest{

	@Autowired
	@Qualifier("k3BasicNumberFormStatistics")
	private StatisticsComponent k3BasicNumberFormStatistics;

	String tripleSameKey=ChartTypeKey.TripleSame.getKey();		
	String doubleSameKey=ChartTypeKey.DoubleSame.getKey();		
	String threeDifferentKey=K3ChartType.ThreeDifferent.getKey();
	
	Integer expectTriple = -41;
	
	Integer expectThreeDifferent = -2;

	Integer expectDouble = 1;
	
	@Before
	public void readyVo(){
		vo.setAwardResult("5,6,6");
		ChartResult lastResult = new ChartResult();
		lastResult.put(tripleSameKey, -40);
		lastResult.put(threeDifferentKey, -1);
		lastResult.put(doubleSameKey, 1);
		vo.setLastResult(lastResult);
	}
	
	@Override
	@Test
	public void testStaistics() {
		Map<String,Object> map = k3BasicNumberFormStatistics.chartRecord(vo);
		
		Integer tripleValue = (Integer) map.get(tripleSameKey);
		Integer doubleValue = (Integer) map.get(doubleSameKey);
		Integer threeDiferentValue = (Integer) map.get(threeDifferentKey);
		
		Assert.assertEquals("triple value not expect", expectTriple,tripleValue );
		Assert.assertEquals("threeDiffernet value not expect", expectThreeDifferent, threeDiferentValue);
		Assert.assertEquals("double value not expect", expectDouble, doubleValue);
		
		
	}
	
}
