package br.com.api.techflix.model;

import java.util.List;

public class Categoria {
	
	int idCategoria;
	String tituloCategoria;
	String linkCategoria;
	String corCategoria;
	List<LinkExtraCategoria> linkExtraCategorias;
	List <Video> videoCategorias; 
	
	public String getTituloCategoria() {
		return tituloCategoria;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public void setTituloCategoria(String tituloCategoria) {
		this.tituloCategoria = tituloCategoria;
	}
	public String getLinkCategoria() {
		return linkCategoria;
	}
	public void setLinkCategoria(String linkCategoria) {
		this.linkCategoria = linkCategoria;
	}
	public String getCorCategoria() {
		return corCategoria;
	}
	public void setCorCategoria(String corCategoria) {
		this.corCategoria = corCategoria;
	}
	public List<LinkExtraCategoria> getLinkExtraCategorias() {
		return linkExtraCategorias;
	}
	public void setLinkExtraCategorias(List<LinkExtraCategoria> linkExtraCategorias) {
		this.linkExtraCategorias = linkExtraCategorias;
	}
	public List<Video> getVideoCategorias() {
		return videoCategorias;
	}
	public void setVideoCategorias(List<Video> videoCategorias) {
		this.videoCategorias = videoCategorias;
	}
}
