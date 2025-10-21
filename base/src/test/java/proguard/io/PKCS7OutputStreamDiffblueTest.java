package proguard.io;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PKCS7OutputStreamDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PKCS7OutputStream.writeSignature(X509Certificate, String, String, byte[])"
  })
  public void testWriteSignature_whenDigestAlgorithm_thenThrowIllegalArgumentException()
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
}
