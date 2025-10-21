package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocalVariableTypeInfoDiffblueTest {
  /**
   * Test {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTypeInfo.<init>()",
    "void LocalVariableTypeInfo.<init>(int, int, int, int, int)"
  })
  public void testNewLocalVariableTypeInfo() {
    // Arrange and Act
    LocalVariableTypeInfo actualLocalVariableTypeInfo = new LocalVariableTypeInfo();

    // Assert
    assertNull(actualLocalVariableTypeInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeInfo#LocalVariableTypeInfo(int, int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#LocalVariableTypeInfo(int, int, int, int,
   * int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTypeInfo.<init>()",
    "void LocalVariableTypeInfo.<init>(int, int, int, int, int)"
  })
  public void testNewLocalVariableTypeInfo_whenOne() {
    // Arrange and Act
    LocalVariableTypeInfo actualLocalVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Assert
    assertNull(actualLocalVariableTypeInfo.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeInfo.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 1, 1, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo2() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 3, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo3() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 0, 1, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo4() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 3, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo5() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 0, 1);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo6() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 3);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo7() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 0);

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo8() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 1, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Given {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo_givenLocalVariableTypeInfo_thenReturnMinusOne() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo();

    // Act and Assert
    assertEquals(-1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo_thenReturnZero() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(0, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo(1, 3, 1, 1, 1)));
  }

  /**
   * Test {@link LocalVariableTypeInfo#compareTo(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalVariableTypeInfo#LocalVariableTypeInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTypeInfo#compareTo(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LocalVariableTypeInfo.compareTo(Object)"})
  public void testCompareTo_whenLocalVariableTypeInfo() {
    // Arrange
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act and Assert
    assertEquals(1, localVariableTypeInfo.compareTo(new LocalVariableTypeInfo()));
  }
}
