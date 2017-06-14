package io.github.trulyfree.musicgen.mechanics.impl;

import io.github.trulyfree.musicgen.mechanics.InvertedChord;
import io.github.trulyfree.musicgen.mechanics.Note;
import io.github.trulyfree.musicgen.mechanics.ScalarIndex;
import io.github.trulyfree.musicgen.mechanics.VoicedChord;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class VoicedChordImpl implements VoicedChord {

	private final @NonNull ScalarIndex scalarIndex;
	private @Setter @NonNull InvertedChord.Inversion inversion;
	private Note bass, tenor, alto, soprano;

	public VoicedChordImpl(ScalarIndex scalarIndex, InvertedChord.Inversion inversion, @NonNull Note... notes) {
		this.scalarIndex = scalarIndex;
		this.inversion = inversion;
		this.setNotes(notes);
	}

	public boolean setBass(@NonNull Note note) {
		if (!this.expects(note)) {
			return false;
		}
		boolean correctInversion;
		switch (inversion) {
		case ROOT:
			correctInversion = note.getScalarIndex().equals(this.getScalarIndex());
			break;
		case FIRST:
			correctInversion = ScalarIndex.isInterval(this.getScalarIndex(), note.getScalarIndex(), 3);
			break;
		case SECOND:
			correctInversion = ScalarIndex.isInterval(this.getScalarIndex(), note.getScalarIndex(), 5);
			break;
		case THIRD:
			correctInversion = ScalarIndex.isInterval(this.getScalarIndex(), note.getScalarIndex(), 7);
			break;
		default:
			return false;
		}
		if (!correctInversion) {
			return false;
		}
		this.bass = note;
		return true;
	}

	public boolean setTenor(@NonNull Note note) {
		if (!this.expects(note)) {
			return false;
		}
		this.tenor = note;
		return true;
	}

	public boolean setAlto(@NonNull Note note) {
		if (!this.expects(note)) {
			return false;
		}
		this.alto = note;
		return true;
	}

	public boolean setSoprano(@NonNull Note note) {
		if (!this.expects(note)) {
			return false;
		}
		this.soprano = note;
		return true;
	}

	public Note[] getNotes() {
		return new Note[] { bass, tenor, alto, soprano };
	}

	public boolean setNotes(@NonNull Note[] notes) {
		Note[] backup = getNotes();
		try {
			if (!(setBass(notes[0]) || setTenor(notes[1]) || setAlto(notes[2]) || setSoprano(notes[3]))) {
				this.bass = backup[0];
				this.tenor = backup[1];
				this.alto = backup[2];
				this.soprano = backup[3];
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return true;
	}

}
