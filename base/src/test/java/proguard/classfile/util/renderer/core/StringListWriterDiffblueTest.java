package proguard.classfile.util.renderer.core;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StringListWriterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringListWriter#StringListWriter(List)}
   *   <li>{@link StringListWriter#getOutput()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> output = new ArrayList<>();

    // Act
    List<String> actualOutput = (new StringListWriter(output)).getOutput();

    // Assert
    assertTrue(actualOutput.isEmpty());
    assertSame(output, actualOutput);
  }
}
