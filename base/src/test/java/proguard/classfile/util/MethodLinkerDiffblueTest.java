package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.util.Processable;

public class MethodLinkerDiffblueTest {
  /**
   * Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  public void testLastMember() {
    // Arrange and Act
    Member actualLastMemberResult = MethodLinker.lastMember(new LibraryField(1, "Name", "Descriptor"));

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
   * Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  public void testLastMember2() {
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
   * Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  public void testLastMember3() {
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
   * Method under test: {@link MethodLinker#lastProcessable(Processable)}
   */
  @Test
  public void testLastProcessable() {
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

  /**
   * Method under test: {@link MethodLinker#lastProcessable(Processable)}
   */
  @Test
  public void testLastProcessable2() {
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
   * Method under test: {@link MethodLinker#lastProcessable(Processable)}
   */
  @Test
  public void testLastProcessable3() {
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
}
