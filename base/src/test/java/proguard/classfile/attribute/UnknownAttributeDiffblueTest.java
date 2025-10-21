package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnknownAttributeDiffblueTest {
  /**
   * Test {@link UnknownAttribute#UnknownAttribute(int, int, byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#UnknownAttribute(int, int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownAttribute.<init>(int, int)",
    "void UnknownAttribute.<init>(int, int, byte[])"
  })
  public void testNewUnknownAttribute_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    UnknownAttribute actualUnknownAttribute =
        new UnknownAttribute(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualUnknownAttribute.getProcessingInfo());
    assertEquals(0, actualUnknownAttribute.getProcessingFlags());
  }

  /**
   * Test {@link UnknownAttribute#UnknownAttribute(int, int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link UnknownAttribute#UnknownAttribute(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownAttribute.<init>(int, int)",
    "void UnknownAttribute.<init>(int, int, byte[])"
  })
  public void testNewUnknownAttribute_whenThree() {
    // Arrange and Act
    UnknownAttribute actualUnknownAttribute = new UnknownAttribute(1, 3);

    // Assert
    assertNull(actualUnknownAttribute.getProcessingInfo());
    assertEquals(0, actualUnknownAttribute.getProcessingFlags());
  }
}
