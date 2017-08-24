package lotteryaward.game.dao;

import org.apache.ibatis.annotations.Mapper;

import feign.Param;
import lotteryaward.common.domain.GameIssue;

@Mapper
public interface IGameIssueDao {
    int insert(GameIssue record);

    GameIssue selectByPrimaryKey(@Param("id")String id);
}