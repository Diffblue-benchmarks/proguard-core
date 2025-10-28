package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.io.kotlin.KotlinMetadataWriter;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinMetadataVersion;
import proguard.classfile.kotlin.UnsupportedKotlinMetadata;
import proguard.classfile.util.WarningLogger;
import proguard.classfile.util.WarningPrinter;
import proguard.evaluation.value.object.model.reflective.ReflectiveModel;
import proguard.testutils.cpa.NamedClass;

public class KotlinMetadataInitializerDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int, String, String)}
   */
  @Test
  public void testInitialize() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();
    int[] mv = new int[]{1, -1, 1, -1};

    // Act
    kotlinMetadataInitializer.initialize(clazz, 1, mv, new String[]{"D1"}, new String[]{"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertSame(mv, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int, String, String)}
   */
  @Test
  public void testInitialize2() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();
    int[] mv = new int[]{1, -1, 1, -1};

    // Act
    kotlinMetadataInitializer.initialize(clazz, 0, mv, new String[]{"D1"}, new String[]{"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertSame(mv, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int, String, String)}
   */
  @Test
  public void testInitialize3() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();
    int[] mv = new int[]{1, -1, 1, -1};

    // Act
    kotlinMetadataInitializer.initialize(clazz, 1, mv, new String[]{"."}, new String[]{"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertSame(mv, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int, String, String)}
   */
  @Test
  public void testInitialize4() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(printWriter, new ArrayList<>()));
    LibraryClass clazz = new LibraryClass(1, ".", ".");

    int[] mv = new int[]{1, -1, 1, -1};

    // Act
    kotlinMetadataInitializer.initialize(clazz, 1, mv, new String[]{"D1"}, new String[]{"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertSame(mv, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int, String, String)}
   */
  @Test
  public void testInitialize5() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();
    int[] mv = new int[]{1, 1, 1, -1};

    // Act
    kotlinMetadataInitializer.initialize(clazz, 0, mv, new String[]{"D1"}, new String[]{"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertSame(mv, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}
   */
  @Test
  public void testIsSupportedMetadataVersion() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isSupportedMetadataVersion(KotlinMetadataWriter.HIGHEST_ALLOWED_TO_WRITE));
    assertFalse(KotlinMetadataInitializer.isSupportedMetadataVersion(KotlinMetadataVersion.UNKNOWN_VERSION));
    assertFalse(KotlinMetadataInitializer.isSupportedMetadataVersion(new KotlinMetadataVersion(1, 1, 1)));
    assertTrue(KotlinMetadataInitializer.isSupportedMetadataVersion(new KotlinMetadataVersion(1, 4, 1)));
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  public void testIsValidKotlinMetadataAnnotationField() {
    // Arrange, Act and Assert
    assertFalse(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("Name"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("k"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("bv"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("mv"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("d1"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("d2"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("xi"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("xs"));
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("pn"));
  }

  /**
   * Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  public void testMetadataTypeOf() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> KotlinMetadataInitializer.metadataTypeOf("Name"));
    assertEquals(KotlinMetadataType.k, KotlinMetadataInitializer.metadataTypeOf("k"));
    assertEquals(KotlinMetadataType.bv, KotlinMetadataInitializer.metadataTypeOf("bv"));
    assertEquals(KotlinMetadataType.mv, KotlinMetadataInitializer.metadataTypeOf("mv"));
    assertEquals(KotlinMetadataType.d1, KotlinMetadataInitializer.metadataTypeOf("d1"));
    assertEquals(KotlinMetadataType.d2, KotlinMetadataInitializer.metadataTypeOf("d2"));
    assertEquals(KotlinMetadataType.xi, KotlinMetadataInitializer.metadataTypeOf("xi"));
    assertEquals(KotlinMetadataType.xs, KotlinMetadataInitializer.metadataTypeOf("xs"));
    assertEquals(KotlinMetadataType.pn, KotlinMetadataInitializer.metadataTypeOf("pn"));
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningLogger(ReflectiveModel.log));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation3() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    NamedClass clazz = new NamedClass("unknown");

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation4() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, null);

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation5() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningLogger(ReflectiveModel.log, new ArrayList<>()));
    LibraryClass clazz = new LibraryClass(-1, "unknown", "unknown");

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation6() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(printWriter, new ArrayList<>()));
    NamedClass clazz = new NamedClass("unknown");

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation7() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningPrinter(new PrintWriter(new StringWriter())));
    NamedClass clazz = new NamedClass("unknown");

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, null);

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation8() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("Encountered corrupt @kotlin/Metadata for class ");
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        new WarningLogger(ReflectiveModel.log, classFilter));
    LibraryClass clazz = new LibraryClass(-1, "unknown", "unknown");

    // Act
    kotlinMetadataInitializer.visitAnnotation(clazz, new Annotation());

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).mv);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertNull(((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertEquals(-1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitIntegerConstant(Clazz, IntegerConstant)}
   */
  @Test
  public void testVisitIntegerConstant() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        (BiConsumer<Clazz, String>) null);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> kotlinMetadataInitializer.visitIntegerConstant(clazz, new IntegerConstant(42)));
  }

  /**
   * Method under test:
   * {@link KotlinMetadataInitializer#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  public void testVisitUtf8Constant() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer = new KotlinMetadataInitializer(
        (BiConsumer<Clazz, String>) null);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> kotlinMetadataInitializer.visitUtf8Constant(clazz, new Utf8Constant("String")));
  }
}
