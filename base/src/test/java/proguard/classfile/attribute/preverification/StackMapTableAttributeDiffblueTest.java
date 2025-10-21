package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StackMapTableAttributeDiffblueTest {
  /**
   * Test {@link StackMapTableAttribute#StackMapTableAttribute()}.
   *
   * <p>Method under test: {@link StackMapTableAttribute#StackMapTableAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapTableAttribute.<init>()",
    "void StackMapTableAttribute.<init>(int, StackMapFrame[])"
  })
  public void testNewStackMapTableAttribute() {
    // Arrange and Act
    StackMapTableAttribute actualStackMapTableAttribute = new StackMapTableAttribute();

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link StackMapTableAttribute#StackMapTableAttribute(StackMapFrame[])}.
   *
   * <p>Method under test: {@link StackMapTableAttribute#StackMapTableAttribute(StackMapFrame[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StackMapTableAttribute.<init>(StackMapFrame[])"})
  public void testNewStackMapTableAttribute2() {
    // Arrange
    FullFrame fullFrame = new FullFrame();

    // Act
    StackMapTableAttribute actualStackMapTableAttribute =
        new StackMapTableAttribute(new StackMapFrame[] {fullFrame});

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
    assertEquals(0, actualStackMapTableAttribute.u2attributeNameIndex);
    StackMapFrame[] stackMapFrameArray = actualStackMapTableAttribute.stackMapFrames;
    assertEquals(1, stackMapFrameArray.length);
    assertEquals(1, actualStackMapTableAttribute.u2stackMapFramesCount);
    assertSame(fullFrame, stackMapFrameArray[0]);
  }

  /**
   * Test {@link StackMapTableAttribute#StackMapTableAttribute(int, StackMapFrame[])}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link StackMapTableAttribute#StackMapTableAttribute(int,
   * StackMapFrame[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StackMapTableAttribute.<init>()",
    "void StackMapTableAttribute.<init>(int, StackMapFrame[])"
  })
  public void testNewStackMapTableAttribute_whenThree() {
    // Arrange and Act
    StackMapTableAttribute actualStackMapTableAttribute =
        new StackMapTableAttribute(3, new StackMapFrame[] {new FullFrame()});

    // Assert
    assertNull(actualStackMapTableAttribute.getProcessingInfo());
    assertEquals(0, actualStackMapTableAttribute.getProcessingFlags());
  }
}
