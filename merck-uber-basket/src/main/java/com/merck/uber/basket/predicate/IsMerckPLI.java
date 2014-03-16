package com.merck.uber.basket.predicate;

import java.util.function.Predicate;

import com.merck.uber.basket.UberPLI;

public final class IsMerckPLI implements Predicate<UberPLI> {

	private IsMerckPLI() {
		
	}
	
	public static final Predicate<UberPLI> INSTANCE = new IsMerckPLI();
	
	public boolean test(UberPLI t) {
		// TODO:peteri
		return false;
	}
}
