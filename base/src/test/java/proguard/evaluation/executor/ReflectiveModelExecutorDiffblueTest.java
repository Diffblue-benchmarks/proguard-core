package proguard.evaluation.executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.util.BasicHierarchyProvider;
import proguard.util.HierarchyProvider;

public class ReflectiveModelExecutorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ReflectiveModelExecutor.Builder#addSupportedModel(ReflectiveModelExecutor.SupportedModelInfo)}
   *   <li>
   * {@link ReflectiveModelExecutor.Builder#addSupportedModel(ReflectiveModelExecutor.SupportedModelInfo)}
   * </ul>
   */
  @Test
  public void testBuilderAddSupportedModel() {
    // Arrange
    ReflectiveModelExecutor.Builder builder = new ReflectiveModelExecutor.Builder(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act and Assert
    assertSame(builder, builder.addSupportedModel(null));
  }

  /**
   * Method under test:
   * {@link ReflectiveModelExecutor.Builder#addSupportedModels(Collection)}
   */
  @Test
  public void testBuilderAddSupportedModels() {
    // Arrange
    ReflectiveModelExecutor.Builder builder = new ReflectiveModelExecutor.Builder(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool));

    // Act and Assert
    assertSame(builder, builder.addSupportedModels(new ArrayList<>()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReflectiveModelExecutor.Builder#build()}
   *   <li>{@link ReflectiveModelExecutor.Builder#Builder(HierarchyProvider)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange and Act
    ReflectiveModelExecutor actualBuildResult = (new ReflectiveModelExecutor.Builder(
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))).build();

    // Assert
    assertTrue(actualBuildResult.supportedSignatureToModel.isEmpty());
    assertTrue(actualBuildResult.getSupportedMethodSignatures().isEmpty());
    assertTrue(actualBuildResult.supportedModels.isEmpty());
  }

  /**
   * Method under test:
   * {@link ReflectiveModelExecutor#getSupportedMethodSignatures()}
   */
  @Test
  public void testGetSupportedMethodSignatures() {
    // Arrange
    HashSet<ReflectiveModelExecutor.SupportedModelInfo<?>> supportedModels = new HashSet<>();

    // Act and Assert
    assertTrue((new ReflectiveModelExecutor(supportedModels,
        new BasicHierarchyProvider(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)))
            .getSupportedMethodSignatures()
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link ReflectiveModelExecutor#ReflectiveModelExecutor(Set, HierarchyProvider)}
   */
  @Test
  public void testNewReflectiveModelExecutor() {
    // Arrange
    HashSet<ReflectiveModelExecutor.SupportedModelInfo<?>> supportedModels = new HashSet<>();
    BasicHierarchyProvider hierarchy = new BasicHierarchyProvider(KotlinConstants.dummyClassPool,
        KotlinConstants.dummyClassPool);

    // Act
    ReflectiveModelExecutor actualReflectiveModelExecutor = new ReflectiveModelExecutor(supportedModels, hierarchy);

    // Assert
    assertTrue(actualReflectiveModelExecutor.supportedSignatureToModel.isEmpty());
    assertTrue(actualReflectiveModelExecutor.getSupportedMethodSignatures().isEmpty());
    assertTrue(hierarchy.getSubClasses("Class Name").isEmpty());
    assertTrue(actualReflectiveModelExecutor.supportedModels.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ReflectiveModelExecutor.SupportedModelInfo#SupportedModelInfo(Class, boolean)}
   *   <li>{@link ReflectiveModelExecutor.SupportedModelInfo#getModelClass()}
   *   <li>
   * {@link ReflectiveModelExecutor.SupportedModelInfo#isSupportsFullInheritance()}
   * </ul>
   */
  @Test
  public void testSupportedModelInfoGettersAndSetters() {
    // Arrange
    Class<ClassLoaderModel> modelClass = ClassLoaderModel.class;

    // Act
    ReflectiveModelExecutor.SupportedModelInfo<ClassLoaderModel> actualSupportedModelInfo = new ReflectiveModelExecutor.SupportedModelInfo<>(
        modelClass, true);
    Class<ClassLoaderModel> actualModelClass = actualSupportedModelInfo.getModelClass();

    // Assert
    assertTrue(actualSupportedModelInfo.isSupportsFullInheritance());
    Class<ClassLoaderModel> expectedModelClass = ClassLoaderModel.class;
    assertEquals(expectedModelClass, actualModelClass);
    assertSame(modelClass, actualModelClass);
  }
}
