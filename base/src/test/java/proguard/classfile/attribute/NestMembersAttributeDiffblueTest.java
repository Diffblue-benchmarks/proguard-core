package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class NestMembersAttributeDiffblueTest {
  /**
   * Method under test: {@link NestMembersAttribute#NestMembersAttribute()}
   */
  @Test
  public void testNewNestMembersAttribute() {
    // Arrange and Act
    NestMembersAttribute actualNestMembersAttribute = new NestMembersAttribute();

    // Assert
    assertNull(actualNestMembersAttribute.getProcessingInfo());
    assertEquals(0, actualNestMembersAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link NestMembersAttribute#NestMembersAttribute(int, int, int[])}
   */
  @Test
  public void testNewNestMembersAttribute2() {
    // Arrange and Act
    NestMembersAttribute actualNestMembersAttribute = new NestMembersAttribute(1, 3, new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualNestMembersAttribute.getProcessingInfo());
    assertEquals(0, actualNestMembersAttribute.getProcessingFlags());
  }
}
