package proguard.io.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IOUtilDiffblueTest {
  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), "**").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata5() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata6() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata7() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata_thenReturnSizeIsZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true, true)
            .size());
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean, boolean)"})
  public void testReadWithFileIsLibraryInitializeKotlinMetadata_thenReturnSizeIsZero2()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true, false)
            .size());
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_thenReturnSizeIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true)
            .size());
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .aab} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsAabToFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .aar} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsAarToFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .apk} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsApkToFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code **} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsAsteriskAsteriskToFile()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), "**").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .ear} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsEarToFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .jar} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsJarToFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .jmod} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsJmodToFile()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean)} with {@code file}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code .war} toFile.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(File, boolean)"})
  public void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsWarToFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> IOUtil.read(Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .aab}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenAab() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".aab", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .aar}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenAar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".aar", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .apk}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenApk() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".apk", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .ear}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenEar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".ear", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenFalse() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read("foo.txt", true, false));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenFooTxt()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read("foo.txt", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .jar}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenJar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".jar", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .jmod}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenJmod() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".jmod", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean, boolean)} with {@code fileName}, {@code isLibrary},
   * {@code initializeKotlinMetadata}.
   *
   * <ul>
   *   <li>When {@code .war}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean, boolean)"})
  public void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenWar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".war", true, true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .aab}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenAab() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".aab", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .aar}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenAar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".aar", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .apk}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenApk() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".apk", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .ear}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenEar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".ear", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenFooTxt() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read("foo.txt", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .jar}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenJar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".jar", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .jmod}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenJmod() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".jmod", true));
  }

  /**
   * Test {@link IOUtil#read(String, boolean)} with {@code fileName}, {@code isLibrary}.
   *
   * <ul>
   *   <li>When {@code .war}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.ClassPool IOUtil.read(String, boolean)"})
  public void testReadWithFileNameIsLibrary_whenWar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".war", true));
  }
}
