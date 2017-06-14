package io.github.trulyfree.musicgen.mechanics.impl;

import static io.github.trulyfree.musicgen.mechanics.InvertedChord.Inversion.ROOT;
import static io.github.trulyfree.musicgen.mechanics.InvertedChord.Inversion.SECOND;
import static io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord.FIVE;
import static io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord.FOUR;
import static io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord.ONE;
import static io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord.SEVEN;
import static io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord.SIX;
import static io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord.TWO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import io.github.trulyfree.musicgen.mechanics.Cadence;
import io.github.trulyfree.musicgen.mechanics.Chord;
import io.github.trulyfree.musicgen.mechanics.Note;
import io.github.trulyfree.musicgen.mechanics.ScalarIndex;
import io.github.trulyfree.musicgen.mechanics.UnknownVoiceChord;
import io.github.trulyfree.musicgen.mechanics.VoicedChord;
import io.github.trulyfree.musicgen.mechanics.VoicedChordIterator;

public class VoicedChordIteratorImpl implements VoicedChordIterator {

	private static final List<List<UnknownVoiceChord>> appropriateFollowingChords = Collections
			.unmodifiableList(Arrays.asList(Collections.unmodifiableList(Arrays.asList(TWO, FOUR, FIVE, SIX)),
					Collections.unmodifiableList(Arrays.asList(FIVE, SEVEN)),
					Collections.unmodifiableList(Arrays.asList(new UnknownVoiceChord[0])),
					Collections.unmodifiableList(Arrays.asList(ONE, TWO, FIVE)),
					Collections.unmodifiableList(Arrays.asList(ONE, SIX)),
					Collections.unmodifiableList(Arrays.asList(TWO, FOUR, FIVE)),
					Collections.unmodifiableList(Arrays.asList(ONE))));

	private VoicedChord previous;
	private Stack<UnknownVoiceChord> forced = new Stack<>();

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public VoicedChord next() {
		if (forced.isEmpty()) {
			if (previous == null) {
				this.previous = new VoicedChordImpl(ScalarIndex.ONE, ROOT, new NoteImpl(ScalarIndex.ONE, 1),
						new NoteImpl(ScalarIndex.FIVE, 1), new NoteImpl(ScalarIndex.THREE, 2),
						new NoteImpl(ScalarIndex.ONE, 3));
			} else {
				this.previous = resolveVoices();
			}
		} else {

		}
		return this.previous;
	}

	private VoicedChord resolveVoices() {
		List<UnknownVoiceChord> possibleFollowingChords = appropriateFollowingChords.get(previous.getScalarIndex().ordinal());
		ScalarIndex target = possibleFollowingChords.get((int) (Math.random() * possibleFollowingChords.size())).getScalarIndex();
		Note bass = resolveBassFor(target);
		return null;
	}

	private Note resolveBassFor(ScalarIndex target) {
		
		return null;
	}

	@Override
	public boolean useCadence(Cadence cadence) {
		Chord[] progression = cadence.getProgression();
		for (int i = progression.length - 1; i >= 0; i--) {
			
		}
		return false;
	}

	@Override
	public Cadence[] possibleCadences() {
		switch (previous.getScalarIndex()) {
		case ONE:
			return new Cadence[] { new Cadence(FIVE), new Cadence(TWO, FIVE), new Cadence(FOUR, ONE),
					new Cadence(FOUR, SIX), new Cadence(SIX, FIVE), new Cadence(SIX, FOUR, ONE),
					new Cadence(SIX, FOUR, FIVE) };
		case TWO:
			return new Cadence[] { new Cadence(FIVE), new Cadence(FIVE, ONE), new Cadence(FIVE, SIX),
					new Cadence(ONE.withInversion(SECOND), FIVE, ONE.withInversion(ROOT)) };
		case THREE:
			return new Cadence[] { new Cadence(ONE), new Cadence(SIX), new Cadence(SIX, TWO, FIVE),
					new Cadence(SIX, TWO, FIVE, ONE) };
		case FOUR:
			return new Cadence[] { new Cadence(ONE), new Cadence(TWO, FIVE), new Cadence(TWO, FIVE, ONE),
					new Cadence(TWO, FIVE, SIX) };
		case FIVE:
			return new Cadence[] { new Cadence(ONE), new Cadence(SIX), new Cadence(ONE, FIVE),
					new Cadence(SIX, FOUR, ONE), new Cadence(SIX, FOUR, FIVE), new Cadence(SIX, FOUR, FIVE, ONE),
					new Cadence(SIX, FOUR, FIVE, SIX) };
		case SIX:
			return new Cadence[] { new Cadence(FIVE), new Cadence(TWO, FIVE), new Cadence(FOUR, FIVE),
					new Cadence(FOUR, ONE), new Cadence(FOUR, FIVE, ONE) };
		case SEVEN:
			return new Cadence[] { new Cadence(ONE) };
		default:
			return new Cadence[0];
		}
	}

}
