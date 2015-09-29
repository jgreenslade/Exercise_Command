package headfirst.command.simpleremote;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class LightTest {
	
	Light l;
	ByteOutputStream o;
	
	@Before
	public void setUp() throws Exception {
		l = new Light();
		System.setOut(new PrintStream(o = new ByteOutputStream()));
	}

	@After
	public void tearDown() throws Exception {
		l = null;
		o = null;
	}

	@Test
	public void testOff() {
		l.off();
		assertEquals("Light is off", o.toString().trim());
		
	}

	@Test
	public void testOn() {
		l.on();
		assertEquals(o.toString().trim(), "Light is on");
	}

}
