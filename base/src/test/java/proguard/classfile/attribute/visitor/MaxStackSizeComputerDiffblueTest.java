package proguard.classfile.attribute.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.exception.NegativeStackSizeException;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SwitchInstruction;
import proguard.exception.ProguardCoreException;

public class MaxStackSizeComputerDiffblueTest {
  /**
   * Method under test: {@link MaxStackSizeComputer#isReachable(int)}
   */
  @Test
  public void testIsReachable() {
    // Arrange, Act and Assert
    assertFalse((new MaxStackSizeComputer()).isReachable(1));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{1, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{-60, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute4() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(ProguardCoreException.class, () -> maxStackSizeComputer.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute5() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{-124, 1, 'A', 1, 'A', 1, 'A', 1})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 1, 'A', -60, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 1, 'A', 0, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction4() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 1, 'A', -124, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction() throws UnsupportedEncodingException {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction2() throws UnsupportedEncodingException {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAAAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 'X', 'A', 4, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction4() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 'X', 'A', -60, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction5() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 'X', 'A', 0, 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class, () -> maxStackSizeComputer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 0, 1, 0}, new int[]{1, 0, 1, 0})));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class,
        () -> maxStackSizeComputer.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo2() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', -60, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class,
        () -> maxStackSizeComputer.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}
   */
  @Test
  public void testVisitExceptionInfo3() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, new byte[]{'A', -124, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(NegativeStackSizeException.class,
        () -> maxStackSizeComputer.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MaxStackSizeComputer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link MaxStackSizeComputer#getMaxStackSize()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MaxStackSizeComputer maxStackSizeComputer = new MaxStackSizeComputer();
    LibraryClass clazz = new LibraryClass();

    // Act
    maxStackSizeComputer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert that nothing has changed
    assertEquals(0, maxStackSizeComputer.getMaxStackSize());
  }

  /**
   * Method under test: {@link MaxStackSizeComputer#MaxStackSizeComputer()}
   */
  @Test
  public void testNewMaxStackSizeComputer() {
    // Arrange and Act
    MaxStackSizeComputer actualMaxStackSizeComputer = new MaxStackSizeComputer();

    // Assert
    assertEquals(0, actualMaxStackSizeComputer.getMaxStackSize());
    boolean[] booleanArray = actualMaxStackSizeComputer.evaluated;
    assertEquals(8096, booleanArray.length);
    assertFalse(booleanArray[0]);
    assertFalse(booleanArray[1]);
    assertFalse(booleanArray[10]);
    assertFalse(booleanArray[11]);
    assertFalse(booleanArray[12]);
    assertFalse(booleanArray[13]);
    assertFalse(booleanArray[14]);
    assertFalse(booleanArray[15]);
    assertFalse(booleanArray[17]);
    assertFalse(booleanArray[18]);
    assertFalse(booleanArray[19]);
    assertFalse(booleanArray[2]);
    assertFalse(booleanArray[20]);
    assertFalse(booleanArray[21]);
    assertFalse(booleanArray[22]);
    assertFalse(booleanArray[23]);
    assertFalse(booleanArray[24]);
    assertFalse(booleanArray[3]);
    assertFalse(booleanArray[4]);
    assertFalse(booleanArray[5]);
    assertFalse(booleanArray[6]);
    assertFalse(booleanArray[7]);
    assertFalse(booleanArray[8]);
    assertFalse(booleanArray[8071]);
    assertFalse(booleanArray[8072]);
    assertFalse(booleanArray[8073]);
    assertFalse(booleanArray[8074]);
    assertFalse(booleanArray[8075]);
    assertFalse(booleanArray[8076]);
    assertFalse(booleanArray[8077]);
    assertFalse(booleanArray[8078]);
    assertFalse(booleanArray[8079]);
    assertFalse(booleanArray[8080]);
    assertFalse(booleanArray[8081]);
    assertFalse(booleanArray[8082]);
    assertFalse(booleanArray[8083]);
    assertFalse(booleanArray[8084]);
    assertFalse(booleanArray[8085]);
    assertFalse(booleanArray[8086]);
    assertFalse(booleanArray[8087]);
    assertFalse(booleanArray[8088]);
    assertFalse(booleanArray[8089]);
    assertFalse(booleanArray[8090]);
    assertFalse(booleanArray[8091]);
    assertFalse(booleanArray[8092]);
    assertFalse(booleanArray[8093]);
    assertFalse(booleanArray[8094]);
    assertFalse(booleanArray[8095]);
    assertFalse(booleanArray[9]);
    assertFalse(booleanArray[Short.SIZE]);
  }

  /**
   * Method under test:
   * {@link MaxStackSizeComputer#MaxStackSizeComputer(MaxStackSizeComputer.StackSizeConsumer)}
   */
  @Test
  public void testNewMaxStackSizeComputer2() {
    // Arrange and Act
    MaxStackSizeComputer actualMaxStackSizeComputer = new MaxStackSizeComputer(null);

    // Assert
    assertEquals(0, actualMaxStackSizeComputer.getMaxStackSize());
    boolean[] booleanArray = actualMaxStackSizeComputer.evaluated;
    assertEquals(8096, booleanArray.length);
    assertFalse(booleanArray[0]);
    assertFalse(booleanArray[1]);
    assertFalse(booleanArray[10]);
    assertFalse(booleanArray[11]);
    assertFalse(booleanArray[12]);
    assertFalse(booleanArray[13]);
    assertFalse(booleanArray[14]);
    assertFalse(booleanArray[15]);
    assertFalse(booleanArray[17]);
    assertFalse(booleanArray[18]);
    assertFalse(booleanArray[19]);
    assertFalse(booleanArray[2]);
    assertFalse(booleanArray[20]);
    assertFalse(booleanArray[21]);
    assertFalse(booleanArray[22]);
    assertFalse(booleanArray[23]);
    assertFalse(booleanArray[24]);
    assertFalse(booleanArray[3]);
    assertFalse(booleanArray[4]);
    assertFalse(booleanArray[5]);
    assertFalse(booleanArray[6]);
    assertFalse(booleanArray[7]);
    assertFalse(booleanArray[8]);
    assertFalse(booleanArray[8071]);
    assertFalse(booleanArray[8072]);
    assertFalse(booleanArray[8073]);
    assertFalse(booleanArray[8074]);
    assertFalse(booleanArray[8075]);
    assertFalse(booleanArray[8076]);
    assertFalse(booleanArray[8077]);
    assertFalse(booleanArray[8078]);
    assertFalse(booleanArray[8079]);
    assertFalse(booleanArray[8080]);
    assertFalse(booleanArray[8081]);
    assertFalse(booleanArray[8082]);
    assertFalse(booleanArray[8083]);
    assertFalse(booleanArray[8084]);
    assertFalse(booleanArray[8085]);
    assertFalse(booleanArray[8086]);
    assertFalse(booleanArray[8087]);
    assertFalse(booleanArray[8088]);
    assertFalse(booleanArray[8089]);
    assertFalse(booleanArray[8090]);
    assertFalse(booleanArray[8091]);
    assertFalse(booleanArray[8092]);
    assertFalse(booleanArray[8093]);
    assertFalse(booleanArray[8094]);
    assertFalse(booleanArray[8095]);
    assertFalse(booleanArray[9]);
    assertFalse(booleanArray[Short.SIZE]);
  }
}
