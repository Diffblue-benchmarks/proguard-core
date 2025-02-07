package proguard.evaluation.executor.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.model.ClassLoaderModelExecutor.Builder;

class ClassLoaderModelExecutorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#Builder(ClassPool, ClassPool)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.executor.model.ClassLoaderModelExecutor$Builder.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)",
    "proguard.evaluation.executor.model.ClassLoaderModelExecutor proguard.evaluation.executor.model.ClassLoaderModelExecutor$Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        (new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .build()
            .getSupportedMethodSignatures()
            .isEmpty());
  }
}
