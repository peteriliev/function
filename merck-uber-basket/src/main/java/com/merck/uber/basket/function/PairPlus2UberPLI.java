package com.merck.uber.basket.function;

import java.util.function.BiFunction;

import wrap.ChannelWrap;
import wrap.ERPWrap;
import wrap.ProductWrap;
import wrap.RequestWrap;
import wrap.UserWrap;

import com.merck.uber.basket.Pair;
import com.merck.uber.basket.UberPLI;

public final class PairPlus2UberPLI implements BiFunction<Pair<ProductWrap, ERPWrap>, Object[], UberPLI> {

	private PairPlus2UberPLI()
	{
		
	}
	
	public static final BiFunction<Pair<ProductWrap, ERPWrap>, Object[], UberPLI> INSTANCE = new PairPlus2UberPLI();
	
	public UberPLI apply(final Pair<ProductWrap, ERPWrap> t, final Object[] u) {
		// TODO:peteri - verify
		final RequestWrap request = (RequestWrap) u[0];
		final ChannelWrap channel = (ChannelWrap) u[1];
		final UserWrap user = (UserWrap) u[2];
		
		// TODO:peteri - user resolvers to build the UberPLI
		return null;
	}
}
