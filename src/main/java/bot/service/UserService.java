package bot.service;

import bot.dataSql.UserTable;
import bot.dataSql.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static UserTableRepository userTableRepository;

    @Autowired
    public UserService(UserTableRepository userTableRepository) {
        this.userTableRepository = userTableRepository;
    }

    public List<UserTable> getAllUsers() {
        return userTableRepository.findAll();
    }
}
