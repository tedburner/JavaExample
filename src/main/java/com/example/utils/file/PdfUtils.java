package com.example.utils.file;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: lingjun.jlj
 * @date: 2019/4/2 16:16
 * @description:
 */
public class PdfUtils {

    public static void main(String[] args) {
        String templatePath = "E:\\宇为\\深圳工行车牌分期\\合同模板\\车牌分期(2).pdf";
        String newPath = "E:\\宇为\\深圳工行车牌分期\\合同模板\\" + System.currentTimeMillis() + ".pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;

        try {
            out = new FileOutputStream(newPath);//输出流
            reader = new PdfReader(templatePath);//读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            //填写字段
            form.setField("name", "蒋灵俊");
            form.setField("pinyin", "jianglingjun");

            // 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.setFormFlattening(true);
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();

            FileOutputStream fos = new FileOutputStream(newPath);
            fos.write(bos.toByteArray());
            fos.close();

            PdfImportedPage importPage = copy.getImportedPage(
                    new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
