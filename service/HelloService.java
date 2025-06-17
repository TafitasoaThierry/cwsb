package test.th.service;

import test.th.model.Hello;
import test.th.repository.HelloRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	final HelloRepository helloRepository;

	public HelloService(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	public Hello addHello(Hello newHello) {
		return this.helloRepository.save(newHello);
	}

	public List<Hello> getHelloList() {
		return this.helloRepository.findAll();
	}

	public String deleteHello(Long a) {
		if(this.helloRepository.findById(a).isPresent()) {
			this.helloRepository.deleteById(a);
			return "hello deleted";
		}else {
			return a.toString() + " isn't in hello list";
		}
	}

	public Hello updateHello(Long a, Hello newHelloInfo) {
		if(this.helloRepository.findById(a).isPresent()) {
			Hello helloInfo = this.helloRepository.findById(a).get();
			helloInfo.setX(newHelloInfo.getX());
			helloInfo.setY(newHelloInfo.getY());
			helloInfo.setB(newHelloInfo.getB());
			return this.helloRepository.save(helloInfo);
		}else {
			throw new ELException(a.toString() + " isn't in hello list");
		}
	}
}
