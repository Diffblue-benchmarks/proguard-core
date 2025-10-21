package proguard.evaluation.executor.model;

import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.evaluation.executor.model.ClassLoaderModelExecutor.Builder;

public class ClassLoaderModelExecutorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Builder.<init>(ClassPool, ClassPool)",
    "ClassLoaderModelExecutor Builder.build()"
  })
  public void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        (new Builder(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .build()
            .getSupportedMethodSignatures()
            .isEmpty());
  }
}
