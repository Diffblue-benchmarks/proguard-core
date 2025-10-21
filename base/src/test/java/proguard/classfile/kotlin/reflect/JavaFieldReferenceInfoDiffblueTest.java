package proguard.classfile.kotlin.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

public class JavaFieldReferenceInfoDiffblueTest {
  /**
   * Test {@link JavaFieldReferenceInfo#JavaFieldReferenceInfo(Clazz, Clazz, Member)}.
   *
   * <p>Method under test: {@link JavaFieldReferenceInfo#JavaFieldReferenceInfo(Clazz, Clazz,
   * Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JavaFieldReferenceInfo.<init>(Clazz, Clazz, Member)"})
  public void testNewJavaFieldReferenceInfo() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act
    JavaFieldReferenceInfo actualJavaFieldReferenceInfo =
        new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    Clazz clazz2 = actualJavaFieldReferenceInfo.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member = actualJavaFieldReferenceInfo.member;
    assertTrue(member instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) member).descriptor);
    assertEquals("Name", actualJavaFieldReferenceInfo.getName());
    assertEquals("Name", ((LibraryField) member).name);
    assertEquals("getName()Descriptor", actualJavaFieldReferenceInfo.getSignature());
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(member.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(((LibraryField) member).referencedClass);
    assertNull(actualJavaFieldReferenceInfo.getOwner());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, member.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz2).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, member.getAccessFlags());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String JavaFieldReferenceInfo.getSignature()"})
  public void testGetSignature_thenReturnDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "()Descriptor",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "", "Descriptor")))
            .getSignature());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String JavaFieldReferenceInfo.getSignature()"})
  public void testGetSignature_thenReturnGetIsDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "getIs()Descriptor",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "is", "Descriptor")))
            .getSignature());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String JavaFieldReferenceInfo.getSignature()"})
  public void testGetSignature_thenReturnGetNameDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "getName()Descriptor",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor")))
            .getSignature());
  }
}
