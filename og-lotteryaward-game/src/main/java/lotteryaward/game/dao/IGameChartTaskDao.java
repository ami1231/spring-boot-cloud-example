package lotteryaward.game.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import lotteryaward.common.domain.GameChartTask;

@Mapper
public interface IGameChartTaskDao {
	
	List<GameChartTask> selectByPrimaryKey(@Param("id")Long id);
	
    int insert(GameChartTask record);
}