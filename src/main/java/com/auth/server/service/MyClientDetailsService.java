package com.auth.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.auth.server.model.AppClient;
import com.auth.server.model.MyClientDetails;
import com.auth.server.repository.ClientRepository;

@Service
public class MyClientDetailsService implements ClientDetailsService {
	
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		
		AppClient c = clientRepository.findByClientId(clientId);
		
		if(c==null)
			throw new ClientRegistrationException("client with "+ clientId + " not registered with server");
		return new MyClientDetails(c);
	}

}
