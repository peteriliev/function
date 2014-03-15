package com.merck.uber.basket.function;

import java.util.function.BiFunction;

import wrap.ERPWrap;
import wrap.ProductWrap;

import com.merck.uber.basket.Pair;

public final class OutputItemPlusERP2Pair implements
		BiFunction<ProductWrap, ERPWrap, Pair<ProductWrap, ERPWrap>> {

	private OutputItemPlusERP2Pair() {

	}

	public final static BiFunction<ProductWrap, ERPWrap, Pair<ProductWrap, ERPWrap>> INSTANCE = new OutputItemPlusERP2Pair();

	public Pair<ProductWrap, ERPWrap> apply(ProductWrap p, ERPWrap e) {
		return Pair.newInstance(p, e);
	}
}
