package lister;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
	private Serializer() {
		throw new IllegalStateException("Utility class");
	}

	public static Object deserialize(String file) {
		Object obj  = new Object();
		
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			obj = ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static void serializer(Object obj, String file) {
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(obj);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
}
