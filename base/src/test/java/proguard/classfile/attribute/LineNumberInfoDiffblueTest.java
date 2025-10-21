package proguard.classfile.attribute;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LineNumberInfoDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LineNumberInfo.<init>()",
    "void LineNumberInfo.<init>(int, int)",
    "java.lang.String LineNumberInfo.getSource()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new LineNumberInfo()).getSource());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LineNumberInfo.<init>()",
    "void LineNumberInfo.<init>(int, int)",
    "java.lang.String LineNumberInfo.getSource()"
  })
  public void testGettersAndSetters_whenOne() {
    // Arrange, Act and Assert
    assertNull((new LineNumberInfo(1, 2)).getSource());
  }
}
