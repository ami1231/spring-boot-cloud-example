package lotteryaward.zuul.filter;

import com.netflix.zuul.ZuulFilter;

public class AccessFilter extends ZuulFilter{
	
	
	    @Override
	    public String filterType() {
	        return "pre";
	    }
	    @Override
	    public int filterOrder() {
	        return 0;
	    }
	    @Override
	    public boolean shouldFilter() {
	        return true;
	    }
	    @Override
	    public Object run() {
	    	 /*RequestContext ctx = RequestContext.getCurrentContext();
	        HttpServletRequest request = ctx.getRequest();
	        //驗證傳入參數
	        Object accessToken = request.getParameter("accessToken");
	       if(accessToken == null) {
	            ctx.setSendZuulResponse(false);
	            ctx.setResponseStatusCode(401);
	            return null;
	        }*/
	        return null;
	    }
}
