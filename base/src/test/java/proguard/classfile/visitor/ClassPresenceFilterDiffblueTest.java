package proguard.classfile.visitor;

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
import proguard.classfile.kotlin.KotlinConstants;

class ClassPresenceFilterDiffblueTest {
  /**
   * Test {@link ClassPresenceFilter#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassPresenceFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPresenceFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass() {
    // Arrange
    ClassVisitor presentClassVisitor = mock(ClassVisitor.class);
    doNothing().when(presentClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor missingClassVisitor = mock(ClassVisitor.class);
    doNothing().when(missingClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassPresenceFilter classPresenceFilter =
        new ClassPresenceFilter(
            KotlinConstants.dummyClassPool, presentClassVisitor, missingClassVisitor);

    // Act
    classPresenceFilter.visitAnyClass(new LibraryClass(1, "kotlin/Function", "Super Class Name"));

    // Assert
    verify(presentClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassPresenceFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPresenceFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassPresenceFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor missingClassVisitor = mock(ClassVisitor.class);
    doNothing().when(missingClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassPresenceFilter classPresenceFilter =
        new ClassPresenceFilter(
            KotlinConstants.dummyClassPool, mock(ClassVisitor.class), missingClassVisitor);

    // Act
    classPresenceFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(missingClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
