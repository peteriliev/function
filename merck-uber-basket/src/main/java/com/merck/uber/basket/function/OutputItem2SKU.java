package com.merck.uber.basket.function;

import java.util.function.Function;

import com.merck.uber.basket.OutputItem;

public final class OutputItem2SKU implements Function<OutputItem, String> {

	private OutputItem2SKU() {

	}

	public static Function<OutputItem, String> INSTANCE = new OutputItem2SKU();

	// TODO:peteri - use Apache Commons
	public String apply(OutputItem t) {
		if (null == t) {
			return "";
		}
		return t.getSKU();
	}
}
