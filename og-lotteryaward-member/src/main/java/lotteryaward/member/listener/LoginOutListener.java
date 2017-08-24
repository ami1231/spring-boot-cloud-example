package lotteryaward.member.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * @author Ami
 *
 */
@WebListener
public class LoginOutListener implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		//HttpSession session = event.getSession();
		//ServletContext context = session.getServletContext();
		//ApplicationContext spring = WebApplicationContextUtils.getWebApplicationContext(context);
		//LotteryAwardCache cache = (LotteryAwardCache) spring.getBean("lotteryAwardCache");
	}
	
}
