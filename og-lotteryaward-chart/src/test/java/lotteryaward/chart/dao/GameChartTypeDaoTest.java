package lotteryaward.chart.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lotteryaward.chart.BaseTest;

public class GameChartTypeDaoTest extends BaseTest{

	@Autowired
	private IGameChartTypeDao gameChartTypeDao;
	
	@Test
	public void testSelectByPrimaryKey(){
		gameChartTypeDao.selectByPrimaryKey(11l);
	}
	
}
