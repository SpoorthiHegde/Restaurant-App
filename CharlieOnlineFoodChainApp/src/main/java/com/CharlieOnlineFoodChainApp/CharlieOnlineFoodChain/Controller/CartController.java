package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service.CartService;

@RestController
@CrossOrigin("*")
public class CartController {
	
	@Autowired
	private CartService CartService;
	
	

}
