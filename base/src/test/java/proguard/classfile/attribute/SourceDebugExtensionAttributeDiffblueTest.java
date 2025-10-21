package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SourceDebugExtensionAttributeDiffblueTest {
  /**
   * Test {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute()}.
   *
   * <p>Method under test: {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SourceDebugExtensionAttribute.<init>()",
    "void SourceDebugExtensionAttribute.<init>(int, int, byte[])"
  })
  public void testNewSourceDebugExtensionAttribute() {
    // Arrange and Act
    SourceDebugExtensionAttribute actualSourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute();

    // Assert
    assertNull(actualSourceDebugExtensionAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDebugExtensionAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute(int, int, byte[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute(int,
   * int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SourceDebugExtensionAttribute.<init>()",
    "void SourceDebugExtensionAttribute.<init>(int, int, byte[])"
  })
  public void testNewSourceDebugExtensionAttribute_whenOne() throws UnsupportedEncodingException {
    // Arrange and Act
    SourceDebugExtensionAttribute actualSourceDebugExtensionAttribute =
        new SourceDebugExtensionAttribute(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualSourceDebugExtensionAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDebugExtensionAttribute.getProcessingFlags());
  }
}
