package pdftool;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

/**
 *
 * @author brajes
 */
public class PdfTool {
    
    public static String FONT_PATH = "resources/ComicNoteSmooth.ttf";
    
    public static void main(String[] args) throws DocumentException, IOException {
        if(args.length > 0) {
            System.out.println(args[args.length - 1].toString());
        }
        
        Stamper stmp;
        String src = "resources/IFSC.pdf";
        String dest = "results/IFSC2.pdf";
        String img = "resources/prison-break.jpg";
        
        stmp = new Stamper( src, dest);
        
        stmp.open();
        stmp.stampImage(img, 100f, 200f);
        stmp.stampText(FONT_PATH, 35, 550);
        stmp.close();
    }
    
}
