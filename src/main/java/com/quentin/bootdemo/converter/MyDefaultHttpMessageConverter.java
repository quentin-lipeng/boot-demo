package com.quentin.bootdemo.converter;

import com.quentin.bootdemo.pojo.RetMessage;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author:quentin
 * @create: 2022-10-18 21:06
 * @Description:
 */
public class MyDefaultHttpMessageConverter implements HttpMessageConverter<String> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        System.out.println("can read");
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        return clazz.equals(String.class) && mediaType.equals(MediaType.TEXT_HTML);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        System.out.println("list");
        return null;
    }

    @Override
    public String read(Class<? extends String> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        System.out.println("read");
        return null;
    }

    @Override
    public void write(String s, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        System.out.println("write");

        try (OutputStream outStream = outputMessage.getBody()) {
            outStream.write(s.getBytes());
            // 其实现类为 {@see org.apache.catalina.connector.CoyoteOutputStream}
//            System.out.println("out stream class = " + outStream.getClass());
            // 因为使用了try-with-resource 所以会自动close()
            // 而且close()方法内最先执行的就是flush()
//            outStream.flush();

        } catch (IOException e) {
            System.out.println("error = " + e.getMessage());
        }

    }
}
