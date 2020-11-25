import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class ZipUtils {
	
	private List <String> fileList;
    private static final String OUTPUT_ZIP_FILE = "C:\\var\\www\\html\\gps\\operator\\TouringTalkies\\TouringTalkies.zip";

    public ZipUtils() {
        fileList = new ArrayList <String> ();
    }

    public static void main(String[] args) {
        ZipUtils appZip = new ZipUtils();
        appZip.generateFileList(new File("C:\\var\\www\\html\\gps\\operator\\TouringTalkies\\efe"));
        appZip.zipIt(OUTPUT_ZIP_FILE);
        appZip.deleteFolder("C:\\var\\www\\html\\gps\\operator\\TouringTalkies\\efe");
        
    }
    
    public void deleteFolder(String path) {
    	
    	File d = new File(path);
    	boolean b = FileUtils.deleteQuietly(d);
    	if(b) {
    		System.out.println("Deleted");
    	}else {
    		System.out.println("Not Deleted");
    	}

    }

    public void zipIt(String zipFile) {
        byte[] buffer = new byte[1024];
        String source = new File("C:\\var\\www\\html\\gps\\operator\\TouringTalkies\\efe").getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file: this.fileList) {
                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try {
                    in = new FileInputStream("C:\\var\\www\\html\\gps\\operator\\TouringTalkies\\efe" + File.separator + file);
                    int len;
                    while ((len = in .read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            System.out.println("Folder successfully compressed");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateFileList(File node) {
    	System.out.println("generateFileList()");
    	System.out.println(node);
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename: subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file) {
    	System.out.println("file--->"+file);
        return file.substring("C:\\var\\www\\html\\gps\\operator\\TouringTalkies\\efe".length() + 1, file.length());
    }
	
	
}
