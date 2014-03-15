package com.merck.uber.basket;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListModule {
	public static interface List<T> {

		public abstract T head();

		public abstract List<T> tail();

		public abstract boolean isEmpty();

		public List<T> filter(Predicate<T> p);

		public <R> List<R> map(Function<T, R> f);

		public <R, U> List<R> map(BiFunction<T, U, R> f, U u);

		// public <T2> T2 foldLeft (T2 seed, BiFunction<T, U, R> f);
		// public <T2> T2 foldRight (T2 seed, Function2<T,T2,T2> f);
		// public void foreach (Function1Void<T> f);
	}

	public static final class NonEmptyList<T> implements List<T> {

		public T head() {
			return _head;
		}

		public List<T> tail() {
			return _tail;
		}

		public boolean isEmpty() {
			return false;
		}

		protected NonEmptyList(final T head, final List<T> tail) {
			this._head = head;
			this._tail = tail;
		}

		private final T _head;
		private final List<T> _tail;

		public List<T> filter(Predicate<T> p) {
			if (p.test(head())) {
				return list(head(), tail().filter(p));
			} else {
				return tail().filter(p);
			}
		}

		public <R> List<R> map(final Function<T, R> f) {
			return list(f.apply(head()), tail().map(f));
		}

		public <R, U> List<R> map(final BiFunction<T, U, R> f, final U u) {
			return list(f.apply(head(), u), tail().map(f, u));
		}

		/*
		 * public <T2> T2 foldLeft (T2 seed, Function2<T2,T,T2> f) { return
		 * tail().foldLeft(f.apply(seed, head()), f); // #8 }
		 * 
		 * public <T2> T2 foldRight (T2 seed, Function2<T,T2,T2> f) { return
		 * f.apply(head(), tail().foldRight(seed, f)); // #10 }
		 * 
		 * public void foreach (Function1Void<T> f) { f.apply(head()); // #11
		 * tail().foreach(f); }
		 */
		@Override
		public boolean equals(Object other) {
			if (other == null || getClass() != other.getClass())
				return false;
			List<?> that = (List<?>) other;
			return head().equals(that.head()) && tail().equals(that.tail());
		}

		@Override
		public int hashCode() {
			return 37 * (head().hashCode() + tail().hashCode());
		}

		@Override
		public String toString() {
			return "(" + head() + ", " + tail() + ")";
		}
	}

	public static class EmptyListHasNoHead extends RuntimeException {

		private static final long serialVersionUID = 1L;
	}

	public static class EmptyListHasNoTail extends RuntimeException {

		private static final long serialVersionUID = 1L;
	}

	public static final List<? extends Object> EMPTY = new List<Object>() {

		public Object head() {
			throw new EmptyListHasNoHead();
		}

		public List<Object> tail() {
			throw new EmptyListHasNoTail();
		}

		public boolean isEmpty() {
			return true;
		}

		/*
		 * public <T2> T2 foldLeft (T2 seed, Function2<T2,Object,T2> f) { return
		 * seed; } public <T2> T2 foldRight (T2 seed, Function2<Object,T2,T2> f)
		 * { return seed; }
		 * 
		 * public void foreach (Function1Void<Object> f) {}
		 */
		@Override
		public String toString() {
			return "()";
		}

		public List<Object> filter(Predicate<Object> p) {
			return this;
		}

		public <R> List<R> map(Function<Object, R> f) {
			return emptyList();
		}

		public <R, U> List<R> map(BiFunction<Object, U, R> f, final U u) {
			return emptyList();
		}
	};

	/* See the text for an explanation of this code */
	@SuppressWarnings(value = "unchecked")
	public static <T> List<T> emptyList() {
		return (List<T>) EMPTY; // Dangerous!?
	}

	public static <T> List<T> list(T head, List<T> tail) {
		return new NonEmptyList<T>(head, tail);
	}
}
