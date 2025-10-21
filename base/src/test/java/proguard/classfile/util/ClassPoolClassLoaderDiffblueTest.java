package proguard.classfile.util;

import static org.junit.Assert.assertNotNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassPoolClassLoaderDiffblueTest {
  /**
   * Test {@link ClassPoolClassLoader#ClassPoolClassLoader(ClassPool)}.
   *
   * <p>Method under test: {@link ClassPoolClassLoader#ClassPoolClassLoader(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassPoolClassLoader.<init>(ClassPool)"})
  public void testNewClassPoolClassLoader() {
    // Arrange, Act and Assert
    assertNotNull(new ClassPoolClassLoader(KotlinConstants.dummyClassPool));
  }
}
