package com.guardsquare.proguard.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import kotlinx.cli.ArgParser.OptionPrefixStyle;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TransformCmdDiffblueTest {
  /**
   * Test {@link TransformCmd#getClassNameFilter()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor) ClassNameFilter is {@code <set-?>}.
   *   <li>Then return {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getClassNameFilter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransformCmd.getClassNameFilter()"})
  public void testGetClassNameFilter_givenTransformCmdClassNameFilterIsSet_thenReturnSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setClassNameFilter("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getClassNameFilter());
  }

  /**
   * Test {@link TransformCmd#getInput()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor) Input is {@code <set-?>}.
   *   <li>Then return {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getInput()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransformCmd.getInput()"})
  public void testGetInput_givenTransformCmdInputIsSet_thenReturnSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setInput("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getInput());
  }

  /**
   * Test {@link TransformCmd#getOutput()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor) Output is {@code <set-?>}.
   *   <li>Then return {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getOutput()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransformCmd.getOutput()"})
  public void testGetOutput_givenTransformCmdOutputIsSet_thenReturnSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setOutput("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getOutput());
  }

  /**
   * Test {@link TransformCmd#getOutput()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getOutput()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransformCmd.getOutput()"})
  public void testGetOutput_givenTransformCmd_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TransformCmd().getOutput());
  }

  /**
   * Test {@link TransformCmd#getPrintClasses()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor) PrintClasses is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getPrintClasses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransformCmd.getPrintClasses()"})
  public void testGetPrintClasses_givenTransformCmdPrintClassesIsFalse_thenReturnFalse() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setPrintClasses(false);

    // Act and Assert
    assertFalse(transformCmd.getPrintClasses());
  }

  /**
   * Test {@link TransformCmd#getPrintClasses()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor) PrintClasses is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getPrintClasses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TransformCmd.getPrintClasses()"})
  public void testGetPrintClasses_givenTransformCmdPrintClassesIsTrue_thenReturnTrue() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setPrintClasses(true);

    // Act and Assert
    assertTrue(transformCmd.getPrintClasses());
  }

  /**
   * Test {@link TransformCmd#getTransformer()}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor) Transformer is {@code <set-?>}.
   *   <li>Then return {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#getTransformer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransformCmd.getTransformer()"})
  public void testGetTransformer_givenTransformCmdTransformerIsSet_thenReturnSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();
    transformCmd.setTransformer("<set-?>");

    // Act and Assert
    assertEquals("<set-?>", transformCmd.getTransformer());
  }

  /**
   * Test new {@link TransformCmd} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TransformCmd}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.<init>()"})
  public void testNewTransformCmd() {
    // Arrange and Act
    TransformCmd actualTransformCmd = new TransformCmd();

    // Assert
    assertEquals(
        "    transform - Apply transformations to input (experimental)\n",
        actualTransformCmd.getHelpMessage());
    assertEquals(
        "Apply transformations to input (experimental)", actualTransformCmd.getActionDescription());
    assertEquals("transform", actualTransformCmd.getProgramName());
    assertEquals("transform", actualTransformCmd.getName());
    assertNull(actualTransformCmd.getOutput());
    assertEquals(OptionPrefixStyle.LINUX, actualTransformCmd.getPrefixStyle());
    assertFalse(actualTransformCmd.getSkipExtraArguments());
    assertFalse(actualTransformCmd.getStrictSubcommandOptionsOrder());
    assertTrue(actualTransformCmd.getUseDefaultHelpShortName());
  }

  /**
   * Test {@link TransformCmd#setClassNameFilter(String)}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor).
   *   <li>Then {@link TransformCmd} (default constructor) ClassNameFilter is {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#setClassNameFilter(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.setClassNameFilter(String)"})
  public void testSetClassNameFilter_givenTransformCmd_thenTransformCmdClassNameFilterIsSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setClassNameFilter("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getClassNameFilter());
  }

  /**
   * Test {@link TransformCmd#setInput(String)}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor).
   *   <li>When {@code <set-?>}.
   *   <li>Then {@link TransformCmd} (default constructor) Input is {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#setInput(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.setInput(String)"})
  public void testSetInput_givenTransformCmd_whenSet_thenTransformCmdInputIsSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setInput("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getInput());
  }

  /**
   * Test {@link TransformCmd#setOutput(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link TransformCmd} (default constructor) Output is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#setOutput(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.setOutput(String)"})
  public void testSetOutput_whenNull_thenTransformCmdOutputIsNull() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setOutput(null);

    // Assert that nothing has changed
    assertNull(transformCmd.getOutput());
  }

  /**
   * Test {@link TransformCmd#setOutput(String)}.
   *
   * <ul>
   *   <li>When {@code <set-?>}.
   *   <li>Then {@link TransformCmd} (default constructor) Output is {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#setOutput(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.setOutput(String)"})
  public void testSetOutput_whenSet_thenTransformCmdOutputIsSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setOutput("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getOutput());
  }

  /**
   * Test {@link TransformCmd#setPrintClasses(boolean)}.
   *
   * <p>Method under test: {@link TransformCmd#setPrintClasses(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.setPrintClasses(boolean)"})
  public void testSetPrintClasses() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setPrintClasses(true);

    // Assert
    assertTrue(transformCmd.getPrintClasses());
  }

  /**
   * Test {@link TransformCmd#setTransformer(String)}.
   *
   * <ul>
   *   <li>Given {@link TransformCmd} (default constructor).
   *   <li>When {@code <set-?>}.
   *   <li>Then {@link TransformCmd} (default constructor) Transformer is {@code <set-?>}.
   * </ul>
   *
   * <p>Method under test: {@link TransformCmd#setTransformer(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformCmd.setTransformer(String)"})
  public void testSetTransformer_givenTransformCmd_whenSet_thenTransformCmdTransformerIsSet() {
    // Arrange
    TransformCmd transformCmd = new TransformCmd();

    // Act
    transformCmd.setTransformer("<set-?>");

    // Assert
    assertEquals("<set-?>", transformCmd.getTransformer());
  }
}
