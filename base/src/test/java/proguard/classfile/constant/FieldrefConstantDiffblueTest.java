package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class FieldrefConstantDiffblueTest {
  /**
   * Method under test: {@link FieldrefConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.FIELDREF, (new FieldrefConstant()).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldrefConstant#FieldrefConstant()}
   *   <li>{@link FieldrefConstant#toString()}
   *   <li>{@link FieldrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link FieldrefConstant#FieldrefConstant(int, int, Clazz, Field)}
   *   <li>{@link FieldrefConstant#toString()}
   *   <li>{@link FieldrefConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    FieldrefConstant actualFieldrefConstant = new FieldrefConstant(1, 1, referencedClass,
        new LibraryField(1, "Name", "Descriptor"));
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
}
