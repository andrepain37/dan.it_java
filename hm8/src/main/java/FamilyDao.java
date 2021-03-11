import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    void displayAllFamilies ();
    List<Family> getFamiliesBiggerThan(int size);
    List<Family> getFamiliesLessThan(int size);
    int countFamiliesWithMemberNumber (int size);
    Family getFamilyByIndex(int i);
    boolean deleteFamily(int i);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    void createNewFamily(Human fHuman, Human sHuman);
    void deleteFamilyByIndex(int i);
    Family bornChild (Family family, String manName, String womanName);
    Family adoptChild (Family family, Human child);
    void deleteAllChildrenOlderThen (int age);
    int count();
    Family getFamilyById(int i);
    List<Pet> getPets(int i);
    void addPet(int indexFamily, Pet pet);
}
