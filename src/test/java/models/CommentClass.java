package models;

public class CommentClass {
	
	private boolean tipo;
	private String comentario;
	
	
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public CommentClass(boolean tipo, String comentario) {
		this.tipo = tipo;
		this.comentario = comentario;
	}

}
