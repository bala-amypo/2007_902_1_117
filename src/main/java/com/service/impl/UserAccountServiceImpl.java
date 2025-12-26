
com.example.demo.service.impl;
@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccount save(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public void updateUserStatus(Long userId, String status) {
        repo.findById(userId).ifPresent(u -> {
            u.setStatus(status);
            repo.save(u);
        });
    }
}
