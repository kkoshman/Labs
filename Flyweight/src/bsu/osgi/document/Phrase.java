package bsu.osgi.document;

public class Phrase extends Glyph {
	protected String mPhrase;
	@Override
	public void draw(int xPos, int yPos) {
		Style usedStyle = getStyle();
		StringBuilder sb = new StringBuilder();
		sb.append("<phrase x=").append(xPos).append(",y=").append(yPos);
		sb.append(",").append(usedStyle.toString()).append(">");
		sb.append(mPhrase).append("</phrase>");
		System.out.println(sb.toString());
	}
	@Override
	public int getLength() {
		return mPhrase.length();
	}
}
