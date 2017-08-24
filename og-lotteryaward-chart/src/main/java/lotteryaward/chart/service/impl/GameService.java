package lotteryaward.chart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import lotteryaward.chart.dao.IGameDao;
import lotteryaward.chart.service.IGameService;
import lotteryaward.common.domain.Game;

public class GameService implements IGameService {
	
	@Autowired
	private IGameDao gameDao;
	
	@Override
	public Game selectByPrimaryKey(String id) {
		return gameDao.selectByPrimaryKey(id);
	}

	
	
}
