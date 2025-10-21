package proguard.evaluation.executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.ReflectiveModelExecutor.Builder;
import proguard.evaluation.executor.ReflectiveModelExecutor.SupportedModelInfo;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.util.BasicHierarchyProvider;
import proguard.util.HierarchyProvider;

public class ReflectiveModelExecutorDiffblueTest {
  /**
   * Test Builder {@link Builder#addSupportedModels(Collection)}.
   *
   * <p>Method under test: {@link Builder#addSupportedModels(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.addSupportedModels(Collection)"})
  public void testBuilderAddSupportedModels() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Builder.<init>(HierarchyProvider)",
    "ReflectiveModelExecutor Builder.build()"
  })
  public void testBuilderBuild() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReflectiveModelExecutor.<init>(Set, HierarchyProvider)"})
  public void testNewReflectiveModelExecutor() {
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
   * Test {@link ReflectiveModelExecutor#getSupportedMethodSignatures()}.
   *
   * <p>Method under test: {@link ReflectiveModelExecutor#getSupportedMethodSignatures()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set ReflectiveModelExecutor.getSupportedMethodSignatures()"})
  public void testGetSupportedMethodSignatures() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SupportedModelInfo.<init>(Class, boolean)",
    "Class SupportedModelInfo.getModelClass()",
    "boolean SupportedModelInfo.isSupportsFullInheritance()"
  })
  public void testSupportedModelInfoGettersAndSetters() {
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
