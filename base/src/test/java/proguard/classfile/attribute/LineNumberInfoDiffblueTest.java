package proguard.classfile.attribute;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LineNumberInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LineNumberInfo#LineNumberInfo()}
   *   <li>{@link LineNumberInfo#getSource()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new LineNumberInfo()).getSource());
    assertNull((new LineNumberInfo(1, 2)).getSource());
  }
}
