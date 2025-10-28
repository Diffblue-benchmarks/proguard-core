package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ExtendedLineNumberInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtendedLineNumberInfo#ExtendedLineNumberInfo()}
   *   <li>{@link ExtendedLineNumberInfo#getSource()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new ExtendedLineNumberInfo()).getSource());
    assertEquals("Source", (new ExtendedLineNumberInfo(1, 2, "Source")).getSource());
  }
}
