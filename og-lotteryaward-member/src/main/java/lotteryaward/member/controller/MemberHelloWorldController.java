package lotteryaward.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberHelloWorldController extends BaseController{

	@GetMapping("/hello")
	public String hello(){
		return "member api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hellomember api hello";
	}
	
}
