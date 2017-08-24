package lotteryaward.common.page;

/**
 * Oracle分頁查詢
 * @author Ami
 *
 */
public class OraclePageHepler{
	/**
	 * 得到分页的SQL
	 * @param offset 	起始筆數
	 * @param limit		最後比數
	 * @return	分页SQL
	 */
	public static String getLimitString(String querySelect,int offset, int limit) {
		
		querySelect		= getLineSql(querySelect);
		
		StringBuilder pagingSelect = new StringBuilder(querySelect.length() + 100);

		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		
		pagingSelect.append(querySelect);
		
		pagingSelect.append(" ) row_ ) where rownum_ <= "+limit+" and rownum_ >"+offset);
		return pagingSelect.toString();
		
	}
	
	/**
	 * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
	 * 
	 * @param sql SQL语句
	 * @return 如果sql是NULL返回空，否则返回转化后的SQL
	 */
	private static String getLineSql(String sql) {
		return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
	}

}
