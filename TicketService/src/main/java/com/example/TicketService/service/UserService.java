package com.example.TicketService.service; import java.util.List;

import com.example.TicketService.entity.UserDetails;

public interface UserService 
{ 
	public List<UserDetails> getAll(); 
	public UserDetails getUserDetailsById(long pnrNo); 
	public String addUserBookingDetails(UserDetails userDetails); 
	public String deleteUserBookingDetails(long pnrNo); 
}
