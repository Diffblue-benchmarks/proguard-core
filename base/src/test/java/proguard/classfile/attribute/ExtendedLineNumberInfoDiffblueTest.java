package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExtendedLineNumberInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Source is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtendedLineNumberInfo#ExtendedLineNumberInfo()}
   *   <li>{@link ExtendedLineNumberInfo#getSource()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExtendedLineNumberInfo.<init>()",
    "void ExtendedLineNumberInfo.<init>(int, int, String)",
    "String ExtendedLineNumberInfo.getSource()"
  })
  public void testGettersAndSetters_thenReturnSourceIsNull() {
    // Arrange, Act and Assert
    assertNull((new ExtendedLineNumberInfo()).getSource());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtendedLineNumberInfo#ExtendedLineNumberInfo(int, int, String)}
   *   <li>{@link ExtendedLineNumberInfo#getSource()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExtendedLineNumberInfo.<init>()",
    "void ExtendedLineNumberInfo.<init>(int, int, String)",
    "String ExtendedLineNumberInfo.getSource()"
  })
  public void testGettersAndSetters_whenOne_thenReturnSource() {
    // Arrange, Act and Assert
    assertEquals("Source", (new ExtendedLineNumberInfo(1, 2, "Source")).getSource());
  }
}
