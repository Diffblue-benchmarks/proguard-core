package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFilePool;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class DataEntryWriterFactoryDiffblueTest {
  /**
   * Test {@link DataEntryWriterFactory#DataEntryWriterFactory(ClassPool, ResourceFilePool, int,
   * StringMatcher, int, boolean, boolean, PrivateKeyEntry[])}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#DataEntryWriterFactory(ClassPool,
   * ResourceFilePool, int, StringMatcher, int, boolean, boolean, KeyStore.PrivateKeyEntry[])}
   */
  @Test
  @DisplayName(
      "Test new DataEntryWriterFactory(ClassPool, ResourceFilePool, int, StringMatcher, int, boolean, boolean, PrivateKeyEntry[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryWriterFactory.<init>(proguard.classfile.ClassPool, proguard.resources.file.ResourceFilePool, int, proguard.util.StringMatcher, int, boolean, boolean, java.security.KeyStore$PrivateKeyEntry[])"
  })
  void testNewDataEntryWriterFactory() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();

    // Act and Assert
    assertNull(
        (new DataEntryWriterFactory(
                KotlinConstants.dummyClassPool,
                resourceFilePool,
                1,
                new EmptyStringMatcher(),
                1,
                true,
                true,
                new PrivateKeyEntry[] {null}))
            .createDataEntryWriter(null, 1, 1, null));
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter2() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter3() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter4() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter5() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter6() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter7() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter8() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter9() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);

    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    classPath.add(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile(), true));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter10() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);

    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    classPath.add(
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));

    // Act and Assert
    assertTrue(
        dataEntryWriterFactory.createDataEntryWriter(
                classPath,
                0,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))
            instanceof NameFilteredDataEntryWriter);
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <ul>
   *   <li>Then return {@link FilteredDataEntryWriter}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter); then return FilteredDataEntryWriter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter_thenReturnFilteredDataEntryWriter() throws IOException {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            null);
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true));

    // Act
    DataEntryWriter actualCreateDataEntryWriterResult =
        dataEntryWriterFactory.createDataEntryWriter(
            classPath,
            0,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualCreateDataEntryWriterResult instanceof FilteredDataEntryWriter);
    assertNull(actualCreateDataEntryWriterResult.createOutputStream(null));
    assertFalse(actualCreateDataEntryWriterResult.createDirectory(null));
  }

  /**
   * Test {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryWriter proguard.io.DataEntryWriterFactory.createDataEntryWriter(proguard.io.ClassPath, int, int, proguard.io.DataEntryWriter)"
  })
  void testCreateDataEntryWriter_thenReturnNull() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            new PrivateKeyEntry[] {null});
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Act and Assert
    assertNull(
        dataEntryWriterFactory.createDataEntryWriter(
            classPath,
            1,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
  }
}
