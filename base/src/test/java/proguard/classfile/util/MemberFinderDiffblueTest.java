package proguard.classfile.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class MemberFinderDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, String, String)"})
  public void testFindFieldWithClazzNameDescriptor_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, String, String)"})
  public void testFindFieldWithClazzNameDescriptor_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, String, String)"})
  public void testFindFieldWithClazzNameDescriptor_whenNull_thenReturnNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  public void testFindFieldWithReferencingClassClazzNameDescriptor_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  public void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field MemberFinder.findField(Clazz, Clazz, String, String)"})
  public void testFindFieldWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, String, String)"})
  public void testFindMethodWithClazzNameDescriptor_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, String, String)"})
  public void testFindMethodWithClazzNameDescriptor_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, String, String)"})
  public void testFindMethodWithClazzNameDescriptor_whenNull_thenReturnNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  public void testFindMethodWithReferencingClassClazzNameDescriptor_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  public void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Method MemberFinder.findMethod(Clazz, Clazz, String, String)"})
  public void testFindMethodWithReferencingClassClazzNameDescriptor_whenNull_thenReturnNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  public void testFindMemberWithClazzNameDescriptorIsField_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  public void testFindMemberWithClazzNameDescriptorIsField_whenFalse_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  public void testFindMemberWithClazzNameDescriptorIsField_whenNull_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, String, String, boolean)"
  })
  public void testFindMemberWithClazzNameDescriptorIsField_whenNull_thenReturnNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  public void testFindMemberWithReferencingClassClazzNameDescriptorIsField_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  public void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  public void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.Member MemberFinder.findMember(Clazz, Clazz, String, String, boolean)"
  })
  public void testFindMemberWithReferencingClassClazzNameDescriptorIsField_whenNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz MemberFinder.correspondingClass()"})
  public void testCorrespondingClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemberFinder.isOverriden(Clazz, Method)"})
  public void testIsOverriden_whenLibraryClass_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemberFinder.isShadowed(Clazz, Field)"})
  public void testIsShadowed_whenLibraryClass_thenReturnFalse() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(memberFinder.isShadowed(clazz, new LibraryField(1, "Name", "Descriptor")));
  }
}
