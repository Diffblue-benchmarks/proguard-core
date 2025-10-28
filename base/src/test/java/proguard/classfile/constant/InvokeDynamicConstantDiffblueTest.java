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

public class InvokeDynamicConstantDiffblueTest {
  /**
   * Method under test: {@link InvokeDynamicConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.INVOKE_DYNAMIC, (new InvokeDynamicConstant()).getTag());
  }

  /**
   * Method under test:
   * {@link InvokeDynamicConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    LibraryClass clazz = new LibraryClass();
    ConstantCounter constantVisitor = new ConstantCounter();

    // Act
    invokeDynamicConstant.accept(clazz, constantVisitor);

    // Assert
    assertEquals(1, constantVisitor.getCount());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InvokeDynamicConstant#equals(Object)}
   *   <li>{@link InvokeDynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();
    InvokeDynamicConstant invokeDynamicConstant2 = new InvokeDynamicConstant();

    // Act and Assert
    assertEquals(invokeDynamicConstant, invokeDynamicConstant2);
    int expectedHashCodeResult = invokeDynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, invokeDynamicConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InvokeDynamicConstant#equals(Object)}
   *   <li>{@link InvokeDynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act and Assert
    assertEquals(invokeDynamicConstant, invokeDynamicConstant);
    int expectedHashCodeResult = invokeDynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, invokeDynamicConstant.hashCode());
  }

  /**
   * Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant(1, 1, new Clazz[]{new LibraryClass()});

    // Act and Assert
    assertNotEquals(invokeDynamicConstant, new InvokeDynamicConstant());
  }

  /**
   * Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant(0, 1, new Clazz[]{new LibraryClass()});

    // Act and Assert
    assertNotEquals(invokeDynamicConstant, new InvokeDynamicConstant());
  }

  /**
   * Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InvokeDynamicConstant(), null);
  }

  /**
   * Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InvokeDynamicConstant(), "Different type to InvokeDynamicConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InvokeDynamicConstant#InvokeDynamicConstant()}
   *   <li>{@link InvokeDynamicConstant#toString()}
   *   <li>{@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link InvokeDynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link InvokeDynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    InvokeDynamicConstant actualInvokeDynamicConstant = new InvokeDynamicConstant();
    String actualToStringResult = actualInvokeDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex = actualInvokeDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualInvokeDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualInvokeDynamicConstant.isCategory2();

    // Assert
    assertEquals("InvokeDynamic(0,0)", actualToStringResult);
    assertNull(actualInvokeDynamicConstant.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodAttributeIndex);
    assertEquals(0, actualNameAndTypeIndex);
    assertEquals(0, actualInvokeDynamicConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InvokeDynamicConstant#InvokeDynamicConstant(int, int, Clazz[])}
   *   <li>{@link InvokeDynamicConstant#toString()}
   *   <li>{@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link InvokeDynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link InvokeDynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    InvokeDynamicConstant actualInvokeDynamicConstant = new InvokeDynamicConstant(1, 1,
        new Clazz[]{new LibraryClass()});
    String actualToStringResult = actualInvokeDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex = actualInvokeDynamicConstant.getBootstrapMethodAttributeIndex();
    int actualNameAndTypeIndex = actualInvokeDynamicConstant.getNameAndTypeIndex();
    boolean actualIsCategory2Result = actualInvokeDynamicConstant.isCategory2();

    // Assert
    assertEquals("InvokeDynamic(1,1)", actualToStringResult);
    assertNull(actualInvokeDynamicConstant.getProcessingInfo());
    assertEquals(0, actualInvokeDynamicConstant.getProcessingFlags());
    assertEquals(1, actualBootstrapMethodAttributeIndex);
    assertEquals(1, actualNameAndTypeIndex);
    assertFalse(actualIsCategory2Result);
  }
}
