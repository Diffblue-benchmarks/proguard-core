package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class StackMapAttributeDiffblueTest {
  /**
   * Method under test: {@link StackMapAttribute#StackMapAttribute()}
   */
  @Test
  public void testNewStackMapAttribute() {
    // Arrange and Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute();

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link StackMapAttribute#StackMapAttribute(int, FullFrame[])}
   */
  @Test
  public void testNewStackMapAttribute2() {
    // Arrange and Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute(3, new FullFrame[]{new FullFrame()});

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link StackMapAttribute#StackMapAttribute(FullFrame[])}
   */
  @Test
  public void testNewStackMapAttribute3() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute(new FullFrame[]{fullFrame});

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
    assertEquals(0, actualStackMapAttribute.u2attributeNameIndex);
    FullFrame[] fullFrameArray = actualStackMapAttribute.stackMapFrames;
    assertEquals(1, fullFrameArray.length);
    assertEquals(1, actualStackMapAttribute.u2stackMapFramesCount);
    assertSame(fullFrame, fullFrameArray[0]);
  }
}
