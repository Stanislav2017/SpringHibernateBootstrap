package com.mykheikin.springproject.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

@Component("convertToFromByte")
public class ConvertToFromByte {

	public byte[] getByteStreamToDB(String path) {

		if (path != null) {
			File file = new File(path);
			byte[] bFile = new byte[(int) file.length()];

			try (FileInputStream fileInputStream = new FileInputStream(file);) {

				fileInputStream.read(bFile);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return bFile;
		} else {
			return null;
		}
	}

	public byte[] getByteStreamFromDB(byte[] bFile) {
		if (bFile != null) {
			try (FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Desktop\\11.jpg");) {

				fos.write(bFile);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return bFile;
		}
		return null;
	}
}
