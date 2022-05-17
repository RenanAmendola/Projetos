package com.blogpessoal.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "TB_usuario")
public class Usuario {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull
private String nome;

@Schema(example = "email@email.com")
@NotNull
@Email
private String usuario;

@NotNull
@Size(min = 5)
private String senha;

@Size(max = 5000)
private String foto;

@NotNull
private String tipo = "common";



@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
@JsonIgnoreProperties("usuario")
private List<Postagem> postagem;



public Usuario(Long id, String nome,String usuario, String senha, String foto, String tipo) {
	super();
	this.id = id;
	this.nome = nome;
	this.usuario = usuario;
	this.senha = senha;
	this.foto = foto;
	this.tipo = tipo;
	
}



public Usuario() {
	super();
}



public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public List<Postagem> getPostagem() {
	return postagem;
}

public void setPostagem(List<Postagem> postagem) {
	this.postagem = postagem;
}





}