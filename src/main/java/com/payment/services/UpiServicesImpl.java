package com.payment.services;

import javax.persistence.EntityExistsException;

import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.payment.entity.UPI;
import com.payment.repository.UPIRepository;

@Service
public class UpiServicesImpl implements IUpiServices {

	@Autowired
	private UPIRepository upiRepository;

	@Override
	public boolean addUpi(UPI upi) throws Exception {
		if (upi != null) {
			if (upi.getUpiId().isEmpty() || upi.getAccountBalance() == 0 || upi.getPasscode().isEmpty()
					|| upi.getUpiHolderName().isEmpty()) {
				throw new NotAcceptableStatusException("Invalid information provided");
			} else if (upiRepository.findByUpiId(upi.getUpiId()) != null) {
				throw new EntityExistsException("UPI with provided UPI Id already exist " + upi.getUpiId());
			} else {
				try {
					upiRepository.save(upi);
				} catch (Exception e) {
					throw new IntegrationException(e.getLocalizedMessage());
				}
				return true;
			}
		}
		return false;
	}

}
