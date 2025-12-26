@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repo.findAll();
    }

    @Override
    public ViolationRecord save(ViolationRecord record) {
        return repo.save(record);
    }
}
