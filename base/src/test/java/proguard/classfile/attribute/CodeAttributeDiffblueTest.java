package proguard.classfile.attribute;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.visitor.AttributeVisitor;

public class CodeAttributeDiffblueTest {
  /**
   * Test {@link CodeAttribute#CodeAttribute()}.
   *
   * <p>Method under test: {@link CodeAttribute#CodeAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeAttribute.<init>()",
    "void CodeAttribute.<init>(int, int, int, int, byte[], int, ExceptionInfo[], int, Attribute[])"
  })
  public void testNewCodeAttribute() {
    // Arrange and Act
    CodeAttribute actualCodeAttribute = new CodeAttribute();

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
  }

  /**
   * Test {@link CodeAttribute#CodeAttribute(int)}.
   *
   * <p>Method under test: {@link CodeAttribute#CodeAttribute(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttribute.<init>(int)"})
  public void testNewCodeAttribute2() {
    // Arrange and Act
    CodeAttribute actualCodeAttribute = new CodeAttribute(1);

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
    assertEquals(0, actualCodeAttribute.attributes.length);
    assertEquals(0, actualCodeAttribute.exceptionTable.length);
    assertEquals(0, actualCodeAttribute.u2attributesCount);
    assertEquals(0, actualCodeAttribute.u2exceptionTableLength);
    assertEquals(0, actualCodeAttribute.u2maxLocals);
    assertEquals(0, actualCodeAttribute.u2maxStack);
    assertEquals(0, actualCodeAttribute.u4codeLength);
    assertEquals(1, actualCodeAttribute.u2attributeNameIndex);
    assertArrayEquals(new byte[] {}, actualCodeAttribute.code);
  }

  /**
   * Test {@link CodeAttribute#CodeAttribute(int, int, int, int, byte[])}.
   *
   * <p>Method under test: {@link CodeAttribute#CodeAttribute(int, int, int, int, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttribute.<init>(int, int, int, int, byte[])"})
  public void testNewCodeAttribute3() throws UnsupportedEncodingException {
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

  /**
   * Test {@link CodeAttribute#CodeAttribute(int, int, int, int, byte[], int, ExceptionInfo[], int,
   * Attribute[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttribute#CodeAttribute(int, int, int, int, byte[], int,
   * ExceptionInfo[], int, Attribute[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeAttribute.<init>()",
    "void CodeAttribute.<init>(int, int, int, int, byte[], int, ExceptionInfo[], int, Attribute[])"
  })
  public void testNewCodeAttribute_whenOne() throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CodeAttribute actualCodeAttribute =
        new CodeAttribute(
            1,
            3,
            3,
            3,
            code,
            3,
            new ExceptionInfo[] {new ExceptionInfo(1, 3, 1, 1)},
            3,
            new Attribute[] {new BootstrapMethodsAttribute()});

    // Assert
    assertNull(actualCodeAttribute.getProcessingInfo());
    assertEquals(0, actualCodeAttribute.getProcessingFlags());
  }

  /**
   * Test {@link CodeAttribute#getAttribute(Clazz, String)}.
   *
   * <p>Method under test: {@link CodeAttribute#getAttribute(Clazz, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Attribute CodeAttribute.getAttribute(Clazz, String)"})
  public void testGetAttribute() {
    // Arrange
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertNull(codeAttribute.getAttribute(new LibraryClass(), "Name"));
  }

  /**
   * Test {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz}, {@code
   * method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttribute.accept(Clazz, Method, AttributeVisitor)"})
  public void testAcceptWithClazzMethodAttributeVisitor() throws UnsupportedEncodingException {
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
   * Test {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code clazz}, {@code
   * method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttribute.accept(Clazz, Method, AttributeVisitor)"})
  public void testAcceptWithClazzMethodAttributeVisitor2() {
    // Arrange
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {-60, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    DominatorCalculator attributeVisitor = new DominatorCalculator(true);

    // Act
    codeAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    assertTrue(attributeVisitor.dominates(1, 1));
  }
}
