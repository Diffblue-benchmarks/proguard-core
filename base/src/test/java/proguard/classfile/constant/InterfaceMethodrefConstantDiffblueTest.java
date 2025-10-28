package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class InterfaceMethodrefConstantDiffblueTest {
  /**
   * Method under test: {@link InterfaceMethodrefConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.INTERFACE_METHODREF, (new InterfaceMethodrefConstant()).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InterfaceMethodrefConstant#InterfaceMethodrefConstant()}
   *   <li>{@link InterfaceMethodrefConstant#toString()}
   *   <li>{@link InterfaceMethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    InterfaceMethodrefConstant actualInterfaceMethodrefConstant = new InterfaceMethodrefConstant();
    String actualToStringResult = actualInterfaceMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualInterfaceMethodrefConstant.isCategory2();

    // Assert
    assertEquals("InterfaceMethodref(0,0)", actualToStringResult);
    assertNull(actualInterfaceMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualInterfaceMethodrefConstant.getClassIndex());
    assertEquals(0, actualInterfaceMethodrefConstant.getNameAndTypeIndex());
    assertEquals(0, actualInterfaceMethodrefConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InterfaceMethodrefConstant#InterfaceMethodrefConstant(int, int, Clazz, Method)}
   *   <li>{@link InterfaceMethodrefConstant#toString()}
   *   <li>{@link InterfaceMethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InterfaceMethodrefConstant actualInterfaceMethodrefConstant = new InterfaceMethodrefConstant(1, 1, referencedClass,
        new LibraryMethod(1, "Name", "Descriptor"));
    String actualToStringResult = actualInterfaceMethodrefConstant.toString();
    boolean actualIsCategory2Result = actualInterfaceMethodrefConstant.isCategory2();

    // Assert
    assertEquals("InterfaceMethodref(1,1)", actualToStringResult);
    assertNull(actualInterfaceMethodrefConstant.getProcessingInfo());
    assertEquals(0, actualInterfaceMethodrefConstant.getProcessingFlags());
    assertEquals(1, actualInterfaceMethodrefConstant.getClassIndex());
    assertEquals(1, actualInterfaceMethodrefConstant.getNameAndTypeIndex());
    assertFalse(actualIsCategory2Result);
  }
}
