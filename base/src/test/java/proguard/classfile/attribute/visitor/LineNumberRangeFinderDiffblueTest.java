package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExtendedLineNumberInfo;
import proguard.classfile.attribute.LineNumberInfo;

public class LineNumberRangeFinderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LineNumberRangeFinder}
   *   <li>{@link LineNumberRangeFinder#getHighestLineNumber()}
   *   <li>{@link LineNumberRangeFinder#getLowestLineNumber()}
   *   <li>{@link LineNumberRangeFinder#hasSource()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LineNumberRangeFinder actualLineNumberRangeFinder = new LineNumberRangeFinder();
    int actualHighestLineNumber = actualLineNumberRangeFinder.getHighestLineNumber();
    int actualLowestLineNumber = actualLineNumberRangeFinder.getLowestLineNumber();

    // Assert
    assertEquals(0, actualHighestLineNumber);
    assertFalse(actualLineNumberRangeFinder.hasSource());
    assertEquals(Integer.MAX_VALUE, actualLowestLineNumber);
  }

  /**
   * Method under test:
   * {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(clazz, method, codeAttribute, new LineNumberInfo(1, 2));

    // Assert
    assertEquals(2, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(2, lineNumberRangeFinder.getLowestLineNumber());
    assertFalse(lineNumberRangeFinder.hasSource());
  }

  /**
   * Method under test:
   * {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo2() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    ExtendedLineNumberInfo lineNumberInfo = new ExtendedLineNumberInfo(1, 2, "Source");

    lineNumberInfo.source = "42";

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(clazz, method, codeAttribute, lineNumberInfo);

    // Assert
    assertEquals(2, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(2, lineNumberRangeFinder.getLowestLineNumber());
    assertTrue(lineNumberRangeFinder.hasSource());
  }

  /**
   * Method under test:
   * {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo3() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(clazz, method, codeAttribute, new LineNumberInfo(1, Integer.MAX_VALUE));

    // Assert
    assertFalse(lineNumberRangeFinder.hasSource());
    assertEquals(Integer.MAX_VALUE, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(Integer.MAX_VALUE, lineNumberRangeFinder.getLowestLineNumber());
  }

  /**
   * Method under test:
   * {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)}
   */
  @Test
  public void testVisitLineNumberInfo4() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(clazz, method, codeAttribute, new LineNumberInfo(1, 0));

    // Assert
    assertEquals(0, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(0, lineNumberRangeFinder.getLowestLineNumber());
    assertFalse(lineNumberRangeFinder.hasSource());
  }
}
