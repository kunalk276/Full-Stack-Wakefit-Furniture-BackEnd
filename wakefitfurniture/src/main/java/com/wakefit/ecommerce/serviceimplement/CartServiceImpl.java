package com.wakefit.ecommerce.serviceimplement;

import com.wakefit.ecommerce.entity.Cart;
import com.wakefit.ecommerce.exception.ResourceNotFoundException;
import com.wakefit.ecommerce.repository.CartRepository;
import com.wakefit.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with ID " + cartId));
    }

    @Override
    public Cart updateCart(Long cartId, Cart updatedCart) {
        Cart existingCart = getCartById(cartId);

        existingCart.setUser(updatedCart.getUser());
        existingCart.setProducts(updatedCart.getProducts());
        existingCart.setOrders(updatedCart.getOrders());

        return cartRepository.save(existingCart);
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cartToDelete = getCartById(cartId);
        cartRepository.delete(cartToDelete);
    }
}
