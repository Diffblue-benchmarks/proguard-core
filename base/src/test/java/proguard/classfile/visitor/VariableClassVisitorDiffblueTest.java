package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class VariableClassVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableClassVisitor#VariableClassVisitor()}
   *   <li>{@link VariableClassVisitor#setClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#getClassVisitor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableClassVisitor.<init>()",
    "void proguard.classfile.visitor.VariableClassVisitor.<init>(proguard.classfile.visitor.ClassVisitor)",
    "proguard.classfile.visitor.ClassVisitor proguard.classfile.visitor.VariableClassVisitor.getClassVisitor()",
    "void proguard.classfile.visitor.VariableClassVisitor.setClassVisitor(proguard.classfile.visitor.ClassVisitor)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VariableClassVisitor actualVariableClassVisitor = new VariableClassVisitor();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    actualVariableClassVisitor.setClassVisitor(classVisitor);

    // Assert
    assertSame(classVisitor, actualVariableClassVisitor.getClassVisitor());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ClassVisitor}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableClassVisitor#VariableClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#setClassVisitor(ClassVisitor)}
   *   <li>{@link VariableClassVisitor#getClassVisitor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ClassVisitor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableClassVisitor.<init>()",
    "void proguard.classfile.visitor.VariableClassVisitor.<init>(proguard.classfile.visitor.ClassVisitor)",
    "proguard.classfile.visitor.ClassVisitor proguard.classfile.visitor.VariableClassVisitor.getClassVisitor()",
    "void proguard.classfile.visitor.VariableClassVisitor.setClassVisitor(proguard.classfile.visitor.ClassVisitor)"
  })
  void testGettersAndSetters_whenClassVisitor() {
    // Arrange and Act
    VariableClassVisitor actualVariableClassVisitor =
        new VariableClassVisitor(mock(ClassVisitor.class));
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    actualVariableClassVisitor.setClassVisitor(classVisitor);

    // Assert
    assertSame(classVisitor, actualVariableClassVisitor.getClassVisitor());
  }

  /**
   * Test {@link VariableClassVisitor#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableClassVisitor.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    VariableClassVisitor variableClassVisitor = new VariableClassVisitor();
    variableClassVisitor.setClassVisitor(classVisitor);

    // Act
    variableClassVisitor.visitAnyClass(new LibraryClass());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
