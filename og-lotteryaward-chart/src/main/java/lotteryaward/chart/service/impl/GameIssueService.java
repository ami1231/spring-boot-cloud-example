package lotteryaward.chart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotteryaward.chart.dao.IGameIssueDao;
import lotteryaward.chart.service.IGameIssueService;
import lotteryaward.common.domain.GameIssue;

@Service
public class GameIssueService implements IGameIssueService {
	
	@Autowired
	private IGameIssueDao gameIssueDao;
	
	@Override
	public GameIssue selectByPrimaryKey(String id) {
		GameIssue gameIssue =gameIssueDao.selectByPrimaryKey(id);
		return gameIssue;
	}
}