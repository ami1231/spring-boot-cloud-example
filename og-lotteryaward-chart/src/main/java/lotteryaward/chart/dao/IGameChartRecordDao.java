package lotteryaward.chart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import lotteryaward.common.domain.GameChartRecord;
@Mapper
public interface IGameChartRecordDao {
	
	 List<GameChartRecord> selectByPrimaryKey(@Param("id")Long id);
	
    int insert(GameChartRecord record);
 
}