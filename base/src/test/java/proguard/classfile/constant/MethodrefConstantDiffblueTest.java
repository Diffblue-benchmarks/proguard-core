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

public class MethodrefConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Methodref(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodrefConstant#MethodrefConstant()}
   *   <li>{@link MethodrefConstant#toString()}
   *   <li>{@link MethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodrefConstant.<init>()",
    "void MethodrefConstant.<init>(int, int, Clazz, Method)",
    "boolean MethodrefConstant.isCategory2()",
    "String MethodrefConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsMethodref00() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Methodref(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodrefConstant#MethodrefConstant(int, int, Clazz, Method)}
   *   <li>{@link MethodrefConstant#toString()}
   *   <li>{@link MethodrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodrefConstant.<init>()",
    "void MethodrefConstant.<init>(int, int, Clazz, Method)",
    "boolean MethodrefConstant.isCategory2()",
    "String MethodrefConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsMethodref11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    MethodrefConstant actualMethodrefConstant =
        new MethodrefConstant(1, 1, referencedClass, new LibraryMethod(1, "Name", "Descriptor"));
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

  /**
   * Test {@link MethodrefConstant#getTag()}.
   *
   * <p>Method under test: {@link MethodrefConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MethodrefConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.METHODREF, (new MethodrefConstant()).getTag());
  }
}
