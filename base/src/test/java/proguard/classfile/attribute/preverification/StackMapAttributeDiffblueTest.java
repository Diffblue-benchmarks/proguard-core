package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StackMapAttributeDiffblueTest {
  /**
   * Test {@link StackMapAttribute#StackMapAttribute()}.
   *
   * <p>Method under test: {@link StackMapAttribute#StackMapAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapAttribute.<init>()",
    "void StackMapAttribute.<init>(int, FullFrame[])"
  })
  public void testNewStackMapAttribute() {
    // Arrange and Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute();

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
  }

  /**
   * Test {@link StackMapAttribute#StackMapAttribute(FullFrame[])}.
   *
   * <p>Method under test: {@link StackMapAttribute#StackMapAttribute(FullFrame[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StackMapAttribute.<init>(FullFrame[])"})
  public void testNewStackMapAttribute2() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act
    StackMapAttribute actualStackMapAttribute = new StackMapAttribute(new FullFrame[] {fullFrame});

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
    assertEquals(0, actualStackMapAttribute.u2attributeNameIndex);
    FullFrame[] fullFrameArray = actualStackMapAttribute.stackMapFrames;
    assertEquals(1, fullFrameArray.length);
    assertEquals(1, actualStackMapAttribute.u2stackMapFramesCount);
    assertSame(fullFrame, fullFrameArray[0]);
  }

  /**
   * Test {@link StackMapAttribute#StackMapAttribute(int, FullFrame[])}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link StackMapAttribute#StackMapAttribute(int, FullFrame[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapAttribute.<init>()",
    "void StackMapAttribute.<init>(int, FullFrame[])"
  })
  public void testNewStackMapAttribute_whenThree() {
    // Arrange and Act
    StackMapAttribute actualStackMapAttribute =
        new StackMapAttribute(3, new FullFrame[] {new FullFrame()});

    // Assert
    assertNull(actualStackMapAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapAttribute.getProcessingFlags());
  }
}
