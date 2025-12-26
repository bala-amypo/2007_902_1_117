
@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;

    public LoginEventServiceImpl(LoginEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        return repo.save(event);
    }

    @Override
    public List<LoginEvent> getUserLoginEvents(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getFailedLogins(Long userId) {
        return repo.findByUserIdAndSuccessFalse(userId);
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
