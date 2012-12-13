package pdftool;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author brajes
 */
public class Stamper {

    private PdfReader reader;
    private PdfStamper stamper;
    private PdfContentByte canvas;
    private String sourcePath;
    private String destinationPath;
    
    Stamper(String src, String dest) throws DocumentException, IOException {
        this.sourcePath = src;
        this.destinationPath = dest;
    }
    
    public void open() throws DocumentException, IOException {
        this.reader = new PdfReader(this.sourcePath);
        this.stamper = new PdfStamper(this.reader, new FileOutputStream(this.destinationPath));
        this.canvas = this.stamper.getOverContent(1);
    }
    
    public void close() throws DocumentException, IOException {
        this.stamper.close();
    }
    
    public void stampImage(String imagePath, float x, float y) throws DocumentException, IOException {
        Image image = Image.getInstance(imagePath);
        image.setAbsolutePosition(x, y);
        this.canvas.addImage(image);
    }
    
    public void stampText(String txt, float x, float y) throws DocumentException, IOException {
        BaseFont bf;
        bf = BaseFont.createFont(PdfTool.FONT_PATH, BaseFont.WINANSI, BaseFont.EMBEDDED);
        
        this.canvas.beginText();
        this.canvas.setFontAndSize(bf, 24);
        this.canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, txt, x, y, 0);
        this.canvas.endText();        
    }
    
}
