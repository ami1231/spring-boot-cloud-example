package lotteryaward.common.page;

import java.util.Map;


/**
 * 
 * @author Ami
 *
 */
public class ReflectHelper {
	/**
     * 检查是否含有分页或本来就是分页类
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object isPage(Object obj, String fieldName) {
    	
		if (obj instanceof Map) {
			@SuppressWarnings("rawtypes")
			Map map = (Map)obj;
			if(map.containsKey(fieldName))
				return map.get(fieldName);

		} else if(obj instanceof Page) {
    		return obj;
    	}
		return null;
      
    } 

}