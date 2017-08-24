package lotteryaward.game.dao;

import org.apache.ibatis.annotations.Mapper;

import feign.Param;
import lotteryaward.common.domain.GameResult;

@Mapper
public interface IGameResultDao {
	
    int insert(GameResult record);

    GameResult selectByPrimaryKey(@Param("id")String id);
}