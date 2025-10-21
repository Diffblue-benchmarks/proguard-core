package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.ConstantCounter;
import proguard.classfile.constant.visitor.ConstantVisitor;

public class DynamicConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Dynamic(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#DynamicConstant()}
   *   <li>{@link DynamicConstant#toString()}
   *   <li>{@link DynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link DynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link DynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DynamicConstant.<init>()",
    "void DynamicConstant.<init>(int, int, Clazz[])",
    "int DynamicConstant.getBootstrapMethodAttributeIndex()",
    "int DynamicConstant.getNameAndTypeIndex()",
    "boolean DynamicConstant.isCategory2()",
    "String DynamicConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsDynamic00() {
    // Arrange and Act
    DynamicConstant actualDynamicConstant = new DynamicConstant();
    String actualToStringResult = actualDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualDynamicConstant.getBootstrapMethodAttributeIndex();
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Dynamic(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#DynamicConstant(int, int, Clazz[])}
   *   <li>{@link DynamicConstant#toString()}
   *   <li>{@link DynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link DynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link DynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DynamicConstant.<init>()",
    "void DynamicConstant.<init>(int, int, Clazz[])",
    "int DynamicConstant.getBootstrapMethodAttributeIndex()",
    "int DynamicConstant.getNameAndTypeIndex()",
    "boolean DynamicConstant.isCategory2()",
    "String DynamicConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsDynamic11() {
    // Arrange and Act
    DynamicConstant actualDynamicConstant =
        new DynamicConstant(1, 1, new Clazz[] {new LibraryClass()});
    String actualToStringResult = actualDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualDynamicConstant.getBootstrapMethodAttributeIndex();
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

  /**
   * Test {@link DynamicConstant#getTag()}.
   *
   * <p>Method under test: {@link DynamicConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DynamicConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.DYNAMIC, (new DynamicConstant()).getTag());
  }

  /**
   * Test {@link DynamicConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link ConstantCounter} (default constructor).
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicConstant.accept(Clazz, ConstantVisitor)"})
  public void testAccept_whenConstantCounter_thenConstantCounterCountIsOne() {
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
   * Test {@link DynamicConstant#equals(Object)}, and {@link DynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#equals(Object)}
   *   <li>{@link DynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicConstant.equals(Object)", "int DynamicConstant.hashCode()"})
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
   * Test {@link DynamicConstant#equals(Object)}, and {@link DynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DynamicConstant#equals(Object)}
   *   <li>{@link DynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicConstant.equals(Object)", "int DynamicConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act and Assert
    assertEquals(dynamicConstant, dynamicConstant);
    int expectedHashCodeResult = dynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, dynamicConstant.hashCode());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicConstant.equals(Object)", "int DynamicConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(dynamicConstant, new DynamicConstant());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicConstant.equals(Object)", "int DynamicConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DynamicConstant dynamicConstant = new DynamicConstant(0, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(dynamicConstant, new DynamicConstant());
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicConstant.equals(Object)", "int DynamicConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicConstant(), null);
  }

  /**
   * Test {@link DynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicConstant.equals(Object)", "int DynamicConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DynamicConstant(), "Different type to DynamicConstant");
  }
}
