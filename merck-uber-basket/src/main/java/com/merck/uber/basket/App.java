package com.merck.uber.basket;

import com.merck.uber.basket.ListModule.List;
import com.merck.uber.basket.function.Many2UberPLI;
import com.merck.uber.basket.function.OutputItem2ERPWrap;
import com.merck.uber.basket.function.OutputItem2SKU;
import com.merck.uber.basket.function.ProductPO2ProductWrap;
import com.merck.uber.basket.function.ProductPOStore;
import com.merck.uber.basket.function.SKU2ProductPO;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	// TODO:peteri - inject
	private ProductPOStore poStore;

	List<UberPLI> buildUbserPLIs(final List<OutputItem> erpOutput, final RequestWrap request, final ChannelWrap channel, final UserWrap user) {

		final List<String> skus = erpOutput.map(OutputItem2SKU.INSTANCE);

		final List<ProductPO> productPOs = skus.map(SKU2ProductPO.getInstance(poStore));

		final List<ProductWrap> productWraps = productPOs.map(ProductPO2ProductWrap.INSTANCE);

		final List<ERPWrap> erpWraps = erpOutput.map(OutputItem2ERPWrap.INSTANCE);

		final List<UberPLI> uberPLIs = erpWraps.map(Many2UberPLI.INSTANCE,
				new Object[] { productWraps, request, channel, user });

		return uberPLIs;
	}
}
