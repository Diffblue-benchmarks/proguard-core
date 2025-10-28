package proguard.classfile.io;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.IntegerConstant;

public class LibraryClassReaderDiffblueTest {
  /**
   * Method under test:
   * {@link LibraryClassReader#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant() throws UnsupportedEncodingException {
    // Arrange
    LibraryClassReader libraryClassReader = new LibraryClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), true, true);
    LibraryClass clazz = new LibraryClass();
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act
    libraryClassReader.visitIntegerConstant(clazz, integerConstant);

    // Assert
    assertEquals(1096302936, integerConstant.getValue());
  }

  /**
   * Method under test:
   * {@link LibraryClassReader#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  public void testVisitClassConstant() throws UnsupportedEncodingException {
    // Arrange
    LibraryClassReader libraryClassReader = new LibraryClassReader(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), true, true);
    LibraryClass clazz = new LibraryClass();
    ClassConstant classConstant = new ClassConstant();

    // Act
    libraryClassReader.visitClassConstant(clazz, classConstant);

    // Assert
    assertEquals(16728, classConstant.u2nameIndex);
  }
}
