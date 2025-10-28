package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class MethodrefConstantDiffblueTest {
  /**
   * Method under test: {@link MethodrefConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHODREF, (new MethodrefConstant()).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodrefConstant#MethodrefConstant()}
   *   <li>{@link MethodrefConstant#toString()}
   *   <li>{@link MethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MethodrefConstant actualMethodrefConstant = new MethodrefConstant();
    String actualToStringResult = actualMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualMethodrefConstant.isCategory2();

    // Assert
    assertEquals("Methodref(0,0)", actualToStringResult);
    assertNull(actualMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualMethodrefConstant.getClassIndex());
    assertEquals(0, actualMethodrefConstant.getNameAndTypeIndex());
    assertEquals(0, actualMethodrefConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodrefConstant#MethodrefConstant(int, int, Clazz, Method)}
   *   <li>{@link MethodrefConstant#toString()}
   *   <li>{@link MethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    MethodrefConstant actualMethodrefConstant = new MethodrefConstant(1, 1, referencedClass,
        new LibraryMethod(1, "Name", "Descriptor"));
    String actualToStringResult = actualMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualMethodrefConstant.isCategory2();

    // Assert
    assertEquals("Methodref(1,1)", actualToStringResult);
    assertNull(actualMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualMethodrefConstant.getProcessingFlags());
    assertEquals(1, actualMethodrefConstant.getClassIndex());
    assertEquals(1, actualMethodrefConstant.getNameAndTypeIndex());
    assertFalse(actualIsCategory2Result);
  }
}
