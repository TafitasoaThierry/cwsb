package nn.tets.controller;

import java.util.List;

import nn.tets.model.Kaka;
import nn.tets.service.KakaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class KakaController {
	final KakaService kakaService;

	public KakaController(KakaService kakaService) {
		this.kakaService = kakaService;
	}

	/*
	 * use Kaka service
	 */
	@PostMapping("/addKaka")
	public ResponseEntity<Kaka> addKaka(@RequestBody Kaka newKaka) {
		return ResponseEntity.ok(this.kakaService.addKaka(newKaka));
	}

	@GetMapping("/getKakaList")
	public ResponseEntity<List<Kaka>> getkakaList() {
		return ResponseEntity.ok(this.kakaService.getKakaList());
	}

	@DeleteMapping("/deleteKaka/{a}")
	public ResponseEntity<String> deleteKaka(@PathVariable Long a) {
		return ResponseEntity.ok(this.kakaService.deleteKaka(a));
	}

	@PutMapping("/updateKaka/{a}")
	public ResponseEntity<Kaka> updateKaka(@PathVariable Long a, @RequestBody Kaka newKakaInfo) {
		return ResponseEntity.ok(this.kakaService.updateKaka(a, newKakaInfo));
	}
}
