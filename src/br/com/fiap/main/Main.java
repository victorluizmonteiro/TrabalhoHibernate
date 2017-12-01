package br.com.fiap.main;

import java.time.LocalDateTime;
import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helper.AplicacaoHelper;

public class Main {

	public static void main(String[] args) {
		AplicacaoHelper dao = new AplicacaoHelper();
		
		Cliente c1 = new Cliente();
		c1.setNome("Victor");
		c1.setEmail("victor@gmail.com");
		

		Cliente c2 = new Cliente();
		c2.setNome("Mateus");
		c2.setEmail("mateus@gmail.com");
		
		Pedido p1 = new Pedido();
		p1.setDescricao("Maquina de lavar");
		p1.setData(LocalDateTime.now());
		p1.setValor(4000.0);
		
		Pedido p2 = new Pedido();
		p2.setDescricao("Fogão");
		p2.setData(LocalDateTime.now());
		p2.setValor(2000.0);
		
		Pedido p3 = new Pedido();
		p3.setDescricao("Notebook");
		p3.setData(LocalDateTime.now());
		p3.setValor(6000.0);
		
		Pedido p4 = new Pedido();
		p4.setDescricao("Armário");
		p4.setData(LocalDateTime.now());
		p4.setValor(400.0);
		
		c1.addPedido(p1);
		c1.addPedido(p2);
		c2.addPedido(p3);
		c2.addPedido(p4);
		dao.cadastrarCliente(c1);
		dao.cadastrarCliente(c2);
		
		
		List<Pedido>pedidoCliente1 = dao.listarPedidosByIdCliente(c1.getId());
		
		
		List<Pedido>pedidoCliente2 = dao.listarPedidosByIdCliente(c2.getId());
		System.out.println("---------- Pedidos do Cliente 1 ----------");
		pedidoCliente1.stream().forEach(System.out::println);
		
		System.out.println("---------- Pedidos do Cliente 2 ----------");
		pedidoCliente2.stream().forEach(System.out::println);
		
		List<Cliente> buscarCliente = dao.listarClientes();
		buscarCliente.stream().forEach(System.out::println);
		
		//dao.cadastrarPedido(p1);
		//dao.cadastrarPedido(p2);
		//dao.cadastrarPedido(p3);
		//dao.cadastrarPedido(p4);
		
		
		
		
		
		
		
	
		
		
		

	}

}
