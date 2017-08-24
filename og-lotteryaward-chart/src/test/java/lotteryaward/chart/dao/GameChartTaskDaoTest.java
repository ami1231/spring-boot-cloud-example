package lotteryaward.chart.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lotteryaward.chart.BaseTest;

public class GameChartTaskDaoTest extends BaseTest{
	
	@Autowired
	private IGameChartTaskDao gameChartTaskDao;
	
	@Test
	public void testSelectByPrimaryKey(){
		gameChartTaskDao.selectByPrimaryKey(11l);
	}

}
