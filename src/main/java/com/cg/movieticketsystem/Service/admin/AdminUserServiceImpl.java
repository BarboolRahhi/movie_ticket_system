package com.cg.movieticketsystem.Service.admin;

import static com.cg.movieticketsystem.util.Constants.ALREADY_EXISTS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movieticketsystem.entity.Role;
import com.cg.movieticketsystem.entity.RoleType;
import com.cg.movieticketsystem.entity.User;
import com.cg.movieticketsystem.exception.AlreadyExistsException;
import com.cg.movieticketsystem.exception.NotFoundException;
import com.cg.movieticketsystem.repository.RoleRepository;
import com.cg.movieticketsystem.repository.UserRepository;
import com.cg.movieticketsystem.security.SecurityConstant;
import com.cg.movieticketsystem.util.Constants;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
	private static final Logger logger = LoggerFactory.getLogger(AdminMovieServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public List<User> getItems() {
		return userRepository.findAll();
	}

	@Override
	public User getItem(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));
	}

	@Override
	public User addItem(User user) {
		logger.info("User: {}", user);

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new AlreadyExistsException(ALREADY_EXISTS);
		}

		User newUser = new User(user.getUsername(), user.getEmail(), encoder.encode(user.getPassword()),
				user.getContact());

		Set<Role> roles = new HashSet<>();

		if (user.getRoles() != null && !user.getRoles().isEmpty()) {
			user.getRoles().forEach((role) -> {
				Role newRole = roleRepository.findByName(role.getName())
						.orElseThrow(() -> new NotFoundException(SecurityConstant.ROLE_NOT_FOUND));
				roles.add(newRole);
			});

		} else {
			Role role = roleRepository.findByName(RoleType.ROLE_CUSTOMER)
					.orElseThrow(() -> new NotFoundException(SecurityConstant.ROLE_NOT_FOUND));
			roles.add(role);

		}

		newUser.setRoles(roles);

		return userRepository.save(newUser);
	}

	@Override
	public User updateItem(Long id, User user) throws NotFoundException {
		logger.info("User: {}", user);

		User newUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));

		if (!newUser.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(user.getEmail())) {
			throw new AlreadyExistsException(ALREADY_EXISTS);
		}

		Set<Role> roles = new HashSet<>();

		if (user.getRoles() != null && !user.getRoles().isEmpty()) {

			user.getRoles().forEach(role -> {
				Role newRole = roleRepository.findByName(role.getName())
						.orElseThrow(() -> new NotFoundException(SecurityConstant.ROLE_NOT_FOUND));
				roles.add(newRole);
			});

		} else {
			newUser.getRoles().forEach(roles::add);

		}

		newUser.setEmail(user.getEmail());
		newUser.setContact(user.getContact());
		newUser.setUsername(user.getUsername());
		newUser.setRoles(roles);

		return userRepository.save(newUser);
	}

	@Override
	public void deleteItem(Long id) throws NotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND));
		user.getRoles().forEach(role -> {
			user.removeRole(role);
		});
		userRepository.deleteById(user.getUserId());
	}

}
