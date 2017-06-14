package io.github.trulyfree.musicgen.mechanics;

import lombok.Getter;

public class Cadence {
	private final @Getter Chord[] progression;

	public Cadence(Chord... progression) {
		this.progression = progression;
	}
}
