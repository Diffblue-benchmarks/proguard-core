package proguard.io.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.visitor.ClassVisitor;
import proguard.io.ClassPath;
import proguard.io.ClassPathEntry;
import proguard.io.DataEntry;
import proguard.io.DataEntryReader;

class IOUtilDiffblueTest {
  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath,
            "Class Name Filter",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader2()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath,
            "Class Name Filter",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader3()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "**.class").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader4()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader5()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader6()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader7()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader8()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader9()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader10()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader11()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(classPath, null, true, true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader12()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(classPath, "", true, true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader13()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath,
            "Class Name Filter",
            false,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader14()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath,
            "Class Name Filter",
            true,
            true,
            false,
            true,
            true,
            true,
            extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader15()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("**.class")).when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code skipNonPublicLibraryClasses}, {@code
   * skipNonPublicLibraryClassMembers}, {@code ignoreStackMapAttributes}, {@code
   * extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'initializeKotlinMetadata', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibraryInitializeKotlinMetadataSkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader16()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath,
            "!META-INF/versions/**",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath, "Class Name Filter", true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader2()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath, "Class Name Filter", true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader3()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "**.class").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader4()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader5()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader6()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader7()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader8()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader9()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader10()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), false));
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader11()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(classPath, null, true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader12()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(classPath, "", true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader13()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath, "Class Name Filter", false, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader14()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("**.class")).when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                classPath,
                "Class Name Filter",
                true,
                true,
                true,
                true,
                true,
                extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean, boolean,
   * BiFunction)} with {@code classPath}, {@code classNameFilter}, {@code android}, {@code
   * isLibrary}, {@code skipNonPublicLibraryClasses}, {@code skipNonPublicLibraryClassMembers},
   * {@code ignoreStackMapAttributes}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(ClassPath, String, boolean, boolean, boolean, boolean,
   * boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(ClassPath, String, boolean, boolean, boolean, boolean, boolean, BiFunction) with 'classPath', 'classNameFilter', 'android', 'isLibrary', 'skipNonPublicLibraryClasses', 'skipNonPublicLibraryClassMembers', 'ignoreStackMapAttributes', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(proguard.io.ClassPath, java.lang.String, boolean, boolean, boolean, boolean, boolean, java.util.function.BiFunction)"
  })
  void
      testReadWithClassPathClassNameFilterAndroidIsLibrarySkipNonPublicLibraryClassesSkipNonPublicLibraryClassMembersIgnoreStackMapAttributesExtraDataEntryReader15()
          throws IOException {
    // Arrange
    ClassPath classPath =
        new ClassPath(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false));
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult =
        IOUtil.read(
            classPath, "!META-INF/versions/**", true, true, true, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean)} with {@code file}, {@code isLibrary}, {@code
   * initializeKotlinMetadata}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata2() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata3() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata4() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata5() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata6() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata7() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            IOUtil.read(
                Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile(), true, true));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult = IOUtil.read(file, true, true, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader2() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("**")).when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader3() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "**").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader4() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".apk").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader5() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".aab").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader6() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".jar").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader7() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".aar").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader8() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".war").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader9() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".ear").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader10()
      throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), ".jmod").toFile();
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(mock(DataEntryReader.class));

    // Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(file, true, true, extraDataEntryReader));
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#read(File, boolean, boolean, BiFunction)} with {@code file}, {@code
   * isLibrary}, {@code initializeKotlinMetadata}, {@code extraDataEntryReader}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#read(File, boolean, boolean, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test read(File, boolean, boolean, BiFunction) with 'file', 'isLibrary', 'initializeKotlinMetadata', 'extraDataEntryReader'; when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean, java.util.function.BiFunction)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadataExtraDataEntryReader_whenFalse()
      throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);

    // Act
    ClassPool actualReadResult = IOUtil.read(file, true, false, extraDataEntryReader);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    assertEquals(0, actualReadResult.size());
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata_thenReturnSizeIsZero() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean, boolean) with 'file', 'isLibrary', 'initializeKotlinMetadata'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean, boolean)"
  })
  void testReadWithFileIsLibraryInitializeKotlinMetadata_thenReturnSizeIsZero2()
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
  @DisplayName("Test read(File, boolean) with 'file', 'isLibrary'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_thenReturnSizeIsZero() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.aab' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsAabToFile() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.aar' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsAarToFile() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.apk' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsApkToFile() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '**' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsAsteriskAsteriskToFile()
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.ear' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsEarToFile() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.jar' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsJarToFile() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.jmod' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsJmodToFile() throws IOException {
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
  @DisplayName(
      "Test read(File, boolean) with 'file', 'isLibrary'; when Property is 'java.io.tmpdir' is '.war' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.io.File, boolean)"
  })
  void testReadWithFileIsLibrary_whenPropertyIsJavaIoTmpdirIsWarToFile() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.aab'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenAab() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.aar'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenAar() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.apk'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenApk() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.ear'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenEar() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenFalse() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when 'foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenFooTxt() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.jar'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenJar() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.jmod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenJmod() throws IOException {
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
  @DisplayName(
      "Test read(String, boolean, boolean) with 'fileName', 'isLibrary', 'initializeKotlinMetadata'; when '.war'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean, boolean)"
  })
  void testReadWithFileNameIsLibraryInitializeKotlinMetadata_whenWar() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.aab'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenAab() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.aar'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenAar() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.apk'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenApk() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.ear'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenEar() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when 'foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenFooTxt() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.jar'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenJar() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.jmod'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenJmod() throws IOException {
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
  @DisplayName("Test read(String, boolean) with 'fileName', 'isLibrary'; when '.war'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ClassPool proguard.io.util.IOUtil.read(java.lang.String, boolean)"
  })
  void testReadWithFileNameIsLibrary_whenWar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> IOUtil.read(".war", true));
  }

  /**
   * Test {@link IOUtil#writeJar(ClassPool, String, String)} with {@code programClassPool}, {@code
   * outputJarFileName}, {@code mainClassName}.
   *
   * <p>Method under test: {@link IOUtil#writeJar(ClassPool, String, String)}
   */
  @Test
  @DisplayName(
      "Test writeJar(ClassPool, String, String) with 'programClassPool', 'outputJarFileName', 'mainClassName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.util.IOUtil.writeJar(proguard.classfile.ClassPool, java.lang.String, java.lang.String)"
  })
  void testWriteJarWithProgramClassPoolOutputJarFileNameMainClassName() throws IOException {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    IOUtil.writeJar(programClassPool, "foo.txt", "Main Class Name");

    // Assert
    verify(programClassPool).classesAccept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#writeJar(ClassPool, String)} with {@code programClassPool}, {@code
   * outputJarFileName}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#writeJar(ClassPool, String)}
   */
  @Test
  @DisplayName(
      "Test writeJar(ClassPool, String) with 'programClassPool', 'outputJarFileName'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.util.IOUtil.writeJar(proguard.classfile.ClassPool, java.lang.String)"
  })
  void testWriteJarWithProgramClassPoolOutputJarFileName_thenCallsAccept() throws IOException {
    // Arrange
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());

    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("SHA-256", clazz);

    // Act
    IOUtil.writeJar(programClassPool, "foo.txt");

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
  }

  /**
   * Test {@link IOUtil#writeJar(ClassPool, String)} with {@code programClassPool}, {@code
   * outputJarFileName}.
   *
   * <ul>
   *   <li>Then calls {@link ClassPool#classesAccept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtil#writeJar(ClassPool, String)}
   */
  @Test
  @DisplayName(
      "Test writeJar(ClassPool, String) with 'programClassPool', 'outputJarFileName'; then calls classesAccept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.util.IOUtil.writeJar(proguard.classfile.ClassPool, java.lang.String)"
  })
  void testWriteJarWithProgramClassPoolOutputJarFileName_thenCallsClassesAccept()
      throws IOException {
    // Arrange
    ClassPool programClassPool = mock(ClassPool.class);
    doNothing().when(programClassPool).classesAccept(Mockito.<ClassVisitor>any());

    // Act
    IOUtil.writeJar(programClassPool, "foo.txt");

    // Assert
    verify(programClassPool).classesAccept(isA(ClassVisitor.class));
  }
}
