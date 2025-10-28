package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantTagFilter;
import proguard.classfile.constant.visitor.ConstantVisitor;

public class ClassConstantDiffblueTest {
  /**
   * Method under test: {@link ClassConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(7, (new ClassConstant()).getTag());
  }

  /**
   * Method under test: {@link ClassConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    LibraryClass clazz = new LibraryClass();

    // Act
    classConstant.accept(clazz, new BootstrapMethodHandleTraveler(new ConstantLookupVisitor()));

    // Assert that nothing has changed
    assertNull(classConstant.getProcessingInfo());
  }

  /**
   * Method under test: {@link ClassConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    LibraryClass clazz = new LibraryClass();

    // Act
    classConstant.accept(clazz, new ConstantTagFilter(1, new ConstantLookupVisitor()));

    // Assert that nothing has changed
    assertNull(classConstant.getProcessingInfo());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassConstant#equals(Object)}
   *   <li>{@link ClassConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertEquals(classConstant, classConstant2);
    int expectedHashCodeResult = classConstant.hashCode();
    assertEquals(expectedHashCodeResult, classConstant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassConstant#equals(Object)}
   *   <li>{@link ClassConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(classConstant, classConstant);
    int expectedHashCodeResult = classConstant.hashCode();
    assertEquals(expectedHashCodeResult, classConstant.hashCode());
  }

  /**
   * Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant(1, new LibraryClass());

    // Act and Assert
    assertNotEquals(classConstant, new ClassConstant());
  }

  /**
   * Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassConstant(), null);
  }

  /**
   * Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassConstant(), "Different type to ClassConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassConstant#ClassConstant()}
   *   <li>{@link ClassConstant#toString()}
   *   <li>{@link ClassConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ClassConstant actualClassConstant = new ClassConstant();
    String actualToStringResult = actualClassConstant.toString();
    boolean actualIsCategory2Result = actualClassConstant.isCategory2();

    // Assert
    assertEquals("Class(0)", actualToStringResult);
    assertNull(actualClassConstant.getProcessingInfo());
    assertEquals(0, actualClassConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassConstant#ClassConstant(int, Clazz)}
   *   <li>{@link ClassConstant#toString()}
   *   <li>{@link ClassConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ClassConstant actualClassConstant = new ClassConstant(1, new LibraryClass());
    String actualToStringResult = actualClassConstant.toString();
    boolean actualIsCategory2Result = actualClassConstant.isCategory2();

    // Assert
    assertEquals("Class(1)", actualToStringResult);
    assertNull(actualClassConstant.getProcessingInfo());
    assertEquals(0, actualClassConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }
}
