package com.example.qr_code_generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CodeGenerator {

    public static BufferedImage generateQRCode(String urlText, String filePath) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(urlText, BarcodeFormat.QR_CODE, 200, 200);

        //gen qr code to image
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}


