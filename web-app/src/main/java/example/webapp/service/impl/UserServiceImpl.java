package example.webapp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.webapp.UserRepository;
import example.webapp.io.entity.UserEntity;
import example.webapp.service.UserService;
import example.webapp.shared.dto.UserDto;

@Service 
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUserId");
		
		userEntity.setEmail("email");
		userEntity.setEmailVerificationToken("token");
		userEntity.setFirstName("fn");
		userEntity.setLastName("ln");
		userEntity.setEmailVerificationStatus("string");
		
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

}
