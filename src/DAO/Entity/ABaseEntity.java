package DAO.Entity;

/**
 * ����� ����������� ����� ����������� ����������
 */
public abstract class ABaseEntity {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;

    }

    @Override
    public String toString() {
        return "I am Entity O_0 ...";
    }

}
