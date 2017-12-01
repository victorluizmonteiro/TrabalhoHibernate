package br.com.fiap.helper;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.fiap.config.HibernateConfig;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class AplicacaoHelper {
	
	Transaction transaction = null;
	 static Session session = null;
	
	public void cadastrarCliente(Cliente c) {
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
			session.close();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public void cadastrarPedido(Pedido p) {
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.save(p);
			transaction.commit();
			session.close();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Pedido>listarPedidosByIdCliente(int idCliente){
		List<Pedido>pedidos = new ArrayList<Pedido>();
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			
			Query<Pedido>query = session.createQuery("from Pedido p where p.cliente.id = :idCliente");
			query.setParameter("idCliente", idCliente);
			query.setCacheable(true);
			pedidos = query.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pedidos;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente>listarClientes(){
		List<Cliente>clientes = new ArrayList<>();
		try {
			session = HibernateConfig.getSessionFactory().openSession();
			Query<Cliente>query = session.createQuery("from Cliente c ");
			clientes = query.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clientes;
		
	}
	
	private   Session  getSession() {
	return	session = HibernateConfig.getSessionFactory().getCurrentSession();
		
	}

}
