package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalVariableInfoDiffblueTest {
  /**
   * Test {@link LocalVariableInfo#LocalVariableInfo()}.
   *
   * <p>Method under test: {@link LocalVariableInfo#LocalVariableInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableInfo.<init>()",
    "void LocalVariableInfo.<init>(int, int, int, int, int)"
  })
  public void testNewLocalVariableInfo() {
    // Arrange and Act
    LocalVariableInfo actualLocalVariableInfo = new LocalVariableInfo();

    // Assert
    assertNull(actualLocalVariableInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableInfo#LocalVariableInfo(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#LocalVariableInfo(int, int, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableInfo.<init>()",
    "void LocalVariableInfo.<init>(int, int, int, int, int)"
  })
  public void testNewLocalVariableInfo_whenOne() {
    // Arrange and Act
    LocalVariableInfo actualLocalVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Assert
    assertNull(actualLocalVariableInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 1, 1, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo2() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 3, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo3() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 0, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo4() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 3, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo5() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 0, 1);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo6() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 3);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo7() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 0);

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo8() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo(1, 1, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Given {@link LocalVariableInfo#LocalVariableInfo()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo_givenLocalVariableInfo_thenReturnMinusOne() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo();

    // Act and Assert
    assertEquals(-1, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo_thenReturnZero() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(0, localVariableInfo.compareTo(new LocalVariableInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalVariableInfo#LocalVariableInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableInfo.compareTo(Object)"})
  public void testCompareTo_whenLocalVariableInfo() {
    // Arrange
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableInfo.compareTo(new LocalVariableInfo()));
  }
}
