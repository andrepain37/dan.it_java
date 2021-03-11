import java.util.*;

public class CollectionFamilyDao implements FamilyDao {

    List<Family> familyList = new ArrayList<Family>();
    public final int year = Calendar.getInstance().get(Calendar.YEAR);

    @Override
    public List<Family> getAllFamilies() {

        return familyList;
    }

    @Override
    public void displayAllFamilies() {
        System.out.println(familyList);
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int size) {
        List<Family> families = new ArrayList<Family>();
        for (Family f: familyList) {
            if (f.countFamily() > size) {
                families.add(f);
            }
        }
        return families;
    }

    @Override
    public List<Family> getFamiliesLessThan(int size) {
        List<Family> families = new ArrayList<Family>();
        for (Family f: familyList) {

            if (f.countFamily() < size) {

                families.add(f);
            }
        }
        return families;
    }

    @Override
    public int countFamiliesWithMemberNumber(int size) {
        int countFamilies = 0;
        for (Family f: familyList) {
            if (f.countFamily() == size) {
                countFamilies++;
            }
        }
        return countFamilies;
    }

    @Override
    public Family getFamilyByIndex(int i) {
        try{
            return familyList.get(i);
        }
        catch (Exception e){
            return null;
        }

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
        for (Family f: familyList) {
            int i = 0;
            List<Human> childList = f.getChildren();
            if (childList == null) {
                for (Human child: childList){
                    if (year - child.getYear() > age) {
                        f.deleteChild(i);

                    }
                    i++;
                }
            }

        }
    }

    @Override
    public int count() {
        return familyList.size();
    }

    @Override
    public Family getFamilyById(int i) {
        return getFamilyByIndex(i);
    }

    @Override
    public List<Pet> getPets(int i) {

        Family family = getFamilyById(i);
        if (family != null) {
            List<Pet> listPet = new ArrayList<Pet>();
            listPet.add(familyList.get(i).getPet());
            return listPet;
        }
        return null;
    }

    @Override
    public void addPet(int indexFamily, Pet pet) {
        Family family = getFamilyById(indexFamily);
        if (family != null) {
            family.setPet(pet);
        }
    }

}
