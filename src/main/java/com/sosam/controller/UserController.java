package com.sosam.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosam.model.Like;
import com.sosam.model.User;
import com.sosam.service.LikeService;
import com.sosam.service.UserService;

@RestController
@RequestMapping("/sg/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	LikeService likeService;

	@GetMapping("/user/{uId}")
	public String checkId(@PathVariable String uId) {
		return userService.checkId(uId);
	}
	/*
	 * @GetMapping("/id") public
	 */
	
	@GetMapping("/dib/{mCode}/{uId}")
	public ResponseEntity<Like> likeClick(@PathVariable String mCode, @PathVariable String uId, String flag) {
		Like like = likeService.likeClick(mCode, uId, flag);
		if(like != null) {
			return ResponseEntity.ok(like);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/newcomer")
	public ResponseEntity<User> signUp(User user) {
		User result = userService.signUp(user);
		if(result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/user/{uId}")
	public String signIn(@PathVariable String uId, String uPw, HttpServletRequest req) {
		return userService.signIn(uId, uPw, req);
	}
}
