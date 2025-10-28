package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TypePathInfoDiffblueTest {
  /**
   * Method under test: {@link TypePathInfo#TypePathInfo()}
   */
  @Test
  public void testNewTypePathInfo() {
    // Arrange and Act
    TypePathInfo actualTypePathInfo = new TypePathInfo();

    // Assert
    assertEquals(0, actualTypePathInfo.u1typeArgumentIndex);
    assertEquals(0, actualTypePathInfo.u1typePathKind);
  }

  /**
   * Method under test: {@link TypePathInfo#TypePathInfo(int, int)}
   */
  @Test
  public void testNewTypePathInfo2() {
    // Arrange and Act
    TypePathInfo actualTypePathInfo = new TypePathInfo(1, 1);

    // Assert
    assertEquals(1, actualTypePathInfo.u1typeArgumentIndex);
    assertEquals(1, actualTypePathInfo.u1typePathKind);
  }
}
