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

public class InvokeDynamicConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code InvokeDynamic(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#InvokeDynamicConstant()}
   *   <li>{@link InvokeDynamicConstant#toString()}
   *   <li>{@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link InvokeDynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link InvokeDynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InvokeDynamicConstant.<init>()",
    "void InvokeDynamicConstant.<init>(int, int, Clazz[])",
    "int InvokeDynamicConstant.getBootstrapMethodAttributeIndex()",
    "int InvokeDynamicConstant.getNameAndTypeIndex()",
    "boolean InvokeDynamicConstant.isCategory2()",
    "String InvokeDynamicConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsInvokeDynamic00() {
    // Arrange and Act
    InvokeDynamicConstant actualInvokeDynamicConstant = new InvokeDynamicConstant();
    String actualToStringResult = actualInvokeDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualInvokeDynamicConstant.getBootstrapMethodAttributeIndex();
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code InvokeDynamic(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#InvokeDynamicConstant(int, int, Clazz[])}
   *   <li>{@link InvokeDynamicConstant#toString()}
   *   <li>{@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}
   *   <li>{@link InvokeDynamicConstant#getNameAndTypeIndex()}
   *   <li>{@link InvokeDynamicConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InvokeDynamicConstant.<init>()",
    "void InvokeDynamicConstant.<init>(int, int, Clazz[])",
    "int InvokeDynamicConstant.getBootstrapMethodAttributeIndex()",
    "int InvokeDynamicConstant.getNameAndTypeIndex()",
    "boolean InvokeDynamicConstant.isCategory2()",
    "String InvokeDynamicConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsInvokeDynamic11() {
    // Arrange and Act
    InvokeDynamicConstant actualInvokeDynamicConstant =
        new InvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});
    String actualToStringResult = actualInvokeDynamicConstant.toString();
    int actualBootstrapMethodAttributeIndex =
        actualInvokeDynamicConstant.getBootstrapMethodAttributeIndex();
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

  /**
   * Test {@link InvokeDynamicConstant#getTag()}.
   *
   * <p>Method under test: {@link InvokeDynamicConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InvokeDynamicConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.INVOKE_DYNAMIC, (new InvokeDynamicConstant()).getTag());
  }

  /**
   * Test {@link InvokeDynamicConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>When {@link ConstantCounter} (default constructor).
   *   <li>Then {@link ConstantCounter} (default constructor) Count is one.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvokeDynamicConstant.accept(Clazz, ConstantVisitor)"})
  public void testAccept_whenConstantCounter_thenConstantCounterCountIsOne() {
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
   * Test {@link InvokeDynamicConstant#equals(Object)}, and {@link
   * InvokeDynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#equals(Object)}
   *   <li>{@link InvokeDynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InvokeDynamicConstant.equals(Object)",
    "int InvokeDynamicConstant.hashCode()"
  })
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
   * Test {@link InvokeDynamicConstant#equals(Object)}, and {@link
   * InvokeDynamicConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InvokeDynamicConstant#equals(Object)}
   *   <li>{@link InvokeDynamicConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InvokeDynamicConstant.equals(Object)",
    "int InvokeDynamicConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act and Assert
    assertEquals(invokeDynamicConstant, invokeDynamicConstant);
    int expectedHashCodeResult = invokeDynamicConstant.hashCode();
    assertEquals(expectedHashCodeResult, invokeDynamicConstant.hashCode());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InvokeDynamicConstant.equals(Object)",
    "int InvokeDynamicConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant =
        new InvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(invokeDynamicConstant, new InvokeDynamicConstant());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InvokeDynamicConstant.equals(Object)",
    "int InvokeDynamicConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InvokeDynamicConstant invokeDynamicConstant =
        new InvokeDynamicConstant(0, 1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(invokeDynamicConstant, new InvokeDynamicConstant());
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InvokeDynamicConstant.equals(Object)",
    "int InvokeDynamicConstant.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InvokeDynamicConstant(), null);
  }

  /**
   * Test {@link InvokeDynamicConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InvokeDynamicConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean InvokeDynamicConstant.equals(Object)",
    "int InvokeDynamicConstant.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InvokeDynamicConstant(), "Different type to InvokeDynamicConstant");
  }
}
