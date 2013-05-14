package bsu.osgi.document.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bsu.osgi.document.Document;
import bsu.osgi.document.Glyph;
import bsu.osgi.document.PhraseFactory;
import bsu.osgi.document.Style;

public class TestFlyweight {

	@Test
	public void test() {
		Document doc = new Document();
		PhraseFactory phraseFactory = new PhraseFactory();
		
		Style st1 = new Style(0,20,0,false,false);
		Glyph g1 = new Glyph(doc.rootGlyph);
		Glyph g11 = new Glyph(g1);
		Glyph g12 = new Glyph(g1);
		g11.phrase = phraseFactory.getPhrase("Вот дом.\n");
		g12.phrase = phraseFactory.getPhrase("Который построил Джек.\n");
		g1.style = st1;

		Style st2 = new Style(0,16,0,false,false);
		Glyph g2 = new Glyph(doc.rootGlyph);
		Glyph g21 = new Glyph(g2);
		Glyph g22 = new Glyph(g2);
		Glyph g23 = new Glyph(g2);
		Glyph g24 = new Glyph(g2);
		g21.phrase = phraseFactory.getPhrase("А это пшеница.\n");
		g22.phrase = phraseFactory.getPhrase("Которая в тёмном чулане хранится\n");
		g23.phrase = phraseFactory.getPhrase("В доме,\n");
		g24.phrase = phraseFactory.getPhrase("Который построил Джек.\n");
		g2.style = st2;
		
		Style st3 = new Style(0,12,0,false,false);
		Glyph g3 = new Glyph(doc.rootGlyph);
		Glyph g31 = new Glyph(g3);
		Glyph g32 = new Glyph(g3);
		Glyph g33 = new Glyph(g3);
		Glyph g34 = new Glyph(g3);
		Glyph g35 = new Glyph(g3);
		g31.phrase = phraseFactory.getPhrase("А это весёлая птица-синица,\n");
		g32.phrase = phraseFactory.getPhrase("Которая ловко ворует пшеницу,\n");
		g33.phrase = phraseFactory.getPhrase("Которая в тёмном чулане хранится\n");
		g34.phrase = phraseFactory.getPhrase("В доме,\n");
		g35.phrase = phraseFactory.getPhrase("Который построил Джек.\n");
		g3.style = st3;
		
		doc.draw();
		
		assertTrue( (g12.phrase == g24.phrase) && (g24.phrase == g35.phrase) );
		assertFalse(g12.phrase == g11.phrase);
	}

}
