package DAO;

public interface ActionDAO {
    String getTitleAction();
    String getDesc();
    void doAction();
    default boolean exit() {
        return false;
    }
}
