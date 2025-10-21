package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Module(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#ModuleConstant()}
   *   <li>{@link ModuleConstant#toString()}
   *   <li>{@link ModuleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModuleConstant.<init>()",
    "void ModuleConstant.<init>(int)",
    "boolean ModuleConstant.isCategory2()",
    "String ModuleConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsModule0() {
    // Arrange and Act
    ModuleConstant actualModuleConstant = new ModuleConstant();
    String actualToStringResult = actualModuleConstant.toString();
    boolean actualIsCategory2Result = actualModuleConstant.isCategory2();

    // Assert
    assertEquals("Module(0)", actualToStringResult);
    assertNull(actualModuleConstant.getProcessingInfo());
    assertEquals(0, actualModuleConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Module(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#ModuleConstant(int)}
   *   <li>{@link ModuleConstant#toString()}
   *   <li>{@link ModuleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ModuleConstant.<init>()",
    "void ModuleConstant.<init>(int)",
    "boolean ModuleConstant.isCategory2()",
    "String ModuleConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsModule1() {
    // Arrange and Act
    ModuleConstant actualModuleConstant = new ModuleConstant(1);
    String actualToStringResult = actualModuleConstant.toString();
    boolean actualIsCategory2Result = actualModuleConstant.isCategory2();

    // Assert
    assertEquals("Module(1)", actualToStringResult);
    assertNull(actualModuleConstant.getProcessingInfo());
    assertEquals(0, actualModuleConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link ModuleConstant#getTag()}.
   *
   * <p>Method under test: {@link ModuleConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ModuleConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.MODULE, (new ModuleConstant(1)).getTag());
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}, and {@link ModuleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#equals(Object)}
   *   <li>{@link ModuleConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModuleConstant.equals(Object)", "int ModuleConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);
    ModuleConstant moduleConstant2 = new ModuleConstant(1);

    // Act and Assert
    assertEquals(moduleConstant, moduleConstant2);
    int expectedHashCodeResult = moduleConstant.hashCode();
    assertEquals(expectedHashCodeResult, moduleConstant2.hashCode());
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}, and {@link ModuleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConstant#equals(Object)}
   *   <li>{@link ModuleConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModuleConstant.equals(Object)", "int ModuleConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act and Assert
    assertEquals(moduleConstant, moduleConstant);
    int expectedHashCodeResult = moduleConstant.hashCode();
    assertEquals(expectedHashCodeResult, moduleConstant.hashCode());
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModuleConstant.equals(Object)", "int ModuleConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(0);

    // Act and Assert
    assertNotEquals(moduleConstant, new ModuleConstant(1));
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModuleConstant.equals(Object)", "int ModuleConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConstant(1), null);
  }

  /**
   * Test {@link ModuleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ModuleConstant.equals(Object)", "int ModuleConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConstant(1), "Different type to ModuleConstant");
  }
}
