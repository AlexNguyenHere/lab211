package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextModel {
    private String content;

    public void readInputFile(String filePath) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            content = stringBuilder.toString();
        } catch (IOException e) {
            throw new IOException("Error reading input file: " + e.getMessage());
        }
    }

    public String normalizeText() {
  //Rút gọn khoảng trắng cách
    content = content.replaceAll("\\s+", " ");

  //Giữ khoảng trắng sau các dấu
    content = content.replaceAll(",\\s+", ", ");
    content = content.replaceAll("\\.\\s+", ". ");
    content = content.replaceAll(":\\s+", ": ");

    //Chữ cái đầu sau dấu. thì IN hoa, còn lại in thường
    content = content.replaceAll("\\.\\s+(\\w)(\\w*)", ". $1$2".toLowerCase());
  
    //Không khoảng trắng trước sau dấu kép
    content = content.replaceAll("\\s+\"(.*?)\"\\s+", " \"$1\" ");

   //Chữ cái đầu thì in hoa
    content = content.replaceFirst("(?m)^\\s*\\w", Character.toString(Character.toUpperCase(content.charAt(0))));
  
   //Xóa dòng trống
    content = content.replaceAll("(?m)^[ \t]*\r?\n", "");

   //Không khoảng trống giữa dấu phẩy hoặc dấu chấm
    content = content.replaceAll("(\\w)[\\s]*,[\\s]*", "$1,");
    content = content.replaceAll("(\\w)[\\s]*\\.[\\s]*", "$1.");

    //Thêm dấu chấm ở cuối đoạn văn bản
    content = content.trim();
    if (!content.endsWith(".")) {
        content += ".";
    }

    return content;
}
}