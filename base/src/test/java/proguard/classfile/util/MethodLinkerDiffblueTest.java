package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.util.Processable;

class MethodLinkerDiffblueTest {
  /**
   * Test {@link MethodLinker#visitAnyMember(Clazz, Member)}.
   *
   * <p>Method under test: {@link MethodLinker#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MethodLinker.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember() {
    // Arrange
    MethodLinker methodLinker = new MethodLinker();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = mock(LibraryField.class);
    when(member.getProcessingInfo()).thenReturn(new LibraryField(1, "<clinit>", "<clinit>"));
    when(member.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(member.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    methodLinker.visitAnyMember(clazz, member);

    // Assert
    verify(member).getDescriptor(isA(Clazz.class));
    verify(member).getName(isA(Clazz.class));
    verify(member, atLeast(1)).getProcessingInfo();
  }

  /**
   * Test {@link MethodLinker#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Given {@code Processing Info}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member); given 'Processing Info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.MethodLinker.visitAnyMember(proguard.classfile.Clazz, proguard.classfile.Member)"
  })
  void testVisitAnyMember_givenProcessingInfo() {
    // Arrange
    MethodLinker methodLinker = new MethodLinker();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = mock(LibraryField.class);
    when(member.getProcessingInfo()).thenReturn("Processing Info");
    when(member.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(member.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    methodLinker.visitAnyMember(clazz, member);

    // Assert
    verify(member).getDescriptor(isA(Clazz.class));
    verify(member).getName(isA(Clazz.class));
    verify(member, atLeast(1)).getProcessingInfo();
  }

  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @DisplayName("Test lastMember(Member)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MethodLinker.lastMember(proguard.classfile.Member)"
  })
  void testLastMember() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");
    libraryField.setProcessingInfo(null);

    LibraryField member = new LibraryField(1, "Name", "Descriptor");
    member.setProcessingInfo(libraryField);

    // Act
    Member actualLastMemberResult = MethodLinker.lastMember(member);

    // Assert
    assertTrue(actualLastMemberResult instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) actualLastMemberResult).descriptor);
    assertEquals("Name", ((LibraryField) actualLastMemberResult).name);
    assertNull(actualLastMemberResult.getProcessingInfo());
    assertNull(((LibraryField) actualLastMemberResult).referencedClass);
    assertEquals(0, actualLastMemberResult.getProcessingFlags());
    assertEquals(1, actualLastMemberResult.getAccessFlags());
  }

  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <ul>
   *   <li>Given {@code Member}.
   *   <li>Then return ProcessingInfo is {@code Member}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @DisplayName("Test lastMember(Member); given 'Member'; then return ProcessingInfo is 'Member'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MethodLinker.lastMember(proguard.classfile.Member)"
  })
  void testLastMember_givenMember_thenReturnProcessingInfoIsMember() {
    // Arrange
    LibraryField member = new LibraryField(1, "Name", "Descriptor");
    member.setProcessingInfo("Member");

    // Act
    Member actualLastMemberResult = MethodLinker.lastMember(member);

    // Assert
    assertTrue(actualLastMemberResult instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) actualLastMemberResult).descriptor);
    assertEquals("Member", actualLastMemberResult.getProcessingInfo());
    assertEquals("Name", ((LibraryField) actualLastMemberResult).name);
    assertNull(((LibraryField) actualLastMemberResult).referencedClass);
    assertEquals(0, actualLastMemberResult.getProcessingFlags());
    assertEquals(1, actualLastMemberResult.getAccessFlags());
  }

  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <ul>
   *   <li>When {@link LibraryField#LibraryField(int, String, String)} with u2accessFlags is one and
   *       {@code Name} and {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @DisplayName(
      "Test lastMember(Member); when LibraryField(int, String, String) with u2accessFlags is one and 'Name' and 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Member proguard.classfile.util.MethodLinker.lastMember(proguard.classfile.Member)"
  })
  void testLastMember_whenLibraryFieldWithU2accessFlagsIsOneAndNameAndDescriptor() {
    // Arrange and Act
    Member actualLastMemberResult =
        MethodLinker.lastMember(new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertTrue(actualLastMemberResult instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) actualLastMemberResult).descriptor);
    assertEquals("Name", ((LibraryField) actualLastMemberResult).name);
    assertNull(actualLastMemberResult.getProcessingInfo());
    assertNull(((LibraryField) actualLastMemberResult).referencedClass);
    assertEquals(0, actualLastMemberResult.getProcessingFlags());
    assertEquals(1, actualLastMemberResult.getAccessFlags());
  }

  /**
   * Test {@link MethodLinker#lastProcessable(Processable)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()} ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastProcessable(Processable)}
   */
  @Test
  @DisplayName("Test lastProcessable(Processable); given LibraryClass() ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.Processable proguard.classfile.util.MethodLinker.lastProcessable(proguard.util.Processable)"
  })
  void testLastProcessable_givenLibraryClassProcessingInfoIsNull() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.setProcessingInfo(null);

    LibraryClass processable = new LibraryClass();
    processable.setProcessingInfo(libraryClass);

    // Act
    Processable actualLastProcessableResult = MethodLinker.lastProcessable(processable);

    // Assert
    assertTrue(actualLastProcessableResult instanceof LibraryClass);
    assertNull(((LibraryClass) actualLastProcessableResult).interfaceNames);
    assertNull(((LibraryClass) actualLastProcessableResult).fields);
    assertNull(((LibraryClass) actualLastProcessableResult).methods);
    assertNull(actualLastProcessableResult.getProcessingInfo());
    assertNull(((LibraryClass) actualLastProcessableResult).getName());
    assertNull(((LibraryClass) actualLastProcessableResult).getSuperName());
    assertNull(((LibraryClass) actualLastProcessableResult).getFeatureName());
    assertNull(((LibraryClass) actualLastProcessableResult).getSuperClass());
    assertNull(((LibraryClass) actualLastProcessableResult).kotlinMetadata);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).getAccessFlags());
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).getInterfaceCount());
    assertEquals(0, actualLastProcessableResult.getProcessingFlags());
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).subClasses.length);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).subClassCount);
    assertTrue(((LibraryClass) actualLastProcessableResult).getExtraFeatureNames().isEmpty());
  }

  /**
   * Test {@link MethodLinker#lastProcessable(Processable)}.
   *
   * <ul>
   *   <li>Given {@code Processable}.
   *   <li>Then return ProcessingInfo is {@code Processable}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastProcessable(Processable)}
   */
  @Test
  @DisplayName(
      "Test lastProcessable(Processable); given 'Processable'; then return ProcessingInfo is 'Processable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.Processable proguard.classfile.util.MethodLinker.lastProcessable(proguard.util.Processable)"
  })
  void testLastProcessable_givenProcessable_thenReturnProcessingInfoIsProcessable() {
    // Arrange
    LibraryClass processable = new LibraryClass();
    processable.setProcessingInfo("Processable");

    // Act
    Processable actualLastProcessableResult = MethodLinker.lastProcessable(processable);

    // Assert
    assertTrue(actualLastProcessableResult instanceof LibraryClass);
    assertEquals("Processable", actualLastProcessableResult.getProcessingInfo());
    assertNull(((LibraryClass) actualLastProcessableResult).interfaceNames);
    assertNull(((LibraryClass) actualLastProcessableResult).fields);
    assertNull(((LibraryClass) actualLastProcessableResult).methods);
    assertNull(((LibraryClass) actualLastProcessableResult).getName());
    assertNull(((LibraryClass) actualLastProcessableResult).getSuperName());
    assertNull(((LibraryClass) actualLastProcessableResult).getFeatureName());
    assertNull(((LibraryClass) actualLastProcessableResult).getSuperClass());
    assertNull(((LibraryClass) actualLastProcessableResult).kotlinMetadata);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).getAccessFlags());
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).getInterfaceCount());
    assertEquals(0, actualLastProcessableResult.getProcessingFlags());
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).subClasses.length);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).subClassCount);
    assertTrue(((LibraryClass) actualLastProcessableResult).getExtraFeatureNames().isEmpty());
  }

  /**
   * Test {@link MethodLinker#lastProcessable(Processable)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastProcessable(Processable)}
   */
  @Test
  @DisplayName(
      "Test lastProcessable(Processable); when LibraryClass(); then return ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.util.Processable proguard.classfile.util.MethodLinker.lastProcessable(proguard.util.Processable)"
  })
  void testLastProcessable_whenLibraryClass_thenReturnProcessingInfoIsNull() {
    // Arrange and Act
    Processable actualLastProcessableResult = MethodLinker.lastProcessable(new LibraryClass());

    // Assert
    assertTrue(actualLastProcessableResult instanceof LibraryClass);
    assertNull(((LibraryClass) actualLastProcessableResult).interfaceNames);
    assertNull(((LibraryClass) actualLastProcessableResult).fields);
    assertNull(((LibraryClass) actualLastProcessableResult).methods);
    assertNull(actualLastProcessableResult.getProcessingInfo());
    assertNull(((LibraryClass) actualLastProcessableResult).getName());
    assertNull(((LibraryClass) actualLastProcessableResult).getSuperName());
    assertNull(((LibraryClass) actualLastProcessableResult).getFeatureName());
    assertNull(((LibraryClass) actualLastProcessableResult).getSuperClass());
    assertNull(((LibraryClass) actualLastProcessableResult).kotlinMetadata);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).getAccessFlags());
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).getInterfaceCount());
    assertEquals(0, actualLastProcessableResult.getProcessingFlags());
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).interfaceClasses.length);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).subClasses.length);
    assertEquals(0, ((LibraryClass) actualLastProcessableResult).subClassCount);
    assertTrue(((LibraryClass) actualLastProcessableResult).getExtraFeatureNames().isEmpty());
  }
}
