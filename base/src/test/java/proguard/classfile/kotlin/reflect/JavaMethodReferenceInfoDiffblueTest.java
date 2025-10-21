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

public class JavaMethodReferenceInfoDiffblueTest {
  /**
   * Test {@link JavaMethodReferenceInfo#JavaMethodReferenceInfo(Clazz, Clazz, Member)}.
   *
   * <p>Method under test: {@link JavaMethodReferenceInfo#JavaMethodReferenceInfo(Clazz, Clazz,
   * Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JavaMethodReferenceInfo.<init>(Clazz, Clazz, Member)"})
  public void testNewJavaMethodReferenceInfo() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act
    JavaMethodReferenceInfo actualJavaMethodReferenceInfo =
        new JavaMethodReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    Clazz clazz2 = actualJavaMethodReferenceInfo.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member = actualJavaMethodReferenceInfo.member;
    assertTrue(member instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) member).descriptor);
    assertEquals("Name", actualJavaMethodReferenceInfo.getName());
    assertEquals("Name", ((LibraryField) member).name);
    assertEquals("NameDescriptor", actualJavaMethodReferenceInfo.getSignature());
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
    assertNull(actualJavaMethodReferenceInfo.getOwner());
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
}
