package ua.tilo.spring.userdetails;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.tilo.spring.config.MyUserDetails;
import ua.tilo.spring.model.MyUser;
import ua.tilo.spring.repository.MyUserRepository;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {


    private MyUserRepository repository;
    @Autowired
    public void setRepository(MyUserRepository repository) {
        this.repository = repository;
    }

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<MyUser> user = Optional.ofNullable(repository.findMyUserByUserName(username));

            return user.map(MyUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException(username+" not found"));

    }
}
