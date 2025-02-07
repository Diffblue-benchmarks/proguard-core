package proguard.classfile.kotlin.visitor;

import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.kotlin.KotlinMetadataVersion;
import proguard.classfile.visitor.ClassVisitor;

class KotlinMetadataVersionFilterDiffblueTest {
  /**
   * Test {@link KotlinMetadataVersionFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVersionFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; given Predicate test(Object) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVersionFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_givenPredicateTestReturnTrue() {
    // Arrange
    Predicate<KotlinMetadataVersion> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinMetadataVersion>any())).thenReturn(true);
    ClassVisitor accepted = mock(ClassVisitor.class);
    doNothing().when(accepted).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinMetadataVersionFilter kotlinMetadataVersionFilter =
        new KotlinMetadataVersionFilter(predicate, accepted, mock(ClassVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataVersionFilter.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(predicate).test(isA(KotlinMetadataVersion.class));
    verify(accepted).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link KotlinMetadataVersionFilter#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>When {@link Annotation#Annotation()}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVersionFilter#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; when Annotation(); then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVersionFilter.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_whenAnnotation_thenCallsTest() {
    // Arrange
    Predicate<KotlinMetadataVersion> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinMetadataVersion>any())).thenReturn(false);
    ClassVisitor accepted = mock(ClassVisitor.class);
    doNothing().when(accepted).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor rejected = mock(ClassVisitor.class);
    doNothing().when(rejected).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinMetadataVersionFilter kotlinMetadataVersionFilter =
        new KotlinMetadataVersionFilter(predicate, accepted, rejected);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataVersionFilter.visitAnnotation(clazz, new Annotation());

    // Assert
    verify(predicate).test(isA(KotlinMetadataVersion.class));
    verify(rejected).visitLibraryClass(isA(LibraryClass.class));
  }
}
