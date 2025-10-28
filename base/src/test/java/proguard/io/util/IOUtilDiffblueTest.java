package proguard.io.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class IOUtilDiffblueTest {
  /**
   * Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  public void testRead() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true).size());
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "**").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true));
    assertEquals(0,
        IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true, true).size());
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "**").toFile(), true, true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true, true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true, true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true, true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true, true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true, true));
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true, true));
    assertEquals(0,
        IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true, false).size());
    assertThrows(IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true, true));
    assertThrows(IOException.class, () -> IOUtil.read("foo.txt", true));
    assertThrows(IOException.class, () -> IOUtil.read(".apk", true));
    assertThrows(IOException.class, () -> IOUtil.read(".aab", true));
    assertThrows(IOException.class, () -> IOUtil.read(".jar", true));
    assertThrows(IOException.class, () -> IOUtil.read(".aar", true));
    assertThrows(IOException.class, () -> IOUtil.read(".war", true));
    assertThrows(IOException.class, () -> IOUtil.read(".ear", true));
    assertThrows(IOException.class, () -> IOUtil.read(".jmod", true));
    assertThrows(IOException.class, () -> IOUtil.read("foo.txt", true, true));
    assertThrows(IOException.class, () -> IOUtil.read(".apk", true, true));
    assertThrows(IOException.class, () -> IOUtil.read(".aab", true, true));
    assertThrows(IOException.class, () -> IOUtil.read(".jar", true, true));
    assertThrows(IOException.class, () -> IOUtil.read(".aar", true, true));
    assertThrows(IOException.class, () -> IOUtil.read(".war", true, true));
    assertThrows(IOException.class, () -> IOUtil.read(".ear", true, true));
    assertThrows(IOException.class, () -> IOUtil.read("foo.txt", true, false));
    assertThrows(IOException.class, () -> IOUtil.read(".jmod", true, true));
  }
}
