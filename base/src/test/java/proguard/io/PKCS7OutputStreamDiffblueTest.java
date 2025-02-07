package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PKCS7OutputStreamDiffblueTest {
  /**
   * Test {@link PKCS7OutputStream#writeSignature(X509Certificate, String, String, byte[])}.
   *
   * <ul>
   *   <li>When {@code Digest Algorithm}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PKCS7OutputStream#writeSignature(X509Certificate, String, String,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test writeSignature(X509Certificate, String, String, byte[]); when 'Digest Algorithm'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.PKCS7OutputStream.writeSignature(java.security.cert.X509Certificate, java.lang.String, java.lang.String, byte[])"
  })
  void testWriteSignature_whenDigestAlgorithm_thenThrowIllegalArgumentException()
      throws IOException, CertificateEncodingException {
    // Arrange
    PKCS7OutputStream pkcs7OutputStream =
        new PKCS7OutputStream(new DEROutputStream(new ByteArrayOutputStream(1)));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            pkcs7OutputStream.writeSignature(
                null, "Digest Algorithm", "Encryption Algorithm", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PKCS7OutputStream#flush()}.
   *
   * <ul>
   *   <li>Given {@link DEROutputStream} {@link DEROutputStream#flush()} does nothing.
   *   <li>Then calls {@link DEROutputStream#flush()}.
   * </ul>
   *
   * <p>Method under test: {@link PKCS7OutputStream#flush()}
   */
  @Test
  @DisplayName("Test flush(); given DEROutputStream flush() does nothing; then calls flush()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.PKCS7OutputStream.flush()"})
  void testFlush_givenDEROutputStreamFlushDoesNothing_thenCallsFlush() throws IOException {
    // Arrange
    DEROutputStream derOutputStream = mock(DEROutputStream.class);
    doNothing().when(derOutputStream).flush();

    // Act
    (new PKCS7OutputStream(derOutputStream)).flush();

    // Assert
    verify(derOutputStream).flush();
  }

  /**
   * Test {@link PKCS7OutputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link DEROutputStream} {@link DEROutputStream#close()} does nothing.
   *   <li>Then calls {@link DEROutputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PKCS7OutputStream#close()}
   */
  @Test
  @DisplayName("Test close(); given DEROutputStream close() does nothing; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.PKCS7OutputStream.close()"})
  void testClose_givenDEROutputStreamCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    DEROutputStream derOutputStream = mock(DEROutputStream.class);
    doNothing().when(derOutputStream).close();

    // Act
    (new PKCS7OutputStream(derOutputStream)).close();

    // Assert
    verify(derOutputStream).close();
  }
}
