package com.code.edu.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

public interface Context {
    Logger logger = LoggerFactory.getLogger(Context.class);
    static String getSystem(){
        String os = System.getProperty("os.name");
        logger.info("system ============> {}",os);
        return os.toLowerCase();
    }
    static String uploadAddr(){
        if(getSystem().startsWith("win")){
            return "D:/javaSoft/nginx-1.12.2/nginx-1.12.2/html/upload/";
        }else{
            return "/usr/local/nginx/html/upload/";
        }
    }
    static File getHttpsFile(String classpathName) throws IOException {
        if(getSystem().startsWith("win1")){
            File keystore = new ClassPathResource(classpathName).getFile();
            return keystore;
        }else{
            InputStream keystore = new ClassPathResource(classpathName).getInputStream();
            byte[] bytes = new byte[1024];
            File file = new File("/usr/java/jkss");
            if(!file.exists()){
                file.mkdirs();
            }
            if(!file.canRead()){
                file.setReadable(true);
            }
            if(file.canWrite()){
                file.setWritable(true);
            }
            File jks = new File(file,classpathName);
            if(!jks.exists()){
                jks.createNewFile();
            }
            if(!jks.canRead()){
                jks.setReadable(true);
            }
            if(jks.canWrite()){
                jks.setWritable(true);
            }
            OutputStream outputStream = new FileOutputStream(jks);
            while(keystore.read(bytes) != -1){
                outputStream.write(bytes);
            }
            jks.setWritable(false);
            return jks;
        }
    }
//    Long DEFAULT_COMPANY_ID = 1L;
    String FILE_HOST = "http://edu.ccmmxj.club/upload/";
}
