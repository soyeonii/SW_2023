package com.angkko.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.angkko.concert.IUConcert;
import com.angkko.concert.Performance;
import com.angkko.concert.PianoConcert;
import com.angkko.config.ConcertConfig;

public class ConcertMain {
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConcertConfig.class);
		
		Performance performance = ctx.getBean("pianoConcert", PianoConcert.class);
		performance.perform();
		System.out.println("-----------------------------------------------");
		
		performance = ctx.getBean("iuConcert", IUConcert.class);
		performance.perform();
		
		ctx.close();
	}
}
