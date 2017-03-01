import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTranslator {

	@Test
		public void testTranslator() {
			assertEquals("igpay",Main.translate("pig"));
			}
			
			@Test
			public void testTranslator2() {
			assertEquals("atinlay",Main.translate("latin"));
			}
			
			@Test
			public void testTranslator3() {
			assertEquals("anksthay",Main.translate("thanks"));
			}
			
			@Test
			public void testTranslator4() {
			assertEquals("ilesmay",Main.translate("smile"));
			}
			
			@Test
			public void testTranslator5() {
			assertEquals("OISTMAY",Main.translate("MOIST"));
			}
			
			@Test
			public void testTranslator6() {
			assertEquals("Ashtray",Main.translate("Trash"));
			}
			
			@Test
			public void testTranslator7() {
			assertEquals("AshTray",Main.translate("TrAsh"));
			}
			
	
			

    @Test
    public void testVowelSound() {
        assertEquals("eatway",Main.translate("eat"));
    }

    @Test
    public void testManyWords() {
        assertEquals("eatway igpay inway atinlay",Main.translateMany("eat pig in latin"));
    }

    @Test
    public void testManyWordsWithManySpace() {
        assertEquals("eatway  igpay   inway     atinlay",Main.translateMany("eat  pig   in     latin"));
    }
}


