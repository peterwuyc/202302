package com.project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.exception.CustomerNotFoundException;
import com.project.model.Cart;
import com.project.model.MyOrder;
import com.project.model.Flights;
import com.project.model.User;
import com.project.repository.CartDao;
import com.project.repository.CurrentUserSessionDao;
import com.project.repository.CustomerDao;
import com.project.repository.OrderDao;
import com.project.repository.FlightsDao;

import com.project.repository.UserDao;




@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currUserSessDao;
	
	@Autowired
	private FlightsDao productDao;

	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	 private CartService cartService;

	@Override
	public List<MyOrder> viewOrder() {
		List<MyOrder>allOrder=orderdao.findAll();
		return allOrder;
	}

	@Override
	public MyOrder viewOrderByCustomerId(Integer custiomerId) {
		List<MyOrder>allOrder=orderdao.findAll();
		
		for(MyOrder order:allOrder) {
			if(order.getUser().getUserId()==custiomerId) {
			return order;
			}
		}
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public MyOrder updateOrder(Integer custiomerId, MyOrder order) {
		List<MyOrder>allOrder=orderdao.findAll();
		int count=0;
		MyOrder findord=new MyOrder();
		for(MyOrder find:allOrder) {
			if(find.getUser().getUserId()==custiomerId) {
				findord=find;
				count++;
			}

		}
		if(count==0) {
			throw new CustomerNotFoundException("Order not found");
		}

		List<Flights> flights2 =order.getProductlist();
		List<Flights> products = findord.getProductlist();
		return findord;
		
		
	}

	@Override
	public String removeOrder(Integer custiomerId) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		
		
		for(MyOrder order:allOrder) {
			if(order.getUser().getUserId()==custiomerId) {
//			 orderdao.delete(order);
				
				User user=  userDao.findByUsername(order.getUser().getUsername());
				String logedinOrNot = currUserSessDao.findByUserId(user.getUserId());
				if(logedinOrNot==null) {
					throw new CustomerNotFoundException("Customer not logged in");
				}
				order.setUser(null);
				order.setProductlist(null);
				orderdao.save(order);
				System.out.println(order);
				orderdao.delete(order);
				
			 return "order canceled";
			}
		}
		
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public MyOrder addorderFromCart(Integer userId) {
		// TODO Auto-generated method stub
		
		MyOrder myOrder=new MyOrder();
		Cart cart=new Cart();
		List<Cart> allCartDetails=cartServiceImpl.ViewAllCart();
		List<Flights>getProducts=new ArrayList<>();
		
		for(Cart newCart:allCartDetails) {
			if(newCart.getUserList().getUserId()==(userId)) {
				getProducts.add(newCart.getCartItem());
				allCartDetails.remove(newCart.getCartItem());
				myOrder.setQuantity(newCart.getQuantity());
			}
		}

		cartServiceImpl.deleteAllCart();
		System.out.println(getProducts);
		myOrder.setDatePlaced(LocalDateTime.now());
		myOrder.setOrderStatus("Processing");

		Optional<User>opt=userDao.findById(userId);
		
		if(opt.isEmpty()) {
			throw new CustomerNotFoundException("User not found with this Id"+userId);
		}
		myOrder.setUser(opt.get());
		myOrder.setProductlist(getProducts);

		MyOrder myOrder2= orderdao.save(myOrder);
		return myOrder2;
	}

	@Override
	public MyOrder cancelOrder(Integer orderId) {
		MyOrder myOrder=orderdao.getById(orderId);

		myOrder.setOrderStatus("Canceled");

		MyOrder myOrder2= orderdao.save(myOrder);
		return myOrder2;
	}

	@Override
	public MyOrder completeOrder(Integer orderId) {


		MyOrder myOrder=orderdao.getById(orderId);

		myOrder.setOrderStatus("Completed");
		Flights product = myOrder.getProductlist().get(0);
		product.setStockQuantity( product.getStockQuantity() - myOrder.getQuantity());

		MyOrder myOrder2= orderdao.save(myOrder);
		return myOrder2;
	}


}






















