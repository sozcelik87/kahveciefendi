package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PAYMENT_TYPE_ID",referencedColumnName="ID")
	private PaymentType paymentType;
	
	@ManyToOne
	@JoinColumn(name="DELIVERY_ADDRESS_ID",referencedColumnName="ID")
	private Address deliveryAddress;
	
	@OneToMany(mappedBy="order",targetEntity=OrderItem.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<OrderItem> orderItems;  
	
	@Column(name="DISCOUNT")
	private Long discount;
	
	@Column(name="TOTAL_PRICE")
	private Long totalPrice;
	
	@Column(name="DISCOUNTED_PRICE")
	private Long discountedPrice;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID",referencedColumnName="ID")
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
