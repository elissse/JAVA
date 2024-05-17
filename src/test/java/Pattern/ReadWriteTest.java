package Pattern;

import Patterns.ReadWrite;
import Patterns.SingletonObj;
import org.junit.Assert;
import org.junit.Test;

import java.io.Writer;

public class ReadWriteTest {
    @Test
    public void testSingletonness() {
        ReadWrite readWrite1 = ReadWrite.getInstance();
        ReadWrite readWrite2 = ReadWrite.getInstance();
        Assert.assertSame(readWrite2, readWrite1);
    }
    @Test
    public void testSingletonnessTwo() {
        Assert.assertTrue(ReadWrite.getInstance() == ReadWrite.getInstance());
    }
}
