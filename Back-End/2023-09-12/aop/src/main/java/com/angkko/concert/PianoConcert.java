package com.angkko.concert;

import org.springframework.stereotype.Component;

@Component
public class PianoConcert implements Performance {
	@Override
	public void perform() throws Exception {
		System.out.println("Playing piano!!!");
	}
}
