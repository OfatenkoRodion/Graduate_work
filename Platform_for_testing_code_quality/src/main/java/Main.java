import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Main
{
    public static void download(String downloadURL,String path) throws IOException
    {
        URL website = new URL(downloadURL);
        String fileName = getFileName(downloadURL);

        try (InputStream inputStream = website.openStream())
        {
            Files.copy(inputStream, Paths.get(path+fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        List<String> lines = Files.readAllLines(Paths.get(path+fileName), StandardCharsets.UTF_8);
        for(String line: lines)
        {
            System.out.println(line);
        }
    }

    public static String getFileName(String downloadURL) throws UnsupportedEncodingException
    {
        String baseName = FilenameUtils.getBaseName(downloadURL);
        String extension = FilenameUtils.getExtension(downloadURL);
        String fileName = baseName + "." + extension;

        int questionMarkIndex = fileName.indexOf("?");
        if (questionMarkIndex != -1)
        {
            fileName = fileName.substring(0, questionMarkIndex);
        }

        fileName = fileName.replaceAll("-", "");
        return URLDecoder.decode(fileName, "UTF-8");
    }

    public static void main(String[] args)
    {
        try
        {
            download("https://raw.githubusercontent.com/OfatenkoRodion/Khai_quest/master/app/src/main/java/Entity/LazyImmutableInt.java","F:\\");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
