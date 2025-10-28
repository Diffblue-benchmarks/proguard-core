package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MethodHandleConstantDiffblueTest {
  /**
   * Method under test: {@link MethodHandleConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHOD_HANDLE, (new MethodHandleConstant(1, 1)).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandleConstant#equals(Object)}
   *   <li>{@link MethodHandleConstant#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandleConstant#equals(Object)}
   *   <li>{@link MethodHandleConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 1);

    // Act and Assert
    assertEquals(methodHandleConstant, methodHandleConstant);
    int expectedHashCodeResult = methodHandleConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodHandleConstant.hashCode());
  }

  /**
   * Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(0, 1);

    // Act and Assert
    assertNotEquals(methodHandleConstant, new MethodHandleConstant(1, 1));
  }

  /**
   * Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodHandleConstant methodHandleConstant = new MethodHandleConstant(1, 0);

    // Act and Assert
    assertNotEquals(methodHandleConstant, new MethodHandleConstant(1, 1));
  }

  /**
   * Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandleConstant(1, 1), null);
  }

  /**
   * Method under test: {@link MethodHandleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodHandleConstant(1, 1), "Different type to MethodHandleConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandleConstant#MethodHandleConstant()}
   *   <li>{@link MethodHandleConstant#toString()}
   *   <li>{@link MethodHandleConstant#getReferenceIndex()}
   *   <li>{@link MethodHandleConstant#getReferenceKind()}
   *   <li>{@link MethodHandleConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link MethodHandleConstant#MethodHandleConstant(int, int)}
   *   <li>{@link MethodHandleConstant#toString()}
   *   <li>{@link MethodHandleConstant#getReferenceIndex()}
   *   <li>{@link MethodHandleConstant#getReferenceKind()}
   *   <li>{@link MethodHandleConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
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
}
