package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.util.Processable;

public class MethodLinkerDiffblueTest {
  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Member MethodLinker.lastMember(Member)"})
  public void testLastMember() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Member MethodLinker.lastMember(Member)"})
  public void testLastMember_givenMember_thenReturnProcessingInfoIsMember() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Member MethodLinker.lastMember(Member)"})
  public void testLastMember_whenLibraryFieldWithU2accessFlagsIsOneAndNameAndDescriptor() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Processable MethodLinker.lastProcessable(Processable)"})
  public void testLastProcessable_givenLibraryClassProcessingInfoIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Processable MethodLinker.lastProcessable(Processable)"})
  public void testLastProcessable_givenProcessable_thenReturnProcessingInfoIsProcessable() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Processable MethodLinker.lastProcessable(Processable)"})
  public void testLastProcessable_whenLibraryClass_thenReturnProcessingInfoIsNull() {
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
