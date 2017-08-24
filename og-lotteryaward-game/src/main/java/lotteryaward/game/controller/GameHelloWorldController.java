package lotteryaward.game.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
public class GameHelloWorldController extends BaseController{

	@GetMapping("/hello")
	public String hello(){
		return "game api hello";
	}
	
}
