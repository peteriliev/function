package com.merck.uber.basket.function;

import java.util.function.Function;

import wrap.ERPWrap;

import com.merck.uber.basket.OutputItem;

public final class OutputItem2ERPWrap implements Function<OutputItem, ERPWrap> {

	private OutputItem2ERPWrap() {
	}

	public static final Function<OutputItem, ERPWrap> INSTANCE = new OutputItem2ERPWrap();

	public ERPWrap apply(OutputItem t) {
		// TODO:peteri
		return null;
	}
}
