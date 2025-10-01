package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LineNumberInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LineNumberInfo#LineNumberInfo()}
   *   <li>{@link LineNumberInfo#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberInfo.<init>()",
    "void LineNumberInfo.<init>(int, int)",
    "java.lang.String LineNumberInfo.getSource()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new LineNumberInfo().getSource());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LineNumberInfo#LineNumberInfo(int, int)}
   *   <li>{@link LineNumberInfo#getSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberInfo.<init>()",
    "void LineNumberInfo.<init>(int, int)",
    "java.lang.String LineNumberInfo.getSource()"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange, Act and Assert
    assertNull(new LineNumberInfo(1, 2).getSource());
  }
}
