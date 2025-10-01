package proguard.evaluation.executor.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>(ClassPool, ClassPool)",
    "ClassLoaderModelExecutor Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool)
            .build()
            .getSupportedMethodSignatures()
            .isEmpty());
  }
}
