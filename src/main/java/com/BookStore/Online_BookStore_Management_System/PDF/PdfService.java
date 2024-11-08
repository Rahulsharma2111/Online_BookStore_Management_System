package com.BookStore.Online_BookStore_Management_System.PDF;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public ByteArrayInputStream generatePdf(String content) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Create PDF Writer
        PdfWriter writer = new PdfWriter(out);

        // Create PDF Document
        PdfDocument pdf = new PdfDocument(writer);

        // Add a Document Layout
        Document document = new Document(pdf);

        // Add content to the PDF
        document.add(new Paragraph(content));

        // Close the document
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}

