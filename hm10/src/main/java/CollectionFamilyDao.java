import java.util.*;

public class CollectionFamilyDao implements FamilyDao {

    List<Family> familyList = new ArrayList<Family>();
    public final int year = Calendar.getInstance().get(Calendar.YEAR);

    @Override
    public List<Family> getAllFamilies() {

        return familyList;
    }


    @Override
    public List<Family> getFamiliesBiggerThan(int size) {
        List<Family> families = new ArrayList<>();
        familyList.forEach((f) -> {
            if (f.countFamily() > size) {
                families.add(f);
            }
        });
        return families;
    }

    @Override
    public List<Family> getFamiliesLessThan(int size) {
        List<Family> families = new ArrayList<>();
        familyList.forEach((f) -> {
            if (f.countFamily() < size) {
                families.add(f);
            }
        });

        return families;
    }

    @Override
    public int countFamiliesWithMemberNumber(int size) {
        final int[] count = {0};
        familyList.forEach((f) -> {
            if (f.countFamily() == size) {
                count[0]++;
            }
        });
        return count[0];

    }

    @Override
    public Optional<Family> getFamilyByIndex(int i) {

        return Optional.ofNullable(familyList.get(i));

    }

    @Override
    public boolean deleteFamily(int i) {

        try{
            if (familyList.size() -1 <= i){
                familyList.remove(i);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        try{
            if (familyList.contains(family)){
                familyList.remove(family);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void saveFamily(Family family) {
        int index = familyList.indexOf(family);

        if (index != -1){
            familyList.set(index, family);
        }else{
            familyList.add(family);
        }
    }

    @Override
    public void createNewFamily(Human fHuman, Human sHuman) {
        Family newFamily = new Family(fHuman, sHuman);
        familyList.add(newFamily);
    }

    @Override
    public void deleteFamilyByIndex(int i) {
        deleteFamily(i);
    }

    @Override
    public Family bornChild(Family family, String manName, String womanName) {
        if (familyList.contains(family)) {
            int random_number = (int) (Math.random() * 2);
            Human newChild;
            Calendar dateBorn = new GregorianCalendar();

            if (random_number == 1) {
                newChild = new Man(manName, family.getFather().getSurname(), year);
            }else{
                newChild = new Woman(womanName, family.getFather().getSurname(), year);
            }
            family.addChild(newChild);
            saveFamily(family);
            return family;
        }
        return null;
    }

    @Override
    public Family adoptChild(Family family, Human child) {
        if (familyList.contains(family)) {
            family.addChild(child);
            saveFamily(family);
            return family;
        }
        return null;
    }

    @Override
    public void deleteAllChildrenOlderThen(int age) {

        familyList.forEach((f) -> {
            final int[] i = {0};
            List<Human> childList = f.getChildren();
            if (childList == null) {
                childList.forEach((child) -> {
                    if (year - child.getYear() > age) {
                        f.deleteChild(i[0]);

                    }
                    i[0]++;
                });
            }

        });

    }

    @Override
    public int count() {
        return familyList.size();
    }

    @Override
    public Optional<Family> getFamilyById(int i) {
        return getFamilyByIndex(i);
    }

    @Override
    public List<Pet> getPets(int i) {

        Optional<Family> family = getFamilyById(i);
        if (family != null) {
            List<Pet> listPet = new ArrayList<Pet>();
            listPet.add(familyList.get(i).getPet());
            return listPet;
        }
        return null;
    }

    @Override
    public void addPet(int indexFamily, Pet pet) {
        Family family = getFamilyById(indexFamily).get();
        if (family != null) {
            family.setPet(pet);
        }
    }

}
