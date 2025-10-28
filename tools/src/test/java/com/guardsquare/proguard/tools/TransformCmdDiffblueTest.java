package com.guardsquare.proguard.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import kotlinx.cli.ArgParser;
import org.junit.Test;

public class TransformCmdDiffblueTest {
  /**
   * Method under test: {@link TransformCmd#getClassNameFilter()}
   */
  @Test
  public void testGetClassNameFilter() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setClassNameFilter("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getClassNameFilter());
  }

  /**
   * Method under test: {@link TransformCmd#getInput()}
   */
  @Test
  public void testGetInput() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setInput("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getInput());
  }

  /**
   * Method under test: {@link TransformCmd#getOutput()}
   */
  @Test
  public void testGetOutput() {
    // Arrange, Act and Assert
    assertNull((new TransformCmd()).getOutput());
  }

  /**
   * Method under test: {@link TransformCmd#getOutput()}
   */
  @Test
  public void testGetOutput2() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setOutput("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getOutput());
  }

  /**
   * Method under test: {@link TransformCmd#getPrintClasses()}
   */
  @Test
  public void testGetPrintClasses() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setPrintClasses(true);

    // Act and Assert
    assertTrue(transformCmd.getPrintClasses());
  }

  /**
   * Method under test: {@link TransformCmd#getPrintClasses()}
   */
  @Test
  public void testGetPrintClasses2() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setPrintClasses(false);

    // Act and Assert
    assertFalse(transformCmd.getPrintClasses());
  }

  /**
   * Method under test: {@link TransformCmd#getTransformer()}
   */
  @Test
  public void testGetTransformer() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setTransformer("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getTransformer());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TransformCmd}
   */
  @Test
  public void testNewTransformCmd() {
    // Arrange and Act
    TransformCmd actualTransformCmd = new TransformCmd();

    // Assert
    assertEquals("    transform - Apply transformations to input (experimental)\n",
        actualTransformCmd.getHelpMessage());
    assertEquals("Apply transformations to input (experimental)", actualTransformCmd.getActionDescription());
    assertEquals("transform", actualTransformCmd.getProgramName());
    assertEquals("transform", actualTransformCmd.getName());
    assertNull(actualTransformCmd.getOutput());
    assertEquals(ArgParser.OptionPrefixStyle.LINUX, actualTransformCmd.getPrefixStyle());
    assertFalse(actualTransformCmd.getSkipExtraArguments());
    assertFalse(actualTransformCmd.getStrictSubcommandOptionsOrder());
    assertTrue(actualTransformCmd.getUseDefaultHelpShortName());
  }

  /**
   * Method under test: {@link TransformCmd#setClassNameFilter(String)}
   */
  @Test
  public void testSetClassNameFilter() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setClassNameFilter("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getClassNameFilter());
  }

  /**
   * Method under test: {@link TransformCmd#setInput(String)}
   */
  @Test
  public void testSetInput() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setInput("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getInput());
  }

  /**
   * Method under test: {@link TransformCmd#setOutput(String)}
   */
  @Test
  public void testSetOutput() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setOutput("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getOutput());
  }

  /**
   * Method under test: {@link TransformCmd#setPrintClasses(boolean)}
   */
  @Test
  public void testSetPrintClasses() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setPrintClasses(true);

    // Assert
    assertTrue(transformCmd.getPrintClasses());
  }

  /**
   * Method under test: {@link TransformCmd#setTransformer(String)}
   */
  @Test
  public void testSetTransformer() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setTransformer("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getTransformer());
  }
}
