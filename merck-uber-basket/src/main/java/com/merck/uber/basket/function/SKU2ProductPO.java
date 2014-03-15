package com.merck.uber.basket.function;

import java.util.function.Function;

import com.merck.uber.basket.ProductPO;
import com.merck.uber.basket.ProductPOStore;

public class SKU2ProductPO implements Function<String, ProductPO> {

	private SKU2ProductPO(ProductPOStore store) {
		this.store = store;
	}

	private final ProductPOStore store;

	public static Function<String, ProductPO> getInstance(
			final ProductPOStore store) {
		return new SKU2ProductPO(store);
	}

	public ProductPO apply(String t) {
		return store.getProductBySKU(t);
	}
}
