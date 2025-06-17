package test.th.controller;

import java.util.List;

import test.th.model.Hello;
import test.th.service.HelloService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {
	final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	/*
	 * use Hello service
	 */
	@PostMapping("/addHello")
	public ResponseEntity<Hello> addHello(@RequestBody Hello newHello) {
		return ResponseEntity.ok(this.helloService.addHello(newHello));
	}

	@GetMapping("/getHelloList")
	public ResponseEntity<List<Hello>> gethelloList() {
		return ResponseEntity.ok(this.helloService.getHelloList());
	}

	@DeleteMapping("/deleteHello/{a}")
	public ResponseEntity<String> deleteHello(@PathVariable Long a) {
		return ResponseEntity.ok(this.helloService.deleteHello(a));
	}

	@PutMapping("/updateHello/{a}")
	public ResponseEntity<Hello> updateHello(@PathVariable Long a, @RequestBody Hello newHelloInfo) {
		return ResponseEntity.ok(this.helloService.updateHello(a, newHelloInfo));
	}
}
