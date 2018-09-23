package com.yxysoft.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.yxysoft.common.base.BaseRuntimeException;
import com.yxysoft.common.constants.Symbol;


/**
 * @ClassName: FileUtil
 * @Description: 文件帮助类
 * @author yangsy
 */
public class FileUtil {

	 /**
    *
    * @param file 文件
    * @param path 文件存放路径
    * @param fileName 源文件名
    * @return
    */
   public static boolean upload(MultipartFile file, String path, String fileName){

       // 生成新的文件名
       //String realPath = path + "/" + FileNameUtils.getFileName(fileName);

       //使用原文件名
       String realPath = path + "/" + fileName;

       File dest = new File(realPath);

       //判断文件父目录是否存在
       if(!dest.getParentFile().exists()){
           dest.getParentFile().mkdir();
       }

       try {
           //保存文件
           file.transferTo(dest);
           return true;
       } catch (IllegalStateException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           return false;
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           return false;
       }

   }
   
   
    /**
     * @Fields LOGGER : 系统各类资源路径处理帮助类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    /**
     * @Fields BUFFER_SIZE : 文件操作缓存区大小
     */
    public static final int BUFFER_SIZE = 65536;

    /**
     * @Fields SEPERATOR : 文件路径分隔符
     */
    public static final String SEPERATOR = File.separator;

    /**
     * @Fields JAVA_PATH_SEPERATOR : 在java中的路径分隔符
     */
    public static final String JAVA_PATH_SEPERATOR = "//";

    /**
     * @Title: createDir
     * @Description: 如果文件夹不存在，则先创建文件夹
     * @param file 要创建的文件
     */
    public static void createDir(final File file) {
        final File parent = file.getParentFile();
        if (parent != null) {
            try {
                parent.mkdirs();
            } catch (final SecurityException e) {
                throw new BaseRuntimeException(e);
            }
        }
    }
    /**
     * @Title: getHumanReadableFileSize
     * @Description: 将文件大小转换成可读的文件大小，例如 1024=1.00KB
     * @param fileSize 文件大小,单位：字节
     * @return 字符串
     */
    public static String getHumanReadableFileSize(final Long fileSize) {
        if (fileSize == null) {
            return null;
        }
        return getHumanReadableFileSize(fileSize.longValue());
    }

    /**
     * @Title: getHumanReadableFileSize
     * @Description: 将文件大小转换成可读的文件大小
     * @param fileSize 文件大小
     * @param unit 大小单位
     * @param unitName 单位名称
     * @return 可读的文件大小
     */
    @SuppressWarnings("unused")
	private static String getHumanReadableFileSize(final long fileSize, final long unit, final String unitName) {
        if (fileSize == 0) {
            return "0";
        }

        if ((fileSize / unit) >= 1) {
            final double value = fileSize / (double) unit;
            final DecimalFormat df = new DecimalFormat("######.##" + unitName);
            return df.format(value);
        }
        return null;
    }

    /**
     * @Title: getWebClassesPath
     * @Description: 获取某个类的全路径
     * @param clas 类的class
     * @return 类的全路径，包含class名称
     */
    public static String getWebClassesPath(final Class<?> clas) {
        final String path = clas.getProtectionDomain().getCodeSource().getLocation().getPath();
        return path;

    }

    /**
     * @Title: getWebRoot
     * @Description: 获取web工程的根目录
     * @param clazz class所在类加载器的web工程根目录
     * @return web工程的根目录
     */
    public static String getWebRoot(Class<?> clazz) {
        String result = getWebClassesPath(clazz);
        int index = result.lastIndexOf("WEB-INF");
        if (index == -1) {
            index = result.lastIndexOf("classes"); // 没有WEB-INF目录，可能是单元测试环境
        }
        if (index == -1) {
            index = result.lastIndexOf("bin");
        }
        result = result.substring(0, index);
        final String warPrefix = "zip:";
        final String classPrefix = "file:/";
        final String jarPrefix = "jar:file:/";
        if (result.startsWith(warPrefix)) { // 当class文件在war中时，返回"zip:D:/ ..."样的路径
            result = result.substring(warPrefix.length());
        } else if (result.startsWith(classPrefix)) { // 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
            result = result.substring(classPrefix.length());
        } else if (result.startsWith(jarPrefix)) { // 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径
            result = result.substring(jarPrefix.length());
        }
        if (result.endsWith(Symbol.FORWARD_SLASH)) {
            result = result.substring(0, result.length() - 1);// 不包含最后的Symbol.FORWARD_SLASH
        }
        result = result.replace("%20", " "); // Window下替换空格
        LOGGER.debug("getWebRoot=====" + result);
        return result;
    }

    /**
     * @return 获取当前工作目录
     */
    public static String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }

    /**
     * @Title: getJavaFileSystemPath
     * @Description: 获取java中路径的写法
     * @param path 原始路径
     * @return java中识别的路径字符串
     */
    public static String getJavaFileSystemPath(final String path) {
        if (path == null) {
            return null;
        }
        final String javaPath = path.replace('\\', '/');
        return javaPath;
    }

    /**
     * @Title: mkdirsWithExistsCheck
     * @Description: 创建文件夹
     * @param dir 文件夹路径
     * @return 如果创建或目录已存在，则返回true
     */
    public static boolean mkdirsWithExistsCheck(final File dir) {
        if (dir.mkdir() || dir.exists()) {
            return true;
        }
        File canonDir = null;
        try {
            canonDir = dir.getCanonicalFile();
        } catch (final IOException e) {
            return false;
        }
        final String parent = canonDir.getParent();
        return (parent != null) && (mkdirsWithExistsCheck(new File(parent)) && (canonDir.mkdir() || canonDir.exists()));
    }

    /**
     * @Title: getFileExt
     * @Description: 获取文件后缀名
     * @param fileName 全部文件名
     * @return 文件后缀名
     */
    public static String getFileExt(final String fileName) {
        String value = "";
        int start = 0;
        int end = 0;
        final int charDot = 46;
        if (fileName == null) {
            return null;
        }
        start = fileName.lastIndexOf(charDot) + 1;
        end = fileName.length();
        value = fileName.substring(start, end);
        if (fileName.lastIndexOf(charDot) > 0) {
            return value;
        } else {
            return "";
        }
    }

    /**
     * @Title: getFilename
     * @Description: 根据路径，获取文件名称
     * @param filename 文件名称
     * @return 文件名
     */
    public static String getFilename(final String filename) {
        String value = "";
        int start = 0;
        int end = 0;
        if (filename == null) {
            return value;
        }
        if (filename.indexOf(Symbol.FORWARD_SLASH) != -1) {
            start = filename.lastIndexOf(Symbol.FORWARD_SLASH) + 1;
            end = filename.length();
            value = filename.substring(start, end);
            if (filename.lastIndexOf(Symbol.FORWARD_SLASH) > 0) {
                return value;
            }
        } else if (filename.indexOf(JAVA_PATH_SEPERATOR) != -1) {
            start = filename.lastIndexOf(JAVA_PATH_SEPERATOR) + 1;
            end = filename.length();
            value = filename.substring(start, end);
            if (filename.lastIndexOf(JAVA_PATH_SEPERATOR) > 0) {
                return value;
            }
        }
        return filename;
    }
    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * MethodName: saveToFile
     * @Description: 获取网络图片存到本地
     * @param destUrl
     * @return String  
     * @author yangsy
     * @version:0.1
     * @date 2016-10-10 下午8:38:13
     */
    public static String saveToFile(String destUrl) {
    	String targetPath = SEPERATOR+"aft"+SEPERATOR+"webapp"+SEPERATOR+"application"+SEPERATOR+"file"+SEPERATOR+"wx"+SEPERATOR+"mpnew"+SEPERATOR+""+DateUtil.getCurrentTimeSSSAsNumber()+".jpg";
    	//String targetPath = "I:"+SEPERATOR+"aft"+SEPERATOR+"webapp"+SEPERATOR+"application"+SEPERATOR+"file"+SEPERATOR+"wx"+SEPERATOR+"mpnew"+SEPERATOR+""+DateUtil.getCurrentTimeSSSAsNumber()+".jpg";
	   //System.out.println("destUrl===================>"+destUrl);
	   //System.out.println("targetPath===================>"+targetPath);
    	FileOutputStream fos = null;  
	    BufferedInputStream bis = null;  
	    HttpURLConnection httpUrl = null;  
	    URL url = null;  
	    int BUFFER_SIZE = 1024;  
	    byte[] buf = new byte[BUFFER_SIZE];  
	    int size = 0;  
	    try {
		    url = new URL(destUrl);  
		    httpUrl = (HttpURLConnection) url.openConnection();  
		    httpUrl.connect();  
		    bis = new BufferedInputStream(httpUrl.getInputStream());  
		    fos = new FileOutputStream(targetPath);  
		    while ((size = bis.read(buf)) != -1) {  
		    fos.write(buf, 0, size);  
		    }  
		    fos.flush();  
	    } catch (IOException e) {
	    	
	    } catch (ClassCastException e) {
	    	
	    } 
	    finally {  
		    try {  
			    fos.close();  
			    bis.close();  
			    httpUrl.disconnect();  
		    } catch (IOException e) {
		    	
		    } catch (NullPointerException e) {  
		    	
		    }  
	    }  
    	return targetPath;
    }  
    /**
     * MethodName: saveToFileUserName
     * @Description: 指定图片名称-保存网络图片
     * @param destUrl
     * @param fileName
     * @return String  
     * @author yangsy
     * @version:0.1
     * @date 2016-10-13 上午11:50:19
     */
    public static String saveToFileUserName(String destUrl,String fileName) {
    	//String targetPath = SEPERATOR+"aft"+SEPERATOR+"webapp"+SEPERATOR+"application"+SEPERATOR+"file"+SEPERATOR+"wx"+SEPERATOR+"mpnew"+SEPERATOR+""+DateUtil.getCurrentTimeSSSAsNumber()+".jpg";
    	String targetPath = "E:"+SEPERATOR+"aft"+SEPERATOR+"webapp"+SEPERATOR+"application"+SEPERATOR+"file"+SEPERATOR+"wx"+SEPERATOR+"mpnew"+SEPERATOR+""+fileName+".jpg";
	   //System.out.println("targetPath===================>"+targetPath);
    	FileOutputStream fos = null;  
	    BufferedInputStream bis = null;  
	    HttpURLConnection httpUrl = null;  
	    URL url = null;  
	    int BUFFER_SIZE = 1024;  
	    byte[] buf = new byte[BUFFER_SIZE];  
	    int size = 0;  
	    try {
		    url = new URL(destUrl);  
		    httpUrl = (HttpURLConnection) url.openConnection();  
		    httpUrl.connect();  
		    bis = new BufferedInputStream(httpUrl.getInputStream());  
		    fos = new FileOutputStream(targetPath);  
		    while ((size = bis.read(buf)) != -1) {  
		    fos.write(buf, 0, size);  
		    }  
		    fos.flush();  
	    } catch (IOException e) {
	    	
	    } catch (ClassCastException e) {
	    	
	    } 
	    finally {  
		    try {  
			    fos.close();  
			    bis.close();  
			    httpUrl.disconnect();  
		    } catch (IOException e) {
		    	
		    } catch (NullPointerException e) {  
		    	
		    }  
	    }  
    	return targetPath;
    }  
    /**
     * 文件转为Base64
     * @param filePath
     * @return
     */
    public static String encryptToBase64(String filePath) {  
        if (filePath == null) {  
            return null;  
        }  
        try {  
            byte[] b = Files.readAllBytes(Paths.get(filePath));  
            return Base64.getEncoder().encodeToString(b);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
      
        return null;  
    }  
    /**
     * 将Base64转为文件
     * @param base64
     * @param filePath
     * @return
     */
    public String decryptByBase64(String base64, String filePath) {  
        if (base64 == null && filePath == null) {  
               return "生成文件失败，请给出相应的数据。";  
        }  
        try {  
            Files.write(Paths.get(filePath), Base64.getDecoder().decode(base64),StandardOpenOption.CREATE);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return "指定路径下生成文件成功！";  
    }  
    
 // 文件复制
    public static boolean copyFile(String source, String copy) throws Exception {
        source = source.replace("\\", "/");
        copy = copy.replace("\\", "/");

        File source_file = new File(source);
        File copy_file = new File(copy);

        // BufferedStream缓冲字节流

        if (!source_file.exists()) {
            throw new IOException("文件复制失败：源文件（" + source_file + "） 不存在");
        }
        if (copy_file.isDirectory()) {
            throw new IOException("文件复制失败：复制路径（" + copy_file + "） 错误");
        }
        File parent = copy_file.getParentFile();
        // 创建复制路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 创建复制文件
        if (!copy_file.exists()) {
            copy_file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(source_file);
        FileOutputStream fos = new FileOutputStream(copy_file);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] KB = new byte[1024];
        int index;
        while ((index = bis.read(KB)) != -1) {
            bos.write(KB, 0, index);
        }

        bos.close();
        bis.close();
        fos.close();
        fis.close();

        if (!copy_file.exists()) {
            return false;
        } else if (source_file.length() != copy_file.length()) {
            return false;
        } else {
            return true;
        }

    }

    // 文件重命名
    public static boolean renameFile(String url, String new_name) throws Exception {
        String old_url = url;
        old_url = old_url.replace("\\", "/");
        File old_file = new File(old_url);
        if (!old_file.exists()) {
            throw new IOException("文件重命名失败，文件（"+old_file+"）不存在");
        }
        System.out.println(old_file.exists());

        String old_name = old_file.getName();
        // 获得父路径
        String parent = old_file.getParent();
        // 重命名
        String new_url = parent + "/" + new_name;
        File new_file = new File(new_url);
        old_file.renameTo(new_file);

        System.out.println("原文件：" + old_file.getName());
        System.out.println("新文件：" + new_file.getName());
        new_name = new_file.getName();
        old_name = old_file.getName();
        if (new_name.equals(old_name)) {
            return false;
        } else {
            return true;
        }

    }

    // 文件删除
    public static boolean deleteFile(String url) throws Exception {
        url = url.replace("\\", "/");
        File file = new File(url);

        if (file.isFile()) {
            if (file.exists()) {
                file.delete();
            }
        }else{
            throw new IOException("文件删除失败：（"+file+"）错误");
        }
        if (file.exists()) {
            return false;
        } else {
            return true;
        }
    }

    // 创建文件夹
    public static boolean createPath(String url) throws Exception {
        url = url.replace("\\", "/");
        File folder = new File(url);
        if(!folder.isDirectory()){
            throw new IOException("创建文件夹失败：（"+folder+"）不是文件夹路径");
        }

        if (!folder.isFile()) {
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }
        // 检测是否创建成功
        if (folder.isDirectory() && folder.exists()) {
            return true;
        } else {
            return false;
        }

    }
    //链接url下载图片
    public static void downloadPicture(String urlList,String imageName) {
        URL url = null;
        int imageNumber = 0;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());


            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
  
}
