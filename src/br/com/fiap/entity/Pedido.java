package br.com.fiap.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TB_PEDIDOS")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPEDIDO")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	
	@Column(name="DATA")
	
	private LocalDateTime data;
	
	@Column(name="DESCRIÇÃO")
	private String descricao;
	
	@Column(name="VALOR")
	private Double valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Pedido(int id, Cliente cliente, LocalDateTime data, String descricao, Double valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Pedido() {
		super();
	}
	
	
	@Override
	public String toString() {
		
		// TODO Auto-generated method stub
		return "Id do Pedido :" + id + "\nID Cliente: "+  cliente.getId() +"\nData :" + data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) +"\nDescrição: "+ descricao  + "\nValor :" + valor;
	}
	
	
	
	
	
	

}
