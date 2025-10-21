package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantTagFilter;
import proguard.classfile.constant.visitor.ConstantVisitor;

public class ClassConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Class(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#ClassConstant()}
   *   <li>{@link ClassConstant#toString()}
   *   <li>{@link ClassConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassConstant.<init>()",
    "void ClassConstant.<init>(int, Clazz)",
    "boolean ClassConstant.isCategory2()",
    "String ClassConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsClass0() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Class(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#ClassConstant(int, Clazz)}
   *   <li>{@link ClassConstant#toString()}
   *   <li>{@link ClassConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassConstant.<init>()",
    "void ClassConstant.<init>(int, Clazz)",
    "boolean ClassConstant.isCategory2()",
    "String ClassConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsClass1() {
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

  /**
   * Test {@link ClassConstant#getTag()}.
   *
   * <p>Method under test: {@link ClassConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ClassConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(7, (new ClassConstant()).getTag());
  }

  /**
   * Test {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <p>Method under test: {@link ClassConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassConstant.accept(Clazz, ConstantVisitor)"})
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
   * Test {@link ClassConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <p>Method under test: {@link ClassConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassConstant.accept(Clazz, ConstantVisitor)"})
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
   * Test {@link ClassConstant#equals(Object)}, and {@link ClassConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#equals(Object)}
   *   <li>{@link ClassConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassConstant.equals(Object)", "int ClassConstant.hashCode()"})
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
   * Test {@link ClassConstant#equals(Object)}, and {@link ClassConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassConstant#equals(Object)}
   *   <li>{@link ClassConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassConstant.equals(Object)", "int ClassConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();

    // Act and Assert
    assertEquals(classConstant, classConstant);
    int expectedHashCodeResult = classConstant.hashCode();
    assertEquals(expectedHashCodeResult, classConstant.hashCode());
  }

  /**
   * Test {@link ClassConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassConstant.equals(Object)", "int ClassConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassConstant classConstant = new ClassConstant(1, new LibraryClass());

    // Act and Assert
    assertNotEquals(classConstant, new ClassConstant());
  }

  /**
   * Test {@link ClassConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassConstant.equals(Object)", "int ClassConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassConstant(), null);
  }

  /**
   * Test {@link ClassConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassConstant.equals(Object)", "int ClassConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassConstant(), "Different type to ClassConstant");
  }
}
