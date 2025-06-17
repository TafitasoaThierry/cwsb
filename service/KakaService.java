package nn.tets.service;

import nn.tets.model.Kaka;
import nn.tets.repository.KakaRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class KakaService {
	final KakaRepository kakaRepository;

	public KakaService(KakaRepository kakaRepository) {
		this.kakaRepository = kakaRepository;
	}

	public Kaka addKaka(Kaka newKaka) {
		return this.kakaRepository.save(newKaka);
	}

	public List<Kaka> getKakaList() {
		return this.kakaRepository.findAll();
	}

	public String deleteKaka(Long a) {
		if(this.kakaRepository.findById(a).isPresent()) {
			this.kakaRepository.deleteById(a);
			return "kaka deleted";
		}else {
			return a.toString() + " isn't in kaka list";
		}
	}

	public Kaka updateKaka(Long a, Kaka newKakaInfo) {
		if(this.kakaRepository.findById(a).isPresent()) {
			Kaka kakaInfo = this.kakaRepository.findById(a).get();
			kakaInfo.setB(newKakaInfo.getB());
			kakaInfo.setC(newKakaInfo.getC());
			return this.kakaRepository.save(kakaInfo);
		}else {
			throw new ELException(a.toString() + " isn't in kaka list");
		}
	}
}
