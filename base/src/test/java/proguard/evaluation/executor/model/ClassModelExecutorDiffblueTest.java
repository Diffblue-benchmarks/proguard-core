package proguard.evaluation.executor.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassModelExecutorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassModelExecutor.Builder#build()}
   *   <li>{@link ClassModelExecutor.Builder#Builder(ClassPool, ClassPool)}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue((new ClassModelExecutor.Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)).build()
        .getSupportedMethodSignatures()
        .isEmpty());
  }
}
