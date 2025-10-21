package proguard.io;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.editor.AccessFixer;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.util.WarningPrinter;
import proguard.classfile.visitor.AllMemberVisitor;
import proguard.classfile.visitor.AllMethodVisitor;

public class ClassReaderDiffblueTest {
  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link AllMemberVisitor#AllMemberVisitor(MemberVisitor)} with memberVisitor is
   *       {@link AttributeSorter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReader.read(DataEntry)"})
  public void testRead_givenAllMemberVisitorWithMemberVisitorIsAttributeSorter()
      throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader =
        new ClassReader(
            true, true, true, true, warningPrinter, new AllMemberVisitor(new AttributeSorter()));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> classReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link AllMethodVisitor#AllMethodVisitor(MemberVisitor)} with memberVisitor is
   *       {@link AttributeSorter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReader.read(DataEntry)"})
  public void testRead_givenAllMethodVisitorWithMemberVisitorIsAttributeSorter()
      throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader =
        new ClassReader(
            true, true, true, true, warningPrinter, new AllMethodVisitor(new AttributeSorter()));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IOException.class, () -> classReader.read(new ClassPathDataEntry(clazz)));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReader.read(DataEntry)"})
  public void testRead_whenA() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader =
        new ClassReader(false, true, true, true, warningPrinter, new AccessFixer());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            classReader.read(
                new StreamingDataEntry(
                    "Can't process class [",
                    new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReader.read(DataEntry)"})
  public void testRead_whenA_thenThrowIOException() throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader =
        new ClassReader(true, true, true, true, warningPrinter, new AccessFixer());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            classReader.read(
                new StreamingDataEntry(
                    "Can't process class [",
                    new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}))));
  }

  /**
   * Test {@link ClassReader#read(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code
   *       byte}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReader#read(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReader.read(DataEntry)"})
  public void testRead_whenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException()
      throws IOException {
    // Arrange
    WarningPrinter warningPrinter = new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassReader classReader =
        new ClassReader(true, true, true, true, warningPrinter, new AccessFixer());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            classReader.read(
                new StreamingDataEntry(
                    "Can't process class [", new ByteArrayInputStream(new byte[] {}))));
  }
}
