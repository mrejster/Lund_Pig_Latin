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
		}
			
			