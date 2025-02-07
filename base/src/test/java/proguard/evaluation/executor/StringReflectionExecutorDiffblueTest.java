package proguard.evaluation.executor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.executor.ReflectionExecutor.InstanceCopyResult;
import proguard.evaluation.executor.StringReflectionExecutor.Builder;
import proguard.evaluation.executor.instancehandler.ExecutorInstanceHandler;
import proguard.evaluation.executor.instancehandler.ExecutorMethodInstanceHandler;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.ParticularReferenceValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.object.AnalyzedObject;

class StringReflectionExecutorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#Builder(ClassPool)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.StringReflectionExecutor$Builder.<init>(proguard.classfile.ClassPool)",
    "proguard.evaluation.executor.StringReflectionExecutor proguard.evaluation.executor.StringReflectionExecutor$Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    StringReflectionExecutor actualBuildResult =
        (new Builder(KotlinConstants.dummyClassPool)).build();

    // Assert
    assertTrue(
        actualBuildResult.getDefaultInstanceHandler() instanceof ExecutorMethodInstanceHandler);
    assertTrue(actualBuildResult.getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Test {@link StringReflectionExecutor#StringReflectionExecutor(ClassPool)}.
   *
   * <p>Method under test: {@link StringReflectionExecutor#StringReflectionExecutor(ClassPool)}
   */
  @Test
  @DisplayName("Test new StringReflectionExecutor(ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.StringReflectionExecutor.<init>(proguard.classfile.ClassPool)"
  })
  void testNewStringReflectionExecutor() {
    // Arrange and Act
    StringReflectionExecutor actualStringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);

    // Assert
    assertTrue(
        actualStringReflectionExecutor.getDefaultInstanceHandler()
            instanceof ExecutorMethodInstanceHandler);
    assertTrue(actualStringReflectionExecutor.getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Test {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link AnalyzedObject} {@link AnalyzedObject#isModeled()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test getInstanceOrCopyIfMutable(ReferenceValue); given 'true'; when AnalyzedObject isModeled() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.executor.StringReflectionExecutor.getInstanceOrCopyIfMutable(proguard.evaluation.value.ReferenceValue)"
  })
  void testGetInstanceOrCopyIfMutable_givenTrue_whenAnalyzedObjectIsModeledReturnTrue() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<InstanceCopyResult> actualInstanceOrCopyIfMutable =
        stringReflectionExecutor.getInstanceOrCopyIfMutable(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    assertFalse(actualInstanceOrCopyIfMutable.isPresent());
  }

  /**
   * Test {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  @DisplayName("Test getInstanceOrCopyIfMutable(ReferenceValue); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.executor.StringReflectionExecutor.getInstanceOrCopyIfMutable(proguard.evaluation.value.ReferenceValue)"
  })
  void testGetInstanceOrCopyIfMutable_thenThrowIllegalStateException() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenThrow(new IllegalStateException("foo"));
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            stringReflectionExecutor.getInstanceOrCopyIfMutable(
                new ParticularReferenceValue(
                    referencedClass,
                    new ParticularReferenceValueFactory(),
                    "Reference ID",
                    value)));
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
  }

  /**
   * Test {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}.
   *
   * <ul>
   *   <li>When {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test getInstanceOrCopyIfMutable(ReferenceValue); when AnalyzedObject isNull() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.executor.StringReflectionExecutor.getInstanceOrCopyIfMutable(proguard.evaluation.value.ReferenceValue)"
  })
  void testGetInstanceOrCopyIfMutable_whenAnalyzedObjectIsNullReturnFalse() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.isNull()).thenReturn(false);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<InstanceCopyResult> actualInstanceOrCopyIfMutable =
        stringReflectionExecutor.getInstanceOrCopyIfMutable(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    verify(value).isNull();
    assertFalse(actualInstanceOrCopyIfMutable.isPresent());
  }

  /**
   * Test {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}.
   *
   * <ul>
   *   <li>When {@link AnalyzedObject} {@link AnalyzedObject#isNull()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test getInstanceOrCopyIfMutable(ReferenceValue); when AnalyzedObject isNull() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.executor.StringReflectionExecutor.getInstanceOrCopyIfMutable(proguard.evaluation.value.ReferenceValue)"
  })
  void testGetInstanceOrCopyIfMutable_whenAnalyzedObjectIsNullReturnTrue() {
    // Arrange
    StringReflectionExecutor stringReflectionExecutor =
        new StringReflectionExecutor(KotlinConstants.dummyClassPool);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.isModeled()).thenReturn(false);
    when(value.isNull()).thenReturn(true);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<InstanceCopyResult> actualInstanceOrCopyIfMutable =
        stringReflectionExecutor.getInstanceOrCopyIfMutable(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value));

    // Assert
    verify(value, atLeast(1)).getType();
    verify(value).isModeled();
    verify(value).isNull();
    assertFalse(actualInstanceOrCopyIfMutable.isPresent());
  }

  /**
   * Test {@link StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * StringReflectionExecutor#getInstanceOrCopyIfMutable(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test getInstanceOrCopyIfMutable(ReferenceValue); when REFERENCE_VALUE; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.evaluation.executor.StringReflectionExecutor.getInstanceOrCopyIfMutable(proguard.evaluation.value.ReferenceValue)"
  })
  void testGetInstanceOrCopyIfMutable_whenReference_value_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(
        (new StringReflectionExecutor(KotlinConstants.dummyClassPool))
            .getInstanceOrCopyIfMutable(BasicValueFactory.REFERENCE_VALUE)
            .isPresent());
  }

  /**
   * Test {@link StringReflectionExecutor#getDefaultInstanceHandler()}.
   *
   * <p>Method under test: {@link StringReflectionExecutor#getDefaultInstanceHandler()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.instancehandler.ExecutorInstanceHandler proguard.evaluation.executor.StringReflectionExecutor.getDefaultInstanceHandler()"
  })
  void testGetDefaultInstanceHandler() {
    // Arrange and Act
    ExecutorInstanceHandler actualDefaultInstanceHandler =
        (new StringReflectionExecutor(KotlinConstants.dummyClassPool)).getDefaultInstanceHandler();
    boolean actualReturnsOwnInstanceResult =
        actualDefaultInstanceHandler.returnsOwnInstance("foo", "foo");

    // Assert
    assertTrue(actualDefaultInstanceHandler instanceof ExecutorMethodInstanceHandler);
    assertFalse(
        actualDefaultInstanceHandler.returnsOwnInstance("Internal Class Name", "Method Name"));
    assertFalse(actualReturnsOwnInstanceResult);
  }

  /**
   * Test {@link StringReflectionExecutor#getSupportedMethodSignatures()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StringReflectionExecutor#getSupportedMethodSignatures()}
   */
  @Test
  @DisplayName("Test getSupportedMethodSignatures(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.evaluation.executor.StringReflectionExecutor.getSupportedMethodSignatures()"
  })
  void testGetSupportedMethodSignatures_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new StringReflectionExecutor(KotlinConstants.dummyClassPool))
            .getSupportedMethodSignatures()
            .isEmpty());
  }
}
