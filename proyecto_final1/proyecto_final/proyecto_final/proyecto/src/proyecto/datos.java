package proyecto;

import java.io.Serializable;

public class datos implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String nombre;
String url;
String img;


public String getUrl() {
	return url;
}

public void setUrl(String imageBase64) {
	this.url = imageBase64;
}

public String getNombre() {
	return nombre;
}

public String setNombre(String nombre) {
	return this.nombre = nombre;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}


}
