package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ModuleConstantDiffblueTest {
  /**
   * Method under test: {@link ModuleConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.MODULE, (new ModuleConstant(1)).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConstant#equals(Object)}
   *   <li>{@link ModuleConstant#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConstant#equals(Object)}
   *   <li>{@link ModuleConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(1);

    // Act and Assert
    assertEquals(moduleConstant, moduleConstant);
    int expectedHashCodeResult = moduleConstant.hashCode();
    assertEquals(expectedHashCodeResult, moduleConstant.hashCode());
  }

  /**
   * Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ModuleConstant moduleConstant = new ModuleConstant(0);

    // Act and Assert
    assertNotEquals(moduleConstant, new ModuleConstant(1));
  }

  /**
   * Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConstant(1), null);
  }

  /**
   * Method under test: {@link ModuleConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConstant(1), "Different type to ModuleConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConstant#ModuleConstant()}
   *   <li>{@link ModuleConstant#toString()}
   *   <li>{@link ModuleConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConstant#ModuleConstant(int)}
   *   <li>{@link ModuleConstant#toString()}
   *   <li>{@link ModuleConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
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
}
