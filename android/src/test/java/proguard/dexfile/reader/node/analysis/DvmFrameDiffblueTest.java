package proguard.dexfile.reader.node.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.insn.ConstStmtNode;
import proguard.dexfile.reader.node.insn.DexStmtNode;

public class DvmFrameDiffblueTest {
  /**
   * Method under test: {@link DvmFrame#setReg(int, Object)}
   */
  @Test
  public void testSetReg() {
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
   * Method under test: {@link DvmFrame#setReg(int, Object)}
   */
  @Test
  public void testSetReg2() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act
    dvmFrame.setReg(-1, Constant.Null);

    // Assert that nothing has changed
    assertEquals(1, dvmFrame.values.length);
  }

  /**
   * Method under test: {@link DvmFrame#init(DvmFrame)}
   */
  @Test
  public void testInit() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertSame(dvmFrame, dvmFrame.init(new DvmFrame<>(1)));
  }

  /**
   * Method under test: {@link DvmFrame#execute(DexStmtNode, DvmInterpreter)}
   */
  @Test
  public void testExecute() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dvmFrame.execute(new ConstStmtNode(Op.NOP, 1, Constant.Null), null));
  }

  /**
   * Method under test: {@link DvmFrame#getReg(int)}
   */
  @Test
  public void testGetReg() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertNull(dvmFrame.getReg(0));
  }

  /**
   * Method under test: {@link DvmFrame#getReg(int)}
   */
  @Test
  public void testGetReg2() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);

    // Act and Assert
    assertNull(dvmFrame.getReg(-1));
  }

  /**
   * Method under test: {@link DvmFrame#getReg(int)}
   */
  @Test
  public void testGetReg3() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(0);

    // Act and Assert
    assertNull(dvmFrame.getReg(1));
  }

  /**
   * Method under test: {@link DvmFrame#descriptorLength(String[])}
   */
  @Test
  public void testDescriptorLength() {
    // Arrange, Act and Assert
    assertEquals(1, DvmFrame.descriptorLength(new String[]{"Types"}));
    assertEquals(0, DvmFrame.descriptorLength(new String[]{}));
    assertEquals(2, DvmFrame.descriptorLength(new String[]{"Types", "java.lang.Object[]"}));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DvmFrame#setTmp(Object)}
   *   <li>{@link DvmFrame#getTmp()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DvmFrame<Object> dvmFrame = new DvmFrame<>(1);
    Object object = Constant.Null;

    // Act
    dvmFrame.setTmp(object);

    // Assert that nothing has changed
    assertSame(object, dvmFrame.getTmp());
  }

  /**
   * Method under test: {@link DvmFrame#DvmFrame(int)}
   */
  @Test
  public void testNewDvmFrame() {
    // Arrange and Act
    DvmFrame<Object> actualDvmFrame = new DvmFrame<>(1);

    // Assert
    assertNull(actualDvmFrame.getTmp());
    Object[] objectArray = actualDvmFrame.values;
    assertNull(objectArray[0]);
    assertEquals(1, actualDvmFrame.getTotalRegisters());
    assertEquals(1, objectArray.length);
  }
}
