package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;

public class VariableCleanerDiffblueTest {
  /**
   * Method under test:
   * {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTableAttribute() {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute(1, 1,
        new LocalVariableInfo[]{new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Act
    variableCleaner.visitLocalVariableTableAttribute(clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    assertNull(localVariableInfoArray[0]);
    assertEquals(0, localVariableTableAttribute.u2localVariableTableLength);
    assertEquals(1, localVariableInfoArray.length);
  }

  /**
   * Method under test:
   * {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTableAttribute2() throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute(1, 1,
        new LocalVariableInfo[]{localVariableInfo});

    // Act
    variableCleaner.visitLocalVariableTableAttribute(clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    assertEquals(1, localVariableInfoArray.length);
    assertEquals(1, localVariableTableAttribute.u2localVariableTableLength);
    assertSame(localVariableInfo, localVariableInfoArray[0]);
  }

  /**
   * Method under test:
   * {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTableAttribute3() throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    LocalVariableInfo localVariableInfo2 = new LocalVariableInfo(1, 3, 1, 1, 1);

    LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute(1, 3,
        new LocalVariableInfo[]{localVariableInfo, localVariableInfo2, new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Act
    variableCleaner.visitLocalVariableTableAttribute(clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    LocalVariableInfo localVariableInfo3 = localVariableInfoArray[0];
    assertEquals(0, localVariableInfo3.u2length);
    LocalVariableInfo localVariableInfo4 = localVariableInfoArray[1];
    assertEquals(0, localVariableInfo4.u2length);
    assertEquals(3, localVariableInfoArray.length);
    assertSame(localVariableInfo, localVariableInfo3);
    assertSame(localVariableInfo2, localVariableInfo4);
  }

  /**
   * Method under test:
   * {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTypeTableAttribute() {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(1, 1,
        new LocalVariableTypeInfo[]{new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Act
    variableCleaner.visitLocalVariableTypeTableAttribute(clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray = localVariableTypeTableAttribute.localVariableTypeTable;
    assertNull(localVariableTypeInfoArray[0]);
    assertEquals(0, localVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertEquals(1, localVariableTypeInfoArray.length);
  }

  /**
   * Method under test:
   * {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTypeTableAttribute2() throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    LocalVariableTypeTableAttribute localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(1, 1,
        new LocalVariableTypeInfo[]{localVariableTypeInfo});

    // Act
    variableCleaner.visitLocalVariableTypeTableAttribute(clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray = localVariableTypeTableAttribute.localVariableTypeTable;
    assertEquals(1, localVariableTypeInfoArray.length);
    assertEquals(1, localVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertSame(localVariableTypeInfo, localVariableTypeInfoArray[0]);
  }

  /**
   * Method under test:
   * {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  public void testVisitLocalVariableTypeTableAttribute3() throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    LocalVariableTypeInfo localVariableTypeInfo2 = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    LocalVariableTypeTableAttribute localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(1, 3,
        new LocalVariableTypeInfo[]{localVariableTypeInfo, localVariableTypeInfo2,
            new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Act
    variableCleaner.visitLocalVariableTypeTableAttribute(clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray = localVariableTypeTableAttribute.localVariableTypeTable;
    LocalVariableTypeInfo localVariableTypeInfo3 = localVariableTypeInfoArray[0];
    assertEquals(0, localVariableTypeInfo3.u2length);
    LocalVariableTypeInfo localVariableTypeInfo4 = localVariableTypeInfoArray[1];
    assertEquals(0, localVariableTypeInfo4.u2length);
    assertEquals(3, localVariableTypeInfoArray.length);
    assertSame(localVariableTypeInfo, localVariableTypeInfo3);
    assertSame(localVariableTypeInfo2, localVariableTypeInfo4);
  }
}
