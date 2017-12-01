package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="TB_CLIENTE")

public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDCLIENTE")
	private int id;
	@Column(name="Nome")
	private String nome;
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cliente",fetch=FetchType.LAZY)
	private List<Pedido> pedidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void addPedido(Pedido pedido) {
		pedido.setCliente(this);
		this.pedidos.add(pedido);
	}
	public Cliente(int id, String nome, String email, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.pedidos = pedidos;
	}

	public Cliente() {
		super();
		pedidos = new ArrayList<Pedido>();
	}
@Override
public String toString() {
	
	return "Nome: " + nome + "\nEmail :" + email ;
}
	
}
