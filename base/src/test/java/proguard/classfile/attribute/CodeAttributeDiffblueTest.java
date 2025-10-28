package proguard.classfile.attribute;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AttributeVisitor;

public class CodeAttributeDiffblueTest {
  /**
   * Method under test: {@link CodeAttribute#getAttribute(Clazz, String)}
   */
  @Test
  public void testGetAttribute() {
    // Arrange
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertNull(codeAttribute.getAttribute(new LibraryClass(), "Name"));
  }

  /**
   * Method under test:
   * {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  public void testAccept() throws UnsupportedEncodingException {
    // Arrange
    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DominatorCalculator attributeVisitor = new DominatorCalculator(true);

    // Act
    codeAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    assertTrue(attributeVisitor.dominates(1, 1));
  }

  /**
   * Method under test:
   * {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{-60, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DominatorCalculator attributeVisitor = new DominatorCalculator(true);

    // Act
    codeAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    assertTrue(attributeVisitor.dominates(1, 1));
  }

  /**
   * Method under test: {@link CodeAttribute#CodeAttribute()}
   */
  @Test
  public void testNewCodeAttribute() {
    // Arrange and Act
    CodeAttribute actualCodeAttribute = new CodeAttribute();

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link CodeAttribute#CodeAttribute(int, int, int, int, byte[], int, ExceptionInfo[], int, Attribute[])}
   */
  @Test
  public void testNewCodeAttribute2() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CodeAttribute actualCodeAttribute = new CodeAttribute(1, 3, 3, 3, code, 3,
        new ExceptionInfo[]{new ExceptionInfo(1, 3, 1, 1)}, 3, new Attribute[]{new BootstrapMethodsAttribute()});

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link CodeAttribute#CodeAttribute(int)}
   */
  @Test
  public void testNewCodeAttribute3() {
    // Arrange and Act
    CodeAttribute actualCodeAttribute = new CodeAttribute(1);

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
    assertEquals(0, actualCodeAttribute.attributes.length);
    assertEquals(0, actualCodeAttribute.code.length);
    assertEquals(0, actualCodeAttribute.exceptionTable.length);
    assertEquals(0, actualCodeAttribute.u2attributesCount);
    assertEquals(0, actualCodeAttribute.u2exceptionTableLength);
    assertEquals(0, actualCodeAttribute.u2maxLocals);
    assertEquals(0, actualCodeAttribute.u2maxStack);
    assertEquals(0, actualCodeAttribute.u4codeLength);
    assertEquals(1, actualCodeAttribute.u2attributeNameIndex);
  }

  /**
   * Method under test:
   * {@link CodeAttribute#CodeAttribute(int, int, int, int, byte[])}
   */
  @Test
  public void testNewCodeAttribute4() throws UnsupportedEncodingException {
    // Arrange and Act
    CodeAttribute actualCodeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
    assertEquals(0, actualCodeAttribute.attributes.length);
    assertEquals(0, actualCodeAttribute.exceptionTable.length);
    assertEquals(0, actualCodeAttribute.u2attributesCount);
    assertEquals(0, actualCodeAttribute.u2exceptionTableLength);
    assertEquals(1, actualCodeAttribute.u2attributeNameIndex);
    assertEquals(3, actualCodeAttribute.u2maxLocals);
    assertEquals(3, actualCodeAttribute.u2maxStack);
    assertEquals(3, actualCodeAttribute.u4codeLength);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCodeAttribute.code);
  }
}
