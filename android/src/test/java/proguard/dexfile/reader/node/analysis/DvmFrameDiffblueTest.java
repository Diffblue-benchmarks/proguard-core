package proguard.dexfile.reader.node.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.insn.ConstStmtNode;
import proguard.dexfile.reader.node.insn.DexStmtNode;

public class DvmFrameDiffblueTest {
  /**
   * Test {@link DvmFrame#DvmFrame(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Tmp is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#DvmFrame(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DvmFrame.<init>(int)"})
  public void testNewDvmFrame_whenOne_thenReturnTmpIsNull() {
    // Arrange and Act
    DvmFrame<Object> actualDvmFrame = new DvmFrame<>(1);

    // Assert
    assertNull(actualDvmFrame.getTmp());
    Object[] objectArray = actualDvmFrame.values;
    assertNull(objectArray[0]);
    assertEquals(1, actualDvmFrame.getTotalRegisters());
    assertEquals(1, objectArray.length);
  }

  /**
   * Test {@link DvmFrame#setReg(int, Object)}.
   *
   * <ul>
   *   <li>Given {@link DvmFrame#DvmFrame(int)} with totalRegister is one.
   *   <li>When minus one.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#setReg(int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DvmFrame.setReg(int, Object)"})
  public void testSetReg_givenDvmFrameWithTotalRegisterIsOne_whenMinusOne_thenArrayLengthIsOne() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act
    dvmFrame.setReg(-1, Constant.Null);

    // Assert that nothing has changed
    assertEquals(1, dvmFrame.values.length);
  }

  /**
   * Test {@link DvmFrame#setReg(int, Object)}.
   *
   * <ul>
   *   <li>Given {@link DvmFrame#DvmFrame(int)} with totalRegister is one.
   *   <li>When zero.
   *   <li>Then first element is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#setReg(int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DvmFrame.setReg(int, Object)"})
  public void testSetReg_givenDvmFrameWithTotalRegisterIsOne_whenZero_thenFirstElementIsNull() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);
    Object object = Constant.Null;

    // Act
    dvmFrame.setReg(0, object);

    // Assert
    Object[] objectArray = dvmFrame.values;
    assertEquals(1, objectArray.length);
    assertSame(object, objectArray[0]);
  }

  /**
   * Test {@link DvmFrame#init(DvmFrame)}.
   *
   * <ul>
   *   <li>Then return {@link DvmFrame#DvmFrame(int)} with totalRegister is one.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#init(DvmFrame)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DvmFrame DvmFrame.init(DvmFrame)"})
  public void testInit_thenReturnDvmFrameWithTotalRegisterIsOne() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertSame(dvmFrame, dvmFrame.init(new DvmFrame<>(1)));
  }

  /**
   * Test {@link DvmFrame#execute(DexStmtNode, DvmInterpreter)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#execute(DexStmtNode, DvmInterpreter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DvmFrame.execute(DexStmtNode, DvmInterpreter)"})
  public void testExecute_thenThrowRuntimeException() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> dvmFrame.execute(new ConstStmtNode(Op.NOP, 1, Constant.Null), null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DvmFrame#setTmp(Object)}
   *   <li>{@link DvmFrame#getTmp()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DvmFrame.getTmp()", "void DvmFrame.setTmp(Object)"})
  public void testGettersAndSetters() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);
    Object object = Constant.Null;

    // Act
    dvmFrame.setTmp(object);

    // Assert
    assertSame(object, dvmFrame.getTmp());
  }

  /**
   * Test {@link DvmFrame#getReg(int)}.
   *
   * <ul>
   *   <li>Given {@link DvmFrame#DvmFrame(int)} with totalRegister is one.
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#getReg(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DvmFrame.getReg(int)"})
  public void testGetReg_givenDvmFrameWithTotalRegisterIsOne_whenMinusOne_thenReturnNull() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertNull(dvmFrame.getReg(-1));
  }

  /**
   * Test {@link DvmFrame#getReg(int)}.
   *
   * <ul>
   *   <li>Given {@link DvmFrame#DvmFrame(int)} with totalRegister is one.
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#getReg(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DvmFrame.getReg(int)"})
  public void testGetReg_givenDvmFrameWithTotalRegisterIsOne_whenZero_thenReturnNull() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertNull(dvmFrame.getReg(0));
  }

  /**
   * Test {@link DvmFrame#getReg(int)}.
   *
   * <ul>
   *   <li>Given {@link DvmFrame#DvmFrame(int)} with totalRegister is zero.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#getReg(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DvmFrame.getReg(int)"})
  public void testGetReg_givenDvmFrameWithTotalRegisterIsZero_whenOne_thenReturnNull() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(0);

    // Act and Assert
    assertNull(dvmFrame.getReg(1));
  }

  /**
   * Test {@link DvmFrame#descriptorLength(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Types} and {@code Object[]}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DvmFrame.descriptorLength(String[])"})
  public void testDescriptorLength_whenArrayOfStringWithTypesAndJavaLangObject_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, DvmFrame.descriptorLength(new String[] {"Types", "java.lang.Object[]"}));
  }

  /**
   * Test {@link DvmFrame#descriptorLength(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Types}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DvmFrame.descriptorLength(String[])"})
  public void testDescriptorLength_whenArrayOfStringWithTypes_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, DvmFrame.descriptorLength(new String[] {"Types"}));
  }

  /**
   * Test {@link DvmFrame#descriptorLength(String[])}.
   *
   * <ul>
   *   <li>When empty array of {@link String}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DvmFrame.descriptorLength(String[])"})
  public void testDescriptorLength_whenEmptyArrayOfString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, DvmFrame.descriptorLength(new String[] {}));
  }
}
