package io.github.trulyfree.musicgen.mechanics.impl;

import io.github.trulyfree.musicgen.mechanics.Note;
import io.github.trulyfree.musicgen.mechanics.ScalarIndex;
import lombok.Value;

public @Value class NoteImpl implements Note {

	ScalarIndex scalarIndex;
	int octave;

}
