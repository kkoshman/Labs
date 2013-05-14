package bsu.osgi.document;

//flyweight class
public class Phrase {
	
	protected String mPhrase;
	
	public Phrase() {
		mPhrase = "";
	}
	public Phrase(String pText) {
		mPhrase = pText;
	}
	public void draw(Style pStyle, int xPos, int yPos) {
		StringBuilder sb = new StringBuilder();
		sb.append("<phrase x=").append(xPos).append(",y=").append(yPos);
		sb.append(",").append(pStyle.toString()).append(">");
		sb.append(mPhrase).append("</phrase>");
		System.out.println(sb.toString());
	}
	
	public int getLength() {
		return mPhrase.length();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Phrase) {
			return mPhrase.equals(((Phrase)obj).mPhrase);
		} else if (obj instanceof String) {
			return mPhrase.equals((String)obj);
		} else {
			return false;
		}
	}
}
