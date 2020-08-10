package br.com.api.techflix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.api.techflix.connection.ConnectionFactory;
import br.com.api.techflix.model.Categoria;
import br.com.api.techflix.model.LinkExtraCategoria;
import br.com.api.techflix.model.Video;

public class CategoriaDAO {
	
	Connection connection;
	
	public CategoriaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Categoria> listaCategoria() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try {	
			String sql = "select *"
					+ " from tf_categoria";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setIdCategoria(rs.getInt("id_categoria"));
				c.setTituloCategoria(rs.getString("titulo_categoria"));
				c.setLinkCategoria(rs.getString("link_categoria"));
				c.setCorCategoria("cor_categoria");
				c.setVideoCategorias(findVideo(c.getIdCategoria()));
				c.setLinkExtraCategorias(findLinkExtra(c.getIdCategoria()));
				
				categorias.add(c);
			}
			
			rs.close();
			stmt.close();
			
			return categorias;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Video> findVideo(int id){
		List<Video> videos = new ArrayList<Video>();
		
		String sql = "select *"
				+ " from tf_video"
				+ " where id_categoria_video = " + id;
		
		System.out.println(sql);
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Video v = new Video();
				v.setTituloVideo(rs.getString("titulo_video"));
				v.setUrlVideo(rs.getString("url_video"));
				
				videos.add(v);
			}
			
			rs.close();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return videos; 
	}
	
	public List<LinkExtraCategoria> findLinkExtra(int id){
		List<LinkExtraCategoria> extras = new ArrayList<LinkExtraCategoria>();
		
		try {
			
			String sql = "select *"
					+ " from tf_link_extra"
					+ " where id_categoria_extra = " + id;
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				LinkExtraCategoria l = new LinkExtraCategoria();
				l.setTextLinkExtraCategoria(rs.getString("titulo_extra"));
				l.setUrlLinkExtraCategoria(rs.getString("url_extra"));
				
				extras.add(l);
			}
			
			rs.close();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return extras; 
	}
}
