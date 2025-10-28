package proguard.io;

import static org.junit.Assert.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Test;
import proguard.classfile.editor.AccessFixer;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.util.WarningPrinter;
import proguard.classfile.visitor.AllMemberVisitor;
import proguard.classfile.visitor.AllMethodVisitor;

public class ClassReaderDiffblueTest {
  /**
   * Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  public void testRead() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader = new ClassReader(true, true, true, true, warningPrinter, new AccessFixer());

    // Act and Assert
    assertThrows(IOException.class, () -> classReader.read(new StreamingDataEntry("Can't process class [",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
  }

  /**
   * Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  public void testRead2() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader = new ClassReader(true, true, true, true, warningPrinter,
        new AllMemberVisitor(new AttributeSorter()));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> classReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  public void testRead3() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader = new ClassReader(true, true, true, true, warningPrinter,
        new AllMethodVisitor(new AttributeSorter()));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> classReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  public void testRead4() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader = new ClassReader(false, true, true, true, warningPrinter, new AccessFixer());

    // Act and Assert
    assertThrows(IOException.class, () -> classReader.read(new StreamingDataEntry("Can't process class [",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
  }

  /**
   * Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  public void testRead5() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader = new ClassReader(true, true, true, true, warningPrinter, new AccessFixer());

    // Act and Assert
    assertThrows(IOException.class, () -> classReader
        .read(new StreamingDataEntry("Can't process class [", new ByteArrayInputStream(new byte[]{}))));
  }
}
