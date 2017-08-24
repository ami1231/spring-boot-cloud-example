package lotteryaward.chart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lotteryaward.chart.feign.game.GameHelloFeign;

@RestController
@RequestMapping("chart")
public class CahrtHelloWorldController extends BaseController{

	@Autowired
	private GameHelloFeign gameHelloFeign;
	
	@GetMapping("/hello")
	public String hello(){
		return "member api hello";
	}
	
	@GetMapping("gameHello")
	public String getGameHello(){
		return gameHelloFeign.hello();
	}
	
}
