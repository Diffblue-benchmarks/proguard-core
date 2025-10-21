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

public class MethodTypeConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code MethodType(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#MethodTypeConstant()}
   *   <li>{@link MethodTypeConstant#toString()}
   *   <li>{@link MethodTypeConstant#getDescriptorIndex()}
   *   <li>{@link MethodTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodTypeConstant.<init>()",
    "void MethodTypeConstant.<init>(int, Clazz[])",
    "int MethodTypeConstant.getDescriptorIndex()",
    "boolean MethodTypeConstant.isCategory2()",
    "String MethodTypeConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsMethodType0() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code MethodType(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#MethodTypeConstant(int, Clazz[])}
   *   <li>{@link MethodTypeConstant#toString()}
   *   <li>{@link MethodTypeConstant#getDescriptorIndex()}
   *   <li>{@link MethodTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodTypeConstant.<init>()",
    "void MethodTypeConstant.<init>(int, Clazz[])",
    "int MethodTypeConstant.getDescriptorIndex()",
    "boolean MethodTypeConstant.isCategory2()",
    "String MethodTypeConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsMethodType1() {
    // Arrange and Act
    MethodTypeConstant actualMethodTypeConstant =
        new MethodTypeConstant(1, new Clazz[] {new LibraryClass()});
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

  /**
   * Test {@link MethodTypeConstant#getTag()}.
   *
   * <p>Method under test: {@link MethodTypeConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MethodTypeConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHOD_TYPE, (new MethodTypeConstant()).getTag());
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}, and {@link MethodTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#equals(Object)}
   *   <li>{@link MethodTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodTypeConstant.equals(Object)",
    "int MethodTypeConstant.hashCode()"
  })
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
   * Test {@link MethodTypeConstant#equals(Object)}, and {@link MethodTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodTypeConstant#equals(Object)}
   *   <li>{@link MethodTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodTypeConstant.equals(Object)",
    "int MethodTypeConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant = new MethodTypeConstant();

    // Act and Assert
    assertEquals(methodTypeConstant, methodTypeConstant);
    int expectedHashCodeResult = methodTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, methodTypeConstant.hashCode());
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodTypeConstant.equals(Object)",
    "int MethodTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodTypeConstant methodTypeConstant =
        new MethodTypeConstant(1, new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertNotEquals(methodTypeConstant, new MethodTypeConstant());
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodTypeConstant.equals(Object)",
    "int MethodTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodTypeConstant(), null);
  }

  /**
   * Test {@link MethodTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodTypeConstant.equals(Object)",
    "int MethodTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodTypeConstant(), "Different type to MethodTypeConstant");
  }
}
