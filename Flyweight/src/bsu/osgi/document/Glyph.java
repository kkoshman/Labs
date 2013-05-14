package bsu.osgi.document;

import java.util.LinkedList;
import java.util.List;

public class Glyph {
	public List<Glyph> childGliphs = new LinkedList<Glyph>();
	public Phrase phrase;
	public Glyph parentGlyph = null;
	public Style style;
	
	public Glyph() {}
	public Glyph(Glyph pParentGlyph) {
		setParent(pParentGlyph);
	}
	
	public Style getStyle() {
		Style result = style;
		if (result == null && parentGlyph != null) {
			result = parentGlyph.getStyle();
		}
		return result;
	}
	
	public Glyph getParent() {
		return parentGlyph;
	}
	public void setParent(Glyph pParentGlyph) {
		if (parentGlyph != null) {
			parentGlyph.childGliphs.remove(this);
		}
		parentGlyph = pParentGlyph;
		if (pParentGlyph != null) {
			pParentGlyph.childGliphs.add(this);
		}
	}
	public int getLength() {
		int length = 0;
		for (Glyph gliph : childGliphs) {
			if (gliph != null) {
				length += gliph.getLength();
			}
		}
		if (phrase != null) {
			length += phrase.getLength();
		}
		return length;
	}
	
	public void draw(int xPos, int yPos) {
		for (Glyph child : childGliphs) {
			child.draw(xPos, yPos);
			xPos += child.getLength();
		}
		if (phrase != null) {
			phrase.draw(getStyle(), xPos, yPos);
		}
	}
}
