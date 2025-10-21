package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class FieldrefConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Fieldref(0,0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldrefConstant#FieldrefConstant()}
   *   <li>{@link FieldrefConstant#toString()}
   *   <li>{@link FieldrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FieldrefConstant.<init>()",
    "void FieldrefConstant.<init>(int, int, Clazz, Field)",
    "boolean FieldrefConstant.isCategory2()",
    "String FieldrefConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsFieldref00() {
    // Arrange and Act
    FieldrefConstant actualFieldrefConstant = new FieldrefConstant();
    String actualToStringResult = actualFieldrefConstant.toString();
    boolean actualIsCategory2Result = actualFieldrefConstant.isCategory2();

    // Assert
    assertEquals("Fieldref(0,0)", actualToStringResult);
    assertNull(actualFieldrefConstant.getProcessingInfo());
    assertEquals(0, actualFieldrefConstant.getClassIndex());
    assertEquals(0, actualFieldrefConstant.getNameAndTypeIndex());
    assertEquals(0, actualFieldrefConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Fieldref(1,1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldrefConstant#FieldrefConstant(int, int, Clazz, Field)}
   *   <li>{@link FieldrefConstant#toString()}
   *   <li>{@link FieldrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FieldrefConstant.<init>()",
    "void FieldrefConstant.<init>(int, int, Clazz, Field)",
    "boolean FieldrefConstant.isCategory2()",
    "String FieldrefConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsFieldref11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    FieldrefConstant actualFieldrefConstant =
        new FieldrefConstant(1, 1, referencedClass, new LibraryField(1, "Name", "Descriptor"));
    String actualToStringResult = actualFieldrefConstant.toString();
    boolean actualIsCategory2Result = actualFieldrefConstant.isCategory2();

    // Assert
    assertEquals("Fieldref(1,1)", actualToStringResult);
    assertNull(actualFieldrefConstant.getProcessingInfo());
    assertEquals(0, actualFieldrefConstant.getProcessingFlags());
    assertEquals(1, actualFieldrefConstant.getClassIndex());
    assertEquals(1, actualFieldrefConstant.getNameAndTypeIndex());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link FieldrefConstant#getTag()}.
   *
   * <p>Method under test: {@link FieldrefConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int FieldrefConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.FIELDREF, (new FieldrefConstant()).getTag());
  }
}
