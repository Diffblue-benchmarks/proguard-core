package proguard.classfile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.DominatorCalculator;
import proguard.analysis.cpa.jvm.util.ConstantLookupVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;

public class LibraryClassDiffblueTest {
  /**
   * Method under test: {@link LibraryClass#isVisible()}
   */
  @Test
  public void testIsVisible() {
    // Arrange, Act and Assert
    assertFalse((new LibraryClass()).isVisible());
    assertTrue((new LibraryClass(1, "This Class Name", "Super Class Name")).isVisible());
  }

  /**
   * Method under test: {@link LibraryClass#getName(int)}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getName(1));
  }

  /**
   * Method under test: {@link LibraryClass#getType(int)}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getType(1));
  }

  /**
   * Method under test: {@link LibraryClass#getRefClassName(int)}
   */
  @Test
  public void testGetRefClassName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefClassName(1));
  }

  /**
   * Method under test: {@link LibraryClass#getRefName(int)}
   */
  @Test
  public void testGetRefName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefName(1));
  }

  /**
   * Method under test: {@link LibraryClass#getRefType(int)}
   */
  @Test
  public void testGetRefType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getRefType(1));
  }

  /**
   * Method under test: {@link LibraryClass#getInterfaceCount()}
   */
  @Test
  public void testGetInterfaceCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new LibraryClass()).getInterfaceCount());
  }

  /**
   * Method under test: {@link LibraryClass#getTag(int)}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getTag(1));
  }

  /**
   * Method under test: {@link LibraryClass#getString(int)}
   */
  @Test
  public void testGetString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getString(1));
  }

  /**
   * Method under test: {@link LibraryClass#getStringString(int)}
   */
  @Test
  public void testGetStringString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getStringString(1));
  }

  /**
   * Method under test: {@link LibraryClass#getClassName(int)}
   */
  @Test
  public void testGetClassName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getClassName(1));
  }

  /**
   * Method under test: {@link LibraryClass#getModuleName(int)}
   */
  @Test
  public void testGetModuleName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getModuleName(1));
  }

  /**
   * Method under test: {@link LibraryClass#getPackageName(int)}
   */
  @Test
  public void testGetPackageName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LibraryClass()).getPackageName(1));
  }

  /**
   * Method under test: {@link LibraryClass#extends_(String)}
   */
  @Test
  public void testExtends_() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "Class Name", "Class Name")).extends_("Class Name"));
    assertFalse((new LibraryClass(1, "This Class Name", "Class Name")).extends_("Class Name"));
  }

  /**
   * Method under test: {@link LibraryClass#extends_(Clazz)}
   */
  @Test
  public void testExtends_2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(libraryClass.extends_(new LibraryClass()));
  }

  /**
   * Method under test: {@link LibraryClass#extendsOrImplements(String)}
   */
  @Test
  public void testExtendsOrImplements() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass(1, "Class Name", "Class Name")).extendsOrImplements("Class Name"));
    assertFalse((new LibraryClass(1, "This Class Name", "Class Name")).extendsOrImplements("Class Name"));
  }

  /**
   * Method under test: {@link LibraryClass#extendsOrImplements(Clazz)}
   */
  @Test
  public void testExtendsOrImplements2() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(libraryClass.extendsOrImplements(new LibraryClass()));
  }

  /**
   * Method under test: {@link LibraryClass#findField(String, String)}
   */
  @Test
  public void testFindField() {
    // Arrange, Act and Assert
    assertNull((new LibraryClass(1, "This Class Name", "Super Class Name")).findField("Name", "Descriptor"));
  }

  /**
   * Method under test: {@link LibraryClass#findMethod(String, String)}
   */
  @Test
  public void testFindMethod() {
    // Arrange, Act and Assert
    assertNull((new LibraryClass(1, "This Class Name", "Super Class Name")).findMethod("Name", "Descriptor"));
  }

  /**
   * Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertTrue(libraryClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations2() {
    // Arrange, Act and Assert
    assertTrue((new LibraryClass()).mayHaveImplementations(null));
  }

  /**
   * Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations3() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass(AccessConstants.FINAL, ClassConstants.METHOD_NAME_INIT,
        ClassConstants.METHOD_NAME_INIT);

    // Act and Assert
    assertFalse(libraryClass.mayHaveImplementations(new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations4() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(libraryClass.mayHaveImplementations(new LibraryMethod(AccessConstants.FINAL, "Name", "Descriptor")));
  }

  /**
   * Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations5() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertFalse(
        libraryClass.mayHaveImplementations(new LibraryMethod(1, ClassConstants.METHOD_NAME_INIT, "Descriptor")));
  }

  /**
   * Method under test: {@link LibraryClass#mayHaveImplementations(Method)}
   */
  @Test
  public void testMayHaveImplementations6() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> libraryClass.mayHaveImplementations(new ProgramMethod()));
  }

  /**
   * Method under test: {@link LibraryClass#attributesAccept(AttributeVisitor)}
   */
  @Test
  public void testAttributesAccept() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> libraryClass.attributesAccept(new DominatorCalculator(true)));
  }

  /**
   * Method under test:
   * {@link LibraryClass#attributeAccept(String, AttributeVisitor)}
   */
  @Test
  public void testAttributeAccept() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> libraryClass.attributeAccept("Name", new DominatorCalculator(true)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LibraryClass#constantPoolEntriesAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#constantPoolEntryAccept(int, ConstantVisitor)}
   *   <li>{@link LibraryClass#interfaceConstantsAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#superClassConstantAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#thisClassConstantAccept(ConstantVisitor)}
   *   <li>{@link LibraryClass#toString()}
   *   <li>{@link LibraryClass#getAccessFlags()}
   *   <li>{@link LibraryClass#getName()}
   *   <li>{@link LibraryClass#getSuperClass()}
   *   <li>{@link LibraryClass#getSuperName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act
    libraryClass.constantPoolEntriesAccept(new ConstantLookupVisitor());
    libraryClass.constantPoolEntryAccept(1, new ConstantLookupVisitor());
    libraryClass.interfaceConstantsAccept(new ConstantLookupVisitor());
    libraryClass.superClassConstantAccept(new ConstantLookupVisitor());
    libraryClass.thisClassConstantAccept(new ConstantLookupVisitor());
    String actualToStringResult = libraryClass.toString();
    int actualAccessFlags = libraryClass.getAccessFlags();
    libraryClass.getName();
    libraryClass.getSuperClass();
    libraryClass.getSuperName();

    // Assert that nothing has changed
    assertEquals("LibraryClass(null)", actualToStringResult);
    assertEquals(0, actualAccessFlags);
  }

  /**
   * Method under test: {@link LibraryClass#LibraryClass()}
   */
  @Test
  public void testNewLibraryClass() {
    // Arrange and Act
    LibraryClass actualLibraryClass = new LibraryClass();

    // Assert
    assertNull(actualLibraryClass.interfaceNames);
    assertNull(actualLibraryClass.fields);
    assertNull(actualLibraryClass.methods);
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getName());
    assertNull(actualLibraryClass.getSuperName());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(actualLibraryClass.kotlinMetadata);
    assertEquals(0, actualLibraryClass.getAccessFlags());
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertFalse(actualLibraryClass.isVisible());
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
  }

  /**
   * Method under test: {@link LibraryClass#LibraryClass(int, String, String)}
   */
  @Test
  public void testNewLibraryClass2() {
    // Arrange and Act
    LibraryClass actualLibraryClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Assert
    assertEquals("Super Class Name", actualLibraryClass.getSuperName());
    assertEquals("This Class Name", actualLibraryClass.getName());
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(actualLibraryClass.kotlinMetadata);
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, actualLibraryClass.fields.length);
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.interfaceNames.length);
    assertEquals(0, actualLibraryClass.methods.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
    assertTrue(actualLibraryClass.isVisible());
  }

  /**
   * Method under test:
   * {@link LibraryClass#LibraryClass(int, String, String, KotlinMetadata)}
   */
  @Test
  public void testNewLibraryClass3() {
    // Arrange
    KotlinClassKindMetadata kotlinMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    LibraryClass actualLibraryClass = new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata);

    // Assert
    KotlinMetadata kotlinMetadata2 = actualLibraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinClassKindMetadata);
    assertEquals("Pn", ((KotlinClassKindMetadata) kotlinMetadata2).pn);
    assertEquals("Super Class Name", actualLibraryClass.getSuperName());
    assertEquals("This Class Name", actualLibraryClass.getName());
    assertEquals("Xs", ((KotlinClassKindMetadata) kotlinMetadata2).xs);
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(kotlinMetadata2.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).anonymousObjectOriginName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).className);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).companionObjectName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).underlyingPropertyName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).ownerClassName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).enumEntryNames);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).nestedClassNames);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).sealedSubclassNames);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedNestedClasses);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedSealedSubClasses);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedEnumEntries);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).constructors);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).functions);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).localDelegatedProperties);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).properties);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).typeAliases);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).contextReceivers);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).superTypes);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).typeParameters);
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).anonymousObjectOriginClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedCompanionClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedDefaultImplsClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).ownerReferencedClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedCompanionField);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).underlyingPropertyType);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).versionRequirement);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).flags);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedModule);
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, kotlinMetadata2.getProcessingFlags());
    assertEquals(0, actualLibraryClass.fields.length);
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.interfaceNames.length);
    assertEquals(0, actualLibraryClass.methods.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertEquals(1, ((KotlinClassKindMetadata) kotlinMetadata2).k);
    assertEquals(1, ((KotlinClassKindMetadata) kotlinMetadata2).xi);
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
    assertTrue(actualLibraryClass.isVisible());
    assertSame(kotlinMetadata.mv, ((KotlinClassKindMetadata) kotlinMetadata2).mv);
  }

  /**
   * Method under test:
   * {@link LibraryClass#LibraryClass(int, String, String, String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)}
   */
  @Test
  public void testNewLibraryClass4() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();
    LibraryClass libraryClass2 = new LibraryClass();
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    LibraryMethod libraryMethod = new LibraryMethod(1, "Name", "Descriptor");

    KotlinClassKindMetadata kotlinMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    LibraryClass actualLibraryClass = new LibraryClass(1, "This Class Name", "Super Class Name",
        new String[]{"Interface Names"}, new Clazz[]{libraryClass}, 3, new Clazz[]{libraryClass2},
        new LibraryField[]{libraryField}, new LibraryMethod[]{libraryMethod}, kotlinMetadata);

    // Assert
    KotlinMetadata kotlinMetadata2 = actualLibraryClass.kotlinMetadata;
    assertTrue(kotlinMetadata2 instanceof KotlinClassKindMetadata);
    assertEquals("Pn", ((KotlinClassKindMetadata) kotlinMetadata2).pn);
    assertEquals("Super Class Name", actualLibraryClass.getSuperName());
    assertEquals("This Class Name", actualLibraryClass.getName());
    assertEquals("Xs", ((KotlinClassKindMetadata) kotlinMetadata2).xs);
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(kotlinMetadata2.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).anonymousObjectOriginName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).className);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).companionObjectName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).underlyingPropertyName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).ownerClassName);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).enumEntryNames);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).nestedClassNames);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).sealedSubclassNames);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedNestedClasses);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedSealedSubClasses);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedEnumEntries);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).constructors);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).functions);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).localDelegatedProperties);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).properties);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).typeAliases);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).contextReceivers);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).superTypes);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).typeParameters);
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).anonymousObjectOriginClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedCompanionClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedDefaultImplsClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).ownerReferencedClass);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedCompanionField);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).underlyingPropertyType);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).versionRequirement);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).flags);
    assertNull(((KotlinClassKindMetadata) kotlinMetadata2).referencedModule);
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, kotlinMetadata2.getProcessingFlags());
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertEquals(1, actualLibraryClass.getInterfaceCount());
    LibraryField[] libraryFieldArray = actualLibraryClass.fields;
    assertEquals(1, libraryFieldArray.length);
    Clazz[] clazzArray = actualLibraryClass.interfaceClasses;
    assertEquals(1, clazzArray.length);
    LibraryMethod[] libraryMethodArray = actualLibraryClass.methods;
    assertEquals(1, libraryMethodArray.length);
    Clazz[] clazzArray2 = actualLibraryClass.subClasses;
    assertEquals(1, clazzArray2.length);
    assertEquals(1, ((KotlinClassKindMetadata) kotlinMetadata2).k);
    assertEquals(1, ((KotlinClassKindMetadata) kotlinMetadata2).xi);
    assertEquals(3, actualLibraryClass.subClassCount);
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
    assertTrue(actualLibraryClass.isVisible());
    assertSame(libraryClass, clazzArray[0]);
    assertSame(libraryClass2, clazzArray2[0]);
    assertSame(libraryField, libraryFieldArray[0]);
    assertSame(libraryMethod, libraryMethodArray[0]);
    assertSame(kotlinMetadata.mv, ((KotlinClassKindMetadata) kotlinMetadata2).mv);
    assertArrayEquals(new String[]{"Interface Names"}, actualLibraryClass.interfaceNames);
  }
}
