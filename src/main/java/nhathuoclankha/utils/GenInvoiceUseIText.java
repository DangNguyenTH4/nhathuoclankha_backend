package nhathuoclankha.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenInvoiceUseIText {
	public void genTable() throws DocumentException, URISyntaxException, IOException {
		// Tạo đối tượng tài liệu
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {

			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("D:\\viblo_asia.pdf"));

			// Mở file để thực hiện ghi
			document.open();


		

			PdfPTable t = new PdfPTable(3);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Header1"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
			t.addCell(c2);
			PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
			t.addCell(c3);

			t.addCell("1.1");
			t.addCell("1.2");
			t.addCell("1.3");

			document.add(t);

			// Đóng File
			document.close();
			System.out.println("Write file succes!");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
	private PdfPTable createTable() {
		PdfPTable t = new PdfPTable(5);
		t.setSpacingAfter(25);
		t.setSpacingBefore(25);
		
		return t;
	}
}
