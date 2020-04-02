package nhathuoclankha.utils;

import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenInvoice {
	public void  gen() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		 
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		 
		contentStream.setFont(PDType1Font.COURIER, 12);
		contentStream.beginText();
		contentStream.showText("Hello World as;dfjks;lkfjs;dlk fjsd;lkjf");
		contentStream.endText();
		contentStream.close();
		 
		document.save("D:/pdfBoxHelloWorld.pdf");
		document.close();
	}
}
