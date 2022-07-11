package exercicio_aula_143.order.entitites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exercicio_aula_143.order.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> orderList = new ArrayList<>(); 
	private Client client;

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order() {}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nOrder summary:" + "\n");
		sb.append("Order moment:" + moment + "\n");
		sb.append("Order status:" + status + "\n");
		sb.append("Client: " + client.toString());
		sb.append("Order items:" + "\n");
		for (OrderItem oit : orderList) {
			sb.append(oit.toString() + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f" ,total()));

		return sb.toString();
	}

	public Double total() {
		Double total = 0.0; 

		for (OrderItem item : orderList) {
			total += item.subTotal();
		}

		return total;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void addItem(OrderItem item) {
		orderList.add(item);
	}
	public void removeItem(OrderItem item) {
		orderList.remove(item);
	}
	public  Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
