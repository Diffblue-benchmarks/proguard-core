package proguard.classfile.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class MemberFinderDiffblueTest {
  /**
   * Method under test: {@link MemberFinder#findField(Clazz, String, String)}
   */
  @Test
  public void testFindField() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findField(new LibraryClass(1, "This Class Name", "Super Class Name"), "Name", "Descriptor"));
  }

  /**
   * Method under test: {@link MemberFinder#findField(Clazz, String, String)}
   */
  @Test
  public void testFindField2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(memberFinder.findField(new LibraryClass(1, "This Class Name", "Super Class Name"), null, "Descriptor"));
  }

  /**
   * Method under test: {@link MemberFinder#findField(Clazz, String, String)}
   */
  @Test
  public void testFindField3() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(memberFinder.findField(new LibraryClass(1, "This Class Name", "Super Class Name"), "Name", null));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  public void testFindField4() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, new LibraryClass(1, "This Class Name", "Super Class Name"),
        "Name", "Descriptor"));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  public void testFindField5() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, new LibraryClass(1, "This Class Name", "Super Class Name"),
        null, "Descriptor"));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findField(Clazz, Clazz, String, String)}
   */
  @Test
  public void testFindField6() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findField(referencingClass, new LibraryClass(1, "This Class Name", "Super Class Name"),
        "Name", null));
  }

  /**
   * Method under test: {@link MemberFinder#findMethod(Clazz, String, String)}
   */
  @Test
  public void testFindMethod() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMethod(new LibraryClass(42, "This Class Name", "Super Class Name"), "Name", "Descriptor"));
  }

  /**
   * Method under test: {@link MemberFinder#findMethod(Clazz, String, String)}
   */
  @Test
  public void testFindMethod2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMethod(new LibraryClass(42, "This Class Name", "Super Class Name"), null, "Descriptor"));
  }

  /**
   * Method under test: {@link MemberFinder#findMethod(Clazz, String, String)}
   */
  @Test
  public void testFindMethod3() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(memberFinder.findMethod(new LibraryClass(42, "This Class Name", "Super Class Name"), "Name", null));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  public void testFindMethod4() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        "Name", "Descriptor"));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  public void testFindMethod5() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        null, "Descriptor"));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMethod(Clazz, Clazz, String, String)}
   */
  @Test
  public void testFindMethod6() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMethod(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        "Name", null));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(memberFinder.findMember(new LibraryClass(42, "This Class Name", "Super Class Name"), "Name",
        "Descriptor", true));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember2() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMember(new LibraryClass(42, "This Class Name", "Super Class Name"), null, "Descriptor", true));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember3() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(
        memberFinder.findMember(new LibraryClass(42, "This Class Name", "Super Class Name"), "Name", null, true));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember4() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);

    // Act and Assert
    assertNull(memberFinder.findMember(new LibraryClass(42, "This Class Name", "Super Class Name"), "Name",
        "Descriptor", false));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember5() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        "Name", "Descriptor", true));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember6() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        null, "Descriptor", true));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember7() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        "Name", null, true));
  }

  /**
   * Method under test:
   * {@link MemberFinder#findMember(Clazz, Clazz, String, String, boolean)}
   */
  @Test
  public void testFindMember8() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass referencingClass = new LibraryClass();

    // Act and Assert
    assertNull(memberFinder.findMember(referencingClass, new LibraryClass(42, "This Class Name", "Super Class Name"),
        "Name", "Descriptor", false));
  }

  /**
   * Method under test: {@link MemberFinder#correspondingClass()}
   */
  @Test
  public void testCorrespondingClass() {
    // Arrange, Act and Assert
    assertNull((new MemberFinder(true)).correspondingClass());
  }

  /**
   * Method under test: {@link MemberFinder#isOverriden(Clazz, Method)}
   */
  @Test
  public void testIsOverriden() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(memberFinder.isOverriden(clazz, new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link MemberFinder#isShadowed(Clazz, Field)}
   */
  @Test
  public void testIsShadowed() {
    // Arrange
    MemberFinder memberFinder = new MemberFinder(true);
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertFalse(memberFinder.isShadowed(clazz, new LibraryField(1, "Name", "Descriptor")));
  }
}
