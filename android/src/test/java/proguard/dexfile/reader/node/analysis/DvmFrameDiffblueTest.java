package proguard.dexfile.reader.node.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.insn.ConstStmtNode;
import proguard.dexfile.reader.node.insn.DexStmtNode;

class DvmFrameDiffblueTest {
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
  @DisplayName("Test new DvmFrame(int); when one; then return Tmp is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.reader.node.analysis.DvmFrame.<init>(int)"})
  void testNewDvmFrame_whenOne_thenReturnTmpIsNull() {
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
  @DisplayName(
      "Test setReg(int, Object); given DvmFrame(int) with totalRegister is one; when minus one; then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.analysis.DvmFrame.setReg(int, java.lang.Object)"
  })
  void testSetReg_givenDvmFrameWithTotalRegisterIsOne_whenMinusOne_thenArrayLengthIsOne() {
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
  @DisplayName(
      "Test setReg(int, Object); given DvmFrame(int) with totalRegister is one; when zero; then first element is Null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.analysis.DvmFrame.setReg(int, java.lang.Object)"
  })
  void testSetReg_givenDvmFrameWithTotalRegisterIsOne_whenZero_thenFirstElementIsNull() {
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
  @DisplayName("Test init(DvmFrame); then return DvmFrame(int) with totalRegister is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.node.analysis.DvmFrame proguard.dexfile.reader.node.analysis.DvmFrame.init(proguard.dexfile.reader.node.analysis.DvmFrame)"
  })
  void testInit_thenReturnDvmFrameWithTotalRegisterIsOne() {
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
  @DisplayName("Test execute(DexStmtNode, DvmInterpreter); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.analysis.DvmFrame.execute(proguard.dexfile.reader.node.insn.DexStmtNode, proguard.dexfile.reader.node.analysis.DvmInterpreter)"
  })
  void testExecute_thenThrowRuntimeException() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            dvmFrame.execute(
                new ConstStmtNode(Op.NOP, 1, Constant.Null), mock(DvmInterpreter.class)));
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.dexfile.reader.node.analysis.DvmFrame.getTmp()",
    "void proguard.dexfile.reader.node.analysis.DvmFrame.setTmp(java.lang.Object)"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test getReg(int); given DvmFrame(int) with totalRegister is one; when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.dexfile.reader.node.analysis.DvmFrame.getReg(int)"})
  void testGetReg_givenDvmFrameWithTotalRegisterIsOne_whenMinusOne_thenReturnNull() {
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
  @DisplayName(
      "Test getReg(int); given DvmFrame(int) with totalRegister is one; when zero; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.dexfile.reader.node.analysis.DvmFrame.getReg(int)"})
  void testGetReg_givenDvmFrameWithTotalRegisterIsOne_whenZero_thenReturnNull() {
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
  @DisplayName(
      "Test getReg(int); given DvmFrame(int) with totalRegister is zero; when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object proguard.dexfile.reader.node.analysis.DvmFrame.getReg(int)"})
  void testGetReg_givenDvmFrameWithTotalRegisterIsZero_whenOne_thenReturnNull() {
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
  @DisplayName(
      "Test descriptorLength(String[]); when array of String with 'Types' and 'java.lang.Object[]'; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.reader.node.analysis.DvmFrame.descriptorLength(java.lang.String[])"
  })
  void testDescriptorLength_whenArrayOfStringWithTypesAndJavaLangObject_thenReturnTwo() {
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
  @DisplayName(
      "Test descriptorLength(String[]); when array of String with 'Types'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.reader.node.analysis.DvmFrame.descriptorLength(java.lang.String[])"
  })
  void testDescriptorLength_whenArrayOfStringWithTypes_thenReturnOne() {
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
  @DisplayName("Test descriptorLength(String[]); when empty array of String; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.dexfile.reader.node.analysis.DvmFrame.descriptorLength(java.lang.String[])"
  })
  void testDescriptorLength_whenEmptyArrayOfString_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, DvmFrame.descriptorLength(new String[] {}));
  }
}
