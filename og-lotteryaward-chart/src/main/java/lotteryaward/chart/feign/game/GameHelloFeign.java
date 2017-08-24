package lotteryaward.chart.feign.game;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import lotteryaward.common.constant.ServiceList;

@FeignClient(name=ServiceList.GAME_SERVICE)
public interface GameHelloFeign{

	@GetMapping("/game/hello")
	public String hello();
	
}
