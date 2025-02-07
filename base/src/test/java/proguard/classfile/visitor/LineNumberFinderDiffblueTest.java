package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberTableAttribute;

class LineNumberFinderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LineNumberFinder#LineNumberFinder(int)}
   *   <li>{@link LineNumberFinder#visitAnyAttribute(Clazz, Attribute)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.LineNumberFinder.<init>(int)",
    "void proguard.classfile.visitor.LineNumberFinder.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LineNumberFinder actualLineNumberFinder = new LineNumberFinder(2);
    LibraryClass clazz = new LibraryClass();
    actualLineNumberFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(-1, actualLineNumberFinder.lineNumber);
  }

  /**
   * Test {@link LineNumberFinder#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <p>Method under test: {@link LineNumberFinder#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.LineNumberFinder.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute() {
    // Arrange
    LineNumberFinder lineNumberFinder = new LineNumberFinder(2);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberFinder.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    assertEquals(0, lineNumberFinder.lineNumber);
  }
}
