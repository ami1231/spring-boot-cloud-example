package lotteryaward.chart.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import lotteryaward.chart.BaseTest;
import lotteryaward.chart.statistics.StatisticsComponent;

public class GenStatisticsTest extends BaseTest {

	Map<String,List<StatisticsComponent>> map;

	@Autowired
	private ApplicationContext context;

	@Before
	public void readyData() {
		map = new HashMap<>();
//		map.put("SSC", new ArrayList<>());
		map.put("K3", new ArrayList<>());
//		map.put("XX5", new ArrayList<>());	
	}

	@Test
	public void createSql(){
		
		Map<String,StatisticsComponent> beans = context.getBeansOfType(StatisticsComponent.class);
		for(Map.Entry<String,StatisticsComponent> entry: beans.entrySet()){
			String classId = entry.getValue().getClass().getSimpleName().substring(0,3).toUpperCase();
			if(classId.startsWith("K3")){
				classId = "K3";
			}
			if(map.get(classId)!=null){
				map.get(classId).add(entry.getValue());				
			}

		}
		
		createSql(map);
		
	}

	private void createSql(Map<String,List<StatisticsComponent>> map){
		
		for(Map.Entry<String,List<StatisticsComponent>> entry:map.entrySet()){
			String classId= entry.getKey();
			List<StatisticsComponent> list = entry.getValue();
			for(StatisticsComponent componenet:list){
				StringBuffer sql = insertCommand("GAME_CHART_TYPE");
				sql = prepareValues(sql, componenet, classId);
				System.out.println(sql.toString());
			}
		}
		
	}
	
	
	private StringBuffer insertCommand(String table){
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO "+table);
		buffer.append("(ID,NAME,GAME_CLASS_ID,CHART_CODE,CREATE_DATE) VALUES");		
		return buffer;
	}
	
	private StringBuffer prepareValues(StringBuffer sql,StatisticsComponent componenet,String classId){
		String chartCode = componenet.getClass().getSimpleName();
		chartCode = chartCode.substring(0,1).toLowerCase()+chartCode.substring(1);

		sql.append("(");
		sql.append("GAME_CHART_TYPE_ID_SEQ.nextval,");
		sql.append("'"+componenet.getClass().getSimpleName()+"'"+",");		
		sql.append("'"+classId+"'"+",");				
		sql.append("'"+chartCode+"'"+",");				
		sql.append("sysdate ");						
		sql.append(");");
		return sql;
	}
	
}