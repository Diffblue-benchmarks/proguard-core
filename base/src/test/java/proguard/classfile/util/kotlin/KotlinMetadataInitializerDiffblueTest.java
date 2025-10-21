package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation2() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation3() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation4() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningLogger(ReflectiveModel.log, new ArrayList<>()));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation5() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(printWriter, new ArrayList<>()));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation6() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation7() {
    // Arrange
    ArrayList<String> classFilter = new ArrayList<>();
    classFilter.add("Encountered corrupt @kotlin/Metadata for class ");
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningLogger(ReflectiveModel.log, classFilter));
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
   * Test {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)} with {@code clazz},
   * {@code annotation}.
   *
   * <ul>
   *   <li>Given {@link WarningLogger#WarningLogger(Logger)} with logger is {@link
   *       ReflectiveModel#log}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitAnnotation(Clazz, Annotation)"})
  public void testVisitAnnotationWithClazzAnnotation_givenWarningLoggerWithLoggerIsLog() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningLogger(ReflectiveModel.log));
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
   * Test {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int,
   * String, String)}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[],
   * String[], int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMetadataInitializer.initialize(Clazz, int, int[], String[], String[], int, String, String)"
  })
  public void testInitialize() {
    // Arrange
    PrintWriter printWriter = new PrintWriter(new StringWriter());
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(printWriter, new ArrayList<>()));
    LibraryClass clazz = new LibraryClass(1, ".", ".");

    // Act
    kotlinMetadataInitializer.initialize(
        clazz,
        1,
        new int[] {1, -1, 1, -1},
        new String[] {"D1"},
        new String[] {"D2"},
        1,
        "Xs",
        "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Test {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int,
   * String, String)}.
   *
   * <ul>
   *   <li>Then {@link LibraryClass#LibraryClass()} {@link LibraryClass#kotlinMetadata} {@link
   *       KotlinMetadata#k} is one.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[],
   * String[], int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMetadataInitializer.initialize(Clazz, int, int[], String[], String[], int, String, String)"
  })
  public void testInitialize_thenLibraryClassKotlinMetadataKIsOne() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.initialize(
        clazz,
        1,
        new int[] {1, -1, 1, -1},
        new String[] {"D1"},
        new String[] {"D2"},
        1,
        "Xs",
        "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Test {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int,
   * String, String)}.
   *
   * <ul>
   *   <li>Then {@link LibraryClass#LibraryClass()} {@link LibraryClass#kotlinMetadata} {@link
   *       KotlinMetadata#mv} is array of {@code int} with one and one.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[],
   * String[], int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMetadataInitializer.initialize(Clazz, int, int[], String[], String[], int, String, String)"
  })
  public void testInitialize_thenLibraryClassKotlinMetadataMvIsArrayOfIntWithOneAndOne() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.initialize(
        clazz, 0, new int[] {1, 1, 1, -1}, new String[] {"D1"}, new String[] {"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertArrayEquals(new int[] {1, 1, 1, -1}, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Test {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int,
   * String, String)}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code .}.
   *   <li>Then {@link LibraryClass#LibraryClass()} {@link LibraryClass#kotlinMetadata} {@link
   *       KotlinMetadata#k} is one.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[],
   * String[], int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMetadataInitializer.initialize(Clazz, int, int[], String[], String[], int, String, String)"
  })
  public void testInitialize_whenArrayOfStringWithDot_thenLibraryClassKotlinMetadataKIsOne() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.initialize(
        clazz, 1, new int[] {1, -1, 1, -1}, new String[] {"."}, new String[] {"D2"}, 1, "Xs", "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Test {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[], String[], int,
   * String, String)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link LibraryClass#LibraryClass()} {@link LibraryClass#kotlinMetadata} {@link
   *       KotlinMetadata#k} is zero.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#initialize(Clazz, int, int[], String[],
   * String[], int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMetadataInitializer.initialize(Clazz, int, int[], String[], String[], int, String, String)"
  })
  public void testInitialize_whenZero_thenLibraryClassKotlinMetadataKIsZero() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer(new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataInitializer.initialize(
        clazz,
        0,
        new int[] {1, -1, 1, -1},
        new String[] {"D1"},
        new String[] {"D2"},
        1,
        "Xs",
        "Pn");

    // Assert
    KotlinMetadata kotlinMetadata = clazz.kotlinMetadata;
    assertTrue(kotlinMetadata instanceof UnsupportedKotlinMetadata);
    assertEquals("Pn", ((UnsupportedKotlinMetadata) kotlinMetadata).pn);
    assertEquals("Xs", ((UnsupportedKotlinMetadata) kotlinMetadata).xs);
    assertNull(kotlinMetadata.getProcessingInfo());
    assertEquals(0, kotlinMetadata.getProcessingFlags());
    assertEquals(0, ((UnsupportedKotlinMetadata) kotlinMetadata).k);
    assertEquals(1, ((UnsupportedKotlinMetadata) kotlinMetadata).xi);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((UnsupportedKotlinMetadata) kotlinMetadata).mv);
  }

  /**
   * Test {@link KotlinMetadataInitializer#visitUtf8Constant(Clazz, Utf8Constant)}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitUtf8Constant(Clazz, Utf8Constant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitUtf8Constant(Clazz, Utf8Constant)"})
  public void testVisitUtf8Constant() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer((BiConsumer<Clazz, String>) null);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kotlinMetadataInitializer.visitUtf8Constant(clazz, new Utf8Constant("String")));
  }

  /**
   * Test {@link KotlinMetadataInitializer#visitIntegerConstant(Clazz, IntegerConstant)}.
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#visitIntegerConstant(Clazz,
   * IntegerConstant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataInitializer.visitIntegerConstant(Clazz, IntegerConstant)"})
  public void testVisitIntegerConstant() {
    // Arrange
    KotlinMetadataInitializer kotlinMetadataInitializer =
        new KotlinMetadataInitializer((BiConsumer<Clazz, String>) null);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kotlinMetadataInitializer.visitIntegerConstant(clazz, new IntegerConstant(42)));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}.
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isSupportedMetadataVersion(KotlinMetadataVersion)"
  })
  public void testIsSupportedMetadataVersion() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinMetadataInitializer.isSupportedMetadataVersion(new KotlinMetadataVersion(1, 1, 1)));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}.
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isSupportedMetadataVersion(KotlinMetadataVersion)"
  })
  public void testIsSupportedMetadataVersion2() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinMetadataInitializer.isSupportedMetadataVersion(new KotlinMetadataVersion(1, 4, 1)));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}.
   *
   * <ul>
   *   <li>When {@link KotlinMetadataWriter#HIGHEST_ALLOWED_TO_WRITE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isSupportedMetadataVersion(KotlinMetadataVersion)"
  })
  public void testIsSupportedMetadataVersion_whenHighest_allowed_to_write_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinMetadataInitializer.isSupportedMetadataVersion(
            KotlinMetadataWriter.HIGHEST_ALLOWED_TO_WRITE));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}.
   *
   * <ul>
   *   <li>When {@link KotlinMetadataVersion#UNKNOWN_VERSION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isSupportedMetadataVersion(KotlinMetadataVersion)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isSupportedMetadataVersion(KotlinMetadataVersion)"
  })
  public void testIsSupportedMetadataVersion_whenUnknown_version_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinMetadataInitializer.isSupportedMetadataVersion(
            KotlinMetadataVersion.UNKNOWN_VERSION));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code bv}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenBv_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("bv"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code d1}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenD1_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("d1"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code d2}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenD2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("d2"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code k}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenK_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("k"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code mv}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenMv_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("mv"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("Name"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code pn}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenPn_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("pn"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code xi}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenXi_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("xi"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}.
   *
   * <ul>
   *   <li>When {@code xs}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataInitializer#isValidKotlinMetadataAnnotationField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField(String)"
  })
  public void testIsValidKotlinMetadataAnnotationField_whenXs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataInitializer.isValidKotlinMetadataAnnotationField("xs"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code bv}.
   *   <li>Then return {@code bv}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenBv_thenReturnBv() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.bv, KotlinMetadataInitializer.metadataTypeOf("bv"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code d1}.
   *   <li>Then return {@code d1}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenD1_thenReturnD1() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.d1, KotlinMetadataInitializer.metadataTypeOf("d1"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code d2}.
   *   <li>Then return {@code d2}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenD2_thenReturnD2() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.d2, KotlinMetadataInitializer.metadataTypeOf("d2"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code k}.
   *   <li>Then return {@code k}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenK_thenReturnK() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.k, KotlinMetadataInitializer.metadataTypeOf("k"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code mv}.
   *   <li>Then return {@code mv}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenMv_thenReturnMv() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.mv, KotlinMetadataInitializer.metadataTypeOf("mv"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> KotlinMetadataInitializer.metadataTypeOf("Name"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code pn}.
   *   <li>Then return {@code pn}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenPn_thenReturnPn() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.pn, KotlinMetadataInitializer.metadataTypeOf("pn"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code xi}.
   *   <li>Then return {@code xi}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenXi_thenReturnXi() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.xi, KotlinMetadataInitializer.metadataTypeOf("xi"));
  }

  /**
   * Test {@link KotlinMetadataInitializer#metadataTypeOf(String)}.
   *
   * <ul>
   *   <li>When {@code xs}.
   *   <li>Then return {@code xs}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataInitializer#metadataTypeOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinMetadataType KotlinMetadataInitializer.metadataTypeOf(String)"})
  public void testMetadataTypeOf_whenXs_thenReturnXs() {
    // Arrange, Act and Assert
    assertEquals(KotlinMetadataType.xs, KotlinMetadataInitializer.metadataTypeOf("xs"));
  }
}
