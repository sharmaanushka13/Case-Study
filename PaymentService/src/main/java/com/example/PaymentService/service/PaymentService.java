package com.example.PaymentService.service;
import java.util.List;

import com.example.PaymentService.entity.PaymentDetails;

public interface PaymentService 
{
	public List<PaymentDetails> getAll();
	public String proceedToPay(PaymentDetails payment);
	public String deletePayment(long pnrNo);
}
