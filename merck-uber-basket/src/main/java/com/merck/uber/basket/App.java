package com.merck.uber.basket;

import wrap.ChannelWrap;
import wrap.ERPWrap;
import wrap.ProductWrap;
import wrap.RequestWrap;
import wrap.UserWrap;

import com.merck.uber.basket.ListModule.List;
import com.merck.uber.basket.function.OutputItem2ERPWrap;
import com.merck.uber.basket.function.OutputItem2SKU;
import com.merck.uber.basket.function.OutputItemPlusERP2Pair;
import com.merck.uber.basket.function.PairPlus2UberPLI;
import com.merck.uber.basket.function.ProductPO2ProductWrap;
import com.merck.uber.basket.function.SKU2ProductPO;
import com.merck.uber.basket.function.SumUberPLIs;
import com.merck.uber.basket.predicate.IsMerckPLI;
import com.merck.uber.basket.predicate.IsMilliPLI;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	// TODO:peteri - inject
	private ProductPOStore poStore;

	List<UberPLI> buildUberPLIs(final List<OutputItem> erpOutput,
			final RequestWrap request, final ChannelWrap channel,
			final UserWrap user) {

		final List<String> skus = erpOutput.map(OutputItem2SKU.INSTANCE);

		final List<ProductPO> productPOs = skus.map(SKU2ProductPO
				.getInstance(poStore));

		final List<ProductWrap> productWraps = productPOs
				.map(ProductPO2ProductWrap.INSTANCE);

		final List<ERPWrap> erpWraps = erpOutput
				.map(OutputItem2ERPWrap.INSTANCE);

		final List<Pair<ProductWrap, ERPWrap>> pairs = FMap.pairUp(
				productWraps, erpWraps, OutputItemPlusERP2Pair.INSTANCE);

		final List<UberPLI> uberPLIs = pairs.map(PairPlus2UberPLI.INSTANCE,
				new Object[] { request, channel, user });

		return uberPLIs;
	}
	
	void buildJSON(final List<UberPLI> uberPLIs)
	{
		final List<UberPLI> merckPLIs = uberPLIs.filter(IsMerckPLI.INSTANCE);
		final Money merckPLIsTotal = merckPLIs.foldLeft(Money.ZERO, SumUberPLIs.INSTANCE);

		final List<UberPLI> milliPLIs = uberPLIs.filter(IsMilliPLI.INSTANCE);
		final Money milliPLIsTotal = milliPLIs.foldLeft(Money.ZERO, SumUberPLIs.INSTANCE);
		
		
		
		
	}
}