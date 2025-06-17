package com.x.controller;

import java.util.List;

import com.x.model.X;
import com.x.service.XService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class XController {
	final XService xService;

	public XController(XService xService) {
		this.xService = xService;
	}

	/*
	 * use X service
	 */
	@PostMapping("/addX")
	public ResponseEntity<X> addX(@RequestBody X newX) {
		return ResponseEntity.ok(this.xService.addX(newX));
	}

	@GetMapping("/getXList")
	public ResponseEntity<List<X>> getxList() {
		return ResponseEntity.ok(this.xService.getXList());
	}

	@DeleteMapping("/deleteX/{x}")
	public ResponseEntity<String> deleteX(@PathVariable float x) {
		return ResponseEntity.ok(this.xService.deleteX(x));
	}

	@PutMapping("/updateX/{x}")
	public ResponseEntity<X> updateX(@PathVariable float x, @RequestBody X newXInfo) {
		return ResponseEntity.ok(this.xService.updateX(x, newXInfo));
	}
}
