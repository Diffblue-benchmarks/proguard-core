package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.util.MemberFinder.findField(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindFieldWithClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findField(
            new LibraryClass(1, "This Class Name", "Super Class Name"), "Name", "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.util.MemberFinder.findField(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindFieldWithClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findField(
            new LibraryClass(1, "This Class Name", "Super Class Name"), null, "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.util.MemberFinder.findField(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindFieldWithClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findField(
            new LibraryClass(1, "This Class Name", "Super Class Name"), "Name", null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.util.MemberFinder.findField(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindFieldWithReferencingClassClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findField(
            referencingClass,
            new LibraryClass(1, "This Class Name", "Super Class Name"),
            "Name",
            "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.util.MemberFinder.findField(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findField(
            referencingClass,
            new LibraryClass(1, "This Class Name", "Super Class Name"),
            null,
            "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Field proguard.classfile.util.MemberFinder.findField(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findField(
            referencingClass,
            new LibraryClass(1, "This Class Name", "Super Class Name"),
            "Name",
            null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.util.MemberFinder.findMethod(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindMethodWithClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMethod(
            new LibraryClass(42, "This Class Name", "Super Class Name"), "Name", "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.util.MemberFinder.findMethod(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindMethodWithClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMethod(
            new LibraryClass(42, "This Class Name", "Super Class Name"), null, "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.util.MemberFinder.findMethod(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindMethodWithClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMethod(
            new LibraryClass(42, "This Class Name", "Super Class Name"), "Name", null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.util.MemberFinder.findMethod(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindMethodWithReferencingClassClazzNameDescriptor_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMethod(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.util.MemberFinder.findMethod(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMethod(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            null,
            "Descriptor"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Method proguard.classfile.util.MemberFinder.findMethod(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMethod(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            null));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            "Descriptor",
            true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_whenFalse_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            "Descriptor",
            false));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_whenNull_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            new LibraryClass(42, "This Class Name", "Super Class Name"), null, "Descriptor", true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithClazzNameDescriptorIsField_whenNull_thenReturnNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            new LibraryClass(42, "This Class Name", "Super Class Name"), "Name", null, true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_thenReturnNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            "Descriptor",
            true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            "Descriptor",
            false));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            null,
            "Descriptor",
            true));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MemberFinder.findMember(proguard.classfile.Clazz, proguard.classfile.Clazz, java.lang.String, java.lang.String, boolean)"
  })
  void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(
        memberFinder.findMember(
            referencingClass,
            new LibraryClass(42, "This Class Name", "Super Class Name"),
            "Name",
            null,
            true));
  }

  /**
   * Test {@link MemberFinder#correspondingClass()}.
   *
   * <p>Method under test: {@link MemberFinder#correspondingClass()}
   */
  @Test
  @DisplayName("Test correspondingClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.classfile.util.MemberFinder.correspondingClass()"
  })
  void testCorrespondingClass() {
    // Arrange, Act and Assert
    assertNull((new MemberFinder(true)).correspondingClass());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.MemberFinder.isOverriden(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testIsOverriden_whenLibraryClass_thenReturnFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(memberFinder.isOverriden(clazz, new LibraryMethod(1, "Name", "Descriptor")));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.MemberFinder.isShadowed(proguard.classfile.Clazz, proguard.classfile.Field)"
  })
  void testIsShadowed_whenLibraryClass_thenReturnFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(memberFinder.isShadowed(clazz, new LibraryField(1, "Name", "Descriptor")));
  }
}
