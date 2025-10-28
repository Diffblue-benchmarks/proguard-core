package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class MethodTypeConstantDiffblueTest {
  /**
   * Method under test: {@link MethodTypeConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHOD_TYPE, (new MethodTypeConstant()).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodTypeConstant#equals(Object)}
   *   <li>{@link MethodTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();
    MethodTypeConstant methodTypeConstant2 = new MethodTypeConstant();

    // Act and Assert
    assertEquals(methodTypeConstant, methodTypeConstant2);
    int expectedHashCodeResult = methodTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodTypeConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodTypeConstant#equals(Object)}
   *   <li>{@link MethodTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act and Assert
    assertEquals(methodTypeConstant, methodTypeConstant);
    int expectedHashCodeResult = methodTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodTypeConstant.hashCode());
  }

  /**
   * Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant(1, new Clazz[]{new LibraryClass()});

    // Act and Assert
    assertNotEquals(methodTypeConstant, new MethodTypeConstant());
  }

  /**
   * Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodTypeConstant(), null);
  }

  /**
   * Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodTypeConstant(), "Different type to MethodTypeConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodTypeConstant#MethodTypeConstant()}
   *   <li>{@link MethodTypeConstant#toString()}
   *   <li>{@link MethodTypeConstant#getDescriptorIndex()}
   *   <li>{@link MethodTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MethodTypeConstant actualMethodTypeConstant = new MethodTypeConstant();
    String actualToStringResult = actualMethodTypeConstant.toString();
    int actualDescriptorIndex = actualMethodTypeConstant.getDescriptorIndex();
    boolean actualIsCategory2Result = actualMethodTypeConstant.isCategory2();

    // Assert
    assertEquals("MethodType(0)", actualToStringResult);
    assertNull(actualMethodTypeConstant.getProcessingInfo());
    assertEquals(0, actualDescriptorIndex);
    assertEquals(0, actualMethodTypeConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodTypeConstant#MethodTypeConstant(int, Clazz[])}
   *   <li>{@link MethodTypeConstant#toString()}
   *   <li>{@link MethodTypeConstant#getDescriptorIndex()}
   *   <li>{@link MethodTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    MethodTypeConstant actualMethodTypeConstant = new MethodTypeConstant(1, new Clazz[]{new LibraryClass()});
    String actualToStringResult = actualMethodTypeConstant.toString();
    int actualDescriptorIndex = actualMethodTypeConstant.getDescriptorIndex();
    boolean actualIsCategory2Result = actualMethodTypeConstant.isCategory2();

    // Assert
    assertEquals("MethodType(1)", actualToStringResult);
    assertNull(actualMethodTypeConstant.getProcessingInfo());
    assertEquals(0, actualMethodTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertFalse(actualIsCategory2Result);
  }
}
