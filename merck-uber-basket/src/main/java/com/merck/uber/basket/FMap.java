package com.merck.uber.basket;

import java.util.function.BiFunction;

import com.merck.uber.basket.ListModule.List;

public class FMap {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T, U, R> List<R> pairUp(final List<T> listT,
			final List<U> listU, BiFunction<T, U, R> f) {

		final R head = f.apply(listT.head(), listU.head());

		final List<R> tail = pairUp(listT.tail(), listU.tail(), f);

		return new ListModule.NonEmptyList(head, tail);
	}
}
