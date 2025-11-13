package proguard.io;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataEntryWriterFactory.<init>(ClassPool, ResourceFilePool, int, StringMatcher, int, boolean, boolean, KeyStore.PrivateKeyEntry[])"
  })
  void testNewDataEntryWriterFactory() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    PrivateKeyEntry[] privateKeyEntries = new PrivateKeyEntry[] {null};

    // Act
    DataEntryWriterFactory actualDataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            privateKeyEntries);

    // Assert
    assertNull(actualDataEntryWriterFactory.createDataEntryWriter(null, 1, 1, null));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataEntryWriter DataEntryWriterFactory.createDataEntryWriter(ClassPath, int, int, DataEntryWriter)"
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
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataEntryWriter DataEntryWriterFactory.createDataEntryWriter(ClassPath, int, int, DataEntryWriter)"
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
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
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
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataEntryWriter DataEntryWriterFactory.createDataEntryWriter(ClassPath, int, int, DataEntryWriter)"
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
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    ClassPath classPath = new ClassPath(classPathEntry);
    classPath.add(
        new ClassPathEntry(Paths.get(System.getProperty("java.io.tmpdir"), ".dex").toFile(), true));

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
   *   <li>Then return {@link NameFilteredDataEntryWriter}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter); then return NameFilteredDataEntryWriter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataEntryWriter DataEntryWriterFactory.createDataEntryWriter(ClassPath, int, int, DataEntryWriter)"
  })
  void testCreateDataEntryWriter_thenReturnNameFilteredDataEntryWriter() {
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
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);

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
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryWriterFactory#createDataEntryWriter(ClassPath, int, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test createDataEntryWriter(ClassPath, int, int, DataEntryWriter); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataEntryWriter DataEntryWriterFactory.createDataEntryWriter(ClassPath, int, int, DataEntryWriter)"
  })
  void testCreateDataEntryWriter_thenReturnNull() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    PrivateKeyEntry[] privateKeyEntries = new PrivateKeyEntry[] {null};

    DataEntryWriterFactory dataEntryWriterFactory =
        new DataEntryWriterFactory(
            KotlinConstants.dummyClassPool,
            resourceFilePool,
            1,
            new EmptyStringMatcher(),
            1,
            true,
            true,
            privateKeyEntries);
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    ClassPath classPath = new ClassPath(classPathEntry);

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
