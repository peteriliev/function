package com.merck.uber.basket.function;

import java.util.function.BiFunction;

import com.merck.uber.basket.Money;
import com.merck.uber.basket.UberPLI;

public class SumUberPLIs implements BiFunction<UberPLI, Money, Money> {

	private SumUberPLIs()
	{
		
	}
	
	public static final BiFunction<UberPLI, Money, Money> INSTANCE = new SumUberPLIs();
	
	public Money apply(UberPLI t, Money u) {
		// TODO:peteri
		return null;
	}
}
