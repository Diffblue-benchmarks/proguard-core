package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodHandleConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code MethodHandle(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#MethodHandleConstant()}
   *   <li>{@link MethodHandleConstant#toString()}
   *   <li>{@link MethodHandleConstant#getReferenceIndex()}
   *   <li>{@link MethodHandleConstant#getReferenceKind()}
   *   <li>{@link MethodHandleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodHandleConstant.<init>()",
    "void MethodHandleConstant.<init>(int, int)",
    "int MethodHandleConstant.getReferenceIndex()",
    "int MethodHandleConstant.getReferenceKind()",
    "boolean MethodHandleConstant.isCategory2()",
    "String MethodHandleConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsMethodHandle00() {
    // Arrange and Act
    MethodHandleConstant actualMethodHandleConstant = new MethodHandleConstant();
    String actualToStringResult = actualMethodHandleConstant.toString();
    int actualReferenceIndex = actualMethodHandleConstant.getReferenceIndex();
    int actualReferenceKind = actualMethodHandleConstant.getReferenceKind();
    boolean actualIsCategory2Result = actualMethodHandleConstant.isCategory2();

    // Assert
    assertEquals("MethodHandle(0,0)", actualToStringResult);
    assertNull(actualMethodHandleConstant.getProcessingInfo());
    assertEquals(0, actualReferenceIndex);
    assertEquals(0, actualReferenceKind);
    assertEquals(0, actualMethodHandleConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code MethodHandle(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#MethodHandleConstant(int, int)}
   *   <li>{@link MethodHandleConstant#toString()}
   *   <li>{@link MethodHandleConstant#getReferenceIndex()}
   *   <li>{@link MethodHandleConstant#getReferenceKind()}
   *   <li>{@link MethodHandleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodHandleConstant.<init>()",
    "void MethodHandleConstant.<init>(int, int)",
    "int MethodHandleConstant.getReferenceIndex()",
    "int MethodHandleConstant.getReferenceKind()",
    "boolean MethodHandleConstant.isCategory2()",
    "String MethodHandleConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsMethodHandle11() {
    // Arrange and Act
    MethodHandleConstant actualMethodHandleConstant = new MethodHandleConstant(1, 1);
    String actualToStringResult = actualMethodHandleConstant.toString();
    int actualReferenceIndex = actualMethodHandleConstant.getReferenceIndex();
    int actualReferenceKind = actualMethodHandleConstant.getReferenceKind();
    boolean actualIsCategory2Result = actualMethodHandleConstant.isCategory2();

    // Assert
    assertEquals("MethodHandle(1,1)", actualToStringResult);
    assertNull(actualMethodHandleConstant.getProcessingInfo());
    assertEquals(0, actualMethodHandleConstant.getProcessingFlags());
    assertEquals(1, actualReferenceIndex);
    assertEquals(1, actualReferenceKind);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link MethodHandleConstant#getTag()}.
   *
   * <p>Method under test: {@link MethodHandleConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MethodHandleConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHOD_HANDLE, (new MethodHandleConstant(1, 1)).getTag());
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}, and {@link MethodHandleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#equals(Object)}
   *   <li>{@link MethodHandleConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodHandleConstant.equals(Object)",
    "int MethodHandleConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);
    MethodHandleConstant methodHandleConstant2 = new MethodHandleConstant(1, 1);

    // Act and Assert
    assertEquals(methodHandleConstant, methodHandleConstant2);
    int expectedHashCodeResult = methodHandleConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodHandleConstant2.hashCode());
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}, and {@link MethodHandleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodHandleConstant#equals(Object)}
   *   <li>{@link MethodHandleConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodHandleConstant.equals(Object)",
    "int MethodHandleConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);

    // Act and Assert
    assertEquals(methodHandleConstant, methodHandleConstant);
    int expectedHashCodeResult = methodHandleConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodHandleConstant.hashCode());
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodHandleConstant.equals(Object)",
    "int MethodHandleConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(0, 1);

    // Act and Assert
    assertNotEquals(methodHandleConstant, new MethodHandleConstant(1, 1));
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodHandleConstant.equals(Object)",
    "int MethodHandleConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 0);

    // Act and Assert
    assertNotEquals(methodHandleConstant, new MethodHandleConstant(1, 1));
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodHandleConstant.equals(Object)",
    "int MethodHandleConstant.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandleConstant(1, 1), null);
  }

  /**
   * Test {@link MethodHandleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodHandleConstant.equals(Object)",
    "int MethodHandleConstant.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandleConstant(1, 1), "Different type to MethodHandleConstant");
  }
}
