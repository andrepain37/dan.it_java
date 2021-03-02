package main;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    @Override
    protected void finalize() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Arrays.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(children);
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
                Arrays.toString(children),
                ((pet == null) ? null : pet));

        return classInfo;
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[]{};
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child){
        Human[] childArr = new Human[this.children.length + 1];

        for (int i = 0; i < this.children.length; i++) {
            childArr[i] = this.children[i];
        }
        childArr[this.children.length] = child;

        this.children = childArr;
    }

    public boolean deleteChild(int i){
        try {
            Human[] result = new Human[this.children.length - 1];
            System.arraycopy(this.children, 0, result, 0, i);
            System.arraycopy(this.children, i + 1, result, i, this.children.length - i - 1);
            this.children = result;
            return true;
        }catch (ArrayStoreException e){
            return false;
        }
    }

    public int countFamily(){
        return this.children.length + 2;
    }

}
