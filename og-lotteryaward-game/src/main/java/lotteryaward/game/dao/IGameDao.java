package lotteryaward.game.dao;

import org.apache.ibatis.annotations.Mapper;

import feign.Param;
import lotteryaward.common.domain.Game;

@Mapper
public interface IGameDao {
	
    int insert(Game record);

    Game selectByPrimaryKey(@Param("id")String id);
}