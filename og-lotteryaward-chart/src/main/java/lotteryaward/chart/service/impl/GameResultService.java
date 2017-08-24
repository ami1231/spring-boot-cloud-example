package lotteryaward.chart.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotteryaward.chart.dao.IGameChartTaskDao;
import lotteryaward.chart.dao.IGameDao;
import lotteryaward.chart.dao.IGameResultDao;
import lotteryaward.chart.service.IGameResultService;
import lotteryaward.common.domain.Game;
import lotteryaward.common.domain.GameChartTask;
import lotteryaward.common.domain.GameResult;

/**
 * 開獎Service
 * @author Ami
 * 
 */
@Service
public class GameResultService implements IGameResultService {
	
	@Autowired
	private IGameDao gameDao;
	
	@Autowired
	private IGameResultDao gameResultDao;
	
	@Autowired
	private IGameChartTaskDao gameChartTaskDao;
	
	@Override
	public void insert(GameResult result) {
		Game game = gameDao.selectByPrimaryKey(result.getGameId());
		if (result.getResultDate() == null) {
			result.setResultDate(LocalDateTime.now());
		}
		if (result.getCreateDate() == null) {
			result.setCreateDate(LocalDateTime.now());
		}
		result.setGameName(game.getName());
		gameResultDao.insert(result);
		
		GameChartTask task = new GameChartTask();
		task.setGameId(game.getId());
		task.setIssue(result.getIssue());
		
	}

	
}