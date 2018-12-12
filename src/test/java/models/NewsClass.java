package models;


public class NewsClass {
	
	private String titulo;	
	private String descripcion;	
	private String linkNoticia;
	private String linkImagen;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescriptionArea(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLinkNoticia() {
		return linkNoticia;
	}
	public void setLinkNoticia(String linkNoticia) {
		this.linkNoticia = linkNoticia;
	}
	public String getLinkImagen() {
		return linkImagen;
	}
	public void setLinkImagen(String linkImagen) {
		this.linkImagen = linkImagen;
	}
	
	public NewsClass(String titulo, String descripcion, String linkNoticia, String linkImagen) {
		this.titulo= titulo;
		this.descripcion = descripcion;
		this.linkNoticia= linkNoticia;
		this.linkImagen = linkImagen;
	}

}

