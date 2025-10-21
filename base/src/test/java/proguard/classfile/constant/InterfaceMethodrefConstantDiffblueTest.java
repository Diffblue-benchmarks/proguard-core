package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class InterfaceMethodrefConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code InterfaceMethodref(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InterfaceMethodrefConstant#InterfaceMethodrefConstant()}
   *   <li>{@link InterfaceMethodrefConstant#toString()}
   *   <li>{@link InterfaceMethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InterfaceMethodrefConstant.<init>()",
    "void InterfaceMethodrefConstant.<init>(int, int, Clazz, Method)",
    "boolean InterfaceMethodrefConstant.isCategory2()",
    "String InterfaceMethodrefConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsInterfaceMethodref00() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code InterfaceMethodref(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InterfaceMethodrefConstant#InterfaceMethodrefConstant(int, int, Clazz, Method)}
   *   <li>{@link InterfaceMethodrefConstant#toString()}
   *   <li>{@link InterfaceMethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InterfaceMethodrefConstant.<init>()",
    "void InterfaceMethodrefConstant.<init>(int, int, Clazz, Method)",
    "boolean InterfaceMethodrefConstant.isCategory2()",
    "String InterfaceMethodrefConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsInterfaceMethodref11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    InterfaceMethodrefConstant actualInterfaceMethodrefConstant =
        new InterfaceMethodrefConstant(
            1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor"));
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

  /**
   * Test {@link InterfaceMethodrefConstant#getTag()}.
   *
   * <p>Method under test: {@link InterfaceMethodrefConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int InterfaceMethodrefConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.INTERFACE_METHODREF, (new InterfaceMethodrefConstant()).getTag());
  }
}
