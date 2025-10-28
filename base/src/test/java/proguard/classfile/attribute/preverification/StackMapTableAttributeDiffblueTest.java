package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class StackMapTableAttributeDiffblueTest {
  /**
   * Method under test: {@link StackMapTableAttribute#StackMapTableAttribute()}
   */
  @Test
  public void testNewStackMapTableAttribute() {
    // Arrange and Act
    StackMapTableAttribute actualStackMapTableAttribute = new StackMapTableAttribute();

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link StackMapTableAttribute#StackMapTableAttribute(int, StackMapFrame[])}
   */
  @Test
  public void testNewStackMapTableAttribute2() {
    // Arrange and Act
    StackMapTableAttribute actualStackMapTableAttribute = new StackMapTableAttribute(3,
        new StackMapFrame[]{new FullFrame()});

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link StackMapTableAttribute#StackMapTableAttribute(StackMapFrame[])}
   */
  @Test
  public void testNewStackMapTableAttribute3() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act
    StackMapTableAttribute actualStackMapTableAttribute = new StackMapTableAttribute(new StackMapFrame[]{fullFrame});

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
    assertEquals(0, actualStackMapTableAttribute.u2attributeNameIndex);
    StackMapFrame[] stackMapFrameArray = actualStackMapTableAttribute.stackMapFrames;
    assertEquals(1, stackMapFrameArray.length);
    assertEquals(1, actualStackMapTableAttribute.u2stackMapFramesCount);
    assertSame(fullFrame, stackMapFrameArray[0]);
  }
}
