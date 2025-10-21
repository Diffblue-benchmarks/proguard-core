package proguard.io.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.ClassPath;
import proguard.io.ClassPathEntry;

public class ClassPathUtilDiffblueTest {
  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  public void testHasAabInput() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  public void testHasAabInput2() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  public void testHasAabInput3() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                classPathEntry,
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  public void testHasAabInput_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.hasAabInput(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), false))));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  public void testHasAabInput_whenClassPath() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(new ClassPath()));
  }

  /**
   * Test {@link ClassPathUtil#hasAabInput(ClassPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#hasAabInput(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.hasAabInput(ClassPath)"})
  public void testHasAabInput_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.hasAabInput(null));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid2() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid3() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid4() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid5() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isAndroid(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid6() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(
        ClassPathUtil.isAndroid(
            new ClassPath(
                classPathEntry,
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid_whenClassPath() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isAndroid(new ClassPath()));
  }

  /**
   * Test {@link ClassPathUtil#isAndroid(ClassPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isAndroid(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isAndroid(ClassPath)"})
  public void testIsAndroid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.isAndroid(null));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  public void testIsDalvik() {
    // Arrange, Act and Assert
    assertFalse(
        ClassPathUtil.isDalvik(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  public void testIsDalvik2() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isDalvik(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  public void testIsDalvik3() {
    // Arrange, Act and Assert
    assertTrue(
        ClassPathUtil.isDalvik(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  public void testIsDalvik4() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(
        ClassPathUtil.isDalvik(
            new ClassPath(
                classPathEntry,
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <ul>
   *   <li>When {@link ClassPath#ClassPath(ClassPathEntry[])}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  public void testIsDalvik_whenClassPath() {
    // Arrange
    new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    // Act and Assert
    assertFalse(ClassPathUtil.isDalvik(new ClassPath()));
  }

  /**
   * Test {@link ClassPathUtil#isDalvik(ClassPath)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtil#isDalvik(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassPathUtil.isDalvik(ClassPath)"})
  public void testIsDalvik_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ClassPathUtil.isDalvik(null));
  }

  /**
   * Test {@link ClassPathUtil#determineCompressionMethod(ClassPath)} with {@code classPath}.
   *
   * <p>Method under test: {@link ClassPathUtil#determineCompressionMethod(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.util.StringMatcher ClassPathUtil.determineCompressionMethod(ClassPath)"
  })
  public void testDetermineCompressionMethodWithClassPath() {
    // Arrange, Act and Assert
    assertNull(
        ClassPathUtil.determineCompressionMethod(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true))));
  }

  /**
   * Test {@link ClassPathUtil#determineCompressionMethod(ClassPath)} with {@code classPath}.
   *
   * <p>Method under test: {@link ClassPathUtil#determineCompressionMethod(ClassPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.util.StringMatcher ClassPathUtil.determineCompressionMethod(ClassPath)"
  })
  public void testDetermineCompressionMethodWithClassPath2() {
    // Arrange, Act and Assert
    assertNull(
        ClassPathUtil.determineCompressionMethod(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false))));
  }
}
