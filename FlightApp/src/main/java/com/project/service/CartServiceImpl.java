package com.project.service;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import com.project.model.*;
import com.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.exception.CustomerNotFoundException;
import com.project.exception.ProductNotFoundException;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private FlightsDao pDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao custDao;

	@Autowired
	private SeatsDao seatsDao;

	@Autowired
	private SeatsService seatService;
	

	
	//Method to add the Product and customer in cart

	@Override
	public Cart AddProduct(Cart cart,Integer Productid,Integer userId, Integer seatId) {
		// TODO Auto-generated method stub\
		
		Optional<Flights> opt=pDao.findById(Productid);
		Optional<User> users=userDao.findById(userId);

		if(users.isEmpty()) {
			throw new CustomerNotFoundException("customer not found");
		}

		User user=  userDao.findByUsername(users.get().getUsername());
		String logedinOrNot = currentUserSessionDao.findByUserId(user.getUserId());
		if(logedinOrNot==null) {
			throw new CustomerNotFoundException("Customer not logged in");
		}

		Flights prod=opt.get();
		User us =users.get();
//		if(cart.getQuantity() > prod.getStockQuantity()){
//			throw new NotEnoughInventoryException(" You select more quantity that available");
//		}
		if(opt.isPresent()) {
			cart.setCartItem(prod);
			cart.setUserList(us);
			cart.setQuantity(cart.getQuantity());
			cart.setSeat(seatService.getSeatById(seatId));
			return cartDao.save(cart);
		}else {
			throw new ProductNotFoundException("Product not available");
		}
	}

	@Override
	public List<Cart> ViewAllCart() {
		// TODO Auto-generated method stub
		List<Cart> list=cartDao.findAll();
		return list;
	}
	

	@Override
    
	public String deleteProductfromCart(Integer id)throws ProductNotFoundException {
		Optional<Cart> opt = cartDao.findById(id);
		
		if (opt.isPresent()) {
			Cart cart = opt.get();
			cartDao.delete(cart);
			return "CartProduct is deleted from Cart";
			
		} else
			throw new ProductNotFoundException("Product not found with given id");

	}

	private Cart cart;
	@Autowired
	private OrderDao orderDao;

	@Override
	@Transactional
	public void deleteAllCart() {
		// TODO Auto-generated method stub
		cartDao.DeleteAll();
	}


	public void changeSeatInOrder(Integer orderId, Integer newSeatId){

		Optional<Cart> cartOptional = cartDao.findById(orderId);
		Optional<Seats> seatsOptional = seatsDao.findById(newSeatId);

		Cart cart = cartOptional.get();
		Seats seats = seatsOptional.get();
		cart.setSeat( seats);
		cartDao.save(cart);

	}
}
