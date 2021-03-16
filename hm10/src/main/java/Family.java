import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Pet pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Family family = (Family) o;

        if (!mother.equals(family.mother)) return false;
        return father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }

    @Override
    protected void finalize() {
        System.out.println(toString());
    }



    @Override
    public String toString() {

        String classInfo = String.format("Family{" +
                        " mother='%s'" +
                        ", father=%s" +
                        ", children=%s" +
                        ", pet=%s" +
                        '}',
                mother.toString(),
                father.toString(),
                children,
                ((pet == null) ? null : pet));

        return classInfo;
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Human>();
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child){
        this.children.add(child);
    }

    public boolean deleteChild(int i){
        try {
            this.children.remove(i);
            return true;
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public int countFamily(){
        return this.children.size() + 2;
    }

}
