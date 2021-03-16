import java.util.List;
import java.util.Optional;

public interface FamilyDao {
    List<Family> getAllFamilies();
    default void displayAllFamilies (){
        System.out.println(getAllFamilies());
    };
    List<Family> getFamiliesBiggerThan(int size);
    List<Family> getFamiliesLessThan(int size);
    int countFamiliesWithMemberNumber (int size);
    Optional<Family> getFamilyByIndex(int i);
    boolean deleteFamily(int i);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    void createNewFamily(Human fHuman, Human sHuman);
    void deleteFamilyByIndex(int i);
    Family bornChild (Family family, String manName, String womanName);
    Family adoptChild (Family family, Human child);
    void deleteAllChildrenOlderThen (int age);
    int count();
    Optional<Family> getFamilyById(int i);
    List<Pet> getPets(int i);
    void addPet(int indexFamily, Pet pet);
}
