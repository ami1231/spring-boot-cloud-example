package lotteryaward.chart.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lotteryaward.chart.BaseTest;

public class GameChartRecordDaoTest  extends BaseTest{
	
	@Autowired
	private IGameChartRecordDao gameChartRecordDao;
	
	@Test
	public void testSelectByPrimaryKey(){
		gameChartRecordDao.selectByPrimaryKey(1345l);
	}
	

}
