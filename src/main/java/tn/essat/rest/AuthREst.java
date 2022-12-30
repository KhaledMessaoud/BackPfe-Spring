package tn.essat.rest;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.config.GestionToken;
import tn.essat.config.JwtRequest;
import tn.essat.dao.IUser;
import tn.essat.model.User;
import tn.essat.response.Authresponse;
import tn.essat.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/auth")
public class AuthREst {

	@Autowired
	GestionToken token_gen;

	@Autowired
	UserService service;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	IUser daou;

	@Autowired
	ServletContext context;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public Authresponse test(@RequestBody JwtRequest request) {

		Authentication authen = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authen);

		User u = (User) service.loadUserByUsername(request.getUsername());
		String token = token_gen.generateToken(u);

		return new Authresponse(u.getId(),u.getNom(),u.getEmail(), u.getUsername(), u.getOrganisation(),token, u.getRole());

	}

	@PostMapping("/save")
	public User get3(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return daou.save(user);
	}

}
