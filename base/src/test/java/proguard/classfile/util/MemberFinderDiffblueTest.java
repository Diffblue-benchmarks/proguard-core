package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.testutils.cpa.NamedClass;

class MemberFinderDiffblueTest {
  /**
   * Test {@link MemberFinder#findField(Clazz, String, String)} with {@code clazz}, {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, String, String) with 'clazz', 'name', 'descriptor'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, String, String)"})
  void testFindFieldWithClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, String, String)} with {@code clazz}, {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, String, String) with 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, String, String)"})
  void testFindFieldWithClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(clazz, null, "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, String, String)} with {@code clazz}, {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, String, String) with 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, String, String)"})
  void testFindFieldWithClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(clazz, "Name", null));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  void testFindFieldWithReferencingClassClazzNameDescriptor() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    NamedClass referencingClass = new NamedClass("Member Name");
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  void testFindFieldWithReferencingClassClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  void testFindFieldWithReferencingClassClazzNameDescriptor_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(null, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, clazz, null, "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findField(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findField(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull3() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, clazz, "Name", null));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, String, String)} with {@code clazz}, {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, String, String) with 'clazz', 'name', 'descriptor'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, String, String)"})
  void testFindMethodWithClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, String, String)} with {@code clazz}, {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, String, String) with 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, String, String)"})
  void testFindMethodWithClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(clazz, null, "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, String, String)} with {@code clazz}, {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, String, String) with 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, String, String)"})
  void testFindMethodWithClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(clazz, "Name", null));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  void testFindMethodWithReferencingClassClazzNameDescriptor() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    NamedClass referencingClass = new NamedClass("Member Name");
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  void testFindMethodWithReferencingClassClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  void testFindMethodWithReferencingClassClazzNameDescriptor_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass(42, "This Class Name", "Super Class Name");
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(null, clazz, "Name", "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, clazz, null, "Descriptor"));
  }

  /**
   * Test {@link MemberFinder#findMethod(Clazz, Clazz, String, String)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test findMethod(Clazz, Clazz, String, String) with 'referencingClass', 'clazz', 'name', 'descriptor'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull3() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, clazz, "Name", null));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, String, String, boolean)} with {@code clazz}, {@code
   * name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, String, String, boolean) with 'clazz', 'name', 'descriptor', 'isField'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(clazz, "Name", "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, String, String, boolean)} with {@code clazz}, {@code
   * name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, String, String, boolean) with 'clazz', 'name', 'descriptor', 'isField'; when 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_whenFalse_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(clazz, "Name", "Descriptor", false));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, String, String, boolean)} with {@code clazz}, {@code
   * name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, String, String, boolean) with 'clazz', 'name', 'descriptor', 'isField'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(clazz, null, "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, String, String, boolean)} with {@code clazz}, {@code
   * name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, String, String, boolean) with 'clazz', 'name', 'descriptor', 'isField'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(clazz, "Name", null, true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    NamedClass referencingClass = new NamedClass("Member Name");
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, clazz, "Name", "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, clazz, "Name", "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass(42, "This Class Name", "Super Class Name");
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, clazz, "Name", "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, clazz, "Name", "Descriptor", false));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(null, clazz, "Name", "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, clazz, null, "Descriptor", true));
  }

  /**
   * Test {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)} with {@code
   * referencingClass}, {@code clazz}, {@code name}, {@code descriptor}, {@code isField}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  @DisplayName(
      "Test findMember(Clazz, Clazz, String, String, boolean) with 'referencingClass', 'clazz', 'name', 'descriptor', 'isField'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull3() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass(42, "This Class Name", "Super Class Name");

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, clazz, "Name", null, true));
  }

  /**
   * Test {@link MemberFinder#correspondingClass()}.
   *
   * <p>Method under test: {@link MemberFinder#correspondingClass()}
   */
  @Test
  @DisplayName("Test correspondingClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Clazz MemberFinder.correspondingClass()"})
  void testCorrespondingClass() {
    // Arrange, Act and Assert
    assertNull(new MemberFinder(true).correspondingClass());
  }

  /**
   * Test {@link MemberFinder#isOverriden(Clazz, Method)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#isOverriden(Clazz, Method)}
   */
  @Test
  @DisplayName("Test isOverriden(Clazz, Method); when LibraryClass(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemberFinder.isOverriden(Clazz, Method)"})
  void testIsOverriden_whenLibraryClass_thenReturnFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertFalse(memberFinder.isOverriden(clazz, method));
  }

  /**
   * Test {@link MemberFinder#isShadowed(Clazz, Field)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MemberFinder#isShadowed(Clazz, Field)}
   */
  @Test
  @DisplayName("Test isShadowed(Clazz, Field); when LibraryClass(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemberFinder.isShadowed(Clazz, Field)"})
  void testIsShadowed_whenLibraryClass_thenReturnFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertFalse(memberFinder.isShadowed(clazz, field));
  }
}
