package bsu.osgi.document;

public abstract class Glyph {
	protected Glyph[] childGliphs;
	protected Glyph parentGliph = null;
	protected Style style;
	
	
	public Style getStyle() {
		Style result = style;
		if (result == null && parentGliph != null) {
			result = parentGliph.getStyle();
		}
		return result;
	}
	
	public Glyph getParent() {
		return parentGliph;
	}
	public int getLength() {
		int length = 0;
		if (childGliphs != null) {
			for (Glyph gliph : childGliphs) {
				if (gliph != null) {
					length += gliph.getLength();
				}
			}
		}
		return length;
	}
	
	public void draw(int xPos, int yPos) {
		//Style usedStyle = getStyle();
		//draw
	}
}
