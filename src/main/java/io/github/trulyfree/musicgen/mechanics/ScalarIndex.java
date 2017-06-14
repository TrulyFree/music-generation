package io.github.trulyfree.musicgen.mechanics;

import lombok.NonNull;

public enum ScalarIndex {
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;

	public ScalarIndex getFromInterval(int interval) {
		return values()[(this.ordinal() + interval - 1) % values().length];
	}

	public static boolean isInterval(@NonNull ScalarIndex first, @NonNull ScalarIndex second, int interval) {
		return getInterval(first, second) == interval;
	}

	public static int getInterval(@NonNull ScalarIndex first, @NonNull ScalarIndex second) {
		int interval = second.ordinal() - first.ordinal();
		if (interval < 0) {
			interval += 8;
		} else if (interval >= 0) {
			interval++;
		}
		return interval;
	}
}
