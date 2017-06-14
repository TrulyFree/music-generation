package io.github.trulyfree.musicgen.mechanics;

import io.github.trulyfree.musicgen.mechanics.InvertedChord.Inversion;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum UnknownVoiceChord implements Chord {
	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;

	private final ScalarIndex scalarIndex;

	private UnknownVoiceChord() {
		this.scalarIndex = ScalarIndex.values()[this.ordinal()];
	}
	
	public UnknownVoiceChordWithInversion withInversion(Inversion inversion) {
		return new UnknownVoiceChordWithInversion(this, inversion);
	}

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Getter
	public static class UnknownVoiceChordWithInversion implements InvertedChord {
		private final UnknownVoiceChord base;
		private final Inversion inversion;

		@Override
		public ScalarIndex getScalarIndex() {
			return base.getScalarIndex();
		}
	}
}
