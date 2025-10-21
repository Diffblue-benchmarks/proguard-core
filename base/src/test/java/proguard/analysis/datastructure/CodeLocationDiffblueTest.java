package proguard.analysis.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

public class CodeLocationDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int)"})
  public void testNewCodeLocation_thenSignatureReturnFieldSignature() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int, int)"})
  public void testNewCodeLocation_thenSignatureReturnFieldSignature2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int)"})
  public void testNewCodeLocation_whenLibraryMethod_thenMemberReturnLibraryMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeLocation.<init>(Clazz, Member, int, int)"})
  public void testNewCodeLocation_whenLibraryMethod_thenMemberReturnLibraryMethod2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getExternalClassName()"})
  public void testGetExternalClassName_thenReturnThisClassName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getMemberName()"})
  public void testGetMemberName_thenReturnName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getMemberName()"})
  public void testGetMemberName_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  public void testGetName_thenReturnLNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  public void testGetName_thenReturnLThisClassNameNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  public void testGetName_thenReturnLnullName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.getName()"})
  public void testGetName_thenReturnThisClassName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String CodeLocation.toString()"})
  public void testToString() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CodeLocation.equals(Object)", "int CodeLocation.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation_thenReturnMinusThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CodeLocation.compareTo(Location)"})
  public void testCompareToWithLocation_whenFileLocationWithFilenameIsFooTxtAndLineIsTwo() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    CodeLocation codeLocation =
        new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act and Assert
    assertEquals(Location.UNKNOWN_LINE, codeLocation.compareTo(new FileLocation("foo.txt", 2)));
  }
}
