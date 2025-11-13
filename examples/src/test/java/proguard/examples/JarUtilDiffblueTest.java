package proguard.examples;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.visitor.ClassVisitor;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPool JarUtil.readJar(String, String, boolean)"})
  public void testReadJarWithJarFileNameClassNameFilterIsLibrary_thenReturnSizeIsZero()
      throws IOException {
    // Arrange and Act
    ClassPool actualReadJarResult = JarUtil.readJar("foo.txt", "Class Name Filter", true);

    // Assert
    assertEquals(0, actualReadJarResult.size());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPool JarUtil.readJar(String, String, boolean)"})
  public void testReadJarWithJarFileNameClassNameFilterIsLibrary_whenEmptyString()
      throws IOException {
    // Arrange and Act
    ClassPool actualReadJarResult = JarUtil.readJar("foo.txt", "", true);

    // Assert
    assertEquals(0, actualReadJarResult.size());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPool JarUtil.readJar(String, String, boolean)"})
  public void testReadJarWithJarFileNameClassNameFilterIsLibrary_whenFalse() throws IOException {
    // Arrange and Act
    ClassPool actualReadJarResult = JarUtil.readJar("foo.txt", "Class Name Filter", false);

    // Assert
    assertEquals(0, actualReadJarResult.size());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPool JarUtil.readJar(String, boolean)"})
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassPool JarUtil.readJar(String, boolean)"})
  public void testReadJarWithJarFileNameIsLibrary_whenFooTxt_thenReturnSizeIsZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, JarUtil.readJar("foo.txt", true).size());
  }

  /**
   * Test {@link JarUtil#writeJar(ClassPool, String)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#writeJar(ClassPool, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JarUtil.writeJar(ClassPool, String)"})
  public void testWriteJar_givenLibraryClassAcceptDoesNothing_thenCallsAccept() throws IOException {
    // Arrange
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());

    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("Name", clazz);

    // Act
    JarUtil.writeJar(programClassPool, "foo.txt");

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link JarUtil#writeJar(ClassPool, String)}.
   *
   * <ul>
   *   <li>When {@link ClassPool} {@link ClassPool#classesAccept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ClassPool#classesAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link JarUtil#writeJar(ClassPool, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JarUtil.writeJar(ClassPool, String)"})
  public void testWriteJar_whenClassPoolClassesAcceptDoesNothing_thenCallsClassesAccept()
      throws IOException {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    JarUtil.writeJar(programClassPool, "foo.txt");

    // Assert
    verify(programClassPool).classesAccept(isA(ClassVisitor.class));
  }
}
