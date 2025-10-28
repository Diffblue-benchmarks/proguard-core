package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantVisitor;

public class DynamicConstantDiffblueTest {
  /**
   * Method under test: {@link DynamicConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.DYNAMIC, (new DynamicConstant()).getTag());
  }

  /**
   * Method under test: {@link DynamicConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    LibraryClass clazz = new LibraryClass();
    ConstantCounter constantVisitor = new ConstantCounter();

    // Act
    dynamicConstant.accept(clazz, constantVisitor);

    // Assert
    assertEquals(1, constantVisitor.getCount());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicConstant#equals(Object)}
   *   <li>{@link DynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();
    DynamicConstant dynamicConstant2 = new DynamicConstant();

    // Act and Assert
    assertEquals(dynamicConstant, dynamicConstant2);
    int expectedHashCodeResult = dynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, dynamicConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicConstant#equals(Object)}
   *   <li>{@link DynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act and Assert
    assertEquals(dynamicConstant, dynamicConstant);
    int expectedHashCodeResult = dynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, dynamicConstant.hashCode());
  }

  /**
   * Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant(1, 1, new Clazz[]{new LibraryClass()});

    // Act and Assert
    assertNotEquals(dynamicConstant, new DynamicConstant());
  }

  /**
   * Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant(0, 1, new Clazz[]{new LibraryClass()});

    // Act and Assert
    assertNotEquals(dynamicConstant, new DynamicConstant());
  }

  /**
   * Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicConstant(), null);
  }

  /**
   * Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicConstant(), "Different type to DynamicConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicConstant#DynamicConstant()}
   *   <li>{@link DynamicConstant#toString()}
   *   <li>{@link DynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link DynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link DynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicConstant actualDynamicConstant = new DynamicConstant();
    String actualToStringResult = actualDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex = actualDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualDynamicConstant.isCategory2();

    // Assert
    assertEquals("Dynamic(0,0)", actualToStringResult);
    assertNull(actualDynamicConstant.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodAttributeIndex);
    assertEquals(0, actualNameAndTypeIndex);
    assertEquals(0, actualDynamicConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicConstant#DynamicConstant(int, int, Clazz[])}
   *   <li>{@link DynamicConstant#toString()}
   *   <li>{@link DynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link DynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link DynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    DynamicConstant actualDynamicConstant = new DynamicConstant(1, 1, new Clazz[]{new LibraryClass()});
    String actualToStringResult = actualDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex = actualDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualDynamicConstant.isCategory2();

    // Assert
    assertEquals("Dynamic(1,1)", actualToStringResult);
    assertNull(actualDynamicConstant.getProcessingInfo());
    assertEquals(0, actualDynamicConstant.getProcessingFlags());
    assertEquals(1, actualBootstrapMethodAttributeIndex);
    assertEquals(1, actualNameAndTypeIndex);
    assertFalse(actualIsCategory2Result);
  }
}
