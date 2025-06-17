package com.x.service;

import com.x.model.X;
import com.x.repository.XRepository;

import jakarta.el.ELException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class XService {
	final XRepository xRepository;

	public XService(XRepository xRepository) {
		this.xRepository = xRepository;
	}

	public X addX(X newX) {
		return this.xRepository.save(newX);
	}

	public List<X> getXList() {
		return this.xRepository.findAll();
	}

	public String deleteX(float x) {
		if(this.xRepository.findById(x).isPresent()) {
			this.xRepository.deleteById(x);
			return "x deleted";
		}else {
			return x.toString() + " isn't in x list";
		}
	}

	public X updateX(float x, X newXInfo) {
		if(this.xRepository.findById(x).isPresent()) {
			X xInfo = this.xRepository.findById(x).get();
			xInfo.setY(newXInfo.getY());
			xInfo.setShape(newXInfo.getShape());
			return this.xRepository.save(xInfo);
		}else {
			throw new ELException(x.toString() + " isn't in x list");
		}
	}
}
