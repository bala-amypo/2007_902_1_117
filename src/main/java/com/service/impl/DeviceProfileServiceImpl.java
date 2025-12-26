@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId).orElse(null);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public DeviceProfile save(DeviceProfile device) {
        return repo.save(device);
    }
}
@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId).orElse(null);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public DeviceProfile save(DeviceProfile device) {
        return repo.save(device);
    }
}
