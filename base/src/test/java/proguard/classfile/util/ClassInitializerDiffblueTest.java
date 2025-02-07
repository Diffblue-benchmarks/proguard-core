package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.kotlin.KotlinConstants;

class ClassInitializerDiffblueTest {
  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassInitializer(ClassPool, ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewClassInitializer() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert that nothing has changed
    assertNull(clazz.getSuperClass());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassInitializer(ClassPool, ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewClassInitializer2() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassInitializer(ClassPool, ClassPool)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewClassInitializer3() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(new ClassPool(), KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer4() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertNull(clazz.getSuperClass());
    assertEquals(1, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer5() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new ProgramClass());

    // Assert that nothing has changed
    assertEquals(0, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer6() {
    // Arrange
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            null,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert that nothing has changed
    assertNull(clazz.getSuperClass());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer7() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.InvalidReferenceVisitor, proguard.classfile.util.InvalidClassReferenceVisitor)"
  })
  void testNewClassInitializer8() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            new ClassPool(),
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class),
            mock(InvalidClassReferenceVisitor.class));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer9() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertNull(clazz.getSuperClass());
    assertEquals(1, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer10() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    actualClassInitializer.visitAnyClass(new ProgramClass());

    // Assert that nothing has changed
    assertEquals(0, missingClassWarningPrinter.getWarningCount());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer11() {
    // Arrange
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            null,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert that nothing has changed
    assertNull(clazz.getSuperClass());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter,
   * WarningPrinter, WarningPrinter, WarningPrinter)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter, proguard.classfile.util.WarningPrinter)"
  })
  void testNewClassInitializer12() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitProgramDependency(Clazz, Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor); then calls visitProgramDependency(Clazz, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.InvalidReferenceVisitor, proguard.classfile.util.InvalidClassReferenceVisitor)"
  })
  void testNewClassInitializer_thenCallsVisitProgramDependency() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor,
            invalidClassReferenceVisitor);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert
    verify(invalidClassReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}.
   *
   * <ul>
   *   <li>When {@link InvalidReferenceVisitor}.
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassInitializer(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor); when InvalidReferenceVisitor; then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.<init>(proguard.classfile.ClassPool, proguard.classfile.ClassPool, boolean, proguard.classfile.util.InvalidReferenceVisitor, proguard.classfile.util.InvalidClassReferenceVisitor)"
  })
  void testNewClassInitializer_whenInvalidReferenceVisitor_thenCallsVisitMissingClass() {
    // Arrange
    InvalidReferenceVisitor invalidReferenceVisitor = mock(InvalidReferenceVisitor.class);
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());

    // Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            invalidReferenceVisitor,
            invalidClassReferenceVisitor);
    actualClassInitializer.visitAnyClass(
        new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert that nothing has changed
    verify(invalidClassReferenceVisitor)
        .visitMissingClass(isA(Clazz.class), eq("Super Class Name"));
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass() {
    // Arrange
    ClassInitializer classInitializer =
        new ClassInitializer(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert that nothing has changed
    assertNull(clazz.getSuperClass());
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass2() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassInitializer classInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert that nothing has changed
    assertNull(clazz.getSuperClass());
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass3() {
    // Arrange
    ClassInitializer classInitializer =
        new ClassInitializer(
            new ClassPool(),
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class),
            mock(InvalidClassReferenceVisitor.class));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("kotlin/Function", superClass.getName());
    assertNull(superClass.getSuperClass());
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, ((ProgramClass) superClass).constantPool.length);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7340032, superClass.getProcessingFlags());
    assertArrayEquals(new int[] {}, ((ProgramClass) superClass).u2interfaces);
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass4() {
    // Arrange
    ClassInitializer classInitializer =
        new ClassInitializer(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("kotlin/Function", superClass.getName());
    assertNull(superClass.getSuperClass());
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, ((ProgramClass) superClass).constantPool.length);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7340032, superClass.getProcessingFlags());
    assertArrayEquals(new int[] {}, ((ProgramClass) superClass).u2interfaces);
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Given {@link PrintWriter#PrintWriter(Writer)} with {@link StringWriter#StringWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); given PrintWriter(Writer) with StringWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_givenPrintWriterWithStringWriter() {
    // Arrange
    WarningPrinter missingClassWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassInitializer classInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            missingClassWarningPrinter,
            missingProgramMemberWarningPrinter,
            missingLibraryMemberWarningPrinter,
            new WarningPrinter(new PrintWriter(new StringWriter())));
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("kotlin/Function", superClass.getName());
    assertNull(superClass.getSuperClass());
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, ((ProgramClass) superClass).constantPool.length);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7340032, superClass.getProcessingFlags());
    assertArrayEquals(new int[] {}, ((ProgramClass) superClass).u2interfaces);
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitMissingClass(Clazz, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitMissingClass(Clazz, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitMissingClass() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitMissingClass(Mockito.<Clazz>any(), Mockito.<String>any());
    ClassInitializer classInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class),
            invalidClassReferenceVisitor);

    // Act
    classInitializer.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert that nothing has changed
    verify(invalidClassReferenceVisitor)
        .visitMissingClass(isA(Clazz.class), eq("Super Class Name"));
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link InvalidClassReferenceVisitor#visitProgramDependency(Clazz, Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitProgramDependency(Clazz, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ClassInitializer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitProgramDependency() {
    // Arrange
    InvalidClassReferenceVisitor invalidClassReferenceVisitor =
        mock(InvalidClassReferenceVisitor.class);
    doNothing()
        .when(invalidClassReferenceVisitor)
        .visitProgramDependency(Mockito.<Clazz>any(), Mockito.<Clazz>any());
    ClassInitializer classInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            true,
            mock(InvalidReferenceVisitor.class),
            invalidClassReferenceVisitor);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    verify(invalidClassReferenceVisitor).visitProgramDependency(isA(Clazz.class), isA(Clazz.class));
    Clazz superClass = clazz.getSuperClass();
    assertTrue(superClass instanceof ProgramClass);
    assertEquals("java/lang/Object", superClass.getSuperName());
    assertEquals("kotlin/Function", superClass.getName());
    assertNull(superClass.getSuperClass());
    assertEquals(0, superClass.getInterfaceCount());
    assertEquals(0, ((ProgramClass) superClass).attributes.length);
    assertEquals(0, ((ProgramClass) superClass).fields.length);
    assertEquals(0, ((ProgramClass) superClass).methods.length);
    assertEquals(0, ((ProgramClass) superClass).u2attributesCount);
    assertEquals(0, ((ProgramClass) superClass).u2fieldsCount);
    assertEquals(0, ((ProgramClass) superClass).u2methodsCount);
    assertEquals(1, superClass.getAccessFlags());
    assertEquals(2, ((ProgramClass) superClass).u2thisClass);
    assertEquals(256, ((ProgramClass) superClass).constantPool.length);
    assertEquals(4, ((ProgramClass) superClass).u2superClass);
    assertEquals(5, ((ProgramClass) superClass).u2constantPoolCount);
    assertEquals(55, ((ProgramClass) superClass).u4version);
    assertEquals(7340032, superClass.getProcessingFlags());
    assertArrayEquals(new int[] {}, ((ProgramClass) superClass).u2interfaces);
  }
}
