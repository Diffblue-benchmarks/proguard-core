package proguard.classfile.attribute.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExtendedLineNumberInfo;
import proguard.classfile.attribute.LineNumberInfo;

class LineNumberRangeFinderDiffblueTest {
  /**
   * Test {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <ul>
   *   <li>Then {@link LineNumberRangeFinder} (default constructor) hasSource.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo); then LineNumberRangeFinder (default constructor) hasSource")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberRangeFinder.visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)"
  })
  void testVisitLineNumberInfo_thenLineNumberRangeFinderHasSource() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(
        clazz, method, codeAttribute, new ExtendedLineNumberInfo(1, 2, "Source"));

    // Assert
    assertEquals(2, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(2, lineNumberRangeFinder.getLowestLineNumber());
    assertTrue(lineNumberRangeFinder.hasSource());
  }

  /**
   * Test {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <ul>
   *   <li>Then {@link LineNumberRangeFinder} (default constructor) HighestLineNumber is {@link
   *       Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo); then LineNumberRangeFinder (default constructor) HighestLineNumber is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberRangeFinder.visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)"
  })
  void testVisitLineNumberInfo_thenLineNumberRangeFinderHighestLineNumberIsMax_value() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(
        clazz, method, codeAttribute, new LineNumberInfo(1, Integer.MAX_VALUE));

    // Assert
    assertFalse(lineNumberRangeFinder.hasSource());
    assertEquals(Integer.MAX_VALUE, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(Integer.MAX_VALUE, lineNumberRangeFinder.getLowestLineNumber());
  }

  /**
   * Test {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <ul>
   *   <li>Then {@link LineNumberRangeFinder} (default constructor) HighestLineNumber is zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo); then LineNumberRangeFinder (default constructor) HighestLineNumber is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberRangeFinder.visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)"
  })
  void testVisitLineNumberInfo_thenLineNumberRangeFinderHighestLineNumberIsZero() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(
        clazz, method, codeAttribute, new LineNumberInfo(1, 0));

    // Assert
    assertEquals(0, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(0, lineNumberRangeFinder.getLowestLineNumber());
    assertFalse(lineNumberRangeFinder.hasSource());
  }

  /**
   * Test {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method, CodeAttribute,
   * LineNumberInfo)}.
   *
   * <ul>
   *   <li>When {@link LineNumberInfo#LineNumberInfo(int, int)} with u2startPC is one and
   *       u2lineNumber is two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberRangeFinder#visitLineNumberInfo(Clazz, Method,
   * CodeAttribute, LineNumberInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo); when LineNumberInfo(int, int) with u2startPC is one and u2lineNumber is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberRangeFinder.visitLineNumberInfo(Clazz, Method, CodeAttribute, LineNumberInfo)"
  })
  void testVisitLineNumberInfo_whenLineNumberInfoWithU2startPCIsOneAndU2lineNumberIsTwo() {
    // Arrange
    LineNumberRangeFinder lineNumberRangeFinder = new LineNumberRangeFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberRangeFinder.visitLineNumberInfo(
        clazz, method, codeAttribute, new LineNumberInfo(1, 2));

    // Assert
    assertEquals(2, lineNumberRangeFinder.getHighestLineNumber());
    assertEquals(2, lineNumberRangeFinder.getLowestLineNumber());
    assertFalse(lineNumberRangeFinder.hasSource());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LineNumberRangeFinder}
   *   <li>{@link LineNumberRangeFinder#getHighestLineNumber()}
   *   <li>{@link LineNumberRangeFinder#getLowestLineNumber()}
   *   <li>{@link LineNumberRangeFinder#hasSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LineNumberRangeFinder.<init>()",
    "int LineNumberRangeFinder.getHighestLineNumber()",
    "int LineNumberRangeFinder.getLowestLineNumber()",
    "boolean LineNumberRangeFinder.hasSource()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LineNumberRangeFinder actualLineNumberRangeFinder = new LineNumberRangeFinder();
    int actualHighestLineNumber = actualLineNumberRangeFinder.getHighestLineNumber();
    int actualLowestLineNumber = actualLineNumberRangeFinder.getLowestLineNumber();

    // Assert
    assertEquals(0, actualHighestLineNumber);
    assertFalse(actualLineNumberRangeFinder.hasSource());
    assertEquals(Integer.MAX_VALUE, actualLowestLineNumber);
  }
}
