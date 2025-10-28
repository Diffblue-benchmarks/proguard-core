package proguard.classfile.util;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassPoolClassLoaderDiffblueTest {
  /**
   * Method under test:
   * {@link ClassPoolClassLoader#ClassPoolClassLoader(ClassPool)}
   */
  @Test
  public void testNewClassPoolClassLoader() {
    // Arrange, Act and Assert
    assertNotNull(new ClassPoolClassLoader(KotlinConstants.dummyClassPool));
  }
}
