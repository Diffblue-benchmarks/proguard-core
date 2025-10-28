package proguard.examples;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;

public class JarUtilDiffblueTest {
  /**
   * Method under test: {@link JarUtil#readJar(String, String, boolean)}
   */
  @Test
  public void testReadJar() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", "Class Name Filter", true).size());
    assertEquals(0, JarUtil.readJar("foo.txt", "", true).size());
    assertEquals(0, JarUtil.readJar("foo.txt", "Class Name Filter", false).size());
    assertEquals(0, JarUtil.readJar("foo.txt", true).size());
    assertEquals(0, JarUtil.readJar("foo.txt", false).size());
  }
}
