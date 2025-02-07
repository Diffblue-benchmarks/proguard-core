package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ClassProcessingInfoFilterDiffblueTest {
  /**
   * Test {@link ClassProcessingInfoFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassProcessingInfoFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given Predicate test(Object) return 'false'; when LibraryClass(); then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassProcessingInfoFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenPredicateTestReturnFalse_whenLibraryClass_thenCallsTest() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(false);
    ClassProcessingInfoFilter classProcessingInfoFilter =
        new ClassProcessingInfoFilter(predicate, mock(ClassVisitor.class));

    // Act
    classProcessingInfoFilter.visitAnyClass(new LibraryClass());

    // Assert
    verify(predicate).test(isNull());
  }

  /**
   * Test {@link ClassProcessingInfoFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassProcessingInfoFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given Predicate test(Object) return 'true'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassProcessingInfoFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenPredicateTestReturnTrue_thenCallsVisitLibraryClass() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassProcessingInfoFilter classProcessingInfoFilter =
        new ClassProcessingInfoFilter(predicate, acceptedClassVisitor);

    // Act
    classProcessingInfoFilter.visitAnyClass(new LibraryClass());

    // Assert
    verify(predicate).test(isNull());
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
