import java.io.*;  
import javax.swing.text.html.*;  
import javax.swing.text.html.parser.*;  
  
public class HtmlToString extends HTMLEditorKit.ParserCallback {  
     StringBuffer s;  
  
     public HtmlToString() {}  
  
     public void parse(Reader in) throws IOException {  
       s = new StringBuffer();  
       ParserDelegator delegator = new ParserDelegator();  
       // the third parameter is TRUE to ignore charset directive  
       delegator.parse(in, this, Boolean.TRUE);  
     }  
  
     public void handleText(char[] text, int pos) {  
       s.append(text);  
     }  
  
     public String getText() {  
       return s.toString();  
     }  
  
     public static void main (String[] args) {  
       try {  
         // the HTML to convert  
         //Reader in=new StringReader("string");      
         FileReader in = new FileReader("java-new.html");  
         HtmlToString parser = new HtmlToString();  
         parser.parse(in);  
         in.close();  
         System.out.println(parser.getText());  
       }  
       catch (Exception e) {  
         e.printStackTrace();  
       }  
     }  
}  
