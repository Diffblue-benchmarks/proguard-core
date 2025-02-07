package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExtendedLineNumberInfoDiffblueTest {
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
  @DisplayName("Test getters and setters; then return Source is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ExtendedLineNumberInfo.<init>()",
    "void proguard.classfile.attribute.ExtendedLineNumberInfo.<init>(int, int, java.lang.String)",
    "java.lang.String proguard.classfile.attribute.ExtendedLineNumberInfo.getSource()"
  })
  void testGettersAndSetters_thenReturnSourceIsNull() {
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
  @DisplayName("Test getters and setters; when one; then return 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.ExtendedLineNumberInfo.<init>()",
    "void proguard.classfile.attribute.ExtendedLineNumberInfo.<init>(int, int, java.lang.String)",
    "java.lang.String proguard.classfile.attribute.ExtendedLineNumberInfo.getSource()"
  })
  void testGettersAndSetters_whenOne_thenReturnSource() {
    // Arrange, Act and Assert
    assertEquals("Source", (new ExtendedLineNumberInfo(1, 2, "Source")).getSource());
  }
}
