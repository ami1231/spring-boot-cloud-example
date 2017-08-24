package lotteryaward.game.dao;

import org.apache.ibatis.annotations.Mapper;

import feign.Param;
import lotteryaward.common.domain.GameClass;

@Mapper
public interface IGameClassDao {
    
	int insert(GameClass record);
    
    GameClass selectByPrimaryKey(@Param("id")String id);
}