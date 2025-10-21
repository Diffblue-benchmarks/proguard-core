package proguard.examples;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JarUtilDiffblueTest {
  /**
   * Test {@link JarUtil#readJar(String, String, boolean)} with {@code jarFileName}, {@code
   * classNameFilter}, {@code isLibrary}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#readJar(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool JarUtil.readJar(String, String, boolean)"})
  public void testReadJarWithJarFileNameClassNameFilterIsLibrary_thenReturnSizeIsZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", "Class Name Filter", true).size());
  }

  /**
   * Test {@link JarUtil#readJar(String, String, boolean)} with {@code jarFileName}, {@code
   * classNameFilter}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#readJar(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool JarUtil.readJar(String, String, boolean)"})
  public void testReadJarWithJarFileNameClassNameFilterIsLibrary_whenEmptyString()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", "", true).size());
  }

  /**
   * Test {@link JarUtil#readJar(String, String, boolean)} with {@code jarFileName}, {@code
   * classNameFilter}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#readJar(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool JarUtil.readJar(String, String, boolean)"})
  public void testReadJarWithJarFileNameClassNameFilterIsLibrary_whenFalse() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", "Class Name Filter", false).size());
  }

  /**
   * Test {@link JarUtil#readJar(String, boolean)} with {@code jarFileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#readJar(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool JarUtil.readJar(String, boolean)"})
  public void testReadJarWithJarFileNameIsLibrary_whenFalse_thenReturnSizeIsZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", false).size());
  }

  /**
   * Test {@link JarUtil#readJar(String, boolean)} with {@code jarFileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#readJar(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool JarUtil.readJar(String, boolean)"})
  public void testReadJarWithJarFileNameIsLibrary_whenFooTxt_thenReturnSizeIsZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", true).size());
  }
}
