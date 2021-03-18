import java.util.List;
import java.util.Optional;

public class FamilyService implements FamilyDao {
    private final CollectionFamilyDao cfDao = new CollectionFamilyDao();

    @Override
    public List<Family> getAllFamilies() {
        return cfDao.getAllFamilies();
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int size) {
        return cfDao.getFamiliesBiggerThan(size);
    }

    @Override
    public List<Family> getFamiliesLessThan(int size) {
        return cfDao.getFamiliesLessThan(size);
    }

    @Override
    public int countFamiliesWithMemberNumber(int size) {
        return cfDao.countFamiliesWithMemberNumber(size);
    }

    @Override
    public Optional<Family> getFamilyByIndex(int i) {
        return cfDao.getFamilyByIndex(i);
    }

    @Override
    public boolean deleteFamily(int i) {
        return cfDao.deleteFamily(i);
    }

    @Override
    public boolean deleteFamily(Family family) {
        return cfDao.deleteFamily(family);
    }

    @Override
    public void saveFamily(Family family) {
        cfDao.saveFamily(family);
    }

    @Override
    public void createNewFamily(Human fHuman, Human sHuman) {
        cfDao.createNewFamily(fHuman, sHuman);
    }

    @Override
    public void deleteFamilyByIndex(int i) {
        cfDao.deleteFamilyByIndex(i);
    }

    @Override
    public Family bornChild(Family family, String manName, String womanName) {
        return cfDao.bornChild(family, manName, womanName);
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        return cfDao.adoptChild(family, child);
    }

    @Override
    public void deleteAllChildrenOlderThen(int age) {
        cfDao.deleteAllChildrenOlderThen(age);
    }

    @Override
    public int count() {
        return cfDao.count();
    }

    @Override
    public Optional<Family> getFamilyById(int i) {
        return cfDao.getFamilyById(i);
    }

    @Override
    public List<Pet> getPets(int i) {
        return cfDao.getPets(i);
    }

    @Override
    public void addPet(int indexFamily, Pet pet) {
        cfDao.addPet(indexFamily, pet);
    }
}
