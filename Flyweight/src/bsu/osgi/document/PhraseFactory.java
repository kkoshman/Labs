package bsu.osgi.document;

import java.util.HashMap;
import java.util.Map;

public class PhraseFactory {
	protected Map<String, Phrase> mBigDictionary = new HashMap<String, Phrase>();
	
	public Phrase getPhrase(String pText) {
		if (pText == null) {
			pText = "";
		}
		Phrase phrase = mBigDictionary.get(pText);
		if (phrase == null) {
			phrase = new Phrase(pText);
			mBigDictionary.put(pText, phrase);
		}
		return phrase;
	}
}
