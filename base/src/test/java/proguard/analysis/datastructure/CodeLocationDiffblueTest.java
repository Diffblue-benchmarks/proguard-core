package proguard.analysis.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassSignature;
import proguard.classfile.Clazz;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

class CodeLocationDiffblueTest {
  /**
   * Test {@link CodeLocation#CodeLocation(Clazz, Member, int)}.
   *
   * <ul>
   *   <li>Then {@link CodeLocation#signature} return {@link ClassSignature}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int)}
   */
  @Test
  @DisplayName("Test new CodeLocation(Clazz, Member, int); then signature return ClassSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int)"})
  void testNewCodeLocation_thenSignatureReturnClassSignature() {
    // Arrange
    LibraryClass clazz =
        new LibraryClass(Location.UNKNOWN_LINE, "This Class Name", "Super Class Name");

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, null, 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof ClassSignature);
    Clazz clazz2 = actualCodeLocation.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("", signature.getExternalPackageName());
    assertEquals("", signature.getPackageName());
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", actualCodeLocation.getExternalClassName());
    assertEquals("This Class Name", actualCodeLocation.getName());
    assertEquals("This Class Name", clazz2.getName());
    assertEquals("This Class Name", signature.getClassName());
    assertEquals("This Class Name", signature.getFqn());
    assertEquals("This Class Name", signature.getPrettyFqn());
    assertNull(actualCodeLocation.member);
    assertEquals(0, ((LibraryClass) clazz2).fields.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceNames.length);
    assertEquals(0, ((LibraryClass) clazz2).methods.length);
    assertFalse(signature.isIncomplete());
    assertEquals(Location.UNKNOWN_LINE, clazz2.getAccessFlags());
    assertSame(clazz.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}.
   *
   * <ul>
   *   <li>Then {@link CodeLocation#signature} return {@link ClassSignature}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}
   */
  @Test
  @DisplayName(
      "Test new CodeLocation(Clazz, Member, int, int); then signature return ClassSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int, int)"})
  void testNewCodeLocation_thenSignatureReturnClassSignature2() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, null, 2, 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof ClassSignature);
    Clazz clazz2 = actualCodeLocation.clazz;
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals("", signature.getExternalPackageName());
    assertEquals("", signature.getPackageName());
    assertEquals("Super Class Name", clazz2.getSuperName());
    assertEquals("This Class Name", actualCodeLocation.getExternalClassName());
    assertEquals("This Class Name", actualCodeLocation.getName());
    assertEquals("This Class Name", clazz2.getName());
    assertEquals("This Class Name", signature.getClassName());
    assertEquals("This Class Name", signature.getFqn());
    assertEquals("This Class Name", signature.getPrettyFqn());
    assertNull(actualCodeLocation.member);
    assertEquals(0, ((LibraryClass) clazz2).fields.length);
    assertEquals(0, ((LibraryClass) clazz2).interfaceNames.length);
    assertEquals(0, ((LibraryClass) clazz2).methods.length);
    assertEquals(1, clazz2.getAccessFlags());
    assertFalse(signature.isIncomplete());
    assertSame(clazz.subClasses, ((LibraryClass) clazz2).subClasses);
  }

  /**
   * Test {@link CodeLocation#CodeLocation(Clazz, Member, int)}.
   *
   * <ul>
   *   <li>Then {@link CodeLocation#signature} return {@link FieldSignature}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int)}
   */
  @Test
  @DisplayName("Test new CodeLocation(Clazz, Member, int); then signature return FieldSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int)"})
  void testNewCodeLocation_thenSignatureReturnFieldSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, member, 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof FieldSignature);
    assertTrue(actualCodeLocation.clazz instanceof LibraryClass);
    Member member2 = actualCodeLocation.member;
    assertTrue(member2 instanceof LibraryField);
    assertEquals("Descriptor", ((FieldSignature) signature).descriptor);
    assertEquals("Descriptor", ((LibraryField) member2).descriptor);
    assertEquals("Lnull;Name", actualCodeLocation.getName());
    assertEquals("Lnull;Name", signature.getFqn());
    assertEquals("Name", actualCodeLocation.getMemberName());
    assertEquals("Name", ((FieldSignature) signature).memberName);
    assertEquals("Name", ((LibraryField) member2).name);
    assertNull(((LibraryField) member2).referencedClass);
    assertEquals(1, member2.getAccessFlags());
    assertTrue(signature.isIncomplete());
  }

  /**
   * Test {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}.
   *
   * <ul>
   *   <li>Then {@link CodeLocation#signature} return {@link FieldSignature}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}
   */
  @Test
  @DisplayName(
      "Test new CodeLocation(Clazz, Member, int, int); then signature return FieldSignature")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int, int)"})
  void testNewCodeLocation_thenSignatureReturnFieldSignature2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, member, 2, 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof FieldSignature);
    assertTrue(actualCodeLocation.clazz instanceof LibraryClass);
    Member member2 = actualCodeLocation.member;
    assertTrue(member2 instanceof LibraryField);
    assertEquals("Descriptor", ((FieldSignature) signature).descriptor);
    assertEquals("Descriptor", ((LibraryField) member2).descriptor);
    assertEquals("Lnull;Name", actualCodeLocation.getName());
    assertEquals("Lnull;Name", signature.getFqn());
    assertEquals("Name", actualCodeLocation.getMemberName());
    assertEquals("Name", ((FieldSignature) signature).memberName);
    assertEquals("Name", ((LibraryField) member2).name);
    assertNull(((LibraryField) member2).referencedClass);
    assertEquals(1, member2.getAccessFlags());
    assertTrue(signature.isIncomplete());
  }

  /**
   * Test {@link CodeLocation#CodeLocation(Clazz, Member, int)}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod#LibraryMethod()}.
   *   <li>Then {@link CodeLocation#member} return {@link LibraryMethod}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int)}
   */
  @Test
  @DisplayName(
      "Test new CodeLocation(Clazz, Member, int); when LibraryMethod(); then member return LibraryMethod")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int)"})
  void testNewCodeLocation_whenLibraryMethod_thenMemberReturnLibraryMethod() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Assert
    assertTrue(actualCodeLocation.clazz instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryMethod);
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("? ?.?(?)", signature.getPrettyFqn());
    assertEquals("L?;?null", actualCodeLocation.getName());
    assertEquals("L?;?null", signature.getFqn());
    assertNull(((MethodSignature) signature).getMethodName());
    assertNull(((LibraryMethod) member).descriptor);
    assertNull(((LibraryMethod) member).name);
    assertNull(((LibraryMethod) member).referencedClasses);
    assertNull(((MethodSignature) signature).getDescriptor());
    assertEquals(0, member.getAccessFlags());
    assertTrue(signature.isIncomplete());
    assertSame(actualCodeLocation.clazz, signature.getReferencedClass());
    assertSame(actualCodeLocation.member, ((MethodSignature) signature).getReferencedMethod());
  }

  /**
   * Test {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod#LibraryMethod()}.
   *   <li>Then {@link CodeLocation#member} return {@link LibraryMethod}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int, int)}
   */
  @Test
  @DisplayName(
      "Test new CodeLocation(Clazz, Member, int, int); when LibraryMethod(); then member return LibraryMethod")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int, int)"})
  void testNewCodeLocation_whenLibraryMethod_thenMemberReturnLibraryMethod2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation = new CodeLocation(clazz, new LibraryMethod(), 2, 2);

    // Assert
    assertTrue(actualCodeLocation.clazz instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryMethod);
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof MethodSignature);
    assertEquals("? ?.?(?)", signature.getPrettyFqn());
    assertEquals("L?;?null", actualCodeLocation.getName());
    assertEquals("L?;?null", signature.getFqn());
    assertNull(((MethodSignature) signature).getMethodName());
    assertNull(((LibraryMethod) member).descriptor);
    assertNull(((LibraryMethod) member).name);
    assertNull(((LibraryMethod) member).referencedClasses);
    assertNull(((MethodSignature) signature).getDescriptor());
    assertEquals(0, member.getAccessFlags());
    assertTrue(signature.isIncomplete());
    assertSame(actualCodeLocation.clazz, signature.getReferencedClass());
    assertSame(actualCodeLocation.member, ((MethodSignature) signature).getReferencedMethod());
  }

  /**
   * Test {@link CodeLocation#getExternalClassName()}.
   *
   * <ul>
   *   <li>Then return {@code This Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getExternalClassName()}
   */
  @Test
  @DisplayName("Test getExternalClassName(); then return 'This Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getExternalClassName()"})
  void testGetExternalClassName_thenReturnThisClassName() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);

    // Act and Assert
    assertEquals("This Class Name", codeLocation.getExternalClassName());
  }

  /**
   * Test {@link CodeLocation#getMemberName()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getMemberName()}
   */
  @Test
  @DisplayName("Test getMemberName(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getMemberName()"})
  void testGetMemberName_thenReturnName() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);

    // Act and Assert
    assertEquals("Name", codeLocation.getMemberName());
  }

  /**
   * Test {@link CodeLocation#getMemberName()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getMemberName()}
   */
  @Test
  @DisplayName("Test getMemberName(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getMemberName()"})
  void testGetMemberName_thenReturnNull() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");
    CodeLocation codeLocation = new CodeLocation(clazz, null, 2);

    // Act and Assert
    assertNull(codeLocation.getMemberName());
  }

  /**
   * Test {@link CodeLocation#getName()}.
   *
   * <ul>
   *   <li>Then return {@code L?;?null}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'L?;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  void testGetName_thenReturnLNull() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act and Assert
    assertEquals("L?;?null", codeLocation.getName());
  }

  /**
   * Test {@link CodeLocation#getName()}.
   *
   * <ul>
   *   <li>Then return {@code LThis Class Name;?null}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'LThis Class Name;?null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  void testGetName_thenReturnLThisClassNameNull() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act and Assert
    assertEquals("LThis Class Name;?null", codeLocation.getName());
  }

  /**
   * Test {@link CodeLocation#getName()}.
   *
   * <ul>
   *   <li>Then return {@code Lnull;Name}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'Lnull;Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  void testGetName_thenReturnLnullName() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);

    // Act and Assert
    assertEquals("Lnull;Name", codeLocation.getName());
  }

  /**
   * Test {@link CodeLocation#getName()}.
   *
   * <ul>
   *   <li>Then return {@code This Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'This Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  void testGetName_thenReturnThisClassName() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");
    CodeLocation codeLocation = new CodeLocation(clazz, null, 2);

    // Act and Assert
    assertEquals("This Class Name", codeLocation.getName());
  }

  /**
   * Test {@link CodeLocation#toString()}.
   *
   * <p>Method under test: {@link CodeLocation#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CodeLocation.toString()"})
  void testToString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);

    // Act and Assert
    assertEquals("Lnull;Name+0002 (line -1)", codeLocation.toString());
  }

  /**
   * Test {@link CodeLocation#equals(Object)}, and {@link CodeLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeLocation#equals(Object)}
   *   <li>{@link CodeLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation2 = new CodeLocation(clazz2, member2, 2);

    // Act and Assert
    assertEquals(codeLocation, codeLocation2);
    assertEquals(codeLocation.hashCode(), codeLocation2.hashCode());
  }

  /**
   * Test {@link CodeLocation#equals(Object)}, and {@link CodeLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeLocation#equals(Object)}
   *   <li>{@link CodeLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);

    // Act and Assert
    assertEquals(codeLocation, codeLocation);
    int expectedHashCodeResult = codeLocation.hashCode();
    assertEquals(expectedHashCodeResult, codeLocation.hashCode());
  }

  /**
   * Test {@link CodeLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 1);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(codeLocation, new CodeLocation(clazz2, member2, 2));
  }

  /**
   * Test {@link CodeLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(codeLocation, new CodeLocation(clazz2, member2, 2));
  }

  /**
   * Test {@link CodeLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(new CodeLocation(clazz, member, 2), null);
  }

  /**
   * Test {@link CodeLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertNotEquals(new CodeLocation(clazz, member, 2), "Different type to CodeLocation");
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation() {
    // Arrange
    LibraryClass clazz =
        new LibraryClass(Location.UNKNOWN_LINE, "This Class Name", "Super Class Name");
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor");

    CodeLocation o = new CodeLocation(clazz2, member2, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(-26, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "42", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor");

    CodeLocation o = new CodeLocation(clazz2, member2, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(-26, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "42");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor");

    CodeLocation o = new CodeLocation(clazz2, member2, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation4() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member = new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor");

    CodeLocation o = new CodeLocation(clazz2, member, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(Location.UNKNOWN_LINE, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation5() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation o = new CodeLocation(clazz2, new LibraryMethod(), 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(Location.UNKNOWN_LINE, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return minus three.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'; then return minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation_thenReturnMinusThree() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor");

    CodeLocation o = new CodeLocation(clazz2, member2, 2, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(-3, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation_thenReturnZero() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);
    LibraryClass clazz2 = new LibraryClass();
    LibraryField member2 = new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor");

    CodeLocation o = new CodeLocation(clazz2, member2, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(o);

    // Assert
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <ul>
   *   <li>When {@link FileLocation#FileLocation(String, int)} with filename is {@code foo.txt} and
   *       line is two.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName(
      "Test compareTo(Location) with 'Location'; when FileLocation(String, int) with filename is 'foo.txt' and line is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  void testCompareToWithLocation_whenFileLocationWithFilenameIsFooTxtAndLineIsTwo() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation codeLocation = new CodeLocation(clazz, member, 2);

    // Act
    int actualCompareToResult = codeLocation.compareTo(new FileLocation("foo.txt", 2));

    // Assert
    assertEquals(Location.UNKNOWN_LINE, actualCompareToResult);
  }
}
