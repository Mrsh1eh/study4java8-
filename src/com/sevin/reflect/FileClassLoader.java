package com.sevin.reflect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class FileClassLoader extends ClassLoader {

	private String rootdir;
	
    public FileClassLoader(String rootdir) {
		super();
		this.rootdir = rootdir;
	}

    protected Class<?> findClass(String name) throws ClassNotFoundException{
    	byte[] data;
		try {
			data = getData(name);
			
			return defineClass(name, data, 0, data.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }

	private byte[] getData(String name) throws IOException {
		String path = this.rootdir + File.separator + name.replace(".", File.separator) + ".class";	
		
		try {
			FileInputStream fis = new FileInputStream(path);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[4096];
			int count = 0;
			while((count = fis.read(b)) != -1){
				bos.write(b, 0, count);
			}
			return bos.toByteArray();
			
		} catch (FileNotFoundException e) {

		}
		return null;
	}
}
