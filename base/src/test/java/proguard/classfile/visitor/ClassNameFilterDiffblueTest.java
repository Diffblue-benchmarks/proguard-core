package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.util.WildcardManager;

class ClassNameFilterDiffblueTest {
  /**
   * Test {@link ClassNameFilter#ClassNameFilter(List, ClassVisitor, ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(List, ClassVisitor, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(List, ClassVisitor, ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.util.List, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_thenCallsVisitLibraryClass() {
    // Arrange
    ArrayList<Object> regularExpression = new ArrayList<>();
    regularExpression.add("42");
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor rejectedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(regularExpression, acceptedClassVisitor, rejectedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(rejectedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(List, WildcardManager, ClassVisitor,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(List, WildcardManager,
   * ClassVisitor, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(List, WildcardManager, ClassVisitor, ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.util.List, proguard.util.WildcardManager, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_thenCallsVisitLibraryClass2() {
    // Arrange
    ArrayList<Object> regularExpression = new ArrayList<>();
    regularExpression.add("42");
    WildcardManager wildcardManager = new WildcardManager();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor rejectedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(
            regularExpression, wildcardManager, acceptedClassVisitor, rejectedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(rejectedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(List, ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(List, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(List, ClassVisitor); when ArrayList(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.util.List, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenArrayList_thenCallsVisitLibraryClass() {
    // Arrange
    ArrayList<Object> regularExpression = new ArrayList<>();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(regularExpression, acceptedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(List, ClassVisitor, ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(List, ClassVisitor, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(List, ClassVisitor, ClassVisitor); when ArrayList(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.util.List, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenArrayList_thenCallsVisitLibraryClass2() {
    // Arrange
    ArrayList<Object> regularExpression = new ArrayList<>();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(regularExpression, acceptedClassVisitor, mock(ClassVisitor.class));
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(List, WildcardManager, ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(List, WildcardManager,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(List, WildcardManager, ClassVisitor); when ArrayList(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.util.List, proguard.util.WildcardManager, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenArrayList_thenCallsVisitLibraryClass3() {
    // Arrange
    ArrayList<Object> regularExpression = new ArrayList<>();
    WildcardManager wildcardManager = new WildcardManager();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(regularExpression, wildcardManager, acceptedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(List, WildcardManager, ClassVisitor,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(List, WildcardManager,
   * ClassVisitor, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(List, WildcardManager, ClassVisitor, ClassVisitor); when ArrayList(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.util.List, proguard.util.WildcardManager, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenArrayList_thenCallsVisitLibraryClass4() {
    // Arrange
    ArrayList<Object> regularExpression = new ArrayList<>();
    WildcardManager wildcardManager = new WildcardManager();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(
            regularExpression, wildcardManager, acceptedClassVisitor, mock(ClassVisitor.class));
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(String, ClassVisitor)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(String, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(String, ClassVisitor); when empty string; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.lang.String, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenEmptyString_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter = new ClassNameFilter("", acceptedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(String, ClassVisitor, ClassVisitor)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(String, ClassVisitor,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(String, ClassVisitor, ClassVisitor); when empty string; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.lang.String, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenEmptyString_thenCallsVisitLibraryClass2() {
    // Arrange
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor rejectedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter("", acceptedClassVisitor, rejectedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(String, WildcardManager, ClassVisitor)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(String, WildcardManager,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(String, WildcardManager, ClassVisitor); when empty string; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.lang.String, proguard.util.WildcardManager, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenEmptyString_thenCallsVisitLibraryClass3() {
    // Arrange
    WildcardManager wildcardManager = new WildcardManager();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter("", wildcardManager, acceptedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(String, WildcardManager, ClassVisitor,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(String, WildcardManager,
   * ClassVisitor, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(String, WildcardManager, ClassVisitor, ClassVisitor); when empty string; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.lang.String, proguard.util.WildcardManager, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenEmptyString_thenCallsVisitLibraryClass4() {
    // Arrange
    WildcardManager wildcardManager = new WildcardManager();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassVisitor rejectedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter("", wildcardManager, acceptedClassVisitor, rejectedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(String, ClassVisitor, ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(String, ClassVisitor,
   * ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(String, ClassVisitor, ClassVisitor); when 'Regular Expression'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.lang.String, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenRegularExpression_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    ClassVisitor rejectedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter("Regular Expression", acceptedClassVisitor, rejectedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(rejectedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#ClassNameFilter(String, WildcardManager, ClassVisitor,
   * ClassVisitor)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#ClassNameFilter(String, WildcardManager,
   * ClassVisitor, ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test new ClassNameFilter(String, WildcardManager, ClassVisitor, ClassVisitor); when 'Regular Expression'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.<init>(java.lang.String, proguard.util.WildcardManager, proguard.classfile.visitor.ClassVisitor, proguard.classfile.visitor.ClassVisitor)"
  })
  void testNewClassNameFilter_whenRegularExpression_thenCallsVisitLibraryClass2() {
    // Arrange
    WildcardManager wildcardManager = new WildcardManager();
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    ClassVisitor rejectedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(rejectedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    ClassNameFilter actualClassNameFilter =
        new ClassNameFilter(
            "Regular Expression", wildcardManager, acceptedClassVisitor, rejectedClassVisitor);
    actualClassNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(rejectedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link ClassNameFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link ClassNameFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName("Test visitAnyClass(Clazz); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassNameFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor acceptedClassVisitor = mock(ClassVisitor.class);
    doNothing().when(acceptedClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    ClassNameFilter classNameFilter = new ClassNameFilter("", acceptedClassVisitor);

    // Act
    classNameFilter.visitAnyClass(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    verify(acceptedClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
