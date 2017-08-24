package lotteryaward.common.page;

import org.springframework.stereotype.Component;

@Component("oracleDialect")
public class OracleDialect extends Dialect{
	
	public String getLimitString(String sql, boolean hasOffset) {
		return OraclePageHepler.getLimitString(sql,-1,-1);
	}

	public String getLimitString(String sql, int offset, int limit) {
		return OraclePageHepler.getLimitString(sql, offset, limit);
	}
	
	

	public boolean supportsLimit() {
		return true;
	}

	@Override
	public int getOffset(Page<?> page) {
		return page.getOffset();
	}

	@Override
	public int getLimit(Page<?> page) {
		return ((page.getPage()) * page.getPageSize() );
	}
}
