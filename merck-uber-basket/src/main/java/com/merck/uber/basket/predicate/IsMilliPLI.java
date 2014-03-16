package com.merck.uber.basket.predicate;

import java.util.function.Predicate;

import com.merck.uber.basket.UberPLI;

public final class IsMilliPLI implements Predicate<UberPLI> {

	private IsMilliPLI() {
		
	}
	
	public static final Predicate<UberPLI> INSTANCE = new IsMilliPLI();
	
	public boolean test(UberPLI t) {
		// TODO:peteri
		return false;
	}
}
