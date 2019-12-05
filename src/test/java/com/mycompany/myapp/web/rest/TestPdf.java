package com.mycompany.myapp.web.rest;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.mycompany.myapp.SpringdataJpaNotesApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdataJpaNotesApp.class)
public class TestPdf {
@Test
    public void te(){
        //模板路径
        String templatePath = "/Users/mac/Downloads/1561962068087-2114201513.pdf";
        //生成的新文件路径
//        String newPDFPath = "E:/pdf/ss1.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
//            out = new FileOutputStream(newPDFPath);//输出流
            reader = new PdfReader(templatePath);//读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();
                //填写内容部分
//                form.setField(name, "2465465145648456");
                System.out.println(name);
                //
            }
            stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();

            Document doc = new Document();
//            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
//            PdfImportedPage importPage = copy.getImportedPage(
//                new PdfReader(bos.toByteArray()), 1);
//            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(1);
        } catch (DocumentException e) {
            System.out.println(2);
        }

    }
}
