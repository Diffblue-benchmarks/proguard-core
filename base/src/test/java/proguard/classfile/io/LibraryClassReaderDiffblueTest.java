package proguard.classfile.io;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.IntegerConstant;

public class LibraryClassReaderDiffblueTest {
  /**
   * Test {@link LibraryClassReader#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <ul>
   *   <li>Then {@link IntegerConstant#IntegerConstant(int)} with value is forty-two Value is {@code
   *       1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClassReader#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClassReader.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant_thenIntegerConstantWithValueIsFortyTwoValueIs1096302936()
      throws UnsupportedEncodingException {
    // Arrange
    LibraryClassReader libraryClassReader =
        new LibraryClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
            true,
            true);
    LibraryClass clazz = new LibraryClass();
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act
    libraryClassReader.visitIntegerConstant(clazz, integerConstant);

    // Assert
    assertEquals(1096302936, integerConstant.getValue());
  }

  /**
   * Test {@link LibraryClassReader#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then {@link ClassConstant#ClassConstant()} {@link ClassConstant#u2nameIndex} is {@code
   *       16728}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryClassReader#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryClassReader.visitClassConstant(Clazz, ClassConstant)"})
  public void testVisitClassConstant_thenClassConstantU2nameIndexIs16728()
      throws UnsupportedEncodingException {
    // Arrange
    LibraryClassReader libraryClassReader =
        new LibraryClassReader(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
            true,
            true);
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();

    // Act
    libraryClassReader.visitClassConstant(clazz, classConstant);

    // Assert
    assertEquals(16728, classConstant.u2nameIndex);
  }
}
