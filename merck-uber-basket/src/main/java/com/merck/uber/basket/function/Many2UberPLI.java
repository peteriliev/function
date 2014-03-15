package com.merck.uber.basket.function;

import java.util.function.BiFunction;

import com.merck.uber.basket.ERPWrap;
import com.merck.uber.basket.UberPLI;

public final class Many2UberPLI implements
		BiFunction<ERPWrap, Object[], UberPLI> {

	public static final BiFunction<ERPWrap, Object[], UberPLI> INSTANCE = new Many2UberPLI();

	private Many2UberPLI() {
	}

	public UberPLI apply(final ERPWrap t, final Object[] u) {
		// TODO:peteri
		return null;
	}
}
