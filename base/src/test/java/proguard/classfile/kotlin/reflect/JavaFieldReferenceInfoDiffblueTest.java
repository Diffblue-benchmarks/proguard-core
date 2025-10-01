package proguard.classfile.kotlin.reflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

class JavaFieldReferenceInfoDiffblueTest {
  /**
   * Test {@link JavaFieldReferenceInfo#JavaFieldReferenceInfo(Clazz, Clazz, Member)}.
   *
   * <p>Method under test: {@link JavaFieldReferenceInfo#JavaFieldReferenceInfo(Clazz, Clazz,
   * Member)}
   */
  @Test
  @DisplayName("Test new JavaFieldReferenceInfo(Clazz, Clazz, Member)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JavaFieldReferenceInfo.<init>(Clazz, Clazz, Member)"})
  void testNewJavaFieldReferenceInfo() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    JavaFieldReferenceInfo actualJavaFieldReferenceInfo =
        new JavaFieldReferenceInfo(ownerClass, clazz, member);

    // Assert
    Clazz clazz2 = actualJavaFieldReferenceInfo.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member2 = actualJavaFieldReferenceInfo.member;
    assertTrue(member2 instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) member2).descriptor);
    assertEquals("Name", actualJavaFieldReferenceInfo.getName());
    assertEquals("Name", ((LibraryField) member2).name);
    assertEquals("getName()Descriptor", actualJavaFieldReferenceInfo.getSignature());
    assertNull(clazz2.getProcessingInfo());
    assertNull(member2.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryField) member2).referencedClass);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(actualJavaFieldReferenceInfo.getOwner());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, member2.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz2).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, member2.getAccessFlags());
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    Clazz[] clazzArray2 = clazz.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link JavaFieldReferenceInfo#getSignature()}.
   *
   * <ul>
   *   <li>Then return {@code ()Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link JavaFieldReferenceInfo#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); then return '()Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String JavaFieldReferenceInfo.getSignature()"})
  void testGetSignature_thenReturnDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "", "Descriptor");

    JavaFieldReferenceInfo javaFieldReferenceInfo =
        new JavaFieldReferenceInfo(ownerClass, clazz, member);

    // Act and Assert
    assertEquals("()Descriptor", javaFieldReferenceInfo.getSignature());
  }

  /**
   * Test {@link JavaFieldReferenceInfo#getSignature()}.
   *
   * <ul>
   *   <li>Then return {@code getIs()Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link JavaFieldReferenceInfo#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); then return 'getIs()Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String JavaFieldReferenceInfo.getSignature()"})
  void testGetSignature_thenReturnGetIsDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "is", "Descriptor");

    JavaFieldReferenceInfo javaFieldReferenceInfo =
        new JavaFieldReferenceInfo(ownerClass, clazz, member);

    // Act and Assert
    assertEquals("getIs()Descriptor", javaFieldReferenceInfo.getSignature());
  }

  /**
   * Test {@link JavaFieldReferenceInfo#getSignature()}.
   *
   * <ul>
   *   <li>Then return {@code getName()Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link JavaFieldReferenceInfo#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); then return 'getName()Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String JavaFieldReferenceInfo.getSignature()"})
  void testGetSignature_thenReturnGetNameDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    JavaFieldReferenceInfo javaFieldReferenceInfo =
        new JavaFieldReferenceInfo(ownerClass, clazz, member);

    // Act and Assert
    assertEquals("getName()Descriptor", javaFieldReferenceInfo.getSignature());
  }
}
