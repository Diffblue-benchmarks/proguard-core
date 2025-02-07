package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiPredicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.util.Counter;

class CounterConditionalClassVisitorDiffblueTest {
  /**
   * Test {@link CounterConditionalClassVisitor#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link BiPredicate} {@link BiPredicate#test(Object, Object)} return {@code false}.
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link BiPredicate#test(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given BiPredicate test(Object, Object) return 'false'; when LibraryClass(); then calls test(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.CounterConditionalClassVisitor.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenBiPredicateTestReturnFalse_whenLibraryClass_thenCallsTest() {
    // Arrange
    Counter counter = mock(Counter.class);
    when(counter.getCount()).thenReturn(3);
    BiPredicate<Integer, Integer> predicate = mock(BiPredicate.class);
    when(predicate.test(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(false);
    ClassVisitor classVisitor1 = mock(ClassVisitor.class);
    doNothing().when(classVisitor1).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor classVisitor2 = mock(ClassVisitor.class);
    doNothing().when(classVisitor2).visitLibraryClass(Mockito.<LibraryClass>any());
    CounterConditionalClassVisitor counterConditionalClassVisitor =
        new CounterConditionalClassVisitor(counter, predicate, classVisitor1, classVisitor2);

    // Act
    counterConditionalClassVisitor.visitAnyClass(new LibraryClass());

    // Assert
    verify(predicate).test(eq(3), eq(3));
    verify(classVisitor1).visitLibraryClass(isA(LibraryClass.class));
    verify(counter, atLeast(1)).getCount();
  }

  /**
   * Test {@link CounterConditionalClassVisitor#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link BiPredicate} {@link BiPredicate#test(Object, Object)} return {@code true}.
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link BiPredicate#test(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); given BiPredicate test(Object, Object) return 'true'; when LibraryClass(); then calls test(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.CounterConditionalClassVisitor.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenBiPredicateTestReturnTrue_whenLibraryClass_thenCallsTest() {
    // Arrange
    Counter counter = mock(Counter.class);
    when(counter.getCount()).thenReturn(3);
    BiPredicate<Integer, Integer> predicate = mock(BiPredicate.class);
    when(predicate.test(Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(true);
    ClassVisitor classVisitor1 = mock(ClassVisitor.class);
    doNothing().when(classVisitor1).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor classVisitor2 = mock(ClassVisitor.class);
    doNothing().when(classVisitor2).visitLibraryClass(Mockito.<LibraryClass>any());
    CounterConditionalClassVisitor counterConditionalClassVisitor =
        new CounterConditionalClassVisitor(counter, predicate, classVisitor1, classVisitor2);

    // Act
    counterConditionalClassVisitor.visitAnyClass(new LibraryClass());

    // Assert
    verify(predicate).test(eq(3), eq(3));
    verify(classVisitor1).visitLibraryClass(isA(LibraryClass.class));
    verify(classVisitor2).visitLibraryClass(isA(LibraryClass.class));
    verify(counter, atLeast(1)).getCount();
  }

  /**
   * Test {@link CounterConditionalClassVisitor#hasIncreased(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#hasIncreased(int, int)}
   */
  @Test
  @DisplayName("Test hasIncreased(int, int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.visitor.CounterConditionalClassVisitor.hasIncreased(int, int)"
  })
  void testHasIncreased_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CounterConditionalClassVisitor.hasIncreased(1, 1));
  }

  /**
   * Test {@link CounterConditionalClassVisitor#hasIncreased(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#hasIncreased(int, int)}
   */
  @Test
  @DisplayName("Test hasIncreased(int, int); when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.visitor.CounterConditionalClassVisitor.hasIncreased(int, int)"
  })
  void testHasIncreased_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CounterConditionalClassVisitor.hasIncreased(0, 1));
  }

  /**
   * Test {@link CounterConditionalClassVisitor#isSame(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#isSame(int, int)}
   */
  @Test
  @DisplayName("Test isSame(int, int); when one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.visitor.CounterConditionalClassVisitor.isSame(int, int)"
  })
  void testIsSame_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CounterConditionalClassVisitor.isSame(1, 1));
  }

  /**
   * Test {@link CounterConditionalClassVisitor#isSame(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CounterConditionalClassVisitor#isSame(int, int)}
   */
  @Test
  @DisplayName("Test isSame(int, int); when zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.visitor.CounterConditionalClassVisitor.isSame(int, int)"
  })
  void testIsSame_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CounterConditionalClassVisitor.isSame(0, 1));
  }
}
