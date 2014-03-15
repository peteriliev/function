package com.merck.uber.basket;

public class Pair<T, U> {

	private final T t;
	private final U u;

	// TODO:peteri - make immutable
	private Pair(final T t, final U u) {
		this.t = t;
		this.u = u;
	}

	public static <T, U> Pair<T, U> newInstance(final T t, final U u) {
		return new Pair<T, U>(t, u);
	}

	public T getKey() {
		return t;
	}

	public U getValue() {
		return u;
	}
}
