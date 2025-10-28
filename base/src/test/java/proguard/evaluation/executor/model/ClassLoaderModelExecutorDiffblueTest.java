package proguard.evaluation.executor.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassLoaderModelExecutorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassLoaderModelExecutor.Builder#build()}
   *   <li>{@link ClassLoaderModelExecutor.Builder#Builder(ClassPool, ClassPool)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        (new ClassLoaderModelExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)).build()
            .getSupportedMethodSignatures()
            .isEmpty());
  }
}
