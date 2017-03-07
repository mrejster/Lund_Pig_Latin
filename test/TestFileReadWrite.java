import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class TestFileReadWrite{
    @Parameters
    public static Collection<Object[]> data() {
        File folder = new File("test/testFiles/input");
        File[] listOfFiles = folder.listFiles();
        ArrayList<Object[]> res = new ArrayList<Object[]>();
        Arrays.stream(listOfFiles).map(file -> file.getName()).forEach(file -> res.add(new Object[]{file}));
        return res;
    }

    private String fileName;

    public TestFileReadWrite(String fileName){
        this.fileName = fileName;

    }
    @Test
    public void test() throws IOException{
        String res = Main.translateFile("test/testFiles/input/" + fileName);
        Main.translationToFile("test/testFiles/actual/" + fileName, res);
        assertEquals(readFile("test/testFiles/expected/" + fileName),readFile("test/testFiles/actual/" + fileName));
    }

    static String readFile(String path) 
        throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }




}
