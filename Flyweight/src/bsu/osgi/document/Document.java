package bsu.osgi.document;

public class Document {
	public Glyph rootGlyph = new Glyph();
	//TODO edit function
	
	public void draw() {
		rootGlyph.draw(0, 0);
	}
}
