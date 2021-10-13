package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
