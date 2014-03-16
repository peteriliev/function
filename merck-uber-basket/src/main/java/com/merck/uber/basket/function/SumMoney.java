package com.merck.uber.basket.function;

import java.util.function.BiFunction;

import com.merck.uber.basket.Money;

public class SumMoney implements BiFunction<Money, Money, Money> {

	private final Calculator calc;
	
	private SumMoney(final Calculator calc)
	{
		this.calc = calc;
	}
	
	public static final BiFunction<Money, Money, Money> newInstance(Calculator calc)
	{
		return new SumMoney(calc);
	}
	
	public Money apply(Money t, Money u) {
		// TODO Auto-generated method stub
		return null;
	}
}
