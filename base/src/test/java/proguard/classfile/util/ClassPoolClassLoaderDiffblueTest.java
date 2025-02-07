package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;

class ClassPoolClassLoaderDiffblueTest {
  /**
   * Test {@link ClassPoolClassLoader#ClassPoolClassLoader(ClassPool)}.
   *
   * <p>Method under test: {@link ClassPoolClassLoader#ClassPoolClassLoader(ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassPoolClassLoader(ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassPoolClassLoader.<init>(proguard.classfile.ClassPool)"
  })
  void testNewClassPoolClassLoader() {
    // Arrange, Act and Assert
    assertNotNull(new ClassPoolClassLoader(KotlinConstants.dummyClassPool));
  }
}
