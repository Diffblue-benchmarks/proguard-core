package proguard.evaluation.executor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodSignature;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.ReflectiveModelExecutor.Builder;
import proguard.evaluation.executor.ReflectiveModelExecutor.SupportedModelInfo;
import proguard.evaluation.value.ArrayReferenceValue;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.util.BasicHierarchyProvider;
import proguard.util.HierarchyProvider;

class ReflectiveModelExecutorDiffblueTest {
  /**
   * Test Builder {@link Builder#addSupportedModel(SupportedModelInfo)}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#addSupportedModel(SupportedModelInfo)}
   *   <li>{@link Builder#addSupportedModel(SupportedModelInfo)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder addSupportedModel(SupportedModelInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.ReflectiveModelExecutor$Builder proguard.evaluation.executor.ReflectiveModelExecutor$Builder.addSupportedModel(proguard.evaluation.executor.ReflectiveModelExecutor$SupportedModelInfo)"
  })
  void testBuilderAddSupportedModel() {
    // Arrange
    Builder builder =
        new Builder(
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act and Assert
    assertSame(builder, builder.addSupportedModel(null));
  }

  /**
   * Test Builder {@link Builder#addSupportedModels(Collection)}.
   *
   * <p>Method under test: {@link Builder#addSupportedModels(Collection)}
   */
  @Test
  @DisplayName("Test Builder addSupportedModels(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.executor.ReflectiveModelExecutor$Builder proguard.evaluation.executor.ReflectiveModelExecutor$Builder.addSupportedModels(java.util.Collection)"
  })
  void testBuilderAddSupportedModels() {
    // Arrange
    Builder builder =
        new Builder(
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act and Assert
    assertSame(builder, builder.addSupportedModels(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#Builder(HierarchyProvider)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.ReflectiveModelExecutor$Builder.<init>(proguard.util.HierarchyProvider)",
    "proguard.evaluation.executor.ReflectiveModelExecutor proguard.evaluation.executor.ReflectiveModelExecutor$Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ReflectiveModelExecutor actualBuildResult =
        (new Builder(
                new BasicHierarchyProvider(
                    KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)))
            .build();

    // Assert
    assertTrue(actualBuildResult.supportedSignatureToModel.isEmpty());
    assertTrue(actualBuildResult.getSupportedMethodSignatures().isEmpty());
    assertTrue(actualBuildResult.supportedModels.isEmpty());
  }

  /**
   * Test {@link ReflectiveModelExecutor#ReflectiveModelExecutor(Set, HierarchyProvider)}.
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#ReflectiveModelExecutor(Set,
   * HierarchyProvider)}
   */
  @Test
  @DisplayName("Test new ReflectiveModelExecutor(Set, HierarchyProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.ReflectiveModelExecutor.<init>(java.util.Set, proguard.util.HierarchyProvider)"
  })
  void testNewReflectiveModelExecutor() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();

    // Act
    ReflectiveModelExecutor actualReflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Assert
    assertTrue(actualReflectiveModelExecutor.supportedSignatureToModel.isEmpty());
    assertTrue(actualReflectiveModelExecutor.getSupportedMethodSignatures().isEmpty());
    assertTrue(actualReflectiveModelExecutor.supportedModels.isEmpty());
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Given {@link AnalyzedObject} {@link AnalyzedObject#isNull()} throw {@link
   *       IllegalStateException#IllegalStateException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); given AnalyzedObject isNull() throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_givenAnalyzedObjectIsNullThrowIllegalStateExceptionWithFoo() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    AnalyzedObject analyzedObject = mock(AnalyzedObject.class);
    when(analyzedObject.isNull()).thenThrow(new IllegalStateException("foo"));
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getValue()).thenReturn(analyzedObject);
    when(arrayReferenceValue.isParticular()).thenReturn(true);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.isConstructor()).thenReturn(false);
    when(methodExecutionInfo.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(methodExecutionInfo.isStatic()).thenReturn(false);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            reflectiveModelExecutor.getMethodResult(
                methodExecutionInfo, mock(ValueCalculator.class)));
    verify(methodExecutionInfo).getInstanceNonStatic();
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo, atLeast(1)).isStatic();
    verify(arrayReferenceValue).getValue();
    verify(arrayReferenceValue).isParticular();
    verify(analyzedObject).isNull();
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodExecutionInfo#getParameters()}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); then calls getParameters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_thenCallsGetParameters() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.getParameters()).thenReturn(new ArrayList<>());
    when(methodExecutionInfo.getSignature())
        .thenReturn(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);
    when(methodExecutionInfo.isConstructor()).thenReturn(false);
    when(methodExecutionInfo.getInstanceNonStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);
    when(methodExecutionInfo.isStatic()).thenReturn(false);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            reflectiveModelExecutor.getMethodResult(
                methodExecutionInfo, mock(ValueCalculator.class)));
    verify(methodExecutionInfo).getInstanceNonStatic();
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo).getParameters();
    verify(methodExecutionInfo).getSignature();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo, atLeast(1)).isStatic();
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_thenReturnNotAnyParameterUpdated() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.isConstructor()).thenReturn(true);
    when(methodExecutionInfo.getInstanceNonStatic()).thenReturn(BasicValueFactory.REFERENCE_VALUE);
    when(methodExecutionInfo.isStatic()).thenReturn(false);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualMethodResult =
        reflectiveModelExecutor.getMethodResult(methodExecutionInfo, mock(ValueCalculator.class));

    // Assert
    verify(methodExecutionInfo).getInstanceNonStatic();
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo, atLeast(1)).isStatic();
    assertFalse(actualMethodResult.isAnyParameterUpdated());
    assertFalse(actualMethodResult.isInstanceUpdated());
    assertFalse(actualMethodResult.isResultValid());
    assertFalse(actualMethodResult.isReturnValuePresent());
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_thenReturnNotAnyParameterUpdated2() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    AnalyzedObject analyzedObject = mock(AnalyzedObject.class);
    when(analyzedObject.isNull()).thenReturn(true);
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getValue()).thenReturn(analyzedObject);
    when(arrayReferenceValue.isParticular()).thenReturn(true);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.isConstructor()).thenReturn(false);
    when(methodExecutionInfo.getInstanceNonStatic()).thenReturn(arrayReferenceValue);
    when(methodExecutionInfo.isStatic()).thenReturn(false);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    MethodResult actualMethodResult =
        reflectiveModelExecutor.getMethodResult(methodExecutionInfo, mock(ValueCalculator.class));

    // Assert
    verify(methodExecutionInfo).getInstanceNonStatic();
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo).isConstructor();
    verify(methodExecutionInfo, atLeast(1)).isStatic();
    verify(arrayReferenceValue).getValue();
    verify(arrayReferenceValue).isParticular();
    verify(analyzedObject).isNull();
    assertFalse(actualMethodResult.isAnyParameterUpdated());
    assertFalse(actualMethodResult.isInstanceUpdated());
    assertFalse(actualMethodResult.isResultValid());
    assertFalse(actualMethodResult.isReturnValuePresent());
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_thenThrowIllegalArgumentException() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    AnalyzedObject analyzedObject = mock(AnalyzedObject.class);
    when(analyzedObject.isNull()).thenThrow(new IllegalArgumentException("foo"));
    ArrayReferenceValue arrayReferenceValue = mock(ArrayReferenceValue.class);
    when(arrayReferenceValue.getValue()).thenReturn(analyzedObject);
    when(arrayReferenceValue.isParticular()).thenReturn(true);
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.isStatic()).thenReturn(false);
    when(methodExecutionInfo.getInstanceOrNullIfStatic()).thenReturn(arrayReferenceValue);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            reflectiveModelExecutor.getMethodResult(
                methodExecutionInfo, mock(ValueCalculator.class)));
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo, atLeast(1)).isStatic();
    verify(arrayReferenceValue).getValue();
    verify(arrayReferenceValue).isParticular();
    verify(analyzedObject).isNull();
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@link MethodExecutionInfo} {@link MethodExecutionInfo#getInstanceOrNullIfStatic()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); when MethodExecutionInfo getInstanceOrNullIfStatic() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_whenMethodExecutionInfoGetInstanceOrNullIfStaticReturnNull() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.isStatic()).thenReturn(false);
    when(methodExecutionInfo.getInstanceOrNullIfStatic()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            reflectiveModelExecutor.getMethodResult(
                methodExecutionInfo, mock(ValueCalculator.class)));
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo, atLeast(1)).isStatic();
  }

  /**
   * Test {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@link MethodExecutionInfo} {@link MethodExecutionInfo#isStatic()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getMethodResult(MethodExecutionInfo,
   * ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test getMethodResult(MethodExecutionInfo, ValueCalculator); when MethodExecutionInfo isStatic() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.executor.ReflectiveModelExecutor.getMethodResult(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testGetMethodResult_whenMethodExecutionInfoIsStaticReturnTrue() {
    // Arrange
    HashSet<SupportedModelInfo<?>> supportedModels = new HashSet<>();
    ReflectiveModelExecutor reflectiveModelExecutor =
        new ReflectiveModelExecutor(
            supportedModels,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));
    MethodExecutionInfo methodExecutionInfo = mock(MethodExecutionInfo.class);
    when(methodExecutionInfo.isStatic()).thenReturn(true);
    when(methodExecutionInfo.getInstanceOrNullIfStatic())
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            reflectiveModelExecutor.getMethodResult(
                methodExecutionInfo, mock(ValueCalculator.class)));
    verify(methodExecutionInfo).getInstanceOrNullIfStatic();
    verify(methodExecutionInfo).isStatic();
  }

  /**
   * Test {@link ReflectiveModelExecutor#getSupportedMethodSignatures()}.
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getSupportedMethodSignatures()}
   */
  @Test
  @DisplayName("Test getSupportedMethodSignatures()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.evaluation.executor.ReflectiveModelExecutor.getSupportedMethodSignatures()"
  })
  void testGetSupportedMethodSignatures() {
    // Arrange
    ReflectiveModelExecutor buildResult =
        (new Builder(
                new BasicHierarchyProvider(
                    KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)))
            .build();

    // Act and Assert
    assertTrue(buildResult.getSupportedMethodSignatures().isEmpty());
  }

  /**
   * Test {@link ReflectiveModelExecutor#generateMethodSignaturesForModel(SupportedModelInfo,
   * HierarchyProvider)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ReflectiveModelExecutor#generateMethodSignaturesForModel(SupportedModelInfo,
   * HierarchyProvider)}
   */
  @Test
  @DisplayName(
      "Test generateMethodSignaturesForModel(SupportedModelInfo, HierarchyProvider); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.evaluation.executor.ReflectiveModelExecutor.generateMethodSignaturesForModel(proguard.evaluation.executor.ReflectiveModelExecutor$SupportedModelInfo, proguard.util.HierarchyProvider)"
  })
  void testGenerateMethodSignaturesForModel_thenReturnEmpty() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;
    SupportedModelInfo<ClassLoaderModel> modelInfo = new SupportedModelInfo<>(modelClass, true);

    // Act
    Set<MethodSignature> actualGenerateMethodSignaturesForModelResult =
        ReflectiveModelExecutor.generateMethodSignaturesForModel(
            modelInfo,
            new BasicHierarchyProvider(
                KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Assert
    assertTrue(actualGenerateMethodSignaturesForModelResult.isEmpty());
  }

  /**
   * Test SupportedModelInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SupportedModelInfo#SupportedModelInfo(Class, boolean)}
   *   <li>{@link SupportedModelInfo#getModelClass()}
   *   <li>{@link SupportedModelInfo#isSupportsFullInheritance()}
   * </ul>
   */
  @Test
  @DisplayName("Test SupportedModelInfo getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.ReflectiveModelExecutor$SupportedModelInfo.<init>(java.lang.Class, boolean)",
    "java.lang.Class proguard.evaluation.executor.ReflectiveModelExecutor$SupportedModelInfo.getModelClass()",
    "boolean proguard.evaluation.executor.ReflectiveModelExecutor$SupportedModelInfo.isSupportsFullInheritance()"
  })
  void testSupportedModelInfoGettersAndSetters() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    SupportedModelInfo<ClassLoaderModel> actualSupportedModelInfo =
        new SupportedModelInfo<>(modelClass, true);
    Class<ClassLoaderModel> actualModelClass = actualSupportedModelInfo.getModelClass();

    // Assert
    assertTrue(actualSupportedModelInfo.isSupportsFullInheritance());
    Class<ClassLoaderModel> expectedModelClass = ClassLoaderModel.class;
    assertEquals(expectedModelClass, actualModelClass);
    assertSame(modelClass, actualModelClass);
  }
}
