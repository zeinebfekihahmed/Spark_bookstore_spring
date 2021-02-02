package tn.esprit.bookStore.entities;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class OffrePdfExporter {
	
	private List<Offre>listOffres;
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Offre Id", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("nomOffre", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("dateDeb", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("dateFin", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("tauxRemise", font));
        table.addCell(cell);       
    }
	private void writeTableData(PdfPTable table) {
        for (Offre offre : listOffres) {
            table.addCell(String.valueOf(offre.getIdOffre()));
            table.addCell(offre.getNomOffre());
            table.addCell(offre.getDateDeb().toString());
            table.addCell(offre.getDateFin().toString());
            table.addCell(offre.getTauxRemise().toString());
        }
    }
	public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List des Offres", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }

}
