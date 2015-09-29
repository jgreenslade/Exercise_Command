package headfirst.command.simpleremote;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class LightOnCommandTest {
	
	LightOnCommand l;
	ByteOutputStream o;
	
	@Before
	public void setUp() throws Exception {
		l = new LightOnCommand(new Light());
		System.setOut(new PrintStream(o = new ByteOutputStream()));
	}

	@After
	public void tearDown() throws Exception {
		l =null;
	}

	@Test
	public void testExecute() {
		l.execute();
		assertEquals(o.toString().trim(), "Light is on");
	}

}
