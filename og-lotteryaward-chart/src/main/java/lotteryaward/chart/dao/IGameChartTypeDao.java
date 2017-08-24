package lotteryaward.chart.dao;

import org.apache.ibatis.annotations.Mapper;

import lotteryaward.common.domain.GameChartType;

@Mapper
public interface IGameChartTypeDao {
    int insert(GameChartType record);

    GameChartType selectByPrimaryKey(Long id);
}