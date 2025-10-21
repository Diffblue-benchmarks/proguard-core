package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassInitializerDiffblueTest {
  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.<init>(ClassPool, ClassPool)"})
  public void testNewClassInitializer() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.<init>(ClassPool, ClassPool)"})
  public void testNewClassInitializer2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.<init>(ClassPool, ClassPool)"})
  public void testNewClassInitializer3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer7() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor)"
  })
  public void testNewClassInitializer8() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true, null, null);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    actualClassInitializer.visitAnyClass(clazz);

    // Assert that nothing has changed
    assertNull(clazz.getSuperClass());
  }

  /**
   * Test {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}.
   *
   * <p>Method under test: {@link ClassInitializer#ClassInitializer(ClassPool, ClassPool, boolean,
   * InvalidReferenceVisitor, InvalidClassReferenceVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor)"
  })
  public void testNewClassInitializer9() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true, null, null);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, InvalidReferenceVisitor, InvalidClassReferenceVisitor)"
  })
  public void testNewClassInitializer10() {
    // Arrange and Act
    ClassInitializer actualClassInitializer =
        new ClassInitializer(new ClassPool(), KotlinConstants.dummyClassPool, true, null, null);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer11() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer12() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer13() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassInitializer.<init>(ClassPool, ClassPool, boolean, WarningPrinter, WarningPrinter, WarningPrinter, WarningPrinter)"
  })
  public void testNewClassInitializer14() {
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
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass3() {
    // Arrange
    ClassInitializer classInitializer =
        new ClassInitializer(KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass4() {
    // Arrange
    WarningPrinter missingProgramMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    WarningPrinter missingLibraryMemberWarningPrinter =
        new WarningPrinter(new PrintWriter(new StringWriter()));
    ClassInitializer classInitializer =
        new ClassInitializer(
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool,
            null,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass5() {
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
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }

  /**
   * Test {@link ClassInitializer#visitAnyClass(Clazz)}.
   *
   * <p>Method under test: {@link ClassInitializer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassInitializer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass6() {
    // Arrange
    ClassInitializer classInitializer =
        new ClassInitializer(new ClassPool(), KotlinConstants.dummyClassPool);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "kotlin/Function");

    // Act
    classInitializer.visitAnyClass(clazz);

    // Assert
    assertTrue(clazz.getSuperClass() instanceof ProgramClass);
  }
}
