import java.util.List;
import java.util.Optional;

public class FamilyController implements FamilyDao{
    private final FamilyService familyService = new FamilyService();

    @Override
    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int size) {
        return familyService.getFamiliesBiggerThan(size);
    }

    @Override
    public List<Family> getFamiliesLessThan(int size) {
        return familyService.getFamiliesLessThan(size);
    }

    @Override
    public int countFamiliesWithMemberNumber(int size) {
        return familyService.countFamiliesWithMemberNumber(size);
    }

    @Override
    public Optional<Family> getFamilyByIndex(int i) {
        try {
            return familyService.getFamilyByIndex(i);
        }catch (Exception e){
            throw new FamilyOverflowException("Семьи по данному индексу не существует");
        }

    }

    @Override
    public boolean deleteFamily(int i) {
        return familyService.deleteFamily(i);
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyService.deleteFamily(family);
    }

    @Override
    public void saveFamily(Family family) {
        familyService.saveFamily(family);
    }

    @Override
    public void createNewFamily(Human fHuman, Human sHuman) {
        familyService.createNewFamily(fHuman, sHuman);
    }

    @Override
    public void deleteFamilyByIndex(int i) {
        familyService.deleteFamilyByIndex(i);
    }

    @Override
    public Family bornChild(Family family, String manName, String womanName) {
        return familyService.bornChild(family, manName, womanName);
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    @Override
    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    @Override
    public int count() {
        return familyService.count();
    }

    @Override
    public Optional<Family> getFamilyById(int i) {
        return familyService.getFamilyById(i);
    }

    @Override
    public List<Pet> getPets(int i) {
        return familyService.getPets(i);
    }

    @Override
    public void addPet(int indexFamily, Pet pet) {
        familyService.addPet(indexFamily, pet);
    }

}
