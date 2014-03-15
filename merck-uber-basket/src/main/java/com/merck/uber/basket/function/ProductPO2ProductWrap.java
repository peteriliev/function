package com.merck.uber.basket.function;

import java.util.function.Function;

import com.merck.uber.basket.ProductPO;
import com.merck.uber.basket.ProductWrap;

public final class ProductPO2ProductWrap implements
		Function<ProductPO, ProductWrap> {

	private ProductPO2ProductWrap() {

	}

	public static final Function<ProductPO, ProductWrap> INSTANCE = new ProductPO2ProductWrap();

	public ProductWrap apply(final ProductPO t) {
		// TODO:peteri
		return null;
	}
}
