package proguard.analysis.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

public class CodeLocationDiffblueTest {
  /**
   * Method under test: {@link CodeLocation#getExternalClassName()}
   */
  @Test
  public void testGetExternalClassName() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertEquals("This Class Name",
        (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).getExternalClassName());
  }

  /**
   * Method under test: {@link CodeLocation#getMemberName()}
   */
  @Test
  public void testGetMemberName() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("Name", (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).getMemberName());
  }

  /**
   * Method under test: {@link CodeLocation#getMemberName()}
   */
  @Test
  public void testGetMemberName2() {
    // Arrange, Act and Assert
    assertNull((new CodeLocation(new LibraryClass(1, "This Class Name", "Super Class Name"), null, 2)).getMemberName());
  }

  /**
   * Method under test: {@link CodeLocation#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("Lnull;Name", (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).getName());
  }

  /**
   * Method under test: {@link CodeLocation#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("L?;?null", (new CodeLocation(clazz, new LibraryMethod(), 2)).getName());
  }

  /**
   * Method under test: {@link CodeLocation#getName()}
   */
  @Test
  public void testGetName3() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertEquals("LThis Class Name;?null", (new CodeLocation(clazz, new LibraryMethod(), 2)).getName());
  }

  /**
   * Method under test: {@link CodeLocation#getName()}
   */
  @Test
  public void testGetName4() {
    // Arrange, Act and Assert
    assertEquals("This Class Name",
        (new CodeLocation(new LibraryClass(1, "This Class Name", "Super Class Name"), null, 2)).getName());
  }

  /**
   * Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(codeLocation, new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2));
  }

  /**
   * Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 1);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(codeLocation, new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2));
  }

  /**
   * Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2), null);
  }

  /**
   * Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2),
        "Different type to CodeLocation");
  }

  /**
   * Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int)}
   */
  @Test
  public void testNewCodeLocation() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof FieldSignature);
    Clazz clazz2 = actualCodeLocation.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryField);
    assertEquals("?", signature.getExternalPackageName());
    assertEquals("?", signature.getPackageName());
    assertEquals("Descriptor", ((FieldSignature) signature).descriptor);
    assertEquals("Descriptor", ((LibraryField) member).descriptor);
    assertEquals("Lnull;Name", actualCodeLocation.getName());
    assertEquals("Lnull;Name", signature.getFqn());
    assertEquals("Name", actualCodeLocation.getMemberName());
    assertEquals("Name", ((FieldSignature) signature).memberName);
    assertEquals("Name", ((LibraryField) member).name);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(member.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(signature.getClassName());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(signature.getReferencedClass());
    assertNull(((LibraryField) member).referencedClass);
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, member.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz2).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, member.getAccessFlags());
    assertEquals(2, actualCodeLocation.offset);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertTrue(signature.isIncomplete());
    assertEquals(Location.UNKNOWN_LINE, actualCodeLocation.line);
    Clazz[] clazzArray2 = clazz.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int)}
   */
  @Test
  public void testNewCodeLocation2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Assert
    Clazz clazz2 = actualCodeLocation.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryMethod);
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("? ?.?(?)", signature.getPrettyFqn());
    assertEquals("?", signature.getExternalPackageName());
    assertEquals("?", signature.getPackageName());
    assertEquals("L?;?null", actualCodeLocation.getName());
    assertEquals("L?;?null", signature.getFqn());
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryMethod) member).referencedClasses);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(member.getProcessingInfo());
    assertNull(actualCodeLocation.getMemberName());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(((MethodSignature) signature).getMethodName());
    assertNull(signature.getClassName());
    assertNull(clazz2.getFeatureName());
    assertNull(((LibraryMethod) member).descriptor);
    assertNull(((LibraryMethod) member).name);
    assertNull(clazz2.getSuperClass());
    assertNull(((MethodSignature) signature).getDescriptor());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, member.getAccessFlags());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, member.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz2).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(2, actualCodeLocation.offset);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertTrue(signature.isIncomplete());
    assertEquals(Location.UNKNOWN_LINE, actualCodeLocation.line);
    Clazz expectedReferencedClass = actualCodeLocation.clazz;
    assertSame(expectedReferencedClass, signature.getReferencedClass());
    Member expectedReferencedMethod = actualCodeLocation.member;
    assertSame(expectedReferencedMethod, ((MethodSignature) signature).getReferencedMethod());
    Clazz[] clazzArray2 = clazz.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}
   */
  @Test
  public void testNewCodeLocation3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2, 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof FieldSignature);
    Clazz clazz2 = actualCodeLocation.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryField);
    assertEquals("?", signature.getExternalPackageName());
    assertEquals("?", signature.getPackageName());
    assertEquals("Descriptor", ((FieldSignature) signature).descriptor);
    assertEquals("Descriptor", ((LibraryField) member).descriptor);
    assertEquals("Lnull;Name", actualCodeLocation.getName());
    assertEquals("Lnull;Name", signature.getFqn());
    assertEquals("Name", actualCodeLocation.getMemberName());
    assertEquals("Name", ((FieldSignature) signature).memberName);
    assertEquals("Name", ((LibraryField) member).name);
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(member.getProcessingInfo());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(signature.getClassName());
    assertNull(clazz2.getFeatureName());
    assertNull(clazz2.getSuperClass());
    assertNull(signature.getReferencedClass());
    assertNull(((LibraryField) member).referencedClass);
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, member.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz2).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(1, member.getAccessFlags());
    assertEquals(2, actualCodeLocation.offset);
    assertEquals(2, actualCodeLocation.line);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertTrue(signature.isIncomplete());
    Clazz[] clazzArray2 = clazz.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}
   */
  @Test
  public void testNewCodeLocation4() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, new LibraryMethod(), 2, 2);

    // Assert
    Clazz clazz2 = actualCodeLocation.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryMethod);
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("? ?.?(?)", signature.getPrettyFqn());
    assertEquals("?", signature.getExternalPackageName());
    assertEquals("?", signature.getPackageName());
    assertEquals("L?;?null", actualCodeLocation.getName());
    assertEquals("L?;?null", signature.getFqn());
    assertNull(((LibraryClass) clazz2).interfaceNames);
    assertNull(((LibraryMethod) member).referencedClasses);
    assertNull(((LibraryClass) clazz2).fields);
    assertNull(((LibraryClass) clazz2).methods);
    assertNull(clazz2.getProcessingInfo());
    assertNull(member.getProcessingInfo());
    assertNull(actualCodeLocation.getMemberName());
    assertNull(clazz2.getName());
    assertNull(clazz2.getSuperName());
    assertNull(((MethodSignature) signature).getMethodName());
    assertNull(signature.getClassName());
    assertNull(clazz2.getFeatureName());
    assertNull(((LibraryMethod) member).descriptor);
    assertNull(((LibraryMethod) member).name);
    assertNull(clazz2.getSuperClass());
    assertNull(((MethodSignature) signature).getDescriptor());
    assertNull(((LibraryClass) clazz2).kotlinMetadata);
    assertEquals(0, clazz2.getAccessFlags());
    assertEquals(0, clazz2.getInterfaceCount());
    assertEquals(0, member.getAccessFlags());
    assertEquals(0, clazz2.getProcessingFlags());
    assertEquals(0, member.getProcessingFlags());
    Clazz[] clazzArray = ((LibraryClass) clazz2).interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, ((LibraryClass) clazz2).subClassCount);
    assertEquals(2, actualCodeLocation.offset);
    assertEquals(2, actualCodeLocation.line);
    assertTrue(clazz2.getExtraFeatureNames().isEmpty());
    assertTrue(signature.isIncomplete());
    Clazz expectedReferencedClass = actualCodeLocation.clazz;
    assertSame(expectedReferencedClass, signature.getReferencedClass());
    Member expectedReferencedMethod = actualCodeLocation.member;
    assertSame(expectedReferencedMethod, ((MethodSignature) signature).getReferencedMethod());
    Clazz[] clazzArray2 = clazz.subClasses;
    assertSame(clazzArray2, clazzArray);
    assertSame(clazzArray2, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Method under test: {@link CodeLocation#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("Lnull;Name+0002 (line -1)",
        (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeLocation#equals(Object)}
   *   <li>{@link CodeLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation codeLocation2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(codeLocation, codeLocation2);
    int expectedHashCodeResult = codeLocation.hashCode();
    assertEquals(expectedHashCodeResult, codeLocation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeLocation#equals(Object)}
   *   <li>{@link CodeLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(codeLocation, codeLocation);
    int expectedHashCodeResult = codeLocation.hashCode();
    assertEquals(expectedHashCodeResult, codeLocation.hashCode());
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(Location.UNKNOWN_LINE, codeLocation.compareTo(new FileLocation("foo.txt", 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, codeLocation
        .compareTo(new CodeLocation(clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(-3, codeLocation
        .compareTo(new CodeLocation(clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2, 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo4() {
    // Arrange
    LibraryClass clazz = new LibraryClass(Location.UNKNOWN_LINE, "This Class Name", "Super Class Name");

    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(-26, codeLocation
        .compareTo(new CodeLocation(clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo5() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "42", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(-26, codeLocation
        .compareTo(new CodeLocation(clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo6() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "42"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, codeLocation
        .compareTo(new CodeLocation(clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo7() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(Location.UNKNOWN_LINE, codeLocation
        .compareTo(new CodeLocation(clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  public void testCompareTo8() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(Location.UNKNOWN_LINE, codeLocation.compareTo(new CodeLocation(clazz2, new LibraryMethod(), 2)));
  }
}
