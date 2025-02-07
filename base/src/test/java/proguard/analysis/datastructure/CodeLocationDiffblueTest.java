package proguard.analysis.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
   *   <li>Then {@link CodeLocation#signature} return {@link FieldSignature}.
   * </ul>
   *
   * <p>Method under test: {@link CodeLocation#CodeLocation(Clazz, Member, int)}
   */
  @Test
  @DisplayName("Test new CodeLocation(Clazz, Member, int); then signature return FieldSignature")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.CodeLocation.<init>(proguard.classfile.Clazz, proguard.classfile.Member, int)"
  })
  void testNewCodeLocation_thenSignatureReturnFieldSignature() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof FieldSignature);
    assertTrue(actualCodeLocation.clazz instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryField);
    assertEquals("Descriptor", ((FieldSignature) signature).descriptor);
    assertEquals("Descriptor", ((LibraryField) member).descriptor);
    assertEquals("Lnull;Name", actualCodeLocation.getName());
    assertEquals("Lnull;Name", signature.getFqn());
    assertEquals("Name", actualCodeLocation.getMemberName());
    assertEquals("Name", ((FieldSignature) signature).memberName);
    assertEquals("Name", ((LibraryField) member).name);
    assertNull(signature.getReferencedClass());
    assertNull(((LibraryField) member).referencedClass);
    assertEquals(1, member.getAccessFlags());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.CodeLocation.<init>(proguard.classfile.Clazz, proguard.classfile.Member, int, int)"
  })
  void testNewCodeLocation_thenSignatureReturnFieldSignature2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    CodeLocation actualCodeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2, 2);

    // Assert
    Signature signature = actualCodeLocation.signature;
    assertTrue(signature instanceof FieldSignature);
    assertTrue(actualCodeLocation.clazz instanceof LibraryClass);
    Member member = actualCodeLocation.member;
    assertTrue(member instanceof LibraryField);
    assertEquals("Descriptor", ((FieldSignature) signature).descriptor);
    assertEquals("Descriptor", ((LibraryField) member).descriptor);
    assertEquals("Lnull;Name", actualCodeLocation.getName());
    assertEquals("Lnull;Name", signature.getFqn());
    assertEquals("Name", actualCodeLocation.getMemberName());
    assertEquals("Name", ((FieldSignature) signature).memberName);
    assertEquals("Name", ((LibraryField) member).name);
    assertNull(signature.getReferencedClass());
    assertNull(((LibraryField) member).referencedClass);
    assertEquals(1, member.getAccessFlags());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.CodeLocation.<init>(proguard.classfile.Clazz, proguard.classfile.Member, int)"
  })
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
    assertNull(((LibraryMethod) member).referencedClasses);
    assertNull(actualCodeLocation.getMemberName());
    assertNull(((MethodSignature) signature).getMethodName());
    assertNull(((LibraryMethod) member).descriptor);
    assertNull(((LibraryMethod) member).name);
    assertNull(((MethodSignature) signature).getDescriptor());
    assertEquals(0, member.getAccessFlags());
    assertTrue(signature.isIncomplete());
    Clazz expectedReferencedClass = actualCodeLocation.clazz;
    assertSame(expectedReferencedClass, signature.getReferencedClass());
    Member expectedReferencedMethod = actualCodeLocation.member;
    assertSame(expectedReferencedMethod, ((MethodSignature) signature).getReferencedMethod());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.CodeLocation.<init>(proguard.classfile.Clazz, proguard.classfile.Member, int, int)"
  })
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
    assertNull(((LibraryMethod) member).referencedClasses);
    assertNull(actualCodeLocation.getMemberName());
    assertNull(((MethodSignature) signature).getMethodName());
    assertNull(((LibraryMethod) member).descriptor);
    assertNull(((LibraryMethod) member).name);
    assertNull(((MethodSignature) signature).getDescriptor());
    assertEquals(0, member.getAccessFlags());
    assertTrue(signature.isIncomplete());
    Clazz expectedReferencedClass = actualCodeLocation.clazz;
    assertSame(expectedReferencedClass, signature.getReferencedClass());
    Member expectedReferencedMethod = actualCodeLocation.member;
    assertSame(expectedReferencedMethod, ((MethodSignature) signature).getReferencedMethod());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.datastructure.CodeLocation.getExternalClassName()"
  })
  void testGetExternalClassName_thenReturnThisClassName() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertEquals(
        "This Class Name",
        (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2))
            .getExternalClassName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.datastructure.CodeLocation.getMemberName()"
  })
  void testGetMemberName_thenReturnName() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Name",
        (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).getMemberName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.analysis.datastructure.CodeLocation.getMemberName()"
  })
  void testGetMemberName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new CodeLocation(new LibraryClass(1, "This Class Name", "Super Class Name"), null, 2))
            .getMemberName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.CodeLocation.getName()"})
  void testGetName_thenReturnLNull() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("L?;?null", (new CodeLocation(clazz, new LibraryMethod(), 2)).getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.CodeLocation.getName()"})
  void testGetName_thenReturnLThisClassNameNull() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act and Assert
    assertEquals(
        "LThis Class Name;?null", (new CodeLocation(clazz, new LibraryMethod(), 2)).getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.CodeLocation.getName()"})
  void testGetName_thenReturnLnullName() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Lnull;Name",
        (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.CodeLocation.getName()"})
  void testGetName_thenReturnThisClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "This Class Name",
        (new CodeLocation(new LibraryClass(1, "This Class Name", "Super Class Name"), null, 2))
            .getName());
  }

  /**
   * Test {@link CodeLocation#toString()}.
   *
   * <p>Method under test: {@link CodeLocation#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.analysis.datastructure.CodeLocation.toString()"})
  void testToString() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Lnull;Name+0002 (line -1)",
        (new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)).toString());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.CodeLocation.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.CodeLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();
    CodeLocation codeLocation2 =
        new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(codeLocation, codeLocation2);
    int expectedHashCodeResult = codeLocation.hashCode();
    assertEquals(expectedHashCodeResult, codeLocation2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.CodeLocation.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.CodeLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.CodeLocation.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.CodeLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        codeLocation, new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.CodeLocation.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.CodeLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 1);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        codeLocation, new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.CodeLocation.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.CodeLocation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2), null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.datastructure.CodeLocation.equals(java.lang.Object)",
    "int proguard.analysis.datastructure.CodeLocation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNotEquals(
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2),
        "Different type to CodeLocation");
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation() {
    // Arrange
    LibraryClass clazz =
        new LibraryClass(Location.UNKNOWN_LINE, "This Class Name", "Super Class Name");

    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        -26,
        codeLocation.compareTo(
            new CodeLocation(
                clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "42", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        -26,
        codeLocation.compareTo(
            new CodeLocation(
                clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation3() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryField(1, "Name", "42"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        codeLocation.compareTo(
            new CodeLocation(
                clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation4() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation = new CodeLocation(clazz, new LibraryMethod(), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        Location.UNKNOWN_LINE,
        codeLocation.compareTo(
            new CodeLocation(
                clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
  }

  /**
   * Test {@link CodeLocation#compareTo(Location)} with {@code Location}.
   *
   * <p>Method under test: {@link CodeLocation#compareTo(Location)}
   */
  @Test
  @DisplayName("Test compareTo(Location) with 'Location'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation5() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        Location.UNKNOWN_LINE,
        codeLocation.compareTo(new CodeLocation(clazz2, new LibraryMethod(), 2)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation_thenReturnMinusThree() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        -3,
        codeLocation.compareTo(
            new CodeLocation(
                clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2, 2)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation_thenReturnZero() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);
    LibraryClass clazz2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        codeLocation.compareTo(
            new CodeLocation(
                clazz2, new LibraryField(Location.UNKNOWN_LINE, "Name", "Descriptor"), 2)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.analysis.datastructure.CodeLocation.compareTo(proguard.analysis.datastructure.Location)"
  })
  void testCompareToWithLocation_whenFileLocationWithFilenameIsFooTxtAndLineIsTwo() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(Location.UNKNOWN_LINE, codeLocation.compareTo(new FileLocation("foo.txt", 2)));
  }
}
