package proguard.classfile.io.kotlin;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.ProgramClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata;
import proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata;
import proguard.classfile.util.WarningPrinter;
import proguard.classfile.visitor.ClassVisitor;

class KotlinMetadataWriterDiffblueTest {
  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata() {
    // Arrange
    KotlinMetadataWriter kotlinMetadataWriter = new KotlinMetadataWriter(mock(BiConsumer.class));
    ProgramClass clazz = mock(ProgramClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());

    // Act
    kotlinMetadataWriter.visitAnyKotlinMetadata(
        clazz,
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 4, 1, 2}, new String[] {"D1"}, 1, "Xs", "Pn"));

    // Assert
    verify(clazz, atLeast(1)).accept(Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata2() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata3() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinMultiFilePartKindMetadata kotlinMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata4() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 4;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata5() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 3;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata6() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 5;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata7() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinMultiFilePartKindMetadata kotlinMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 4;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata8() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinMultiFilePartKindMetadata kotlinMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 3;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata9() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinFileFacadeKindMetadata kotlinMetadata =
        new KotlinFileFacadeKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 5;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BiConsumer} {@link BiConsumer#accept(Object, Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); given BiConsumer accept(Object, Object) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_givenBiConsumerAcceptDoesNothing() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doNothing().when(errorHandler).accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter = new KotlinMetadataWriter(errorHandler);
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 2;

    // Act
    kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata);

    // Assert
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_givenOne() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinMultiFilePartKindMetadata kotlinMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 1;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link StringWriter#StringWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); given PrintWriter(Writer) with StringWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_givenPrintWriterWithStringWriter() {
    // Arrange
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(new WarningPrinter(new PrintWriter(new StringWriter())));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 2;

    // Act
    kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata);

    // Assert
    verify(clazz, atLeast(1)).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName("Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_givenZero() {
    // Arrange
    BiConsumer<Clazz, String> errorHandler = mock(BiConsumer.class);
    doThrow(new IllegalArgumentException("unknown"))
        .when(errorHandler)
        .accept(Mockito.<Clazz>any(), Mockito.<String>any());
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(errorHandler, mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    when(clazz.getName()).thenReturn("Name");
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    kotlinMetadata.k = 0;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> kotlinMetadataWriter.visitAnyKotlinMetadata(clazz, kotlinMetadata));
    verify(errorHandler)
        .accept(
            isA(Clazz.class),
            eq(
                "Encountered corrupt Kotlin metadata in class Name (version unknown). Not processing the metadata for this class."));
    verify(clazz).getName();
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); when ProgramClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_whenProgramClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    KotlinMetadataWriter kotlinMetadataWriter = new KotlinMetadataWriter(mock(BiConsumer.class));
    ProgramClass clazz = mock(ProgramClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());

    // Act
    kotlinMetadataWriter.visitAnyKotlinMetadata(
        clazz,
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 2, 1, 2}, new String[] {"D1"}, 1, "Xs", "Pn"));

    // Assert
    verify(clazz, atLeast(1)).accept(Mockito.<ClassVisitor>any());
  }

  /**
   * Test {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataWriter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); when ProgramClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.io.kotlin.KotlinMetadataWriter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_whenProgramClassAcceptDoesNothing_thenCallsAccept2() {
    // Arrange
    KotlinMetadataWriter kotlinMetadataWriter =
        new KotlinMetadataWriter(mock(BiConsumer.class), mock(ClassVisitor.class));
    ProgramClass clazz = mock(ProgramClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());

    // Act
    kotlinMetadataWriter.visitAnyKotlinMetadata(
        clazz,
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 2, 1, 2}, new String[] {"D1"}, 1, "Xs", "Pn"));

    // Assert
    verify(clazz, atLeast(1)).accept(Mockito.<ClassVisitor>any());
  }
}
