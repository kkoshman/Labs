package bsu.osgi.document;

public class Style {
	public int font;
	public int size;
	public int color;
	public boolean bold;
	public boolean italic;
	
	public Style() {}
	public Style(int pFont, int pSize, int pColor, boolean pBold, boolean pItalic) {
		font = pFont;
		size = pSize;
		color = pColor;
		bold = pBold;
		italic = pItalic;
	}
	@Override
	public String toString() {
		return "Style [font=" + font + ", size=" + size + ", color=" + color + ", bold=" + bold
				+ ", italic=" + italic + "]";
	}
}
