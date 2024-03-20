package de.cbrachem.example.samesitecookiedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/")
	public String index() {
		return "Hello, World!";
	}
}
